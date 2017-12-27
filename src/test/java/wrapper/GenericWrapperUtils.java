package wrapper;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrapperUtils implements WrapperUtils {
	public RemoteWebDriver driver = null;
	public WebElement element = null;
	public int i = 1;

	/**
	 * This method launch the respective browser and load the requested URL
	 * 
	 * @param browserName
	 *            - firefox or chrome or ie
	 * @param appURL
	 */
	public void launchBrowserAndApp(String browserName, String appURL) {

		try {
			if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"./drivers/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/iedriver/IEDriver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(appURL);
			driver.manage().window().maximize();
		} catch (WebDriverException e) {

			System.out.println("The browser " + browserName + " could not be launched");
		} 
	}

	
	/**
	 * this is the common method to identify/locate the elements used for the other methods
	 * @param : id or name or className or xpath or tagName or css
	 * @param locatorValue
	 * @return
	 */
	public WebElement locateTheElement(String locatorType, String locatorValue) {
		try {
			if (locatorType.equals("id")) {
				element = driver.findElement(By.id(locatorValue));
			} else if (locatorType.equals("name")) {
				element = driver.findElement(By.name(locatorValue));
			} else if (locatorType.equals("className")) {
				element = driver.findElement(By.className(locatorValue));
			} else if (locatorType.equals("xpath")) {
				element = driver.findElement(By.xpath(locatorValue));
			} else if (locatorType.equals("tagName")) {
				element = driver.findElement(By.tagName(locatorValue));
			} else if (locatorType.equals("css")) {
				element = driver.findElement(By.cssSelector(locatorValue));
			}
		} catch (NoSuchElementException e) {
			System.out.println("element not found");
			e.printStackTrace();
		} catch (WebDriverException e) {

			e.printStackTrace();
		}
		return element;

	}

	/**
	 * This method helps to send the text to text box
	 * 
	 * @param locatorType
	 *            -  id or name or className or xpath or tagName or css
	 * @param locatorValue
	 *            - the value of above locotor type u have chosen
	 * @param textToBePassed
	 *            - text needs to be passed to the text box
	 */
	public void textBoxHandling(String locatorType, String locatorValue, String textToBePassed) {

		try {
			locateTheElement(locatorType, locatorValue);
			element.clear();
			element.sendKeys(textToBePassed);
			System.out.println("The data " + textToBePassed + "Entered successfully in the field:" + locatorValue);
		} catch (NoSuchElementException e) {

			System.out.println("The data " + textToBePassed + " could not be Entered in the filed" + locatorValue);
		} catch (InvalidElementStateException e) {
			// TODO Auto-generated catch block
			System.out.println("the element is not ready to interact due to " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("error in text box handling with locator as " + locatorValue);
			e.printStackTrace();
		} finally {
			takeScreenShot();
		}
	}

	/**
	 * This method helps to the find element/button and click on it
	 * @param locatorType
	 *            - id or name or className or tagName or xpath or css
	 * @param locatorValue
	 *            -
	 */
	public void buttonHandling(String locatorType, String locatorValue) {

		try {
			locateTheElement(locatorType, locatorValue);
			element.click();
			System.out.println("The element " + locatorValue + " is clicked successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("the element " + element + " is not interactable");
		} catch (WebDriverException e) {
			System.out.println("error in handling button ");
		} finally {
			takeScreenShot();
		}
	}
	
	public void buttonHandlingWithoutSnap(String locatorType, String locatorValue) {

		try {
			locateTheElement(locatorType, locatorValue);
			element.click();
			System.out.println("The element " + locatorValue + " is clicked successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("the element " + element + " is not interactable");
		} catch (WebDriverException e) {
			System.out.println("error in handling button ");
		} 
	}

	/**
	 * this method will click the link based on input link text
	 * 
	 * @param linkText
	 *            - text on the link
	 */
	public void linkhandling(String linkText) {
		try {
			driver.findElement(By.partialLinkText(linkText)).click();
			System.out.println("The element " + linkText + " is clicked successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("the element " + element + " is not interactable");
		} catch (WebDriverException e) {
			System.out.println("error in handling link ");
		} finally {
			takeScreenShot();
		}

	}

	/**
	 * This method selects the value from the drop down list
	 * 
	 * @param locatorType
	 *            - id or name or className or tagName or xpath or css
	 * @param locatorValue
	 * @param valueToBeSelected
	 */
	public void dropDownHandling(String locatorType, String locatorValue, String valueToBeSelected) {
		try {
			locateTheElement(locatorType, locatorValue);
			Select sel = new Select(element);
			sel.selectByVisibleText(valueToBeSelected);
		} catch (WebDriverException e) {
			System.out.println("error in dropdown handling ");
		}

	}

	/**
	 * This method will take screen shot and save it in local drive
	 * 
	 * 
	 */
	public void takeScreenShot() {
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + i + ".png");
		try {
			FileUtils.copyFile(src, target);
			System.out.println("screen shot has been saved in following location "
					+ "C:\\Users\\RK\\eclipse-workspace\\SeleniumMaven\\ScreenShots");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("screen shot has been saved in following location "
					+ "C:\\Users\\RK\\eclipse-workspace\\SeleniumMaven\\ScreenShots");
			e.printStackTrace();
		}
		i++;

	}

	/**
	 * this method will handle alert based on the user input
	 * 
	 * @param okorcancel
	 *            - ok/cancel
	 * @return
	 */
	public String alertHandling(String okorcancel) {
		String textOnAlert = null;
		try {
			Alert alert1 = driver.switchTo().alert();
			textOnAlert = alert1.getText();
			if (okorcancel.equals("ok")) {
				alert1.accept();
			} else if (okorcancel.equals("cancel")) {
				alert1.dismiss();
			}
		} catch (WebDriverException e) {
			System.out.println("error in alert handling " + e.getMessage());
			e.printStackTrace();
		}
		return textOnAlert;
	}
/**
 * 
 * This method is used to switch the to frame present in the current window
 * @param locatorType
 * @param locatorValue
 */
	public void switchToFrame(String locatorType, String locatorValue) {
		try {

			driver.switchTo().frame(locateTheElement(locatorType, locatorValue));
			System.out.println("switch In to the Frame ");
		} catch (NoSuchFrameException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}
/**
 * This method is used to switch to the default frame present in the current window
 */
	public void switchBackFromFrame() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("brought the control out of frame");
		} catch (NoSuchFrameException e) {
			System.out.println("no such frame available  : " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	/**
	 * This method switch the control to child window
	 * 
	 * @param index
	 *            0 means parent window & 1 means first child window
	 */
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("number of windows " + allWindowHandles.size());
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index " + index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException ");
			e.printStackTrace();
		}
	}

	/**
	 * This method will return you the text available in the element (means text in
	 * between the tags)
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public String getText(String locatorType, String locatorValue) {
		String text = null;
		try {
			text = locateTheElement(locatorType, locatorValue).getText();
			System.out.println("The text is successfully fetched from the element");
		} catch (Exception e) {
			System.out.println("The text is failed to fetch from the element");
	
		}
		return text;
	}

	/**
	 * this method will return you the value of attribute that have been passed
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @param attribute
	 * @return
	 */
	public String getAtrribute(String locatorType, String locatorValue, String attribute) {
		String text = null;
		try {
			text = locateTheElement(locatorType, locatorValue).getAttribute(attribute);
			System.out.println("The value of attribute is successfully fetched from the element");
		} catch (Exception e) {
			System.out.println("Failed to fetch The value of attribute from the element");
			
		}
		return text;
	}

	/**
	 * this method will close the browser or the current window
	 */
	public void closeBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("error in closing browser " + e.getMessage());
		}
	}
/**
 * This method will close the browser
 */
	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The opened browsers are closed");
		} catch (WebDriverException e) {
			System.out.println("The browsers could not be closed");
		}
	}
/**
 * This method will get the text or message from the element
 * @param locatorType
 * @param locatorValue
 */
	public void frameMessage(String locatorType, String locatorValue) {
		locateTheElement(locatorType, locatorValue);
		System.out.println(element);
	}

}
