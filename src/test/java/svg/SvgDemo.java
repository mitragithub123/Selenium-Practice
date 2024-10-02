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
		driver.get("https://prsindia.org/covid-19/cases");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		List<WebElement> circles = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and contains(@class, 'highcharts-markers')]//path[@fill='red']"));
		Actions action=new Actions(driver);
		for(WebElement circle:circles) {
			action.moveToElement(circle).moveByOffset(0, 10).build().perform(); // Not working
			Thread.sleep(1000);
		}
		
		

	}

}
