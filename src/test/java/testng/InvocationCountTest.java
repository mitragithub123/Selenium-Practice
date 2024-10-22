package testng;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testng.listners.Listner.class)
public class InvocationCountTest {

	@Test(invocationCount = 5) // This method will execute 5 times
	public void demo(ITestContext context) {
		int currentInvocation = context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing test iteration: " + currentInvocation);
	}
}
