import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SendKeysGetTextAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click(); //click Option2 checkbox
		String cbGetText = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText(); //get text of the checkbox
		
		//System.out.println(cbGetText);
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example")); //static dropdown
		Select select = new Select(staticDropdown); 
		select.selectByVisibleText(cbGetText);  //select checkbox text from the dropdown options
		
		driver.findElement(By.id("name")).sendKeys(cbGetText); //enter in alert text box
		
		driver.findElement(By.id("alertbtn")).click(); //click alert button
		
		String alertMsg = driver.switchTo().alert().getText();
		
		if (alertMsg.contains(cbGetText))
		{
			System.out.println("Alert message: \"" + alertMsg + "\" CONTAINS this text from the selected checkbox: " + cbGetText);
		}
		else
		{
			System.out.println("Alert message: \"" + alertMsg + "\" DOES NOT contain this text from the selected checkbox: " + cbGetText);
		}
		
		driver.switchTo().alert().accept();
		
		driver.close();
		
		
		

	}

}
