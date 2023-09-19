package Session14;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class FindBrokenLinksusingSelenium {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver;
        driver = new ChromeDriver();
        
        //Java methods help us to call URLs and get their status code.
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        // if status > 400, link is broken, link tied to URL is broken.
		String url1 = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		String url2 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

		HttpURLConnection conn = (HttpURLConnection) new URL(url1).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);//200
		conn.disconnect();
		
		HttpURLConnection conn2 = (HttpURLConnection) new URL(url2).openConnection();
		//GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE are parameters
		conn2.setRequestMethod("HEAD");
		conn2.connect();
		int respCode2 = conn2.getResponseCode();
		System.out.println(respCode2);//404
		conn2.disconnect();
		System.out.println("=======================================================");
		//Lets iterate through each of the links below:
		List <WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
        for(WebElement link:links) {
        	String url3 = link.getAttribute("href");
        	System.out.println(url3);
    		HttpURLConnection conn3 = (HttpURLConnection) new URL(url3).openConnection();
    		//GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE are parameters
    		conn3.setRequestMethod("HEAD");
    		conn3.connect();
    		int respCode3 = conn3.getResponseCode();
    		System.out.println(respCode3);
			a.assertTrue(respCode3<400,"The link with text broken is "+ link.getText()+ "with respcode"+respCode3);
        }
        System.out.println("=======================================================");
		a.assertAll();
		
        driver.quit();
	}

}

/*Quiz:
Question 1:
Name the class to customize the Chrome browser:
a.ChromeOptions
b.AcceptInsecureCerts
c.DesiredCapabilities
d.ChromeDriver
Ans:c

Question 2:
How to handle SSL certificates in Chrome browser in Selenium?
A: DesiredCapabilities ch=DesiredCapabilities.chrome(); 
   ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
B: DesiredCapabilities ch=DesiredCapabilities.chrome(); 
   ch.getCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
C: DesiredCapabilities ch=DesiredCapabilities.chrome(); 
   ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
D: DesiredCapabilities ch=DesiredCapabilities.chrome(); 
   ch.getCapability(ACCEPT_SSL_CERTS);
Ans: A

Question 3:
Identify the method to maximize the browser window.
a.driver.maximize();
b.driver.manage.maximize.window();
c.driver.manage.window().maximize();
d.driver.manage().window().maximize();
Ans: d

Question 4:
How to delete cookies in Selenium Web Driver?
a.driver.manage().window().deleteAllCookies();
b.driver.manage().deleteCookieNamed("sessionId")
c.All of the above
d.None of the above
Ans: c

Question 5:
How to capture screenshots with Selenium Web driver?
a.File src = driver.getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(src, new File("C:\\Users\\screenshots\\screenshot.png"));
b.File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(src, new File("C:\\Users\\screenshots\\screenshot.png"));
c.File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(new File("C:\\Users\\screenshots\\screenshot.png"));
d.File src = ((TakesScreenshot)driver).getScreenshotAs();
  FileUtils.copyFile(src, new File("C:\\Users\\screenshots\\screenshot.png"));  
Ans:b

Question 6:
How to identify broken links in Selenium Webdriver?
a.Get status codes of links to decide if they are broken
b.Get url attribute to decide if they are broken
c.Impossible to validate in Selenium
Ans: a


 * */
