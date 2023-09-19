package Session12;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverLinksCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//1.Get the count of all links in the Webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.Get the count of all links in the Webpage - Footer
		WebElement footerdriverelem = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriverelem.findElements(By.tagName("a")).size());
		
		//3.Get the count of all links in the Webpage - Footer column 1 
		WebElement columnfooter = footerdriverelem.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnfooter.findElements(By.tagName("a")).size());
		
		//4.click on all of links in the Webpage - Footer column 1 to 2
		for(int j=1; j<5;j++) {
			WebElement colsfooter = footerdriverelem.findElement(By.xpath("//table/tbody/tr/td[" + j + "]/ul"));
			for(int i=1; i<colsfooter.findElements(By.tagName("a")).size();i++) {
				String ctrlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
				colsfooter.findElements(By.tagName("a")).get(i).sendKeys(ctrlClick);
			}
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parentId = iter.next();
		System.out.println(driver.getTitle());
		System.out.println(parentId);
		
		while(iter.hasNext()) {
			String childId = iter.next();
			driver.switchTo().window(childId);
			System.out.println(driver.getTitle());
		}
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
