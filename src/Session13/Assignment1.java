package Session13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> rows = driver.findElements(By.cssSelector("div.left-align table#product tr"));
		int rowCount = rows.size();
		List <WebElement> cols = driver.findElements(By.cssSelector("div.left-align table#product tr th"));
		int colCount = 	cols.size();
		System.out.println(rowCount);
		System.out.println(colCount);
		
		for(int i=1;i<=rowCount;i++)
		{
			if(i==3) {
				WebElement elem = driver.findElement(By.cssSelector("div.left-align table#product tr:nth-child(3)"));
				for(int j=0;j<cols.size();j++)
				{
					String attr = cols.get(j).getText();
					String value = elem.findElement(By.cssSelector("td:nth-child("+ (j+1) + ")" )).getText();
					System.out.println(attr);
					System.out.println(value);
				}
				break;
			}
		}
		
		
		WebElement table = driver.findElement(By.cssSelector("table[name='courses'] > tbody"));
		System.out.println("Rows: " + table.findElements(By.tagName("tr")).size());
		System.out.println("Columns: " + table.findElements(By.tagName("th")).size());
		System.out.println("Second Element: " + table.findElement(By.cssSelector("tr:nth-child(3)")).getText());
		
		driver.quit();
	}
}
