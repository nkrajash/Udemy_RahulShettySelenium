package Session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebLocatorsSalesforce {

	public static void main(String[] args) {
		
		String baseUrl = "https://login.salesforce.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);   
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
       
        
        WebElement sfusrname = driver.findElement(By.id("username"));
        sfusrname.sendKeys("hello");

        WebElement sfpwd = driver.findElement(By.name("pw"));
        sfpwd.sendKeys("123456");
        
        WebElement sfloginbtn = driver.findElement(By.xpath("//*[@id='Login']"));
        sfloginbtn.click();
        
      
        String errormsg =  driver.findElement(By.cssSelector("div#error")).getText();
        System.out.println(errormsg);
        
        driver.quit();
	}

}

/*

<div class="loginError" id="error" role="alert" style="display: block;">
Here,
div - tagName
class - Attribute
loginError - value 
General syntax of xpath is :
tagName[@Attribute = 'value'])
say like:
 //div[@error='loginError']
or like:
//*[@error='loginError']

General syntax of css is :
tagName[Attribute = 'value'])
say like:
 div#error.loginError
 or do like:
 div[error='loginError']
 or like below if irrespective of tagname:
 [error='loginError']
 or like :
 div#error 
 or just if error is unique:
 #error

Regular Expression:
xpath:
//div[contains(@error,'Error')
 * 
css:
div[error*='Error']


Quiz:
1.Identify the correct xpath for the sample html code:
<input class="button_r4wideprimary" type="submit" id="LoginIdwideprimary" name="Login">
A:
//input[contains(@class,'wideprimary')]
//*[contains(@id,'LoginIdwide')]

2.Identify of the xpath from the html code for the second element of the unordered list 
(<li name="item2">Css</li>, assuming that the parent (div tag) is having a dynamic value for
 locator Id.
<div id="name_12">
	<ul>
		<li name="item1">Xpath</li>
		<li name="item2">Css</li> <!--this one-->
		<li name="item3">Partial Text</li>
	</ul>
</div>
A:
//li[@name='item1']/following-sibling::li

3.Xpath and CSS difference:
Xpath allows us to traverse from parent to child and vice -versa.

4.How to create an xpath with the help of visible text ‘Selenium Feature’ from the below html code?
		<p class="text">Selenium Feature</p>
A:
//p[text()='Selenium Feature']
//*[text()='Selenium Feature']

*/

