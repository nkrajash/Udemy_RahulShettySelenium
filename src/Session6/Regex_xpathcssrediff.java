package Session6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Regex_xpathcssrediff {
	public static void main(String[] args) {

        //xpath/CSS  can be defined in a number of  ways
        //double quotes within double quotes is not allowed
        //firepath deprecated from firefox v56
        //Multiple values selenium identified with the one with top left
        //If xpath starts with html/body not reliable
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait
		 
		 driver.get("https://www.rediff.com");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		 driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("navinkmr");
		 driver.findElement(By.cssSelector("input#password")).sendKeys("goodbye");
		 driver.findElement(By.xpath("//input[contains(@name,'proce')]")).click();
		 
		 driver.quit();
	}
}
