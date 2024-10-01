package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollBar {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com");
		driver.manage().window().maximize();

		// Scroll down page by pixel number
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,1000)", "");
		// System.out.println(js.executeScript("return window.pageYOffset;"));

		// Scroll the page till the element is visible
		//WebElement elementScroll = driver.findElement(By.cssSelector(".unable_track .subhero_title h2"));
		//js.executeScript("arguments[0].scrollIntoView()", elementScroll);
		// System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// Scroll to end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// Scroll up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}

}
