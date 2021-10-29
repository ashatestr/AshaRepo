package com.evs.genericLayer;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericMathod {
	public WebDriver driver;

	public void lounchBrowse() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public void close() {
		driver.close();
	}

	public void getElements(WebDriver driver, String xpath) {
		driver.findElements(By.xpath(xpath));
	}

	public void click(WebElement we) {
		we.click();
	}

	public void sendkey(WebElement we, String input) {
		we.sendKeys(input);
	}

	public void windowHandles(String expTitile) {
		Set<String> handls = driver.getWindowHandles();
		for (String handl : handls) {
			driver.switchTo().window(handl);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase(expTitile))
				break;
		}
	}

	public void closeAllWindowHandles(String expUrl) {
		Set<String> handls = driver.getWindowHandles();
		for (String handl : handls) {
			driver.switchTo().window(handl);
			String url = driver.getCurrentUrl();
			if (url.equalsIgnoreCase(expUrl))
				driver.close();

		}
	}

	public void clear(WebElement we) {
		we.clear();
	}

	public void close(WebElement we) {
		driver.close();
	}

	public void SelectByIndex(WebElement we, int num) {
		Select sel = new Select(we);
		sel.selectByIndex(num);
	}

	public void SelectByValue(WebElement we, String name) {
		Select sel = new Select(we);
		sel.selectByValue(name);
	}

	public void SelectByVisibaltext(WebElement we, String path) {
		Select sel = new Select(we);
		sel.selectByVisibleText(path);
	}

	public void mouseover(WebElement we) {
		Actions ac = new Actions(driver);
		ac.moveToElement(we).build().perform();
	}

	public void dragdrop(WebElement we, WebElement exp) {
		Actions action = new Actions(driver);
		action.dragAndDrop(we, exp).build().perform();
	}

	public String getText(WebElement we) {
		return we.getText();

	}
}
