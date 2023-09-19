package Session12;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Path2USA_CalenderHandleConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//May 21
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
		for (WebElement date: dates)
			System.out.println(date);
		//Grab common attribute
		//Put into list and iterate
		int count=driver.findElements(By.className("day")).size();

		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("21"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}

}

/*Quiz
Question 1:
How to count number of links of an entire webpage?
a.driver.findElements(By.tagName("a")).size()
b.driver.findElements(By.tagName("a")).length()
c.driver.findElement(By.tagName("a")).size()
d.driver.findElements(By.tagName("input")).size()
Ans:a

Question 2:
How to count the number of links only on header section of the webpage?
a. 		WebElement header = driver.findElement(By.name("header"));
		driver.findElements(By.tagName("a")).size();
b. 		WebElement header = driver.findElement(By.name("header"));
		header.findElements(By.tagName("input")).size();
c. 		WebElement header = driver.findElement(By.name("header"));
		header.findElements(By.tagName("a")).size();
d. 		WebElement header = driver.findElement(By.name("header"));
		driver.findElement(By.tagName("a")).size();
Ans: c

Question 3:
How to verify if links on click are opening a new page?
a.				String ctrlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
				driver.findElements(By.tagName("a")).click();
b.				String ctrlClick = Keys.chord(Keys.SHIFT);
				driver.findElements(By.tagName("a")).sendKeys(ctrlClick);
c.				String ctrlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
				driver.findElements(By.tagName("a")).enter(ctrlClick);
d.				String ctrlClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
				driver.findElements(By.tagName("a")).sendKeys(ctrlClick);								
Ans: d

Question 4:
What does hasNext () method return?
a. Returns true if the iteration has no more elements.
b. Returns true if the iteration has more elements.
c. Returns the next element in the iteration.
d. None of the above.
Ans: b

Question 5:
How to switch to a new window opened in Selenium?
a.
for(String handle : driver.getWindowHandles())
	driver.switchTo().window(handle)
b. driver.switchTo().window().
c. All of the above.
d. None of the above.
Ans: a

Question 6:
What is the return type of findElements() method?
a.Boolean
b.List<WebElement>
c.Elements
d.None of the above.

Ans:b

*/
