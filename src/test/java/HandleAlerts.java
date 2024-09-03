import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Normal alert with OK button
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		// driver.switchTo().alert().accept();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		// Confirmation alert (OK & Cancel button)
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		driver.switchTo().alert().accept(); // Close alert using OK button
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss();// Close alert using Cancel button
		
		//Prompt alert (Input box)
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Alert myAlert=driver.switchTo().alert();
		myAlert.sendKeys("Welcome");
		Thread.sleep(5000);
		myAlert.accept();
		
		

	}

}
