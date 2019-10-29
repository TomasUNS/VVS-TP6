package pages;

import org.openqa.selenium.By;
import controls.Button;

public class OverviewPage extends BasePage {
	
	public OverviewPage () {
		super (By.xpath ("//div[contains(text(),'Checkout: Overview')]"));
	}
	
	public Button buttonCheckout () {
		return new Button (By.xpath ("//a[contains(@class, 'btn_action cart_button')]"));
	}
	
}