package threadSafety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

// Unstability in Parallel Execution resolve
public class Solution {
	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	public void setDriver(WebDriver driver) {
		tDriver.set(driver);
	}

	public WebDriver getDriver() {
		return tDriver.get();
	}

	public WebDriver driver;

	@Test
	public void myTest1() {
		driver = new ChromeDriver();
		setDriver(driver);

		getDriver().get("https://www.google.com/");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}

	@Test
	public void myTest2() {
		driver = new EdgeDriver();
		setDriver(driver);
		getDriver().get("https://www.bing.com/");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}

	@AfterClass
	public void tearDown() {
		tDriver.remove();
	}

	// If we run this code from "solutions.xml" parallely it will execute correctly.
}
