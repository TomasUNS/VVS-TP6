package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import pages.LoginFailPage;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
	
	//Originalmente parte de LoginTest
	
	private LoginPage loginPage;
	private LoginFailPage loginFailPage;
	
	public InvalidLoginTest () {
		super ();
	}
	
	@Before
	public void setUp () throws Exception {}
	
	@Test
	public void invalidLoginTest () throws Exception {
		loginPage = new LoginPage ();
		
		loginPage.inputUsername ().write ("standard_user");
		loginPage.inputPassword ().write ("noexiste");
		loginPage.buttonLogin ().click ();
		
		loginFailPage = new LoginFailPage ();
		
		Assert.assertTrue (loginFailPage.errorMessage ().visible ());
	}
	
	@After
	public void tearDown () {
		this.finalize ();
	}
	
}