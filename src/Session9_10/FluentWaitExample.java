package Session9_10;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//div[@class='example']/a[contains(text(),'Example 1')]")).click();
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FluentWait<WebDriver> wait = new FluentWait < WebDriver >(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		//WaitDriverWait and FluentWait are classes under Interface Wait --> Explicit Waits
		//or another way:
		//FluentWait monitors the DOM at regular intervals(defined by polling time)
		//based on the conditions need to be built based on customized wait methods.
		//Explicit wait monitors the DOM until the timeout happens or till the object is found
		//with some expected conditions.
		//Wait<WebDriver> wait = new FluentWait < WebDriver >(driver)
		//		.withTimeout(Duration.ofSeconds(30))
		//		.pollingEvery(Duration.ofSeconds(3))
		//		.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));
		//Polls every 3 seconds upto 30 seconds until WebElement is returned.
		System.out.println(foo.getText());	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}

}
