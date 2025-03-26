package testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionHardVsSoft {
	@Test(priority = 1)
	public void testHardAssertion() {
		System.out.println("Testing");
		System.out.println("Testing");

		// Hard assertion
		Assert.assertEquals(1, 2); // If this statement fails here, it will not execute further lines.
		// So we use soft assertions in this case.

		System.out.println("Testing");
		System.out.println("Testing");
	}

	@Test(priority = 2)
	public void testSoftAssertion() {
		System.out.println("Testing");
		System.out.println("Testing");

		// Soft assertion
		SoftAssert sa = new SoftAssert(); // If this statement fails here, it will execute further lines too.
		sa.assertEquals(1, 2);

		System.out.println("Testing");
		System.out.println("Testing");
		
		sa.assertAll(); // This will fail the test if any soft assertions failed (Mandatory)
	}
}
