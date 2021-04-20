import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("#start button")).click();
		
		//Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		//Need to create customized wait method
		WebElement foo = wait.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver driver) //wait until this method(apply) returns web element
			{
				if (driver.findElement(By.cssSelector("#finish h4")).isDisplayed())
				{
					return driver.findElement(By.cssSelector("#finish h4")); //return the web element
					//Hello World is already present but is in invisible mode
				}
				else
				{
					return null;
				}
			}

		});
		//Wait until element is displayed
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).isDisplayed()); 
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).getText()); 
		System.out.println(foo);
		//End of Section 10

}
}
