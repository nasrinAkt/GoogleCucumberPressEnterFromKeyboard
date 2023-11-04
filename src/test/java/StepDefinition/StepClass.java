package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepClass {
	WebDriver driver;
	
	@Given("^Open google application$")
	public void open_google_application() throws Throwable {
	System.setProperty("Webdriver.chrome.driver", "C:\\chrome driver\\chrome-win64\\chrome.exe") ;  
	
	ChromeOptions run = new ChromeOptions();
	run.addArguments("--remote-allow-origins=*");
	
	driver = new ChromeDriver();
	driver.get("https://www.google.com/finance");
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.manage().window().maximize();
	
	
	}

	@Then("^Enter google in search field$")
	public void enter_google_in_search_field() throws Throwable {
	 
	
 WebElement search = driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[2]"));
  search.sendKeys("GOOGLE");
  
  WebElement search1 = driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[2]"));
  search1.sendKeys(Keys.ENTER);
  
  
	}

	@Then("^Print privious close result$")
	public void print_privious_close_result() throws Throwable {
	 
String result =driver.findElement(By.xpath("//div[normalize-space()='$138.10']")).getText();	
		System.out.println("PREVIOUS CLOSE" + result);
		
		driver.close();
	}
	@Then("^count of links available in page$")
	public void count_of_links_available_in_page() throws Throwable {
	 
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	System.out.println("Total links in this page " +allLinks.size());
	
	
	for(int i = 0 ; i<allLinks.size(); i++) {
	System.out.println(allLinks.get(i).getAttribute("href"));	
		
	}
	driver.close();
	}

}
