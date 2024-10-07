package testng;

import org.testng.annotations.Test;

public class TC03 {

	@Test(priority = 10)
	public void openApp() {
		System.out.println("Open the application");
	}

	@Test(priority = 5)
	public void login() {
		System.out.println("Login to the application");
	}

	@Test(priority = 20)
	public void logout() {
		System.out.println("Logout from the application");
	}
}
