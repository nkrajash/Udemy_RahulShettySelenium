package Session8;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdownConcept {

	public static void main(String[] args) {
		//Use Ctrl+Shift+F to align the code
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch Chrome browser

		driver.manage().window().maximize(); // maximize the windows
		// to enable elements which are hidden and invisible
		driver.manage().deleteAllCookies(); // delete all the cookies
		// dynamic wait - implicit wait
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// From CITY
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Ben");
		List<WebElement> elements = driver.findElements(By.xpath(
				"//li[contains(@class,'react-autosuggest__suggestion')]//div[@class='calc60']//p[contains(@class, 'blackText')]"));
		for (WebElement element : elements) {
			if (element.getText().contains("Bengaluru")) {
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Del");
		List<WebElement> elements2 = driver.findElements(By.xpath(
				"//li[contains(@class,'react-autosuggest__suggestion')]//div[@class='calc60']//p[contains(@class, 'blackText')]"));
		for (WebElement element : elements2) {
			if (element.getText().contains("Delhi")) {
				element.click();
				break;
			}
		}
		driver.quit();
	}

}
