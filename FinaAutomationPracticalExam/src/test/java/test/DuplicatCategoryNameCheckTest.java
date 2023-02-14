package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DuplicatCategoryNameCheck;
import util.BrowserFactory;

public class DuplicatCategoryNameCheckTest {

	WebDriver driver;
	
	
	@Test
	public void userShouldNotBeAbleToAddDuplicateName() {
		
		driver = BrowserFactory.init();
		DuplicatCategoryNameCheck duplicatCategoryNameCheck= PageFactory.initElements(driver,DuplicatCategoryNameCheck.class);
		duplicatCategoryNameCheck.addDuplicateName();
		duplicatCategoryNameCheck.addCategorybutton();
		duplicatCategoryNameCheck.validateUserIsNotAbleToAddDuplicateName();
		BrowserFactory.tearDown();
	}	
}
