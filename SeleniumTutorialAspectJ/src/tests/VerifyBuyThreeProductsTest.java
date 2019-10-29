package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CounterPage;
import pages.LoginPage;
import pages.ProductPage;

public class VerifyBuyThreeProductsTest extends BaseTest {
	
	//Originalmente parte de ProductTest
	
	private LoginPage loginPage;
	private ProductPage productPage;
	private CounterPage counterPage;
	
	@Before
	public void setUp () throws Exception {}
	
	@Test
	public void verifyBuyThreeProducts () throws Exception {
		loginPage = new LoginPage ();
		
		loginPage.inputUsername ().write ("standard_user");
		loginPage.inputPassword ().write ("secret_sauce");
		loginPage.buttonLogin ().click ();
		
		productPage = new ProductPage ();
		
		productPage.productButton (2).click();
		productPage.productButton (1).click();
		productPage.productButton (4).click();
		
		counterPage = new CounterPage ();
		
		Assert.assertEquals(counterPage.counter ().text (), "3");
	}
	
	@After
	public void tearDown () {
		this.finalize ();
	}
	
}