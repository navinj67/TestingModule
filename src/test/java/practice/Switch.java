 package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Switch {

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
		System.out.println("Switch test is done");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		
	}

	@Test
	public void Switchwindows() {
		
		String windowhandle = driver.getWindowHandle();
		System.out.println("Windowhandle ID  "+  windowhandle );
		
		WebElement openwindow = driver.findElement(By.id("openwindow"));
		openwindow.click();
		
		Set<String>windows = driver.getWindowHandles();
		
		for(String window : windows) {
			
			System.out.println("window id "+ window);
			if(!window.equals(windowhandle)) {
				driver.switchTo().window(window);	
				
				String Title = driver.getTitle();
				System.out.println("window title" +Title);
				WebElement course = driver.findElement(By.xpath("//input[@id=\"search\"]"));
				course.sendKeys("Python");
				
				WebElement submit = driver.findElement(By.xpath("//button[@class=\"find-course search-course\"]"));
				submit.click();
			}
		}
		
	}
	
	@Test
	
	public void Switchtab() {
		
		
		
		
	}
	
	
	}


