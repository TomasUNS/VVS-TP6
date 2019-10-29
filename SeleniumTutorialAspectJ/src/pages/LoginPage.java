package pages;

import org.openqa.selenium.By;
import controls.Button;
import controls.Input;

public class LoginPage extends BasePage {
	
	public LoginPage () {
		super (By.id ("user-name"));
	}
	
	public Input inputUsername () {
		return new Input (By.id ("user-name"));
	}
	
	public Input inputPassword () {
		return new Input (By.id ("password"));
	}
	
	public Button buttonLogin () {
		return new Button (By.xpath ("//input[@value='LOGIN']"));
	}
	
}