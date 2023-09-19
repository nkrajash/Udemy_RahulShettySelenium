package Session9_10;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsToCart_EcommerceApp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Thread.sleep(3000);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Implicit wait:
		//Global wait applied to each test step of the test case and applied to full web page.
		//It waits until the maximum time specified after which throws an exception.
		//It slows the execution as it does not catch performance errors in the code.
		addItems(driver, itemsNeeded);
		
		
		//Add to cart the items
		driver.findElement(By.cssSelector("[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Enter promocode:rahulshettyacademy
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//explicit wait
		//Applied to a particular webelement of a webpage not on the full web page.
		//This targets a specific test scenario, while that it applies to all test scenarios in test suite. 
		//WaitDriverWait w = new WebDriverWait(driver,30);
		Wait<WebDriver> w = new WebDriverWait(driver,30);
		WebElement promo = w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String promoInfo = promo.getText();
		
		if(promoInfo == "Code applied ..!") {
			System.out.println("Promo code applied successfully..!");
		}
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		driver.quit();
		
	}


	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{

		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++)
		{

			// Brocolli - 1 Kg
			// Brocolli, 1 kg
			
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// format it to get actual vegetable name
			// convert array into array list for easy search
			// check whether name you extracted is present in arrayList or not-

			List <String> itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName))
			{

				j++;

				// click on Add to cart
				
				//if(formattedName=="Carrot") {
					//driver.findElements(By.xpath("//div[@class='stepper-input']/input[@type='number']")).get(i).sendKeys("3");
					//driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//}
				//else {
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//}
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
