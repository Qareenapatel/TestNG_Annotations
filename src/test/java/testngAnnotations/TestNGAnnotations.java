package testngAnnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNGAnnotations {

	WebDriver driver;

	@BeforeSuite
	public void setUpEnvironment() {
		System.out.println("Setup QA Environment");
		System.setProperty("webdriver.chrome.driver", "C:/Users/patel/Webdriver/chromedriver.exe");
	}

	@BeforeTest
	public void launchbrowser() {
		driver = new ChromeDriver();
	}

	@BeforeClass
	public void readybrowser() {
		System.out.println("Browser is ready to launch");
	}

	@BeforeMethod
	public void url() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void login() {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	}

	@AfterClass
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void done() {
		System.out.println("Done with annotations");
	}
}
