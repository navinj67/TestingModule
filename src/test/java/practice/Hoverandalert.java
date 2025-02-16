package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hoverandalert {

	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("All the test cases have been executed.");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	public void alert() {

		WebElement alerttest = driver.findElement(By.name("enter-name"));
		alerttest.sendKeys("111");

		WebElement alertbutton = driver.findElement(By.id("alertbtn"));
		alertbutton.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Confirm

		alerttest.sendKeys("Confirm");

		WebElement confirmbtn = driver.findElement(By.id("confirmbtn"));
		confirmbtn.click();

		alert.accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cancel
		alerttest.sendKeys("cancel");
		confirmbtn.click();
		alert.dismiss();

	}

	@Test
	public void hover() {
	    // Locate the hover element and perform the hover action
	    WebElement hover = driver.findElement(By.id("mousehover"));
	    Actions action = new Actions(driver);
	    action.moveToElement(hover).perform();

	    // Locate and click the "Top" link
	    WebElement top = driver.findElement(By.xpath("//a[normalize-space(text())='Top']"));
	    top.click();

	    // Refresh the page
	    driver.navigate().refresh();

	    // Re-locate the hover element after the refresh
	    hover = driver.findElement(By.id("mousehover")); // Refresh the reference
	    action.moveToElement(hover).perform();

	    // Re-locate the reload link and perform the hover action
	    WebElement reload = driver.findElement(By.xpath("//a[normalize-space(text())='Reload']"));
	    action.moveToElement(reload).perform();
	}


}
