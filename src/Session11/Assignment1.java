package Session11;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentID,childID, sub-childID]
		Iterator<String>  it = windows.iterator();
		
		String parentID  = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);

		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		driver.quit();
		
	}

}
