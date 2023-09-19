package Session8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EndToEndTravelUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows  
		 //to enable elements which are hidden and invisible
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait - implicit wait
		 
		 driver.get("https://www.spicejet.com");
		 
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 //One way trip radio button clicking on it
		 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		 
		 //Click on input origin station button
		 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		 
		 //scroll page slightly down
		 scrollPageDown(driver);
		 
		 //Select Jalandhar - AIP From station
		 driver.findElement(By.xpath("//a[@value='AIP']")).click();
		 
		 //Select Mumbai - BOM To station
		 driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BOM']")).click();
		 
		 //Click on the current date in depart date calendar
		 driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		 
		 //Check if return date calendar is disabled due to one-way trip
		 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			 Assert.assertTrue(true);
			 System.out.println("Return date is not enabled");
		 }
		 else{
			 Assert.assertTrue(false);
			 System.out.println("Return date is enabled");
		 }
		 //Click on the Family & Friends radio button
		 driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		 
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
	     
	     //Click on static dropdown for currency
		 WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		 //Single select option for currency type
		 Select Currencydropdown = new Select(currency);
		 Currencydropdown.selectByIndex(5); //Select By index -5 i.e.USD
		 String cur = Currencydropdown.getFirstSelectedOption().getText();
		 System.out.println(cur);

		 //Outer HTML for Search button:-
		 // <input type="submit" name="ctl00$mainContent$btn_FindFlights" value="Search" id="ctl00_mainContent_btn_FindFlights">
		 
		 //Many ways to write the Web-locator expression above:
		 //driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); -- 1 occurrence
		 //driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click(); -- 1 occurrence
		 //driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		 //driver.findElement(By.xpath("input[@value='Search']")).click(); -- 2 occurrences
		 //driver.findElement(By.xpath("input[@type='submit']")).click();  -- 2 occurrences
		 //driver.findElement(By.cssSelector("input[value='Search']")).click(); -- 2 occurrences
		 //driver.findElement(By.cssSelector("input[type='submit']")).click(); -- 2 occurrences
		 
		 driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		 System.out.println(driver.getTitle());
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.quit();
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,300)");
	}
	
}
