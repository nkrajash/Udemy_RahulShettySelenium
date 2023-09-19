package Session21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Envvariables_propertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Data\\Selenium-workspace\\Udemy_RahulShettySelenium\\src\\Session21\\data.properties");
		prop.load(fis);

		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));

		prop.setProperty("browser", "firefox");
		System.out.println(prop.getProperty("browser"));

		FileOutputStream fos = new FileOutputStream("E:\\Data\\Selenium-workspace\\Udemy_RahulShettySelenium\\src\\Session21\\data.properties");
		prop.store(fos, null);

	}
}
