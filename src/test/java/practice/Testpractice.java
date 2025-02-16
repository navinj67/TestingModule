package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testpractice {
	
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://letcode.in/dropdowns";
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
	public void select() {
		
		//select by visible text
		
		WebElement dropdownfruit = driver.findElement(By.id("fruits"));
		Select Selectfruit = new Select(dropdownfruit);
		List<WebElement> fruits = Selectfruit.getOptions();
		for (WebElement fruit : fruits) {
			
			String fruittext = fruit.getText();
			System.out.println("Fruittext is "+fruittext);
			
		}
		
		//Select your super hero's
		
		WebElement herolist = driver.findElement(By.id("superheros"));
		Select hero = new Select(herolist);
		hero.selectByVisibleText("Batman");
		WebElement myhero = hero.getFirstSelectedOption();
		System.out.println("selected value" + myhero.getText());
		
		//Select the last programming language and print all the options
		
		WebElement lang = driver.findElement(By.id("lang"));
		Select selectlang = new Select(lang);
		List<WebElement> alllang = selectlang.getOptions();
		for(WebElement langs : alllang ) {
			
			String text = langs.getText();
			System.out.println("text is  "+ text);
						
			
		}
		
		int lastindex =  alllang.size()-1;
		selectlang.selectByIndex(lastindex);
		
		WebElement selectedOption = selectlang.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());

		

}}
