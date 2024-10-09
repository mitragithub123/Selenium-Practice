package testng.groupping;

import org.testng.annotations.Test;

public class PaymentTests {

	@Test(priority = 1, groups = { "Sanity", "Regression" })
	public void paymentInRupees() {
		System.out.println("Payment in rupees..");
	}

	@Test(priority = 2, groups = { "Sanity", "Regression" })
	public void paymentInDollars() {
		System.out.println("Payment in dollars..");
	}

}
