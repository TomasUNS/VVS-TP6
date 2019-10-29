package pages;

import org.openqa.selenium.By;
import controls.Button;
import controls.Label;

public class ProductPage extends BasePage {
	
	public ProductPage () {
		super (By.xpath ("//div[contains(text(),'Products')]"));
	}
	
	public Label labelProduct () {
		return new Label (By.xpath("//div[@class='product_label']"));
	}
	
	public Button productButton (int Indice) {
		return new Button (By.xpath("//div[@class='inventory_list']/div[" + Indice + "]/div[@class='pricebar']/button"));
	}
	
	public int getProductAmmount () {
		return (driver ().findElements (By.xpath("//div[@class='inventory_list']"))).size ();
	}
	
	public Button goToCart () {
		return new Button (By.id("shopping_cart_container"));
	}
	
}