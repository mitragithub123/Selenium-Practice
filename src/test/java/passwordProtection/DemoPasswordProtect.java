package passwordProtection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoPasswordProtect {
	public static final String SECRET_KEY = "MyTestSecretKey1";
	public static Properties properties;

	public static void main(String[] args) throws IOException {
		// Check encryption process
		// String passwordString = "12345678";
		// String encrptedString = encrypt(passwordString);
		// System.out.println(encrptedString);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.orangescrum.com/users/login");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#txt_UserId")).sendKeys("andolasoft.user133@gmail.com");

		// Fetch encrypted password and decrypt it
		readPropFile();
		String encryptedPassword = properties.getProperty("password");
		String decryptedPassword = decrypt(encryptedPassword);
		driver.findElement(By.cssSelector("#txt_Password")).sendKeys(decryptedPassword);

		driver.findElement(By.cssSelector("#submit_Pass")).click();

	}

	public static Properties readPropFile() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\passwordProtection\\password.properties");
		properties = new Properties();
		properties.load(fis);
		return properties;
	}

	public static String encrypt(String strToEncrypt) {
		try {
			SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decrypt(String strToDecrypt) {
		try {
			SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
