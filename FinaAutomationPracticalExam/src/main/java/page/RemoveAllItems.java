package page;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class RemoveAllItems {

	WebDriver driver;
	
	//Initialize driver 
	public RemoveAllItems(WebDriver driver){
		this.driver=driver;
	}
	
	//Used methods are created in the Checkbox class 
	//Used methods from RemoveSingleItem class
	public void removeAllItemsMethod() {
		
		Checkbox checkbox = PageFactory.initElements(driver, Checkbox.class);
		checkbox.clickToggleAllCheckBox();
		
		RemoveSingleItem removeSingleItem = PageFactory.initElements(driver,RemoveSingleItem.class);
		removeSingleItem.ClickOnRemoveButton();
		
	}
	
}
