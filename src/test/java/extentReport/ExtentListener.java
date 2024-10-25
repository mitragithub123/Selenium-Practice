package extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener implements ITestListener {

	ExtentSparkReporter htmlReporter; // User interface and look & feel of the report
	ExtentReports reports; // Common information
	ExtentTest test; // Entries for test
	public String reportName;
	public List<String> includedGroups;

	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "AutomationTestReport-" + timestamp + ".html";
		String reportPath = System.getProperty("user.dir") + "/Reports/" + reportName;

		// Ensure the Reports directory exists
		File reportsDir = new File(System.getProperty("user.dir") + "/Reports");
		if (!reportsDir.exists()) {
			reportsDir.mkdirs();
		}

		htmlReporter = new ExtentSparkReporter(reportPath);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add system information/environment info to reports
		reports.setSystemInfo("Machine:", "AS-PC-007");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Tester name:", "Mitra bhanu");

		// To display groups in reports
		if (includedGroups != null && !includedGroups.isEmpty()) {
			reports.setSystemInfo("Groups", includedGroups.toString());
		}

		// Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("Rest Assured Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
		includedGroups = context.getCurrentXmlTest().getIncludedGroups();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started:" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method successfully executed:" + result.getName());

		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName());
		test = reports.createTest(result.getName()); // create entry in html report
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));

		// Log the exception message
		Throwable exception = result.getThrowable();
		if (exception != null) {
			test.log(Status.FAIL, exception);
		}

		String screenShotPath = System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + ".png";

		File screenShotFile = new File(screenShotPath);

		if (screenShotFile.exists()) {
			try {
				test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped:" + result.getName());

		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked....");
		reports.flush(); // It is mandatory to call flush method to ensure information is written to the
							// started reporter.

		// To open report automatically in browser
		String reportPath = System.getProperty("user.dir") + "\\Reports\\" + reportName;
		File extentReport = new File(reportPath);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// To send the email report via mail
		// Make sure less secured apps options enabled in gmail (Disable 2 factor
		// authorization)
		/*
		 * try { URL url = new URL("file:///" + reportPath);
		 * 
		 * // Create the email message ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); email.setSmtpPort(587); // 465
		 * email.setStartTLSEnabled(true); // Enable TLS email.setAuthenticator(new
		 * DefaultAuthenticator("mitrabhanu.prusty@andolasoft.us", "******"));// email &
		 * password of sender email.setFrom("mitrabhanu.prusty@andolasoft.us"); //
		 * Sender email.setSubject("Automation Test Results"); // Email body String
		 * emailBody = "<html>" + "<body>" + "<p>Dear Sir,</p>" +
		 * "<p>I hope this message finds you well.</p>" +
		 * "<p>Attached, please find the latest test results report. This report includes all the recent test cases and their results, which were executed as part of our ongoing testing efforts.</p>"
		 * +
		 * "<p>Should you have any questions or need further details, please do not hesitate to reach out.</p>"
		 * + "<p>Best regards,</p>" + "<p>Mitra bhanu Prusty</p>" +
		 * "<p>Quality Analyst</p>" + "<p>+91-8249493741</p>" + "</body>" + "</html>";
		 * 
		 * email.setMsg(emailBody); email.setMsg(emailBody);
		 * email.addTo("andolasoft.user133@gmail.com"); // Receiver
		 * email.addCc("andolasoft.user212@gmail.com"); // CC recipient
		 * //email.addBcc("bcc-recipient@example.com"); // BCC recipient
		 * email.attach(url, "extent report", "please check report..."); email.send();
		 * // send the email } catch (Exception e) { e.printStackTrace(); }
		 */
	}

}
