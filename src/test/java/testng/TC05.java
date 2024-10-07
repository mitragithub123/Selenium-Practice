package testng;

import org.testng.annotations.Test;

public class TC05 {

	@Test(priority = 1)
	public void openApp() {
		System.out.println("Open the application");
	}

	@Test(priority = 1)
	public void login() {
		System.out.println("Login to the application");
	}

	@Test(priority = 1)
	public void logout() {
		System.out.println("Logout from the application");
	}

}
