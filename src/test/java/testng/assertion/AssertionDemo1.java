package testng.assertion;

import org.testng.annotations.Test;

public class AssertionDemo1 {

	@Test
	public void testAssertion() {
		String expOutput = "Sriram";
		String actualOutput = "Sriram1";
		if (expOutput.equals(actualOutput)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

}

//If statements can not make a test method fail, that is why we use assertion.