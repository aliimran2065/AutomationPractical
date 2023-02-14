package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class whiteBackgroundPage {

	WebDriver driver;

	// Variables of the background colors. These are being used to store the rgba
	// values in-order to make the code easier to read
	String rgbaValueOfWhite = "rgba(255, 255, 255, 1)";
	String rgbaValueOfSkyBlue = "rgba(135, 206, 235, 1)";

	// WebDriver initialization
	public whiteBackgroundPage(WebDriver driver) {
		this.driver = driver;
	}

	// Web Element List
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/button[2]")
	WebElement WHITE_BACKGROUND_BUTTON;

	// This code verifies that the button is found on the page, by getting the text
	// from the buttons Xpath and comparing it to our expected string
	public void verifyButtonExists() {

		String buttonText = WHITE_BACKGROUND_BUTTON.getText();
		if (buttonText.equalsIgnoreCase("Set White Background")) {
			System.out.println("Button Exists");
		} else {
			System.out.println("Button Does Not Exists");
		}

	}

	// Clicks white background button
	public void clickSetBackgroundWhiteButton() {
		WHITE_BACKGROUND_BUTTON.click();

	}

	// This part of the code is to verify that the background of our web-site
	// changed. I created a WebElement element and used it to find the body in the
	// html with the cssSelector, then got the color of the background with
	// getCssValue and stored it into the actualBackgroundColor variable. Then I
	// stored our global variable rgbaValueOfSkyBlue as expectedBackgroundColor just
	// so the code is easier to read. Lastly I used if else statements to compare
	// actualBackgroundColor and expectedBackgroundColor
	public void validateBackgroundColorChangedToWhite() {
		WebElement element = driver.findElement(By.cssSelector("body"));
		String actualBackgroundColor = element.getCssValue("background-color");
		String expectedBackgroundColor = rgbaValueOfWhite;
		if (actualBackgroundColor.equals(expectedBackgroundColor)) {
			System.out.println("The background color of the element is as expected:" + actualBackgroundColor);
		} else {
			System.out.println("The background color of the element is not as expected");
		}

	}

}
