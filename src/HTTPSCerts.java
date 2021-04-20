import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPSCerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SSL Certificates
		//Customize chrome browsers using ChromeOptions class
		//Capabilities is a class which help you customize your chrome browser. Use desired capabilities
		
		//Input Desired Capabilities
		//General Chrome Profile
		DesiredCapabilities desiredCapab = DesiredCapabilities.chrome(); //to handle all the customizable things in chrome browser
		//desiredCapab.acceptInsecureCerts(); //pass this desiredCapab profile to the chrome browser Options
		desiredCapab.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //accept insecure certs
		desiredCapab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //accept SSL certs
		
		//Local Chrome Browser
		ChromeOptions chroOptions = new ChromeOptions();
		chroOptions.merge(desiredCapab); //merge chrome profile from above code
		
		System.setProperty("webdriver.chrome.driver","//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver(chroOptions);
		
		System.out.println(driver);

	}

}
