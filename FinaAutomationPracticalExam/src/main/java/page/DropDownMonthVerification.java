package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DropDownMonthVerification {

	// WebElement List
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[3]")
	WebElement DROP_DOWN_ELEMENT;

	WebDriver driver;

	// Initializing WebElement
	public DropDownMonthVerification(WebDriver driver) {
		this.driver = driver;
	}

	// Clicks dropdown
	public void clickDropDown() {
		DROP_DOWN_ELEMENT.click();

	}

	// This code is used to extract the data from the drop down and compare its
	// values to the expected values
	// I used the select method to select all the items in the drop down then used
	// select.getOptions() to gather all the options
	// Then I created a String array to have a data set to compare the ones from the
	// web-site.
	// I also included "None" because it is one of the available options in the drop
	// down.
	// Next is the for loop, I started with i=1 not 0 in order to skip comparing
	// None to the months.
	// i is less than the option.size() so we can stop when we get to the last month
	// and i++ so we can get to to option.size()
	// Lastly I have set up the if statement as getting the options from our
	// WebElements starting from i
	// then comparing it to our array list starting with i.
	// if the months do not match a message with be in the console

	public void validateDropDownData() {

		Select select = new Select(DROP_DOWN_ELEMENT);
		List<WebElement> options = select.getOptions();
		String[] months = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		for (int i = 1; i < options.size(); i++) {
			if (!options.get(i).getText().equals(months[i])) {
				System.out.println("Month not found: " + months[i]);
			} else {
				System.out.println("Month was found: " + months[i]);
			}
		}

	}

}
