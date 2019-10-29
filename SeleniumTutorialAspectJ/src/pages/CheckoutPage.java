package pages;

import org.openqa.selenium.By;
import controls.Button;
import controls.Input;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage () {
		super (By.xpath ("//div[contains(text(),'Checkout: Your Information')]"));
	}
	
	public Input inputFirstName () {
		return new Input (By.id ("first-name"));
	}
	
	public Input inputLastName () {
		return new Input (By.id ("last-name"));
	}
	
	public Input inputPostalCode () {
		return new Input (By.id ("postal-code"));
	}
	
	public Button buttonContinue () {
		return new Button (By.xpath ("//input[@value='CONTINUE']"));
	}
	
}