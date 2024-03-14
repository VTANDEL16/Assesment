package ContactUs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ContactUs_TestCase {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.mortgageadvicebureau.com/contact-us/");

		driver.findElement(By.linkText("Allow all cookies")).click();

		driver.manage().window().maximize();

		By firstName = By.xpath("(//input[@type='text'])[3]");
		By lastName = By.xpath("(//input[@type='text'])[4]");
		By email = By.xpath("//input[@type='email']");
		By telephone = By.xpath("//input[@type='tel']");

		By bestTimeCall = By.xpath("(//input[@type='text'])[5]");
		By dropDown = By.xpath("//span[@class='custom-select-opener select form-control']");
		By DroDownElements=By.xpath("//div[contains(@id,'customSelect')]//div");
		By message = By.xpath("//div[@class='form-group__wrap']/textarea "); 																		
		By checkBox = By.xpath("(//input[@type='checkbox'])[1]");

		getElement(firstName).sendKeys("vibhuti");
		getElement(lastName).sendKeys("tandel");
		getElement(email).sendKeys("v@gmail.com");
		getElement(telephone).sendKeys("07466086602");
		getElement(bestTimeCall).sendKeys("Tommorow at 12pm");
		clickOnDropDrownAndSelectValue(dropDown,DroDownElements, "I'm looking to remortgage");
		getElement(message).sendKeys("Tommorow after 12pm will be best suitable time to call me");
		action(checkBox);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void action(By locator)
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).build().perform();
		driver.findElement(locator).click();
	}

	public static void clickOnDropDrownAndSelectValue(By locator,By locator2 ,String value) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).build().perform();
		driver.findElement(locator).click();
		
	
		List<WebElement> ListOfelements = driver.findElements(locator2);
		for (WebElement e : ListOfelements) {
			String text = e.getText();
			if (text.length() != 0) {
				if (text.equals(value)) {
					act.moveToElement(e).perform();
					e.click();
					System.out.println(text);
					break;
				}
			}
		}

	}

}
