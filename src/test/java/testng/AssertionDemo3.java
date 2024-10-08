package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo3 {
	@Test
	public void testAssertion() {
		String expOutput = "Sriram";
		String actualOutput = "Sriram1";
		Assert.assertEquals(expOutput, actualOutput, "Test failed...");
		// Assert.assertEquals(expOutput, actualOutput);
	}

}
