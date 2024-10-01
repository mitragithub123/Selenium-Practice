package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		String file = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(file);

		Properties property = new Properties();
		property.load(fis);

		// Reading data from properties file
		String url = property.getProperty("appUrl");
		String mail = property.getProperty("email");
		String pass = property.getProperty("password");
		System.out.println(url + " " + mail + " " + pass); // https://demo.opencart.com/ abc@gmail.com 12345678

		// Reading all keys from properties file
		Set<String> keys = property.stringPropertyNames();
		System.out.println(keys); // [password, appUrl, email]
		// or,
		Set<Object> keySet = property.keySet(); // [password, appUrl, email]
		System.out.println(keySet);

		// Reading all values from properties file
		Collection<Object> values = property.values();
		System.out.println(values); // [12345678, https://demo.opencart.com/, abc@gmail.com]
	}

}
