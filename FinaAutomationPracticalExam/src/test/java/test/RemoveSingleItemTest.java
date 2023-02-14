package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;


import page.RemoveSingleItem;
import util.BrowserFactory;

public class RemoveSingleItemTest {
	
	WebDriver driver;
	
	@Test
	public void userShouldBeAbleToRemoveSingleItem() {
		
		driver = BrowserFactory.init();
		RemoveSingleItem removeSingleItem = PageFactory.initElements(driver, RemoveSingleItem.class);
		removeSingleItem.ClickOnSingleItem();
		removeSingleItem.ClickOnRemoveButton();
		BrowserFactory.tearDown();
	}
	
	
}
