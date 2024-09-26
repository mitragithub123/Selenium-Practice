package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadSendKeys {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();

		// <input type="file"> element
		WebElement uploadElement = driver.findElement(By.cssSelector("#uploadfile_0"));
		uploadElement.sendKeys(System.getProperty("user.dir") + "\\screenshot\\sctionScreenshot.png");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.id("submit-button")).click();
	}

}
