package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnableElementdisabled {
	
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
	public void Enabled() {
		
		WebElement enabled = driver.findElement(By.id("enabled-button"));
		enabled.click();
		
		WebElement text = driver.findElement(By.id("enabled-example-input"));
		text.sendKeys("1111");
		
		WebElement disbaled = driver.findElement(By.id("disabled-button"));
		disbaled.click();
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", text);

        text.sendKeys("2222");
  

	}
	
	@Test
	public void elementdisable() {
	    WebElement show = driver.findElement(By.id("show-textbox")); 
	    show.click();
	    
	    WebElement text = driver.findElement(By.id("displayed-text"));
	    text.sendKeys("abcd");
	    
	    WebElement hide = driver.findElement(By.id("hide-textbox"));
	    hide.click();
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].removeAttribute('disabled')", text);
	    js.executeScript("arguments[0].style.visibility='visible'", text);
	    js.executeScript("arguments[0].style.display='block'", text);

	    // Verify interactability
	    if (text.isDisplayed() && text.isEnabled()) {
	        text.sendKeys("efg");
	    } else {
	        System.out.println("Element is not interactable.");
	    }
	}


}
