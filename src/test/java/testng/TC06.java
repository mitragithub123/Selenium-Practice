package testng;

import org.testng.annotations.Test;

public class TC06 {
	@Test(priority = -1)
	public void openApp() {
		System.out.println("Open the application");
	}

	@Test(priority = -2)
	public void login() {
		System.out.println("Login to the application");
	}

	@Test(priority = 0)
	public void logout() {
		System.out.println("Logout from the application");
	}

	@Test(priority = 1)
	public void closeApp() {
		System.out.println("Close the application");
	}
}
