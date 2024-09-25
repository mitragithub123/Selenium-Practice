package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Count the number of pages
		List<WebElement> allPages = driver.findElements(By.cssSelector(".pagination li a"));
		int pageCount = allPages.size();
		System.out.println("Total pages: " + pageCount);

		// Click on all pages
		for (int i = 1; i <= pageCount; i++) {
			if (i > 1) {
				WebElement activePage = driver
						.findElement(By.xpath("//ul[@class='pagination']//li//a[text()=" + i + "]"));
				activePage.click();
				Thread.sleep(3000);
			}
		}

		// Reading data from a specified page and clicking on checkbox in a row
		int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		List<WebElement> checkbox = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr//td//input"));
		for (int i = 1; i <= rows; i++) {
			String name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + i + "]//td[2]"))
					.getText();
			System.out.println(name);
			checkbox.get(i - 1).click();

		}

	}

}
