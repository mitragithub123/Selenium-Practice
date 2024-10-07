package testng;

import org.testng.annotations.Test;

public class TC07 {

	@Test
	public void openApp() {
		System.out.println("Open the application");
	}

	@Test
	public void login() {
		System.out.println("Login to the application");
	}

	@Test
	public void logout() {
		System.out.println("Logout from the application");
	}

	public void closeApp() {
		System.out.println("Close the application");
	}
}
