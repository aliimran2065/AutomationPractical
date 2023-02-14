package Steps;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import page.whiteBackgroundPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.BrowserFactory;

public class whiteBackgroundStepDefinition {

	WebDriver driver;
	whiteBackgroundPage WhiteBackgroundPage;
	
	@Before
	public void beforeRunWhite() {
		driver = BrowserFactory.init();
		WhiteBackgroundPage = PageFactory.initElements(driver, whiteBackgroundPage.class);
	}
	
	@Given("the {string} button exists")
	public void the_button_exists(String string) {
	    WhiteBackgroundPage.verifyButtonExists();
	}
	
	@When("I click on the White button")
	public void i_click_on_the_White_button() {
		WhiteBackgroundPage.clickSetBackgroundWhiteButton();;
	
	}

	@Then("the background color will change to white")
	public void the_background_color_will_change_to_white() {
	    WhiteBackgroundPage.validateBackgroundColorChangedToWhite();
	}
	@After
	public void tearDownWhite() {
		BrowserFactory.tearDown();
	}


}
