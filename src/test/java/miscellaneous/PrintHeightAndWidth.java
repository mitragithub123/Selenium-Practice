package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintHeightAndWidth {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.cssSelector("#email"));
		WebElement password = driver.findElement(By.cssSelector("#pass"));

		int height = email.getSize().getHeight();
		int width = email.getSize().getWidth();
		System.out.println("Height of email is: " + height);
		System.out.println("Width of email is: " + width);

		int heightP = password.getSize().getHeight();
		int widthP = password.getSize().getWidth();
		System.out.println("Height of password is: " + heightP);
		System.out.println("Width of password is: " + widthP);

		int emailXaxis = email.getLocation().getX();
		int passwordXaxis = password.getLocation().getX();
		System.out.println("X Co-ordinate of email is: " + emailXaxis);
		System.out.println("X Co-ordinate of password  is: " + passwordXaxis);

		int emailYaxis = email.getLocation().getY();
		int passwordYaxis = password.getLocation().getY();
		System.out.println("Y Co-ordinate of email is: " + emailYaxis);
		System.out.println("Y Co-ordinate of password  is: " + passwordYaxis);

		if (emailXaxis == passwordXaxis) {
			System.out.println("Email and password are properly aligned.");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Email and password are not properly aligned.");
		}

	}

}
