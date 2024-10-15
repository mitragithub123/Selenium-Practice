package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	@Test
	void testHardAssertion() {
		Assert.assertEquals("xyz", "xyz"); // pass
		Assert.assertEquals(123, 345); // failed

		// Assert.assertEquals("abc",123); // Expects equal but abc!=123
		// Assert.assertEquals("123",123); // Expects equal & 123=123

		// Assert.assertNotEquals(123,123); //failed // Expects not equal but 123=123
		// Assert.assertNotEquals(123,345); //passed // Expects not equal and 123!=345

		// Assert.assertTrue(true); //pass
		// Assert.assertTrue(false); //failed

		// Assert.assertTrue(1==2); //fail // Expects true and 1==2 is false
		// Assert.assertTrue(1==1); //passed // Expects true and 1==1 is true

		// Assert.assertFalse(1==2); //passed // Expects false and 1==2 is false
		// Assert.assertFalse(1==1); //failed // Expects false and 1==1 is true

		Assert.fail(); // Directly fail a test method
	}
}
