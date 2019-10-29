package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import driver.DriverWrapper;

public class BaseControl {
	
	protected By by;
	
	public BaseControl (By findBy) {
		this.by = findBy;
	}
	
	protected WebDriver driver () {
		return DriverWrapper.Driver ();
	}
	
	public By getBy () {
		return by;
	}
	
	protected WebElement element () {
		try {
			return this.driver ().findElement (this.by);
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public boolean visible () {
		try {
			return DriverWrapper.isVisible (this.by);
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean enabled () {
		try {
			return DriverWrapper.isEnabled (this.by);
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean clickable () {
		try {
			return DriverWrapper.isClickable (this.by);
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
}