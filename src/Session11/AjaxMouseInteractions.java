package Session11;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AjaxMouseInteractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions act = new Actions(driver);
		//Moves to specific element
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		act.moveToElement(move).contextClick().build().perform();

		//To type SHIFT and then enter HELLO in the search box
		act.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click()
									.keyDown(Keys.SHIFT)
											.sendKeys("hello")
											.doubleClick()
													.build()
														.perform();
		
		//act.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click()
		//							.keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		

		driver.quit();
	}

}

/*
Quiz :
 1. Which class in Selenium used to perform mouse and keyboard interactions?
 a.Actions
 b.Action
 c.Select
 d.Wait
Ans: a

2.Question 2:
How to perform right click with the help of actions class in Selenium?
A:
Actions a = new Actions(driver)
a.moveToElement(driver.findElement(By.id("name")).rightClick().build().perform()
B:
Actions a = new Actions()
a.moveToElement(driver.findElement(By.id("name")).contextClick().build.perform()
C:
Actions a = new Actions(driver)
a.moveToElement(driver.findElement(By.id("name")).contextClick().build()
D:
Actions a = new Actions(driver)
a.moveToElement(driver.findElement(By.id("name")).contextClick().build.perform()
Ans: D

3.Question 3:
How to enter text ‘Hello’ in capital letters help of actions class in Selenium?
A:Actions a = new Actions(driver)
a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click()
			.keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
B:Actions a = new Actions(driver)
a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")))
			.keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
C:Actions a = new Actions(driver)
a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click()
			.sendKeys("hello").build().perform();
D:None of the above.	
Ans: A

4.Question 4:
Which method is used to store multiple child windows in Selenium?
a.getWindowHandles
b.getWindow
c.getWindows
d.getWindowsHandle
Ans:a

5.Question 5:
How to navigate to the parent window when there are multiple windows?
A:
Set<String> windows = driver.getWindowHandles();
Iterator<String>  it = windows.iterator();
String parentID  = it.next();
driver.switchTo(parentID);
B:
Set<String> windows = driver.getWindowHandles();
Iterator<String>  it = windows.iterator();
String parentID  = it.next();
driver.switchTo().window(parentID);
C:
windows = driver.getWindowHandles();
Iterator<String>  it = windows.iterator();
String parentID  = it.next();
driver.switchTo(parentID);
D:
Set<String> windows = driver.getWindowHandles();
Iterator<String>  it = windows.iterator();
driver.switchTo().window(parent);

Ans:B

6.Question 6:
How can we identify frames in Selenium?
a.By its index
b.By its id
c.By its webelement
d.All of these
Ans:d

7.Question 7:
How to switch to a specific frame in Selenium?
a.driver.switchTo().frame(id)
b.driver.switchTo(name)
c.driver.switchTo().defaultContent()
d.None of theabove
Ans: a

8.Question 8:
Name the Java collection framework used to store window ids.
a.Array
b.List
c.Set
d.Dequeue
Ans: c


*/


