package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.orangescrum.com/users/login");
		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.id("txt_UserId"));
		email.sendKeys("andolasoft.user133@gmail.com");
		WebElement password = driver.findElement(By.id("txt_Password"));
		password.sendKeys("12345678");
		WebElement signIn = driver.findElement(By.cssSelector("#submit_Pass"));
		signIn.click();
		WebElement launchpadListItem = driver.findElement(By.cssSelector("#UserLaunchpadForm a:nth-child(5)"));
		launchpadListItem.click();

		driver.findElement(By.cssSelector("#btn-add-new-all")).click();
		driver.findElement(By.xpath("//ul[@class='border-box']//li[1]//a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#txt_ProjStartDate")).click();

		String requiredYear = "2025";
		String requiredMonth = "May";
		String requiredDate = "20";

		while (true) {
			String monthAndYear = driver
					.findElement(By.xpath("//table[@class=' table-condensed']//thead//tr[2]//th[2]")).getText();

			String extractedMonth = monthAndYear.substring(0, monthAndYear.indexOf(" "));
			String extractedYear = monthAndYear.substring(monthAndYear.indexOf(" ") + 1);

			if (extractedMonth.equalsIgnoreCase(requiredMonth) && extractedYear.equals(requiredYear)) {
				break;
			}
			driver.findElement(By.xpath("//table[@class=' table-condensed']//thead//tr[2]//th[3]")).click();
		}

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class=' table-condensed']//tbody//tr//td"));
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getText().equals(requiredDate)) {
				dates.get(i).click();
				break;
			}
		}

	}

}
