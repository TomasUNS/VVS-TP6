package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	private WebDriver activeDriver;
	
	private DriverManager () {}
	
	private static DriverManager instance;
	
	public static DriverManager instance () {
		if (instance == null) {
			instance = new DriverManager ();
		}
		return instance;
	}
	
	public WebDriver driver () {
		if (this.activeDriver == null) {
			String driverPath = System.getProperty ("user.dir") + "/driver/chromedriver.exe";
			System.setProperty ("webdriver.chrome.driver", driverPath);
			this.activeDriver = new ChromeDriver ();
			this.activeDriver.manage ().window ().maximize ();
		}
		return this.activeDriver;
	}
	
	public void closeDriver () {
		this.activeDriver.close ();
		this.activeDriver.quit ();
		this.activeDriver = null;
	}
	
}