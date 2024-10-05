package file;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PDFReader {
	public WebDriver driver;
	public String url = "https://ncert.nic.in/pdf/publication/exemplarproblem/classXII/mathematics/leep209.pdf";

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void readPDF() throws IOException {
		URL pdfUrl = new URL(url);
		InputStream inpstm = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(inpstm);
		PDDocument pdDoc = PDDocument.load(bf); // This will not work in newer Pdfbox versions (Use 2.0.27)

		// Page count
		int pageCount = pdDoc.getNumberOfPages();
		System.out.println("Total no of pages: " + pageCount);

		// Page content text
		System.out.println("---------------------");
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String pdfText = pdfStripper.getText(pdDoc);
		System.out.println(pdfText);
		Assert.assertTrue(pdfText.contains("DIFFERENTIAL EQUATIONS"));

		// Set the page number and get the text
		System.out.println("---------------------");
		pdfStripper.setStartPage(24);
		String pdfText1 = pdfStripper.getText(pdDoc);
		System.out.println(pdfText1);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
