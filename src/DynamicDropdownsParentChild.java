import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdownsParentChild {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		//Dynamic dropdowns - options are loaded only after typing in the dropdown
		
		
		//FROM / Departure City
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //click Departure dropdown
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //click BLR
		
		Thread.sleep(2000);
		
		//TO / Arrival City
		
		//Arrival City opens by default - no need to click the second dropdown
		//With index:
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //click BLR
		
		//Implement without Index using Parent-Child relationship:
		//First find parent xpath - entire window selection
		//Syntax: //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']
		//Then add whitespace then input the child
		//Syntax: //a[@value='MAA']
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //click MAA
		
		driver.close();
	}

}
