package Session15;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortWebTablesUsingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Positive Test case
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelements into list
		List <WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture the text of all webelements into new(original) list
		List <String> originalList = elementsList.stream()
				.map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the originalList to get the sortedList
		List <String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		//Now get the price of a particular WebElement
		List <String> price = elementsList.stream().filter(s->s.getText().contains("Beans"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println("Price of Beans is Rs."+ s));
		
		List <String> elemprice;
		//Automating pagination scenarios to find the price of a particular WebElement using do-while loop
		do {
			List <WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			//Now get the price of a particular WebElement
			elemprice = rows.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
			elemprice.forEach(s->System.out.println("Price of Rice is Rs."+ s));
			if(elemprice.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(elemprice.size()<1);
		

		
		//Negative Test case
		/*
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelements into list
		List <WebElement> elementsList2 = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture the text of all webelements into new(original) list
		List <String> originalList2 = elementsList2.stream()
				.map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the originalList to get the sortedList
		List <String> sortedList2 = originalList2.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList2.equals(sortedList2));
		*/
		
		driver.quit();
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceval = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceval;
	}

}
