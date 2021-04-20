import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizedXPathCSSSelectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//<input name="txtUsername" id="txtUsername" type="text">
		//tagName: input
		//attributes: name, id, type
		//values: input text. e.g. txtUsername
		//select a unique attribute like name, id
		
		//XPath
		//syntax of xPath: //tagName[@attribute='value']
		//tagName is not required. can put * meaning any tagname which has the attribute mentioned
		//example: //input[@id='txtUsername']
		
		//CSS Selectors
		//syntax of CSS: tagName[attribute='value'], #idvalue 
		//tagName is not required. syntax is [attribute='value']
		//example: input[id='txtUsername'], #txtUsername
		//Reference: https://www.w3schools.com/cssref/css_selectors.asp
		
		//Validating xPath and CSS Selectors before applying in the script
		//Go to console tab, convert copied xPath into single quote
		//Then $x("//*[@id=\'btnLogin\']") - remove x for CSS Selectors
		//Can also validate in Chropath
		
		//Scenario where you only have one attribute or the value is too long
		//Use regular expression concept
		//Need to identify which is constant
		//<input name = "username123">
		//Syntax of Regular Expression in Xpath: //tagName[contains(@attribute,'value')]
		//Example: input[contains(@name,'username123')] - checks if value matches with any subtext, not exact value.
		//Syntax of Regular Expression in CSS: tagName[attribute*='value'] - it assumes not need exact match in values
		//Example: input[name*='txtUsername']
		
		
		//You can also write XPath using parent-child traverse relationship if you do not have any unique attributes
		//Define xPath for parent/tagnames
		///html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input
		//[index] if the same tag name is present in the parent tag name, we should add an index
		
		//Chrome plugin: Chropath
		//Using Chropath, you can get xPath and CSS Selectors
		//No. of elements matching are also displayed
		
		//Difference between relative and absolute xPath
		//xPath - how we traverse thru nodes to reach a specific desired point
		//relative - does not depend on parent nodes
		//absolute - we traverse with the help of parent nodes
		
		//Traverse if the element to be used is dynamic
		
		//Traverse from Child move to next Child - used if the second sibling's id keeps on changing/dynamic as well as its parent
		//Syntax: //*[@attribute='value']/following-sibling::sibling2TagName[index]
		//Example: //*[@id='sibling1']/following-sibling::sibling2[1]
		
		//Traverse from Child to Parent - used if child is static while parent is dynamic
		//Syntax: //*[@attribute='value']/parent::tagName
		
		//In CSS, you cannot traverse back
		
		//Identify an element that is Text-based -example: you cannot see backend code, UI design only (prototype image)
		//Syntax: //*[text()='value'], //*[contains(text(),'value')]
		//Example://*[text()='Username'], //*[contains(text(),'Username')]
		
		//Why CSS? CSS is 10x faster than xPath
		
		//https://medium.com/@kshitishirke/which-locator-is-faster-in-identifying-elements-in-selenium-5aeb3f943f5d
		
		//Which locator is faster in identifying elements in Selenium?
		//ID - IDs are the safest, fastest locator option and should always be your first choice.
		//Name - Name locator comes after ID. If any web element has not ID attribute, we can use name attribute if available. Name cannot be unique all the times.
		//CSS Selector - CSS Selector is best option if web element has no ID and name. It is very useful when we want to test our application on multiple browsers because CSS engine are consistent in all browsers. 
		//XPath - Locate an element using an XPath expression. It is slowest among all locators. But it provides you reliable ways to locate web elements. XPath engines are different in each browser, hence make them inconsistent across browsers. 
		//Linktext - It is mostly based on situation. Accessing links using their exact link text is done through the By.linkText() method.
		//Partial LinkText - Accessing links using a portion of their link text is done using the By.partialLinkText() method.
		//Tag Name - It is mostly based on situation. A tagName is a part of a DOM structure where every element on a page is been defined via tag like input tag, button tag, anchor tag, etc.
		//Class Name - It is mostly based on situation. Class Name locator helps in locating element defined through the class attribute. Class attribute need not to be unique like id.
		
		//https://rahulshettyacademy.com/dropdownsPractise/
	}

}
