package testng.batchTesting;

import org.testng.annotations.Test;

public class HomeScreenTest {
	@Test
	public void launchApplication() {
		System.out.println("Application launch");
	}

	@Test
	public void verifyTitle() {
		System.out.println("Title verification");
	}
	
	@Test
	public void verifyLogo() {
		System.out.println("Logo verification");
	}
}
