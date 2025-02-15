package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToParentFrameDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Switching to frame3 (Parent frame)
		WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.cssSelector("input[name='mytext3']")).sendKeys("Siku");

		// Switching to iframe inside frame3 (Child frame)
		WebElement iframeInsideFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframeInsideFrame);
		driver.findElement(By.id("i21")).click();

		driver.switchTo().parentFrame(); // Control comes to parent frame

		driver.findElement(By.cssSelector("input[name='mytext3']")).clear();
		driver.findElement(By.cssSelector("input[name='mytext3']")).sendKeys("Riku");

		driver.close();

	}

}
