package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadSendKeysMultiple {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();

		// <input type="file"> element
		WebElement uploadElement = driver.findElement(By.cssSelector("#filesToUpload"));
		String file1 = System.getProperty("user.dir") + "\\screenshot\\sctionScreenshot.png";
		String file2 = System.getProperty("user.dir") + "\\screenshot\\elementScreenshot.png";
		uploadElement.sendKeys(file1 + "\n" + file2);
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.id("submit-button")).click();
	}

}
