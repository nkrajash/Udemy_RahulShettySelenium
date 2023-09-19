package Session12;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> checkBoxOptions = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
	    int cnt = checkBoxOptions.size();
	    String text = "";
		for(int i=0;i<cnt;i++)
	    {
	        text =  driver.findElements(By.xpath("//div[@id='checkbox-example']//label")).get(i).getText();
	        if(text.contains("Option2")) {
	        	WebElement ele = driver.findElements(By.xpath("//div[@id='checkbox-example']//input")).get(i);
	        	if(ele.isSelected()==false) {
	        		System.out.println(ele.getText());
	        		ele.click();
	        	}
	        	text = text.trim();
	        	break;
	        }
	    }

    	WebElement selbox2 = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
    	Select sel = new Select(selbox2);
    	sel.selectByVisibleText(text);

    	WebElement inpbox = driver.findElement(By.cssSelector("input#name.inputs"));
    	inpbox.sendKeys(text);

		WebElement alertbtn = driver.findElement(By.cssSelector("input#alertbtn.btn-style"));
		alertbtn.click();

		String msg= driver.switchTo().alert().getText();
		System.out.println(msg);
		if(msg.contains(text)) {
			driver.switchTo().alert().accept();
		}
		else {
			System.out.println("The option not correctly selected");
		}
		
		driver.quit();
	}

}
