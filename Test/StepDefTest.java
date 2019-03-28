package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefTest {
	WebDriver driver;
	
	@Given("^Open the firefox and launch the application$")
	public void open_the_firefox_and_launch_the_application() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NITISHAG\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\NITISHAG\\Desktop\\mod\\login.html");
	}
	

	@When("^Enter the username and password$")
	public void enter_the_username_and_password() throws Throwable {
		
		driver.findElement(By.name("userName")).sendKeys("capgemini");
		Thread.sleep(1000);

		driver.findElement(By.name("userPwd")).sendKeys("capgi1234");
		Thread.sleep(1000);
	}

	@Then("^Reset the credentials$")
	public void reset_the_credentials() throws Throwable {
		driver.findElement(By.xpath("//*[@id='mainCnt']/div/div[1]/form/table/tbody/tr[4]/td[2]/input")).click();
	}


	
}
