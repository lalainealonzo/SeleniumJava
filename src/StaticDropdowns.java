import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Static Dropdowns - options in the dropdown are fixed
		//Tag Name: select
		
		
		//Currency - tagname is Select
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //dropdown element
		
		Select selectObj = new Select(staticDropdown); //create object of the Select Class. using object you will be able to use methods of the Select class.

		selectObj.selectByIndex(2); //AED Select by Index
		String selectedOption = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
		System.out.println(selectedOption);
		
		selectObj.selectByValue("USD"); //USD Select by Value
		String selectedOption2 = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
		System.out.println(selectedOption2);
		
		selectObj.selectByVisibleText("INR"); //INR Select by Visible Text
		String selectedOption3 = selectObj.getFirstSelectedOption().getText(); //returns the webelement of the selected option
		System.out.println(selectedOption3);
		
		//Passengers - tagname is div
		driver.findElement(By.id("divpaxinfo")).click(); //Passenger dropdown
		Thread.sleep(2000L);
		
		int cnt = 0;
		while(cnt<3) //while true
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //Click plus icon in Adult 3 times. Outcome should be 4.
			cnt++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click(); //Click Done
		
		String validateCount = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(validateCount); //print the passenger dropdown element
		
		
		//driver.close();
		
	}

}
