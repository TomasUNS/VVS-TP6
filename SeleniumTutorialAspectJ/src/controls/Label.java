package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Label extends BaseControl {
	
	public Label (By by) {
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
	
}