package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {
	public WebDriver driver;

	@Test(priority = 1)
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void testLogo() throws InterruptedException {
		Thread.sleep(3000);
		WebElement logo = driver.findElement(By.cssSelector("img[alt='company-branding']"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo is not displayed");
		}

	}

	@Test(priority = 3)
	public void logintoApp() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[placeholder='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

}
