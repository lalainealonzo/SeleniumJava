import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click(); //title contains 'Sign in' text using CSS Selector
		
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("xPath Regular Expression :)"); //id contains 'login' text using xPath
		
		driver.findElement(By.cssSelector("input#password")).sendKeys("CSS Selector #id :)"); //#id using CSS Selector
		
		driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click(); //name contains 'procee' text using xPath
		
		String actualErrorMsg = driver.findElement(By.cssSelector("#div_login_error > b")).getText(); //get the error message text
		System.out.println(actualErrorMsg);
		
		String expectedErrorMsg = "Wrong username and password combination.";
		
		if (actualErrorMsg.equals(expectedErrorMsg))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		driver.close();

	}

}
