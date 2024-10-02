package email;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Image;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class ReadEmail {
	@Test
	public void testMailExample() throws IOException, MailosaurException {
		// https://mailosaur.com/docs/languages/java
		// https://github.com/mailosaur/mailosaur-java?tab=readme-ov-file
		// https://mailosaur.com/docs/automation/selenium/email-testing
		// https://www.youtube.com/watch?v=Il8efgsiJyw&ab_channel=NaveenAutomationLabs
		// Sign up to Mailosaur and create api key

		String apiKey = "ebqnTbM3WyterGkilY6rEglB1PmRecEX";
		String serverId = "7hsmfofm";
		String serverDomain = "7hsmfofm.mailosaur.net";

		MailosaurClient mailosaur = new MailosaurClient(apiKey);

		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("cutting-relationship@" + serverDomain);

		Message message = mailosaur.messages().get(params, criteria);
		System.out.println("Email Subject: " + message.subject());
		System.out.println("To: " + message.to());
		System.out.println("CC: " + message.cc());
		System.out.println("BCC: " + message.bcc());
		System.out.println("From: " + message.from());
		System.out.println("Email Body: " + message.text().body());

		// Print total links in the body
		System.out.println("Total Links in Email (HTML): " + message.html().links().size());

		Link firstLink = message.html().links().get(0);
		System.out.println(firstLink.text());// Print 1st link text in the body
		System.out.println(firstLink.href());// Print 1st link href in the body
		Link secondLink = message.html().links().get(0);
		System.out.println(secondLink.text());// Print 2nd link text in the body
		System.out.println(secondLink.href());// Print 2nd link href in the body

		// Print all links in the body
		List<Link> links = message.html().links();
		for (Link link : links) {
			System.out.println(link.text());
			System.out.println(link.href());
		}
		// Number of attachments found
		System.out.println("Total attachment: " + message.attachments().size());
		Image firstImage = message.html().images().get(0);

		// Number of images found
		System.out.println("Total images: " + message.html().images().size());
		System.out.println("Src of image: " + firstImage.src());
		System.out.println("Alt of image: " + firstImage.alt());

		// Print all images
		List<Image> images = message.html().images();
		for (Image image : images) {
			System.out.println(image.src());
			System.out.println(image.alt());
		}

		// Email subject validation
		// Assert.assertEquals("Welcome to Orangescrum!", message.subject());
		// Email body validation
		// Assert.assertTrue(message.text().body().contains("We're excited to have you
		// onboard!"));

		String otpPattern = "^\\d{6}$"; // Regex pattern for 6-digit OTP
		Pattern pattern = Pattern.compile(otpPattern);
		Matcher matcher = pattern.matcher(message.text().body());
		System.out.println(matcher.group(1));

	}

}
