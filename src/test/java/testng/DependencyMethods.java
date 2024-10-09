package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

	/*
	 * In TestNG, the dependsOnMethods attribute is used to define dependencies
	 * between test methods. It allows one test method to depend on the successful
	 * execution of another test method. This means that the dependent test method
	 * will only be executed if the method it depends on passes. If the dependent
	 * method fails or is skipped, the dependent test will be skipped automatically.
	 */

	@Test(priority = 1)
	public void openApp() {
		Assert.assertTrue(true);
	}

	@Test(priority = 2, dependsOnMethods = { "openApp" })
	public void login() {
		Assert.assertTrue(false);
	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	public void search() {
		Assert.assertTrue(true);
	}

	@Test(priority = 4, dependsOnMethods = { "login", "search" })
	public void advancedSearch() {
		Assert.assertTrue(true);
	}

	@Test(priority = 5, dependsOnMethods = { "login" })
	public void logout() {
		Assert.assertTrue(true);
	}

}
