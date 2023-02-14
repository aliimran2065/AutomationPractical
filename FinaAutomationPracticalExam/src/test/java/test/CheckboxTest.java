package test;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.Checkbox;
import util.BrowserFactory;

public class CheckboxTest {

	WebDriver driver;

	@Test
	public void userShouldBeAbleToCheckAllBoxesWithToggleAllBox() {

		driver = BrowserFactory.init();
		Checkbox checkbox = PageFactory.initElements(driver, Checkbox.class);
		checkbox.clickToggleAllCheckBox();
		checkbox.validateAllCheckboxesAreChecked();
		BrowserFactory.tearDown();

	}

}
