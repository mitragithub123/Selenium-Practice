package testng.batchTesting;

import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void loginByMobileNumber() {
		System.out.println("Mobile login");
	}

	@Test
	public void loginByEmail() {
		System.out.println("Email login");
	}
}
