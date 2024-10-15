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

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement elementScroll
		 * = driver.findElement(By.
		 * xpath("//h4[normalize-space()='Resource Workload Status']"));
		 * js.executeScript("arguments[0].scrollIntoView()", elementScroll);
		 */
		Thread.sleep(5000);

		// Locate the SVG paths
		List<WebElement> circles = driver
				.findElements(By.xpath("//*[name()='svg']//*[name()='path' and @id='SvgjsPath2925']"));
		System.out.println("Number of elements found: " + circles.size());

		// Hover over elements using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement circle : circles) {
			js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', { bubbles: true }));", circle);
			Thread.sleep(1000);
		}

	}

}
