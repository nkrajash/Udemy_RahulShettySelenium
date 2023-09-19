package Session8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows  
		 //to enable elements which are hidden and invisible
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait - implicit wait
		 
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());	 
	     
	     driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
	     Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());	 
	     driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
	     Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());	 

	     int ncountCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	     System.out.println(ncountCheckboxes);

	}

}
