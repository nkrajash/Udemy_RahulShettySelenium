package Session6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebLocatorsforWebobjects{

	public static void main(String[] args) throws InterruptedException {
		  	String baseUrl = "https://en-gb.facebook.com/";
	        System.setProperty("webdriver.chrome.driver","C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	
	        driver.get(baseUrl);   
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        
	        //Usually alpha numeric ids may change upon web page refresh.
	        //Every web object might not have id,classname or name.xpath and cssselector preferred.
	        //link can be confirmed with anchor (a) tag.
	        //compound classes ie class names with spaces cannot be accepted.
	       
	        
	        WebElement fbemail = driver.findElement(By.id("email"));
	        fbemail.sendKeys("xyz");

	        WebElement fbforgotbtn = driver.findElement(By.linkText("Forgotten password?"));
	        fbforgotbtn.click();
	        
	        driver.navigate().back();
	        try{
	        	fbemail.sendKeys("rnavinkmr45.12@gmail.com");
	         }
	        catch(StaleElementReferenceException e){ //try catch block - avoids StaleElementReferenceException
	        	fbemail = driver.findElement(By.id("email"));
	        	fbemail.sendKeys(Keys.CONTROL,Keys.HOME);
	        	fbemail.sendKeys(Keys.CONTROL,Keys.chord("a"));
	        	fbemail.sendKeys(Keys.BACK_SPACE);
	        	fbemail.sendKeys("rnavinkmr45.12@gmail.com");
	        }
	        
	        WebElement fbpassword = driver.findElement(By.name("pass"));
	        fbpassword.sendKeys("Selenium@131");
	        
	        Thread.sleep(3000);
	        WebElement fbloginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
	        fbloginbtn.click();
	        
	        driver.quit();

	}

}

/*
Xpaths/css  can be accurately validated using Console in Firefox or Chrome addons:

Type for xpaths:
$x("") 
where in double quotes put the full xpath.
Type for css:
$("#")
where in after # put the css selector class.

If they highlight the web objects its success else error or null is displayed in the Console.
*/


