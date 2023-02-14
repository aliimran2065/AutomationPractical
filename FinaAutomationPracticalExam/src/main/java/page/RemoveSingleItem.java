package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemoveSingleItem {

	WebDriver driver;

	// WebElement List
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[1]")
	WebElement removeButton;

	// Initializing driver
	public RemoveSingleItem(WebDriver driver) {
		this.driver = driver;

	}

	// Split the xpath to make iterating easier
	// got the list of all the available check boxes
	// created an int variable to store the number of check boxes
	// Created an if statement to make sure there is an check box available to click
	// in the WebElement Check box I used the split xpaths and the number of
	// check boxes in order to always select the last check box ensuring I select one 
	// then checkBox.click just clicks the item 
	public void ClickOnSingleItem() {
		String xpathFirstHalf = "//*[@id=\"todos-content\"]/form/ul/li[";
		String xpathSecondHalf = "]/input";
		List<WebElement> checkboxes = driver.findElements(By.xpath(xpathFirstHalf + "*" + xpathSecondHalf));
		int numOfCheckboxes = checkboxes.size();

		if (numOfCheckboxes != 0) {
			WebElement checkBox = driver.findElement(By.xpath(xpathFirstHalf + numOfCheckboxes + xpathSecondHalf));
			checkBox.click();
			System.out.println("Single item number " + numOfCheckboxes + " has been removed succesfully.");
		} else {
			System.out.println("No items availbale");
		}

	}
	//Clicks remove button 
	public void ClickOnRemoveButton() {
		removeButton.click();
	}

}
