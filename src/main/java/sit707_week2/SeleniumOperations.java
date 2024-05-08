package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.locators.RelativeLocator;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate gecko driver folder in the local drive.
		System.setProperty("webdriver.gecko.driver", "C:/Users/User/Downloads/geckodriver.exe");
		
		// Step 2: Use above gecko driver to open up a firefox browser.
		System.out.println("Fire up firefox browser.");
		WebDriver driver = new FirefoxDriver();
		
        // Maximize the browser window to fullscreen
        driver.manage().window().maximize();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in firefox browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
        // Locate and fill input fields using Relative Locators
		WebElement fName = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("lastname")));
        fName.sendKeys("Samadhi");
        
		WebElement lName = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("firstname")));
        lName.sendKeys("Jayasinghe");

        WebElement pNumber = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("email")));
        pNumber.sendKeys("0424548014");

        WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("phoneNumber")));
        email.sendKeys("samadhi0727@gmail.com");

        WebElement pword = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("confirmPassword")));
        pword.sendKeys("samadhi");

        WebElement pwordConf = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("password")));
        pwordConf.sendKeys("samadhi");

        // Locate Create account button and click click to submit using Selenium API.
        WebElement login = driver.findElement(By.cssSelector("a[data-testid='account-action-link']"));
        
        WebElement createAccountButton = driver.findElement(RelativeLocator.with(By.tagName("button")).near(login));
        createAccountButton.click();
		
		//Take screenshot using selenium API.
		
        if (driver.getCurrentUrl().equals(url)) {
        	saveScreenshotOfficeworks(driver);
        }
		
		// Sleep a while
		sleep(2);
		
		// close firefox driver
		driver.close();	
	}
	
 static void saveScreenshotOfficeworks(WebDriver driver) {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:/Users/User/Documents/SIT 707 - Software Quality And Testing/Task 2.2D/screenshot.png"));
			System.out.println("Screenshot from Officework's registration page saved successfully");
		}catch(IOException e) {
			System.out.println("Failed to save screenshot from Officework's registration page");
			e.printStackTrace();
		}
	}

	
}

