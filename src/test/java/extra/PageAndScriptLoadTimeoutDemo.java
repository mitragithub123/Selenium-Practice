package extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageAndScriptLoadTimeoutDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

	}
	
	
	    /*The default timeouts in Selenium are:
			Implicit wait: 0 milliseconds
			Page load timeout: 300,000 milliseconds (5 minutes)
			Script timeout: 30,000 milliseconds (30 seconds)
		
		To inspect all capabilities:
			Set a breakpoint at WebDriver driver = new ChromeDriver();
			Debug the code
			Use "Step Over" to proceed
			Hover over the driver instance
			Click on "Capabilities" to view all available settings*/
	
	
	/*
	 * Capabilities {acceptInsecureCerts: false, browserName: chrome,
	 * browserVersion: 133.0.6943.98, chrome: {chromedriverVersion: 133.0.6943.98
	 * (da53563ceb66..., userDataDir: C:\Users\hp\AppData\Local\T...},
	 * fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:52945},
	 * networkConnectionEnabled: false, pageLoadStrategy: normal, platformName:
	 * windows, proxy: Proxy(), se:cdp: ws://localhost:52945/devtoo...,
	 * se:cdpVersion: 133.0.6943.98, setWindowRect: true, strictFileInteractability:
	 * false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000},
	 * unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob:
	 * true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength:
	 * true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
	 */
}
