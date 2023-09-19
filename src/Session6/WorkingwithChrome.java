package Session6;

import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingwithChrome {
	ChromeDriver driver;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Data\\Selenium-workspace\\LearningSeleniumGrid_UdemyCoursera\\drivers\\chromedriver.exe");

		// Chrome driver is 90.0.4430.24
		// Java SE 1.8
		// Selenium 3.141.59

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com//v4");
	}

	public void getTitle() {
		System.out.println(driver.getTitle());
	}

	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		WorkingwithChrome wc = new WorkingwithChrome();
		wc.invokeBrowser();
		wc.getTitle();
		wc.closeBrowser();
	}
}