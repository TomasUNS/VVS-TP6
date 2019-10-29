package pages;

import org.openqa.selenium.By;
import controls.Label;

public class CounterPage extends BasePage {
	
	public CounterPage () {
		super (By.xpath ("//div[contains(text(),'Products')]"));
	}
	
	public Label counter () {
		return new Label (By.xpath("//span[contains(@class, 'shopping_cart_badge')]"));
	}
	
}