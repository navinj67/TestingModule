package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropdown {

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
	       // driver.quit(); // Close the browser
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		
	}

	 @Test
	    public void SelectDropdowntest() {
	        WebElement dropdown = driver.findElement(By.id("carselect"));
	        Select select = new Select(dropdown);

	        List<WebElement> options = select.getOptions();
	        for (WebElement car : options) {
	            System.out.println("Option: " + car.getText());
	        }

	        select.selectByVisibleText("Honda");
	        select.selectByIndex(0);
	        System.out.println("Selected 'Honda' from the dropdown.");
	    }
	 
	 @Test
	 public void multipleselect(){
		 
		 
		 WebElement multiple = driver.findElement(By.id("multiple-select-example"));
		 Select sel = new Select(multiple);
		 
		 sel.selectByIndex(0);
		 sel.selectByValue("orange");
		 
		Actions a = new Actions(driver);
	   
		
		WebElement hover =	driver.findElement(By.id("mousehover"));
	    a.moveToElement(hover).perform();
        WebElement top = driver.findElement(By.xpath("//div[@class=\"mouse-hover-content\"]//a[contains(text(),\"Top\")]"));
        top.click();
        
       a.moveToElement(hover).perform();
        WebElement reload = driver.findElement(By.xpath("//div[@class=\"mouse-hover-content\"]//a[contains(text(),\"Reload\")]"));
        reload.click();
	
		 
	 }

}
