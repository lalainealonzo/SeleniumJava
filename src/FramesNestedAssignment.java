import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesNestedAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		
		driver.switchTo().frame("frame-top"); //frame name
		driver.switchTo().frame("frame-middle"); //frame name
		
		String frameMidContent = driver.findElement(By.id("content")).getText();

		System.out.println(frameMidContent); //MIDDLE
		
		

	}

}
