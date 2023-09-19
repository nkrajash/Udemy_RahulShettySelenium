package Session11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest_DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        scrollPageDown(driver);

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']"))); /*switch to frame only if its present. */
        Actions a = new Actions(driver);
        
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement dest = driver.findElement(By.id("droppable"));
        
        a.dragAndDrop(src, dest).build().perform();
        driver.switchTo().defaultContent();
        
        driver.quit();
	}

	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,400)");
	}
}
