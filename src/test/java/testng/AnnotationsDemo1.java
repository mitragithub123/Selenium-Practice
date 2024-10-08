package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo1 {

	@BeforeMethod
	public void login() {
		System.out.println("This is login..");
	}

	@Test(priority = 1)
	public void search() {
		System.out.println("This is search..");
	}

	@Test(priority = 2)
	public void advancedSearch() {
		System.out.println("This is advanced search..");
	}

	@AfterMethod
	public void logout() {
		System.out.println("This is logout..");
	}

}
