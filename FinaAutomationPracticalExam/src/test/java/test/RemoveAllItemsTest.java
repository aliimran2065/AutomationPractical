package test;

import org.openqa.selenium.support.PageFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.RemoveAllItems;
import util.BrowserFactory;

public class RemoveAllItemsTest {

	
	WebDriver driver;
	
	
	@Test
	public void userShouldBeAbleToRemoveAllItems() {
		
		driver = BrowserFactory.init();
		RemoveAllItems removeAllItems = PageFactory.initElements(driver, RemoveAllItems.class);
		removeAllItems.removeAllItemsMethod();
		BrowserFactory.tearDown();
		
	}
	
}
