package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable {

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

		System.out.println("WebTable test is done");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	public void webtable() {

		WebElement table = driver.findElement(By.id("simpletable"));
		List<WebElement> headers = table.findElements(By.tagName("th"));
		for (WebElement header : headers) {

			String text = header.getText();
			System.out.println("Title is" + text);
		}

		List<WebElement> allrows = driver.findElements(By.cssSelector("#simpletable tbody tr"));
		int size = allrows.size();
		if (size == 3) {

			System.out.println("pass");
		} else {

			System.out.println("fail");
		}

		for (WebElement row : allrows) {
			List<WebElement> allcolums = row.findElements(By.cssSelector("#simpletable td"));
			WebElement Lastname = allcolums.get(0);
			System.out.println(Lastname.getText());

		}
		
		for(int i =0; i<size; i++) {
			List<WebElement> row = allrows.get(i).findElements(By.cssSelector("#simpletable td"));
			WebElement lastname = row.get(1);
			String text =lastname.getText();
			System.out.println(text);
			if(text.equals("Raj")) {
				
				WebElement input = driver.findElement(By.id("second"));
				input.click();
				
			}	
		}

	}

}
