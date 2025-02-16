package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
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

public class Letscodeit {

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
        driver.quit(); // Close the browser
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test case completed.");
    }

    @Test
    public void displayed() {
        WebElement display = driver.findElement(By.id("displayed-text"));
        display.sendKeys("10");
        System.out.println("Entered '10' into the text box.");

        WebElement hide = driver.findElement(By.id("hide-textbox"));
        hide.click();
        System.out.println("Clicked the 'Hide' button.");

        // Check if the text box is hidden
        if (!display.isDisplayed()) {
            System.out.println("The text box is now hidden.");

            // Use JavaScript to make it visible again
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", display);
            System.out.println("The text box has been made visible using JavaScript.");
        }

        display.sendKeys("20");
        System.out.println("Entered '20' into the text box after making it visible.");
    }

    @Test
    public void AlertExample() {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("ABC");
        System.out.println("Entered 'ABC' into the name field.");

        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();
        System.out.println("Clicked the alert button.");

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted.");
    }

   
}
