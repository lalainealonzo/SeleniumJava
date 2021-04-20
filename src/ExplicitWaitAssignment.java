import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		
		driver.findElement(By.xpath("//div/a[contains(text(), 'Click to load get data via Ajax!')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[@id='results']")));
		
		System.out.println(driver.findElement(By.xpath("//div/div[@id='results']")));
		
		driver.close();
		

	}

}
