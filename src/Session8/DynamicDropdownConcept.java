package Session8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdownConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows  
		 //to enable elements which are hidden and invisible
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait - implicit wait
		 
		 driver.get("https://www.spicejet.com/");
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 // From drop-down
		 driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		 
	     driver.findElement(By.xpath("//a[@value='BLR']")).click();
	     
	     
		 // To drop-down
 	     //Method 1:
	     //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	     
	     //Method 2:
	     //PARENT -CHILD RELATIONSHIP: To drop-down
		 driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
	     //Click on the current date
		 driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		 
		 //Select round trip radio button by clicking on it
		 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		 //check for the style attribute of the return date calendar to check if its enabled or not
		 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			 Assert.assertTrue(true);
			 System.out.println("Return date is enabled");
		 }
		 else{
			 Assert.assertTrue(false);
			 System.out.println("Return date is not enabled");
		 }
		 
	     driver.quit();
	}

}
