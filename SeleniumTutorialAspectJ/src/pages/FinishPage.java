package pages;

import org.openqa.selenium.By;
import controls.Label;

public class FinishPage extends BasePage {
	
	public FinishPage () {
		super (By.xpath ("//div[contains(text(),'Finish')]"));
	}
	
	public Label thankYouMessage () {
		return new Label (By.xpath("//h2[contains(@class, 'complete-header')]"));
	}
	
	public Label orderMessage () {
		return new Label (By.xpath("//div[contains(@class, 'complete-text')]"));
	}
	
}