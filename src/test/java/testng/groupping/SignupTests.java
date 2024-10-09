package testng.groupping;

import org.testng.annotations.Test;

public class SignupTests {
	@Test(priority = 1, groups = { "Regression" })
	public void signupByEmail() {
		System.out.println("Email signup");
	}

	@Test(priority = 2, groups = { "Regression" })
	public void signupByFacebook() {
		System.out.println("Facebook signup");
	}

	@Test(priority = 3, groups = { "Regression" })
	public void signupByTwitter() {
		System.out.println("Twitter signup");
	}
}
