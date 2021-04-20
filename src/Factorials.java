import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Factorials {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://qainterview.pythonanywhere.com/");
		
		String integer = "5";
		
		driver.findElement(By.id("number")).sendKeys(integer);
		
		driver.findElement(By.id("getFactorial")).click();
		
		Factorials factorial = new Factorials();
		long expected = factorial.getfactorial(Integer.parseInt(integer));
		
		Thread.sleep(3000);
		
		String result = driver.findElement(By.id("resultDiv")).getText()	//The factorial of 5 is: 120
			.split(":")[1]
			.trim();
		
		//System.out.println("expected: " + expected);
		//System.out.println("result: " + result);
		
		Assert.assertEquals(Long.parseLong(result), expected);
		

	}
	
	public long getfactorial(int integer) {
	    if (integer <= 2) {
	        return integer;
	    }
	    return integer * getfactorial(integer - 1);
	}

}
