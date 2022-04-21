package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TS000_DemoBlaze_Base {
	/*
	 * Definition of the variables and URL constant 
	 * used for the test cases in the AOS project.*/
	protected WebDriver driver;
	protected WebDriverWait wdw;
	static private String URL = "https://www.demoblaze.com/index.html"; 
	
	/*
	 * 
	 * Setup of the test. The driver is set up,
	 * the window maximized and a WebDriverWeb object
	 * is instanced for it to be used in the test cases.*/
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	/*
	 * Before every method, we go back to the original URL
	 * in case there are 2 or more test cases contained in one class.*/
	@BeforeMethod
	public void conf() {
		driver.get(URL);
	}
	
	/*
	 * Just a heads up in the terminal telling that
	 * a test case has been executed.*/
	@AfterMethod
	public void tear() {
		System.err.println("Method finished.");
	}
	
	
	/*
	 * After everything was executed, the driver is closed.*/
	@AfterClass
	public void tearDown() {
//		driver.quit();
	}
}
