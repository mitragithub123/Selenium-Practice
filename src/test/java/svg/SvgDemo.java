package svg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://oslive-v4.2.andolasoft.co.in/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input[placeholder='Enter your email']"))
				.sendKeys("andolasoft.user133@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys("Mitra@1234");
		driver.findElement(By.cssSelector("input[title='Sign In']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Dashboard']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementScroll = driver.findElement(By.xpath("//h4[normalize-space()='Resource Workload Status']"));
		js.executeScript("arguments[0].scrollIntoView()", elementScroll);
		Thread.sleep(5000);

		List<WebElement> circles = driver
				.findElements(By.xpath("//div[@id='apexcharts7iun7p9d']//*[name()='svg']//*[name()='path']"));
		Actions action = new Actions(driver);
		for (WebElement circle : circles) {
			action.moveToElement(circle).moveByOffset(0, 10).build().perform(); // Not working
			Thread.sleep(1000);
		}

	}

}
