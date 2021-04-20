import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//frame is a component/container hosted in an html page
		
		//drag n drop
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		//switching to frame 
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); //frame with drag n drop
		
		//use actions class to drag n drop
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable")); //inside the frame. element to be dragged
		WebElement target = driver.findElement(By.id("droppable")); //where to drag the element
		
		action.dragAndDrop(source, target) //source, target
			.build()
			.perform();
		
		driver.switchTo().defaultContent(); //come back to the default content
		

	}

}
