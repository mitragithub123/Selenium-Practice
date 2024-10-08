package testng.packForAfterAndBeforeTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Common {

	@BeforeTest
	public void bt() {
		System.out.println("Before Test method");
	}

	@AfterTest
	public void at() {
		System.out.println("After Test method");
	}

}
