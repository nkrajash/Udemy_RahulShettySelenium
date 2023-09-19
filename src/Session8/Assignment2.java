package Session8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException{

			ChromeOptions options=new ChromeOptions();
	
			Map<String, Object> prefs=new HashMap<String,Object>();
	
			prefs.put("profile.default_content_setting_values.notifications", 1);
			//1-Allow, 2-Block, 0-default

			options.setExperimentalOption("prefs",prefs);
			System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver=new ChromeDriver(options);//launch Chrome browser with ChromeOptions
	
			driver.manage().window().maximize(); //maximize the windows  
			//to enable elements which are hidden and invisible
			driver.manage().deleteAllCookies(); // delete all the cookies
			//dynamic wait - implicit wait

			driver.get("https://www.cleartrip.com");
			 
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("span.radio__circle.bs-border.bc-neutral-500.bw-1.ba")).click();

		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    Select AdultsDrp = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='bc-neutral-100 bg-transparent'])[1]"))));
			AdultsDrp.selectByValue("5");

		    Select ChildrenDrp = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='bc-neutral-100 bg-transparent'])[2]"))));
			ChildrenDrp.selectByValue("2");

			Select InfantDrp = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='bc-neutral-100 bg-transparent'])[3]"))));
			InfantDrp.selectByValue("1");

			driver.findElement(By.cssSelector("div.row.pt-3.p-relative.px-4 a")).click();
			
			
			WebElement airline= driver.findElement(By.xpath("//input[@placeholder='Airline name']"));
			airline.sendKeys("indigo");
			
			Select TravelClass = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='bc-neutral-100 bg-transparent'])[4]"))));
			TravelClass.selectByValue("Business");
			
			
			WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Search flights')]")));
			search.click();
			
			
			System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Select Departure and Arrival airports')]")).getText());
			driver.close();
	}

}


