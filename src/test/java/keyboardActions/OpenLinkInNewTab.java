package keyboardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='About']"));

		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).build().perform();
		
		// Switch to About page
		List<String> ids=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		// Again switches back
		driver.switchTo().window(ids.get(0));
		System.out.println(driver.getTitle());

	}

}
