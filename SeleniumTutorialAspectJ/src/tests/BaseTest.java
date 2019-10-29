package tests;

import org.openqa.selenium.WebDriver;
import driver.DriverManager;

public class BaseTest {
	
private WebDriver driver;
	
	public BaseTest () {
		this.driver = DriverManager.instance ().driver ();
		
		this.driver.get ("https://www.saucedemo.com/");
	}
	
	protected WebDriver driver () {
		return this.driver;
	}
	
	public void finalize () {
		DriverManager.instance ().closeDriver ();
	}
	
}