package pages;

import org.openqa.selenium.By;
import controls.Label;

public class FakePersonPage extends BasePage {
	
	public FakePersonPage () {
		super (By.id ("user-name"));
	}
	
	public Label nameLabel () {
		return new Label (By.xpath("//p[contains(@class, 'text-center name')]/b[contains(@class, 'click')]"));
	}
	
	public Label postalCodeLabel () {
		return new Label (By.xpath("//div[contains(@class, 'col-md-8 col-sm-6 col-xs-12')]/p[5]/b"));
	}
	
}