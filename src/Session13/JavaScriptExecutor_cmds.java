package Session13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor_cmds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		windowScrollByJS(driver);
		documentScrollToJS(driver);
		documentScrollByJS(driver);
		
		WebElement element = driver.findElement(By.cssSelector(".tableFixHead")); 
		scrollonWebElementByJS(element, driver);
		
		documentScrollToJS(driver);
		
		highlightElement("document.getElementById('name')",driver);
		typeJS("document.getElementById('name')", "Naveen",driver);
		
		highlightElement("document.querySelector(\"[id='alertbtn']\")",driver);
		try {
			clickJS("document.querySelector(\"[id='alertbtn']\")", driver);
			driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		String curURL = getURLByJS(driver);
		System.out.println(curURL);
		
		String curTitle = getTitleByJS(driver);
		System.out.println(curTitle);
		
		windowScrollByJS(driver);
		List <WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		int tot = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		if(sum== tot) {
			System.out.println("sum Matches tot");
		}
		else {
			System.out.println("sum not Matches tot");
		}
		
		
		List <WebElement> rows = driver.findElements(By.cssSelector("div.left-align table#product tr"));
		int rowCount = rows.size();
		List <WebElement> cols = driver.findElements(By.cssSelector("div.left-align table#product tr th"));
		int colCount = 	cols.size();
		System.out.println(rowCount);
		System.out.println(colCount);
		
		for(int i=1;i<=rowCount;i++)
		{
			if(i==3) {
				WebElement elem = driver.findElement(By.cssSelector("div.left-align table#product tr:nth-child(2)"));
				for(int j=0;j<cols.size();j++)
				{
					String attr = cols.get(j).getText();
					String value = elem.getText().split(" ")[j];
					System.out.println(attr);
					System.out.println(value);
				}
				break;
			}
		}
		
		newLaunchURL(driver,"http://demo.guru99.com/");
		driver.quit();
	}

	public static void windowScrollByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public static void documentScrollByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(scrollBy(0,500))");
	}
	
	public static void documentScrollToJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(scrollTo(0,0))");
	}
	
	public static void scrollonWebElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollBy(0,500)",element);
	}

	public static void typeJS(String locator, String keyword, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  String jsQuery = 
		    String.format("%s.value='%s'", locator, keyword);

		  js.executeScript(jsQuery);
	}

	public static void highlightElement(String locator, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  String jsQuery = 
		  String.format("%s.style.backgroundColor='red'", locator);

		  js.executeScript(jsQuery);
	}

	public static void clickJS(String locator, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  String jsQuery = 
		    String.format("%s.click()", locator);

		  js.executeScript(jsQuery);
	}
	
	public static String getURLByJS(WebDriver driver) {
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		String URL = js.executeScript("return document.URL;").toString();
		return URL;
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void newLaunchURL(WebDriver driver, String url) {
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("window.location = '"+ url + "'");
	}
}
