package enumUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdownEnumNMethod {
	public static WebDriver driver;

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

//	public static void selectByVisibleText(By locator, String value) {
//		Select select = new Select(getElement(locator));
//		select.selectByVisibleText(value);
//		select.selectByValue(value);
//	}

//	public static void selectByIndex(By locator, String value) {
//		Select select = new Select(getElement(locator));
//		select.selectByIndex(Integer.parseInt(value));
//	}

//	public static void selectByValue(By locator, String value) {
//		Select select = new Select(getElement(locator));
//		select.selectByValue(value);
//	}

//	public static void selectDropdown(By locator, String type, String value) {
//		Select select = new Select(getElement(locator));
//		switch (type) {
//		case "index":
//			select.selectByIndex(Integer.parseInt(value));
//			break;
//		case "value":
//			select.selectByValue(value);
//			break;
//		case "visibleText":
//			select.selectByVisibleText(value);
//			break;
//		default:
//			System.out.println("Please pass the correct selection criteria");
//			break;
//		}
//
//	}
	public static void selectDropdown(By locator, Dropdown visibletext, String value) {
		Select select = new Select(getElement(locator));
		switch (visibletext) {
		case INDEX:
			select.selectByIndex(Integer.parseInt(value));
			break;
		case VALUE:
			select.selectByValue(value);
			break;
		case VISIBLETEXT:
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Please pass the correct selection criteria");
			break;
		}
		
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		driver.manage().window().maximize();

		By country = By.cssSelector("#Form_getForm_Country");

		//selectByVisibleText(country, "India");
		
		//selectDropdown(country,"visibleText","India");
		selectDropdown(country,Dropdown.VISIBLETEXT,"India");

	}

}
