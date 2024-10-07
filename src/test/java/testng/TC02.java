package testng;

import org.testng.annotations.Test;

public class TC02 {
	@Test(priority=1)
	public void openApp() {
		System.out.println("Open the application");
	}

	@Test(priority=2)
	public void login() {
		System.out.println("Login the application");
	}

	@Test(priority=3)
	public void logout() {
		System.out.println("Logout the application");
	}
}
