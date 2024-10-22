package testng;

import org.testng.annotations.Test;

// The description attribute is part of the @Test annotation. It is often used to give a human-readable explanation of the test’s purpose, making it easier to understand why a test exists when viewing the test results or reports.

public class DescriptionTest {
	@Test(description = "This test checks the login functionality with valid credentials")
	public void validLoginTest() {
		System.out.println("Executing valid login test...");
	}

	@Test(description = "This test checks the login functionality with invalid credentials")
	public void invalidLoginTest() {
		System.out.println("Executing invalid login test...");
	}
}
