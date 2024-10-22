package testng.listners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listner.class)
public class ListnerDemo2 {
	@Test
	public void add() {
		System.out.println("This is addition..");
	}
	@Test
	public void diff() {
		System.out.println("This is difference..");
		Assert.fail();
	}
}
