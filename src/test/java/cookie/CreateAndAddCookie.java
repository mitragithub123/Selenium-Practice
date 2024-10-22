package cookie;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndAddCookie {
	// Cookies are small pieces of data that websites store on a user's browser.
	// They are commonly used for session management, user personalization, and
	// tracking.
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Cookie ck = new Cookie("Mitra bhanu", "Tester");// Create cookie
		driver.manage().addCookie(ck);// Add cookie

		Set<Cookie> cookies = driver.manage().getCookies();// Extract all cookies and store
		System.out.println("Total cookies: " + cookies.size());// Print cookies size
		// Print all cookies
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ": " + cookie.getValue());
		}
	}

}
