import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyLoginErrorMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin"); //username
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin12"); //incorrect password
		
		boolean linkDisplayed = driver.findElement(By.linkText("Forgot your password?")).isDisplayed(); //true or false
		System.out.print("Forgot your password link is displayed? "); //+ linkDisplayed);
		
		if(linkDisplayed == true) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		driver.findElement(By.cssSelector("#btnLogin")).click(); //using CSS Selector
		
		String errorMessage = driver.findElement(By.cssSelector("#spanMessage")).getText(); //grab any text
		System.out.println(errorMessage); //Invalid credentials
		
		System.out.println(driver.findElement(By.cssSelector("#spanMessage")).isDisplayed());
		
		driver.close();
		
	}

}
