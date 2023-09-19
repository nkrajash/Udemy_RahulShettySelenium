package Session11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int framecnt = driver.findElements(By.tagName("frame")).size();
		System.out.println(framecnt);
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");

		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		driver.switchTo().defaultContent(); //switching back from the parent frame
		
		int total,k=0;
		for(int i=0;i<framecnt;i++) {
			driver.switchTo().frame(i);
		    total= driver.findElements(By.tagName("frame")).size();
			System.out.println(total);

			for(int j=1;j<=total;j++) {
				if( driver.findElement(By.xpath("//*[@name='frame-middle']")).isDisplayed() ) {
					driver.switchTo().frame(k+j);
					System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
					break;
				}
			}
			k=k+total+1;
			driver.switchTo().defaultContent(); //switching back from the parent frame
		}
		
		driver.quit();
		
	}

}
