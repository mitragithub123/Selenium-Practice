package testng;

import org.testng.annotations.Test;

public class TC01 {
	@Test
	public void openApp() {
		System.out.println("Open the application");
	}

	@Test
	public void login() {
		System.out.println("Login the application");
	}

	@Test
	public void logout() {
		System.out.println("Logout the application");
	}
}