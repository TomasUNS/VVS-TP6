package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driver.DriverManager;

public class BasePage {
	
	protected By by;
	
	public BasePage (By findBy) {
		this.by = findBy;
	}
	
	protected WebDriver driver () {
		return DriverManager.instance ().driver ();
	}
	
}