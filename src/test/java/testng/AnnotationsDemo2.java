package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {

	@BeforeClass
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

	@AfterClass
	public void logout() {
		System.out.println("This is logout..");
	}

}
