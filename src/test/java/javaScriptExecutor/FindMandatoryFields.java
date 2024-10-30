package javaScriptExecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindMandatoryFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/en-gb?route=account/register");
		driver.manage().window().maximize();

		List<WebElement> elements = driver.findElements(By.xpath("//form[@id='form-register']//label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement element : elements) {
			String script = "return window.getComputedStyle(arguments[0], '::Before').getPropertyValue('content');";
			String content = js.executeScript(script, element).toString();
			if (content.contains("*")) {
				System.out.println(element.getText() + ": Mandatory field");
			} else {
				System.out.println(element.getText() + ": Not mandatory field");
			}
		}

	}

}
