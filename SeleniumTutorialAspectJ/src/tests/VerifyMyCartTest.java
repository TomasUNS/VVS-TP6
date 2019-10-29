package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class VerifyMyCartTest extends BaseTest {
	
	//Originalmente parte de ProductTest
	
	private LoginPage loginPage;
	private ProductPage productPage;
	private CartPage cartPage;
	
	@Before
	public void setUp () throws Exception {}
	
	@Test
	public void verifyMyCart () throws Exception {
		loginPage = new LoginPage ();
		
		loginPage.inputUsername ().write ("standard_user");
		loginPage.inputPassword ().write ("secret_sauce");
		loginPage.buttonLogin ().click ();
		
		productPage = new ProductPage ();
		
		productPage.productButton (2).click();
		productPage.productButton (1).click();
		productPage.productButton (4).click();
		
		productPage.goToCart ().click ();
		
		cartPage = new CartPage ();
		
		Assert.assertTrue(cartPage.elementButton (1).visible ());
		Assert.assertTrue(cartPage.elementButton (2).visible ());
		Assert.assertTrue(cartPage.elementButton (2).visible ());
	}
	
	@After
	public void tearDown () {
		this.finalize ();
	}
	
}