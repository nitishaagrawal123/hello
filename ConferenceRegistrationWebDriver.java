package ConferenceRegistrationWebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ConferenceRegistrationWebDriver {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Alert alert;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NITISHAG\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:/Users/NITISHAG/Desktop/mod/ConferenceRegistartion.html");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		/*********** For First Name **************/
		driver.findElement(By.id("txtFirstName")).sendKeys("Nitisha");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		/*********** For Last Name **************/
		driver.findElement(By.id("txtLastName")).sendKeys("Agrawal");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		/*********** For Email **************/
		driver.findElement(By.id("txtEmail")).sendKeys("Nitishagarg123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		/*********** For Contact Number **************/
		driver.findElement(By.id("txtPhone")).sendKeys("9897496567");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();
		
	
		/*********** For Invalid Contact Number **************/
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).clear();
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("9897");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For Valid Contact Number **************/
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).clear();
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("9897496567");
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For Building name and room no **************/
		driver.findElement(By.id("txtAddress1")).sendKeys("21, Capgemini");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For area Name **************/
		driver.findElement(By.id("txtAddress2")).sendKeys("Talawade");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		/*********** For blank city **************//*
		Select drpCity = new Select(driver.findElement(By.name("city")));
		drpCity.selectByIndex(1);*/

		/*********** For selecting city **************/
		Select drpCity = new Select(driver.findElement(By.name("city")));
		drpCity.selectByVisibleText("Pune");
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		/*********** For selecting state **************/
		Select drpState = new Select(driver.findElement(By.name("state")));
		drpState.selectByIndex(1);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For Conference full-Access **************/
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[12]/td[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		Thread.sleep(1000);
		callAlert();

		driver.findElement(By.xpath("html/body/form/table/tbody/tr[14]/td/a")).click();
		
		//After successful conference registration, it navigates to payment details page
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NITISHAG\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\NITISHAG\\Desktop\\mod\\PaymentDetails.html");
		Thread.sleep(2000);

		/*********** For filling the card holder name **************/
		driver.findElement(By.id("txtCardholderName")).sendKeys("Nitu");
		Thread.sleep(1000);
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For filling the Debit card number **************/
		driver.findElement(By.id("txtDebit")).sendKeys("101010101010");
		Thread.sleep(1000);
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For filling the CVV**************/
		driver.findElement(By.id("txtCvv")).sendKeys("036");
		Thread.sleep(1000);
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For Expiration month **************/
		driver.findElement(By.id("txtMonth")).sendKeys("12");
		Thread.sleep(1000);
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(1000);
		callAlert();
		
		/*********** For Expiration year **************/
		driver.findElement(By.id("txtYear")).sendKeys("23");
		Thread.sleep(1000);
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(1000);
		callAlert();
		
		driver.findElement(By.id("btnPayment")).click();

	}
	public static void callAlert() {
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Message is : " + alertMessage);
		driver.switchTo().alert().accept();
	}
}
