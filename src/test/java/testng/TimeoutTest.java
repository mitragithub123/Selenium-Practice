package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeoutTest {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangescrum.com/");
	}

	@Test(timeOut = 2000) // This test must finish within 2 seconds else ThreadTimeoutException
	public void homeTest() throws InterruptedException {
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
