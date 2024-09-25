package tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Find the total number of rows in the table
		int row = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total no of rows: " + row);
		// int row1 = driver.findElements(By.tagName("tr")).size(); (If only 1 table is
		// present in page)

		// Find the total number of columns in the table
		int col = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total no of columns: " + col);
		// int col1 = driver.findElements(By.tagName("th")).size(); (If only 1 table is
		// present in page)

		// Read data from all rows and cols
		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");
		for (int i = 2; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]"))
						.getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}

		System.out.println("------------------");

		// Print book names whose author is Mukesh
		for (int i = 2; i <= row; i++) {
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[2]"))
					.getText();
			if (authorName.equalsIgnoreCase("mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[1]"))
						.getText();
				System.out.println(bookName);
			}
		}

		System.out.println("------------------");

		// Find total price of all books.
		int total = 0;
		for (int i = 2; i <= row; i++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[4]")).getText();
			total = total + Integer.parseInt(price);
		}
		System.out.println("Total price: " + total);

		System.out.println("------------------");

		// Find the book with the minimum price
		int minPrice = Integer.MAX_VALUE;
		String minPriceBookName = "";

		for (int i = 2; i <= row; i++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[4]")).getText();
			int priceValue = Integer.parseInt(price);
			if (priceValue < minPrice) {
				minPrice = priceValue;
				minPriceBookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[1]"))
						.getText();
			}
		}
		System.out.println("Book with the minimum price is: " + minPriceBookName + " with price: " + minPrice);
	}

}
