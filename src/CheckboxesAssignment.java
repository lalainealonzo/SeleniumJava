import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxesAssignment {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		//check the checkbox and verify
		driver.findElement(By.cssSelector("#checkBoxOption1")).click(); //option 1
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()); //verify if selected
		Assert.assertTrue(true);
		
		//uncheck the checkbox and verify
		driver.findElement(By.cssSelector("#checkBoxOption1")).click(); //option 1
		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()); //verify if not selected
		Assert.assertFalse(false);
		
		//count size of checkboxes
		//find the common locator of the checkboxes and use size() method
		int checkboxSize = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(checkboxSize);
		
		
		driver.close();
	}

}
