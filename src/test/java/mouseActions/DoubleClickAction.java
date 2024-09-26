package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");

		WebElement box1 = driver.findElement(By.cssSelector("#field1"));
		WebElement box2 = driver.findElement(By.cssSelector("#field2"));
		WebElement button = driver.findElement(By.cssSelector("button[ondblclick='myFunction()']"));

		box1.clear();
		box1.sendKeys("Jai Sriram");

		Actions act = new Actions(driver);
		act.doubleClick(button).build().perform();

		String text = box2.getAttribute("value");
		System.out.println("Captured text is: " + text);
		if (text.equalsIgnoreCase("Jai Sriram")) {
			System.out.println("Text copied...");
		} else {
			System.out.println("Text not copied...");
		}

		// Here getText() will not work. See html of the element box2 and click on right
		// click button.
		// getText()--Returns inner text of the web element
		// getAttribute("attr name")--Returns value of attribute.

	}

}
