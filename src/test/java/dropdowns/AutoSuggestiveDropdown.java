package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Selenium");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.cssSelector("div[class='erkvQe'] ul[role='listbox'] li"));
		System.out.println("Size of list: " + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("Selenium")) {
				list.get(i).click();
				break;
			}
		}
	}

}
