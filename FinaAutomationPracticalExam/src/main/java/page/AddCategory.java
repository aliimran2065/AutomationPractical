package page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCategory extends BasePage {

	WebDriver driver;

	// WebElements
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[1]")
	WebElement ADD_CATEGORY_TEXT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_CATEGORY_BUTTON;

	// Initializing WebDriver
	public AddCategory(WebDriver driver) {
		this.driver = driver;
	}

	// Initializing variables
	String categoryName;
	String randCategoryName;

	// Code to make project more dynamic by using data from a file
	public void readCategoryData() {
		InputStream input;
		try {
			input = new FileInputStream(
					"/Users/aliimran/Desktop/Selenium/AutomationPracticalExam1/src/main/java/Data/CategoryData.properties");
			Properties prop = new Properties();
			prop.load(input);
			categoryName = prop.getProperty("Category");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Taking data from our Data file and concatenating with a random number
	// generator found in the BasePage class, so we have a unique category name each
	// time we add a category
	public void nameCategoryTextBox() {
		readCategoryData();
		randCategoryName = categoryName + generateRandomNum(9999);
		if (categoryName.equalsIgnoreCase("Techfios")) {
			ADD_CATEGORY_TEXT.sendKeys(randCategoryName);
		}

	}

	public void addCategoryButton() {
		ADD_CATEGORY_BUTTON.click();
	}

	// This method verifies our category was added. I first create two variables to
	// split the Xpath in order to get the latest category by adding 1 to the
	// category number we retrieved from the site. Then I get the category name and
	// compare it to the global variable to confirm that our category was added

	public void verifyCategoryWasAdded() {

		String begining_xpath = "/html/body/div[3]/a[";
		String after_xpath = "]/span";

		int size = driver.findElements(By.xpath("/html/body/div[3]/a[*]/span")).size();

		WebElement element = driver.findElement(By.xpath(begining_xpath + (size + 1) + after_xpath));
		if (element.getText().equals(randCategoryName)) {
			System.out.println("Your name, " + element.getText() + " was added to the list");
		} else {
			System.out.println("Your name was not found in the list");
		}

	}

}
