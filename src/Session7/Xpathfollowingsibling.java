package Session7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathfollowingsibling {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait
		 
		 driver.get("https://www.wikipedia.org/");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@class='central-featured']/following-sibling::div[1]//div/input[@name='search']")).sendKeys("MayDay");
		 //driver.navigate().back();
		
		 
		 
		 
		 /*
	
	
		 Child		-->Traverse all child element of the current html tag
		//*[attribute=’value’]/child::tagname
		Parent	 	-->Traverse all parent element of the current html tag	
		//*[attribute=’value’]/parent::tagname
		Following	-->	Traverse all element that comes after the current tag	
		//*[attribute=’value’]/following::tagname
		Preceding  	-->	Traverse all nodes that comes before the current html tag.	
		//*[attribute=’value’]/preceding::tagname
		Following-sibling -->	Traverse from current Html tag to Next sibling Html tag.	
		//current html tag[@attribute =’value’]/following-sibling:: sibling tag[@attribute =’value’]  
		Preceding-sibling -->	Traverse from current Html tag to previous sibling Html tag.	
		//current html tag[@attribute =’value’]/preceding-sibling:: previous tag[@attribute =’value’]  
		Ancestor	-->Traverse all the ancestor elements (grandparent, parent, etc.) of the current html tag.	
		//*[attribute=’value’]/ancestor::tagname
		Descendant	--> Traverse all descendent element (child node, grandchild node, etc.) of the current Html tag.	
		//*[attribute=’value’]/descendant::tagname
		 
		 
		 */
		 //These methods are mainly used when the web element is not identified with the help of 
		 //ID, name, class name, link text, CSS selector and XPath, etc. locators.
		 //Order of Preference:
		 //1.xpath,cssSelector
		 //2.id, name
		 //3.tagName
		 //4.linkText,className
		 //5. partialLinkText
		 //Since XPath axes are used to identify the web element that changes dynamically on the 
		 //refresh or the dynamic operations.

		 driver.quit();
		 
	}

}
