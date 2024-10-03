package email;

import java.io.IOException;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickConfirmButtonOnMail {

	String apiKey = "ebqnTbM3WyterGkilY6rEglB1PmRecEX";
	String serverId = "7hsmfofm";
	String serverDomain = "7hsmfofm.mailosaur.net";
	String from = "noreply@groww.in";

	public String generateRandomEmail() {
		return "user" + RandomStringUtils.randomAlphabetic(7) + "@" + serverDomain;
	}

	@Test
	public void testOtp() throws IOException, MailosaurException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://userfront.com/signup");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[contains(text(),'Email me a link')]")).click();
		String randomEmail = generateRandomEmail();
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(randomEmail);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		MailosaurClient mailosaur = new MailosaurClient(apiKey);

		// Wait for the email to arrive using the waitForEmail method
		Message message = waitForEmail(randomEmail, mailosaur);
		if (message == null) {
			System.out.println("Email not found.");
			driver.quit(); // Exit if no email is received
			return;
		}

		// Extract and click the "Confirm your email" link
		String confirmLink = findConfirmEmailLink(message);
		if (confirmLink != null) {
			System.out.println("Found Confirm your email link: " + confirmLink);
			driver.get(confirmLink); // Navigate to the confirmation link
		} else {
			System.out.println("Confirm your email link not found.");
		}

	}

	// Helper method to find and return the "Confirm your email" link from the
	// message body
	private String findConfirmEmailLink(Message message) {
		// Use the HTML body to extract the correct link
		String body = message.html().body();

		// Regular expression to find the anchor tag with the text "Confirm your email"
		Pattern pattern = Pattern.compile(
				"<a[^>]+href=['\"](https?://[^'\"]+)['\"][^>]*>(.*?)Confirm your email(.*?)</a>",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(body);

		// Find the link with "Confirm your email" in the anchor text
		if (matcher.find()) {
			String confirmLink = matcher.group(1); // Extract the URL from the href attribute
			return confirmLink;
		}

		return null;
	}

	// Wait for the email to arrive
	public Message waitForEmail(String emailId, MailosaurClient mailosaur) throws MailosaurException {
		Wait<MailosaurClient> wait = new FluentWait<>(mailosaur)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class);

		return wait.until(mailosaurClient -> {
			try {
				MessageSearchParams params = new MessageSearchParams();
				params.withServer(serverId);

				SearchCriteria criteria = new SearchCriteria();
				criteria.withSentTo(emailId);

				Message message = mailosaurClient.messages().get(params, criteria);
				return message;
			} catch (MailosaurException | IOException e) {
				return null;
			}
		});
	}
}
