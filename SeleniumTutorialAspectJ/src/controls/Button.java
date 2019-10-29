package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Button extends BaseControl {
	
	public Button (By by) {
		super (by);
	}
	
	public String text () {
		try {
			return this.element ().getText ();
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public void click () {
		this.element ().click ();
	}
	
}