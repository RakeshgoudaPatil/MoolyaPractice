package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrapper implements Wrappers {

	public RemoteWebDriver driver;

	int i = 1;

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser" + browser + " launched succesfully");
		} catch (WebDriverException e) {
			System.out.println("The browser " + browser + " could not be launched");

		} finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The data " + data + "Entered successfully in the field:" + idValue);
		} catch (NoSuchElementException e) {

			System.out.println("The data " + data + " could not be Entered in the filed" + idValue);

		} catch (WebDriverException e) {
			System.out.println("Unexpected error occured");

		} finally {
			takeSnap();

		}

	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementById(nameValue).clear();
			driver.findElementById(nameValue).sendKeys(data);
			System.out.println("The data " + data + "Entered successfully in the field:" + nameValue);
		} catch (NoSuchElementException e) {

			System.out.println("The data " + data + " could not be Entered in the filed" + nameValue);

		} catch (WebDriverException e) {
			System.out.println("Unexpected error occured");

		} finally {
			takeSnap();
		}

	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementById(xpathValue).clear();
			driver.findElementById(xpathValue).sendKeys(data);
			System.out.println("The data " + data + "Entered successfully in the field:" + xpathValue);
		} catch (NoSuchElementException e) {

			System.out.println("The data " + data + " could not be Entered in the filed" + xpathValue);

		} catch (WebDriverException e) {
			System.out.println("Unexpected error occured");

		} finally {
			takeSnap();
		}

	}

	public boolean verifyTitle(String title) {
		
		return false;
	}

	public void verifyTextById(String id, String text) {

	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void verifyTextContainsById(String id, String text) {
		// TODO Auto-generated method stub

	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("The element " + id + " click successfully");
		} catch (NoSuchElementException e) {
			System.out.println("The element" + id + "could not clickable");

		} finally {
			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The element " + classVal + " click successfully");
		} catch (NoSuchElementException e) {
			System.out.println("The element" + classVal + "could not clickable");

		} finally {
			takeSnap();
		}

	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub

	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub

	}

	public void selectIndexById(String id, String value) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow() {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	public void quitBrowser() {
		// TODO Auto-generated method stub

	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + i + ".png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;

	}

	public void switchToFrame(String id, String name) {
		driver.switchTo().frame(id);

	}

}
