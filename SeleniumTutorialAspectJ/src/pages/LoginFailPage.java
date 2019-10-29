package pages;

import org.openqa.selenium.By;
import controls.Label;

public class LoginFailPage extends BasePage {
	
	public LoginFailPage () {
		super (By.id ("user-name"));
	}
	
	public Label errorMessage () {
		return new Label (By.tagName("h3"));
	}
	
}