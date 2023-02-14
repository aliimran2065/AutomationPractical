package Steps;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.PageFactory;

import page.blueBackgroundPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.BrowserFactory;

public class blueBackgroundStepDefinition {

	WebDriver driver;
	blueBackgroundPage BlueBackgroundPage;

	@Before
	public void beforeRunSkyblue() {
		driver = BrowserFactory.init();
		BlueBackgroundPage = PageFactory.initElements(driver, blueBackgroundPage.class);
	}

	@Given("{string} button exists")
	public void button_exists(String string){
		BlueBackgroundPage.verifyButtonExists();
	}

	@When("I click on the Skyblue button")
	public void i_click_on_the_Skyblue_button() {
		BlueBackgroundPage.clickSetBackgroundSkyBlueButton();
	
	}

	@Then("the background color will change to sky blue")
	public void the_background_color_will_change_to_sky_blue() {
		BlueBackgroundPage.validateBackgroundColorChangedToSkyBlue();
	}
	@After
	public void tearDownSkyblue() {
		BrowserFactory.tearDown();
	}

}
