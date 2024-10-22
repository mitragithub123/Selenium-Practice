package testng.listners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListnerDemo1 {
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
