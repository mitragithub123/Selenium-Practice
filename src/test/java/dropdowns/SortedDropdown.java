package dropdowns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Select select = new Select(driver.findElement(By.cssSelector("#animals")));
		Select select = new Select(driver.findElement(By.cssSelector("#colors")));

		ArrayList<String> orgList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();

		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			orgList.add(option.getText());
			tempList.add(option.getText());
		}

		System.out.println("------------Before soting-----------");
		System.out.println("Original list: " + orgList);
		System.out.println("Temporary list: " + tempList);

		Collections.sort(tempList);

		System.out.println("------------After sorting-----------");
		System.out.println("Original list: " + orgList);
		System.out.println("Temporary list: " + tempList);

		if (orgList.equals(tempList)) {
			System.out.println("List is sorted...");

		} else {
			System.out.println("List is n't sorted...");
		}

		driver.close();

	}

}
