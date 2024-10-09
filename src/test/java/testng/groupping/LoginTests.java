package testng.groupping;

import org.testng.annotations.Test;

public class LoginTests {
	@Test(priority = 1, groups = { "Sanity" })
	public void loginByEmail() {
		System.out.println("Email login");
	}

	@Test(priority = 2, groups = { "Sanity" })
	public void loginByFacebook() {
		System.out.println("Facebook login");
	}

	@Test(priority = 3, groups = { "Sanity" })
	public void loginByTwitter() {
		System.out.println("Twitter login");
	}
}
