package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DuplicatCategoryNameCheck {

	WebDriver driver;

	// WebElement List
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[1]")
	WebElement ADD_CATEGORY_TEXT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_CATEGORY_BUTTON;

	// Setting a global variable
	String duplicateName;

	// Initializing Driver
	public DuplicatCategoryNameCheck(WebDriver driver) {
		this.driver = driver;
	}

	// Split the xpath then getting the number of category names
	// I got the names by getting all the categories and using .size()
	// Then I retrieved the last category added and getting its text and saving that
	// name into our global variable duplicateName
	// Next I sent that duplicated name to the Category name box
	public void addDuplicateName() {

		String begining_xpath = "/html/body/div[3]/a[";
		String after_xpath = "]/span";

		int size = driver.findElements(By.xpath("/html/body/div[3]/a[*]/span")).size();
		WebElement element = driver.findElement(By.xpath(begining_xpath + (size + 1) + after_xpath));
		duplicateName = element.getText();
		ADD_CATEGORY_TEXT.sendKeys(duplicateName);

	}

	// Clicks the button to add duplicated name
	public void addCategorybutton() {
		ADD_CATEGORY_BUTTON.click();
	}

	// Because adding a duplicated name takes us to a new page
	//I coded a wait to allow the page to load
	// I Got a unique Element from the new page
	// then I saved the error message that is expected into the string errorMessage
	// Created an assertion to confirm we landed on the right page for duplicated names 
	// printed out the error message with the duplicated name
	public void validateUserIsNotAbleToAddDuplicateName() {
		WebElement DUPLICATE_ERROR_PAGE = driver.findElement(By.xpath("/html/body/a[1]"));
		String errorMessage = "The category you want to add already exists: ";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertEquals(DUPLICATE_ERROR_PAGE.getText(), "Yes", "Wrong Page!");
		System.out.println(errorMessage + duplicateName);

	}

}
