package Session14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleSSLCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SSl certificates
		//Now not used in Selenium, Desired Capabilities are used in Appium driver for Mobile Automation.
		//Desired capabilities:
		//Capabilities are options that you can use to customize and configure a ChromeDriver session.
		//general chrome profile
		DesiredCapabilities ch=DesiredCapabilities.chrome(); // instantiate DesiredCapabilities Class
		//ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		//Belongs to your local browser:
		ChromeOptions c= new ChromeOptions();  // instantiate ChromeOptions Class
		c.merge(ch); // passing DesiredCapabilities class object to ChromeOptions Class
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(c);

		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.quit();
	}

}
