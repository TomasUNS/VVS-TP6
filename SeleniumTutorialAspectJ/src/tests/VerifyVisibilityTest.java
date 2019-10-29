package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import pages.LoginPage;

public class VerifyVisibilityTest extends BaseTest {
	
	//Originalmente parte de LoginTest
	
	private LoginPage loginPage;
	
	public VerifyVisibilityTest () {
		super ();
	}
	
	@Before
	public void setUp () throws Exception {}
	
	@Test
	public void verifyVisibilityOfAllElements () throws Exception {
		loginPage = new LoginPage ();
		
		Assert.assertTrue (this.loginPage.inputUsername ().visible ());
		Assert.assertEquals (this.loginPage.inputUsername ().text (), "Username");
		Assert.assertTrue (this.loginPage.inputPassword ().visible ());
		Assert.assertEquals (this.loginPage.inputPassword ().text (), "Password");
		Assert.assertTrue (this.loginPage.buttonLogin ().visible ());
	}
	
	@After
	public void tearDown () {
		this.finalize ();
	}
	
}