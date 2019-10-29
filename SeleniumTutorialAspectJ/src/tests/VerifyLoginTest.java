package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import pages.LoginPage;
import pages.ProductPage;

public class VerifyLoginTest extends BaseTest {
	
	//Originalmente parte de LoginTest
	
	private LoginPage loginPage;
	private ProductPage productPage;
	
	public VerifyLoginTest () {
		super ();
	}
	
	@Before
	public void setUp () throws Exception {}
	
	@Test
	public void verifyLogin () throws Exception {
		loginPage = new LoginPage ();
		
		loginPage.inputUsername ().write ("standard_user");
		loginPage.inputPassword ().write ("secret_sauce");
		loginPage.buttonLogin ().click ();
		
		productPage = new ProductPage ();
		
		Assert.assertTrue (productPage.labelProduct ().visible ());
		Assert.assertEquals (productPage.labelProduct ().text (), "Products");
	}
	
	@After
	public void tearDown () {
		this.finalize ();
	}
	
}