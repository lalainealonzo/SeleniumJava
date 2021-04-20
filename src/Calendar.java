import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().window().maximize();
		
		//FROM / Departure City
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //click Departure dropdown
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //click BLR
				
		Thread.sleep(2000);
		
		//TO / Arrival City
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //click MAA
		
		//Calendar
		//current date: ui-state-default ui-state-highlight ui-state-active
		//other dates: ui-state-default
		//replace space with dot
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click(); //select the current date
		
		//Verify Return Date for One Way and Roundtrip
		//Choose Roundtrip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		Assert.assertTrue(true);
		
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); //check if Return Date is enabled true
		Assert.assertTrue(true);
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //look for the attribute thats changing in Return Date
		
		//Choose One Way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
		Assert.assertTrue(true);
				
		//Assert.assertFalse(driver.findElement(By.id("spclearDate")).isDisplayed()); //check if Return Date X is enabled true
		//Assert.assertFalse(false);

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //look for the attribute thats changing in Return Date
		
		//BEFORE: display: block; opacity: 1;
		//AFTER: display: block; opacity: 0.5;
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) //check if Return Date is enabled true
		{
			System.out.println("Return Date field is disabled upon clicking One Way radio button");
			Assert.assertTrue(true); //if condition is met
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		driver.close();
	}

}
