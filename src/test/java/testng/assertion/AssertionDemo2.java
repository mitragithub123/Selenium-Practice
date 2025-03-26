package testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo2 {

	@Test
	public void testAssertion() {
		String expOutput = "Sriram";
		String actualOutput = "Sriram1";
		if (expOutput.equals(actualOutput)) {
			System.out.println("Test Pass");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test Fail");
			Assert.assertTrue(false);
			// Assert.fail();
		}
	}

}
