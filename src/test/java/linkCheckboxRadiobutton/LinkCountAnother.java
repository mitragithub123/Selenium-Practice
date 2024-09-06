package linkCheckboxRadiobutton;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCountAnother {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Prints the total links count in the page
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println("Total links inside the page: " + linkCount);

		/* Limiting the WebDriver scope */
		// Prints the links count in the footer section
		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		int footerLinkCount = footer.findElements(By.tagName("a")).size();
		System.out.println("Total links count in footer: " + footerLinkCount);

		// Prints the links count in the footer section 1st column
		WebElement footerFirstColumn = driver.findElement(By.cssSelector("tbody tr td:nth-child(1) ul:nth-child(1)"));
		int footerFirstColumnLinkCount = footerFirstColumn.findElements(By.tagName("a")).size();
		System.out.println("Total links count in footer 1st column: " + footerFirstColumnLinkCount);

		/* Check whether the links in footer section 1st column are opening or not */
		// Open in new tab-->CTRL+click/enter
		for (int i = 1; i < footerFirstColumnLinkCount; i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
		}

		// Get the titles of child tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while (iterator.hasNext()) {
			String window = iterator.next();
			driver.switchTo().window(window);
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
		}

	}

}
