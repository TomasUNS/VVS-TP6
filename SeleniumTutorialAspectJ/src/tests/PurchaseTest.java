package tests;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.FakePersonPage;
import pages.FinishPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductPage;

public class PurchaseTest extends BaseTest {
	
	private LoginPage loginPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private OverviewPage overviewPage;
	private FinishPage finishPage;
	private FakePersonPage fakePersonPage;
	
	public PurchaseTest () {
		super ();
	}
	
	@Before
	public void setUp () throws Exception {}
	
	@Test
	public void buyElements () throws Exception {
		loginPage = new LoginPage ();
		
		loginPage.inputUsername ().write ("standard_user");
		loginPage.inputPassword ().write ("secret_sauce");
		loginPage.buttonLogin ().click ();
		
		productPage = new ProductPage ();
		
		int randomInt = (int) (Math.floor(Math.random() * productPage.getProductAmmount ()) + 1);
		
		productPage.productButton (randomInt).click ();
		productPage.goToCart ().click ();
		
		cartPage = new CartPage ();
		
		cartPage.buttonCheckout ().click ();
		
		String newTabScript = "window.open('about:blank','_blank');";
		((JavascriptExecutor) driver ()).executeScript (newTabScript);
		ArrayList <String> tabArray = new ArrayList <String> (driver ().getWindowHandles ());
	    driver ().switchTo ().window (tabArray.get (1));
	    
	    driver ().get ("https://www.fakepersongenerator.com/Index/generate");
	    fakePersonPage = new FakePersonPage ();
	    String fullName = fakePersonPage.nameLabel ().text ();
	    String cityStateZip = fakePersonPage.postalCodeLabel ().text ();
	    
	    String [] splitNames = fullName.split (" ", 0); 
        int nameAmount = splitNames.length;
        String firstName = splitNames [0];
        String lastName = splitNames [nameAmount - 1];
        
        String [] splitInfo = cityStateZip.split (" ", 0);
        int infoAmount = splitInfo.length;
        String postalCode = splitInfo [infoAmount - 1];
	    
        driver ().close ();
	    driver ().switchTo ().window (tabArray.get (0));
	    
	    checkoutPage = new CheckoutPage ();
		
		checkoutPage.inputFirstName ().write (firstName);
		checkoutPage.inputLastName ().write (lastName);
		checkoutPage.inputPostalCode ().write (postalCode);
		checkoutPage.buttonContinue ().click ();
		
		overviewPage = new OverviewPage ();
		
		overviewPage.buttonCheckout ().click ();
		
		finishPage = new FinishPage ();
		
		Assert.assertEquals (this.finishPage.thankYouMessage ().text (), "THANK YOU FOR YOUR ORDER");
		Assert.assertEquals (this.finishPage.orderMessage ().text (), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
	}
	
	@After
	public void tearDown () {
		this.finalize ();
	}
	
}