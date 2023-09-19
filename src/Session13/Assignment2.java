package Session13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Auto-suggestive Dropdown assignment
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement nation = driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));
		nation.sendKeys("United");
		String country = "United Kingdom (UK)";
		
		List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]//div[contains(@class,'ui-menu-item-wrapper')]"));
		for (WebElement elem: elements) {
			if(elem.getText().equals(country)) {
				System.out.println(elem.getText());
				elem.click();
				break;
			}
		}
		driver.quit();
	}

}

/*Quiz:
Question 1:
In a web table, which could be valid syntax below to get row count?
a.driver.findElement(By.cssSelector("table-rows").size();
b.driver.findElements(By.cssSelector("table-rows").size();
c.driver.findElements(By.cssSelector("table-rows").count();
d.None of the above
Ans: b

Question 2:
Can we determine the xpath of an element in the fourth column from the xpath of the element in the first column in the same row?
a.Yes, with the help of following-sibling method in xpath
b.No, its not possible
c.Yes, with the help of parent-child method in xpath.
d.Yes, with the help of column count
Ans: a

Question 3:
Guess the valid syntax below to get the columns in a table with xpath.
a. List <WebElement> tblCols = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td"));
b. List <WebElement> tblCols = driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
c. List <WebElement> tblCols = driver.findElements(By.xpath("//table[@id='product']/tbody/tr[1]"));
d. List <WebElement> tblCols = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
Ans:d
 
 
Question 4:
How to perform arrow key down operation in Selenium?
a.driver.findElements(By.id("text-id").click();
b.driver.findElements(By.id("text-id").sendKeys(DOWN);
c.driver.findElements(By.id("text-id").sendKeys(Keys.DOWN);
d.All of above
Ans:c

Question 5:
Why Javascript Executor is important in Selenium?
a.Identifies object which has hidden elements.
b.Identifies element with key-value pairs.
c.None of above.
d.All of above
Ans: a

Question 6:
How to extract value from a field with help of Javascript Executor?
a).
String val = "return document.getElementById("hiddentext").value";
String title = (String)js.executeScript(val);
b).
String val = "return document.getElementById(\"hiddentext\").value;";
String title = (String)js.executeScript(val);
c).
String val = "document.getElementById(\"hiddentext\").value;";
String title = (String)js.executeScript(val);
d).
String val = "return document.getElementById(\"hiddentext\");";
String title = (String)js.executeScript(val);

Ans:b

 */
