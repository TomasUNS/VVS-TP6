package pages;

import org.openqa.selenium.By;
import controls.Button;

public class CartPage extends BasePage {
	
	public CartPage () {
		super (By.xpath ("//div[contains(text(),'Your Cart')]"));
	}
	
	public Button elementButton (int Indice) {
		return new Button (By.xpath("//div[@class='cart_item'][" + Indice + "]"));
	}
	
	public Button buttonCheckout () {
		return new Button (By.xpath ("//a[contains(@class, 'btn_action checkout_button')]"));
	}
	
}