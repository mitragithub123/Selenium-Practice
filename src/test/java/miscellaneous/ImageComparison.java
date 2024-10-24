package miscellaneous;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class ImageComparison {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.cssSelector("img[alt='Orangescrum reviews']"));
		
		// Load the expected image
		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\testData\\new-signup-page-customer-logo.png"));

		// Capture screenshot of the specific element
		Screenshot screenshot = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element);

		// Save the captured screenshot
		BufferedImage actualImage = screenshot.getImage();
		File output = new File(System.getProperty("user.dir") + "\\testData\\actualImage.png");
		ImageIO.write(actualImage, "PNG", output);
        
        // Compare the two images
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff =imgDiff.makeDiff(expectedImage, actualImage);
        
		// Check if the images are identical
		if (diff.hasDiff()) {
			System.out.println("Images are NOT the same!");
		} else {
			System.out.println("Images are identical.");
		}

	}

}
