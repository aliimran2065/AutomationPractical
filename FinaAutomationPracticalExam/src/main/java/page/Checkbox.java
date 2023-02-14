package page;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Checkbox {

	WebDriver driver;

	// Web Element list
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[3]")
	WebElement toggleAllCheckBox;

	// Initializing WebDriver
	public Checkbox(WebDriver driver) {
		this.driver = driver;
	}

	// Clicks Toggle all button
	public void clickToggleAllCheckBox() {
		toggleAllCheckBox.click();

	}

	// In order to validate that all the check boxes are checked I split the Xpath
	// in
	// order to increment it and get access to all the check boxes available
	// Then I used List<WebElement> to get all the available check boxes and then
	// used checkboxes.size() to get the number of boxes
	// Then I used a for loop and if else statement to go through all the available
	// check boxes and see if they were selected
	// To check if the boxes were selected I used checkBox.isSelected() as the
	// condition in the if statement
	public void validateAllCheckboxesAreChecked() {

		String xpathFirstHalf = "//*[@id=\"todos-content\"]/form/ul/li[";
		String xpathSecondHalf = "]/input";

		List<WebElement> checkboxes = driver.findElements(By.xpath(xpathFirstHalf + "*" + xpathSecondHalf));
		int numOfCheckboxes = checkboxes.size();

		for (int i = 1; i <= numOfCheckboxes; i++) {
			WebElement checkBox = driver.findElement(By.xpath(xpathFirstHalf + i + xpathSecondHalf));

			if (checkBox.isSelected()) {
				System.out.println("Checkbox " + i + " is selected");
			} else if (numOfCheckboxes == 0) {
				System.out.println("There are no items to select");
			} else {
				System.out.println("Checkbox " + i + " is not selected");
			}

		}

	}
}
