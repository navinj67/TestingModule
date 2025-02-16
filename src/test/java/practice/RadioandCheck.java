package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioandCheck {

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
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);

	}

	@AfterMethod
	public void afterMethod() {

	}

	@Test
	public void RadioButtonExample() {
        WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
        bmwRadio.click();
        System.out.println("Clicked on BMW radio button.");

        WebElement benzRadio = driver.findElement(By.id("benzradio"));
        benzRadio.click();
        System.out.println("Clicked on Benz radio button.");

        WebElement hondaRadio = driver.findElement(By.id("hondaradio"));
        hondaRadio.click();
        System.out.println("Clicked on Honda radio button.");
    }
	
	@Test
    public void Checkbox() {
        WebElement bmwCheckbox = driver.findElement(By.id("bmwcheck"));
        bmwCheckbox.click();
        System.out.println("Checked BMW checkbox.");

        WebElement benzCheckbox = driver.findElement(By.id("benzcheck"));
        benzCheckbox.click();
        System.out.println("Checked Benz checkbox.");

        WebElement hondaCheckbox = driver.findElement(By.id("hondacheck"));
        hondaCheckbox.click();
        System.out.println("Checked Honda checkbox.");
    }

}
