package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertsUsingJavascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		// Normal alert with OK button (Using WebDriverWait)
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		try {
			jsExecutor.executeScript("window.alert = function(){};");
		} catch (Exception e) {
			
		}

	}

}
