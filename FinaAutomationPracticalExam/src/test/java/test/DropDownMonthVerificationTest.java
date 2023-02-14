package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DropDownMonthVerification;
import util.BrowserFactory;

public class DropDownMonthVerificationTest {

	WebDriver driver;
	
	@Test
	public void validDropDownShouldHaveAllTheMonths() {
		driver= BrowserFactory.init();
		DropDownMonthVerification dropDownMonthVerification = PageFactory.initElements(driver, DropDownMonthVerification.class);
		dropDownMonthVerification.clickDropDown();
		dropDownMonthVerification.validateDropDownData();
		BrowserFactory.tearDown();
		
	}
	
}
