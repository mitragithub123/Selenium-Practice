package testng.dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "login")
	public void testLogin(String email, String password) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if (status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	// {0, 2}: This means that the data provider will only pass the data from the
	// 0th and 2nd rows (first and third sets of data) to the test method, skipping
	// any other rows.
	@DataProvider(name = "login", indices = { 0, 2 })
	public Object[][] loginData() {
		Object[][] data = { { "andolasoft.user133@gmail.com", "mitra@1234" }, { "eqfvye@gmail.com", "123456" },
				{ "eqfvyerrre@gmail.com", "123456" }, { "eqfvyerrddre@gmail.com", "123456" } };
		return data;
	}
}
