package testng.batchTesting;

import org.testng.annotations.Test;

public class ProductPageTest {
	@Test
	public void cashOnDelivert() {
		System.out.println("COD");
	}

	@Test
	public void netBanking() {
		System.out.println("Net banking");
	}
	
	@Test
	public void selectQuantity() {
		System.out.println("Quantity selection");
	}
}
