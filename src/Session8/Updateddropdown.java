package Session8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Updateddropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait
		 
		 driver.get("https://www.goindigo.in/");
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 //dynamic wait - implicit wait
		 
		 //Click on Passengers dropdown
		 driver.findElement(By.xpath("//input[@name='passenger']")).click();
		 //dynamic wait - explicit wait
		 scrollPageDown(driver);
		 int i=1;
		 for(;i<=5;i++) {
			 driver.findElement(By.xpath("(//*[@id='bookFlightTab']//button[@title='Up'])[1]")).click();
		 }
	     System.out.println("Adults=" + (i-1));
	     i=1;
	     for(;i<=3;i++) {
			 driver.findElement(By.xpath("(//*[@id='bookFlightTab']//button[@title='Up'])[2]")).click();
		 }
	     System.out.println("Children=" + (i-1));
	     i=1;
	     for(;i<=2;i++) {
			 driver.findElement(By.xpath("(//*[@id='bookFlightTab']//button[@title='Up'])[3]")).click();
		 }
		 System.out.println("Infants=" + (i-1));

		
		 //Click on Done button
		 driver.findElement(By.xpath("//*[@id='bookFlightTab']//button[contains(text(),'Done')]")).click();
		 driver.quit();
		 
	}

	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,400)");
	}
}
