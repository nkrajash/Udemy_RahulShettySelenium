package Session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class parentchildrelationxpath {
	 //Parent Child relationship: Define xpath for the parent/tagnames.
	 //Like Firepath - firefox deprecated post v56
	 //Have Chropath - chrome recently in 2020.
	public static void main(String[] args) throws InterruptedException {
		  	String baseUrl = "https://www.google.co.in/";
	        System.setProperty("webdriver.chrome.driver","C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	
	        driver.get(baseUrl);   
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        
	        WebElement googlesearch = driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input"));
	        googlesearch.sendKeys("MayDay");
	        googlesearch.click();
	        driver.quit();
	}
}
