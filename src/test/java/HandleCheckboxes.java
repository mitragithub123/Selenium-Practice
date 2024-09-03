import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Click specific checkbox
		// driver.findElement(By.cssSelector("#sunday")).click();

		// Click all checkboxes
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(".form-check-input[type=\"checkbox\"]"));
		
		/*
		 * for (int i = 0; i < checkboxes.size(); i++) { checkboxes.get(i).click(); }
		 */
		
		/*
		 * for(WebElement checkbox:checkboxes) { checkbox.click(); }
		 */
		
		// Click last 3 checkboxes
		/*
		 * for (int i = 4; i < checkboxes.size(); i++) { checkboxes.get(i).click(); }
		 */
		
		// Click first 3 checkboxes
		/*
		 * for (int i = 0; i < 3; i++) { checkboxes.get(i).click(); }
		 */
		
		// Unselect checkboxes if they are selected.
		for (int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}
		Thread.sleep(5000);
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				checkbox.click();
			}
		}

		//driver.close();
	}

}
