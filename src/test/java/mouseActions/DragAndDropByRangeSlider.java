package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropByRangeSlider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		Actions act = new Actions(driver);

		System.out.println(minSlider.getLocation());// (86, 233)
		System.out.println(minSlider.getLocation().getX());// 86
		System.out.println(minSlider.getLocation().getY());// 233
		
		System.out.println(maxSlider.getLocation());// (544, 250)
		System.out.println(maxSlider.getLocation().getX());
		System.out.println(maxSlider.getLocation().getY());
		
		act.dragAndDropBy(minSlider, 100, 233).build().perform();
		act.dragAndDropBy(maxSlider, -49, 250).build().perform();
		
	}

}
