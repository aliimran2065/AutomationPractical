package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCategory;
import util.BrowserFactory;

public class AddCategoryTest {

	WebDriver driver;
	
	
	@Test
	public void validUserShouldBeAbleToAddCategory() {
		driver = BrowserFactory.init();
		AddCategory addCategory = PageFactory.initElements(driver,AddCategory.class);
		addCategory.nameCategoryTextBox();
		addCategory.addCategoryButton();
		addCategory.verifyCategoryWasAdded();
		BrowserFactory.tearDown();
	}
	
}
