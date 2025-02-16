package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webtablepractice {
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		baseUrl = "https://letcode.in/table";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	public void tableheader() {

		WebElement table = driver.findElement(By.id("simpletable"));
		Assert.assertTrue(table.isDisplayed());

		List<WebElement> allheader = table.findElements(By.cssSelector("#simpletable th"));
		for (WebElement header : allheader) {
			String Htitle = header.getText();
			System.out.println("title is " + Htitle);

			List<WebElement> allrows = table.findElements(By.cssSelector("#simpletable tr"));
			int Rsize = allrows.size();
			System.out.println("row size " + Rsize);
			WebElement rowone = allrows.get(1);
			System.out.println("firstrow data is "+rowone.getText());
			
			List<WebElement> allcolumn = table.findElements(By.cssSelector("#simpletable td"));
			int Csize = allcolumn.size();
			System.out.println("Column size " +Csize );
			WebElement Lastname = allcolumn.get(1);
			System.out.println("second row is "+ Lastname.getText());
			
			for(int i =0 ; i>Rsize; i++) {
				
				List<WebElement> row = table.findElements(By.cssSelector("#simpletable td"));
				WebElement lastname = row.get(1);
				String text = lastname.getText();
				System.out.println("Text is "+text);
				if(text.equals("Raj")) {
					
					WebElement input = driver.findElement(By.id("second"));
					input.click();
					
				}
				
			}
			

		}
	}

}
