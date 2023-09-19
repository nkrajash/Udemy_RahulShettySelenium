package Session8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class StaticDropdownConcept {

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
				 WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				 //Single select option
				 Select Currencydropdown = new Select(currency);
				 Currencydropdown.selectByIndex(5);
				 String cur = Currencydropdown.getFirstSelectedOption().getText();
				 System.out.println(cur);
				 
				 Currencydropdown.selectByVisibleText("AED");
				 cur = Currencydropdown.getFirstSelectedOption().getText();
				 System.out.println(cur);
				 
				 Currencydropdown.selectByValue("INR");
				 cur = Currencydropdown.getFirstSelectedOption().getText();
				 System.out.println(cur);
				 
				 //Click on Passengers dropdown
				 driver.findElement(By.id("divpaxinfo")).click();
				 //dynamic wait - explicit wait
				 WebDriverWait wait = new WebDriverWait(driver, 20);
			     Select selectAdult = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Adult"))));
			     selectAdult.selectByVisibleText("5");
			     System.out.println("Adults=" + selectAdult.getFirstSelectedOption().getText());
			     Select selectChild = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Child"))));
			     selectChild.selectByVisibleText("3");
			     System.out.println("Children=" + selectChild.getFirstSelectedOption().getText());
			     Select selectInfant = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Infant"))));
			     selectInfant.selectByVisibleText("1");
			     System.out.println("Infants=" + selectInfant.getFirstSelectedOption().getText());
			     
			     System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

			     Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult, 3 Child, 1 Infant");
			     if(driver.findElement(By.id("divpaxinfo")).getText().equals("5 Adult, 3 Child, 1 Infant")) {
			    	 System.out.println("Successfully entered the no of passengers..");
			     }
			     else {
			    	 System.out.println("Failed to enter the no of passengers..");
			     }
			     Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());	 
			     int ncountCheckboxes = driver.findElements(By.cssSelector("[type='checkbox']")).size();
			     System.out.println(ncountCheckboxes);
			     driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			     
			     if(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) {
			    	 System.out.println("Senior Citizen Selected");
			     }
			     else {
			    	 System.out.println("Senior Citizen Not Selected");
			     }
			     Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());	 
			     
			     driver.quit();
				 
	}
}
