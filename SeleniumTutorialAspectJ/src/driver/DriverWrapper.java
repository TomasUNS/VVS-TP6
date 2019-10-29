package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DriverWrapper {
	
	public static WebDriver Driver () {
		return DriverManager.instance ().driver ();
	}
	
	public static boolean isVisible (By by) {
		try {
			return ExpectedConditions.visibilityOfElementLocated (by) != null;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean isEnabled (By by) {
		try {
			return Driver ().findElement (by).isEnabled ();
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean isClickable (By by) {
		try {
			return isVisible (by) && (ExpectedConditions.elementToBeClickable (by) != null);
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
}