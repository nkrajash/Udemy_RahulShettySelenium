package Session9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//explicit wait
			driver.findElement(By.xpath("//div[@id='content']/a[contains(text(),'Click to load get')]")).click();
			WebDriverWait w = new WebDriverWait(driver,30);
			WebElement results = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
			System.out.println(results.getText());
			driver.quit();

	}

}
