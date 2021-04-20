import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkNotFound {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Broken URL - check if working or not
		//status 400 and above are broken links
		//Inspect > Network > All/XHR > Status
		
		//Java methods will call the URLs and get the status code
		//Scan all links using selenium and get all URL
		//If status code >400 means the link is broken
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert softAssert = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection(); 
			conn.setRequestMethod("HEAD"); //head http request type. call url using head
			conn.connect();
			int responseCode = conn.getResponseCode(); //status
			
			System.out.println(responseCode);
			
			String msg = "The link with Text: \"" + link.getText() + "\" is broken with code " + responseCode;
			
			softAssert.assertTrue(responseCode < 400,msg); //false of true = fail
			//the message above will be displayed only if responseCode < 400 is NOT true
			//SoftAssert will still continue execution even if a failure is already found
			
			/*
			if(responseCode > 400)
			{
				System.out.println("The link with Text: \"" + link.getText() + "\" is broken with code " + responseCode);
				System.out.println("Error " + responseCode + " at " + url + "\n");
				Assert.assertTrue(false); //hard assertion. when failed, it will produce hard stop and not proceed with remaining links.
			}
			*/
			
		}
		softAssert.assertAll(); //will report all failed assertions
		
		//String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href"); //get complete url of the link
		
		//openConnection method comes from URL class
		//call method using obj of the class
		
		
		
		
		

	}

}
