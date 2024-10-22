package testng;

import org.testng.annotations.Test;

public class EnableDisableTest {
	@Test(enabled = true) // This test will run (enabled is true by default)
	public void testEnabled() {
		System.out.println("This test is enabled and will execute.");
	}

	@Test(enabled = false) // This test will not run
	public void testDisabled() {
		System.out.println("This test is disabled and will not execute.");
	}

	@Test // enabled is true by default, so this test will run
	public void testDefault() {
		System.out.println("This test will execute by default (enabled = true).");
	}
}
