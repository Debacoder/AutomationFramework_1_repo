package genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author debashish
 */
public class webDriverUtility {
	/**
	 * this method will switch the driver control to frame based on index passed
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch the driver control to frame based on name or id present in iframe tag
	 * @param driver
	 * @param nameodId
	 */
	public void switchToFrame(WebDriver driver,String nameodId) {
		driver.switchTo().frame(nameodId);
	}

	/**
	 * This method will switch to the driver control to frame based on webElement reference
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	
	/**
	 * This method will use to right click in any element
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	
	/**
	 * this method will use for mousehover in any element by webdriver reference
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}
	
	
	public void selectByIndex(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void selectByValue(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
}