package threadSafety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

// Unstability in Parallel Execution
public class Problem {
	public WebDriver driver;

	@Test
	public void myTest1() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Test
	public void myTest2() {
		driver = new EdgeDriver();
		driver.get("https://www.bing.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	// If we run this code from "problem.xml" parallely it may result unwanted outputs.
}
