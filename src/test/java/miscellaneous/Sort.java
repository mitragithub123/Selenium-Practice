package miscellaneous;

import java.util.List;
import java.util.stream.Collectors;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();
		WebElement dropdownEle = driver.findElement(By.cssSelector("#products-orderby"));
		Select dropdown = new Select(dropdownEle);
		dropdown.selectByVisibleText("Name: A to Z");

		List<WebElement> products = driver.findElements(By.cssSelector(".product-title"));
		List<String> beforeSort = products.stream().map(e -> e.getText()).collect(Collectors.toList());
		List<String> afterSort = products.stream().map(e -> e.getText()).sorted().collect(Collectors.toList());

		if (beforeSort.equals(afterSort)) {
			System.out.println("Sorting works");
		} else {
			System.out.println("Sorting is not working");
		}

	}
}
