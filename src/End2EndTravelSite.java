import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2EndTravelSite {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
	WebDriver driver = new ChromeDriver();
		
	driver.get("https://www.spicejet.com/");
	
	driver.manage().window().maximize();
	
	//Checkbox - Family and Friends
	driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	Assert.assertTrue(true);
	
	//FROM / Departure City
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //click Departure dropdown
	driver.findElement(By.xpath("//a[@value='DEL']")).click(); //click DEL
		
	Thread.sleep(2000);
		
	//TO / Arrival City
	driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //click MAA
	
	//Calendar
	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click(); //select the current date
	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) //check if Return Date is enabled true
	{
		System.out.println("Return Date field is disabled upon clicking One Way radio button");
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	
	
	//Currency - tagname is Select
	WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //dropdown element
			
	Select selectObj = new Select(staticDropdown); //create object of the Select Class. using object you will be able to use methods of the Select class.

	selectObj.selectByValue("USD");  //USD Select by Index
	String selectedOption = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
	System.out.println(selectedOption);
	
	/*		
	selectObj.selectByValue("USD"); //USD Select by Value
	String selectedOption2 = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
	System.out.println(selectedOption2);
			
	selectObj.selectByVisibleText("INR"); //INR Select by Visible Text
	String selectedOption3 = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
	System.out.println(selectedOption3);
	*/
			
	//Passengers - tagname is div
	driver.findElement(By.id("divpaxinfo")).click(); //Passenger dropdown
	Thread.sleep(2000L);
	/*		
	int cnt = 0;
	while(cnt<3) //while true
	{
		driver.findElement(By.id("hrefIncAdt")).click(); //Click plus icon in Adult 3 times. Outcome should be 4.
		cnt++;
	}
			
	driver.findElement(By.id("btnclosepaxoption")).click(); //Click Done
	*/
	
	Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
	dropdown.selectByValue("4");
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
	//Assert.assertEquals(actual, expected);
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
	
	driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click(); //click Search
	
	Thread.sleep(5000);
	
	//Verify URL after clicking Search
	String expectedURL = "https://book.spicejet.com/Select.aspx";
	String actualURL = driver.getCurrentUrl();
	Assert.assertEquals(actualURL, expectedURL);
	
	
	}

}
