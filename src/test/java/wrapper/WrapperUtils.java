package wrapper;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public interface WrapperUtils {
	
	/**
	 * This method launch the respective browser and load the rewquested URL
	 * @param browserName  - firefox or chrome or ie
	 * @param appURL
	 */
	public void launchBrowserAndApp(String browserName, String appURL);
	public WebElement locateTheElement(String locatorType, String locatorValue);
	/**
	 * This method helps to send the text to text box
	 * 
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue - the value of above locotor type u have chosen
	 * @param textToBePassed - text needs to be passed to the text box 
	 */
	public void textBoxHandling(String locatorType, String locatorValue, String textToBePassed);
	/**
	 * 
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue - 
	 */
	public void buttonHandling(String locatorType, String locatorValue);
	/**
	 * this method will click the link based on input link text
	 * @param linkText - text on the link
	 */
	public void linkhandling( String linkText);
	
	/**
	 * This method selects the value from the drop down list
	 * @param locatorType - id or name or className or tagName or xpath or css
	 * @param locatorValue
	 * @param valueToBeSelected
	 */
	public void dropDownHandling(String locatorType, String locatorValue,String valueToBeSelected);
	/**
	 * This method will take screen shot and save it in local drive 
	 * @throws IOException
	 */
	public void takeScreenShot() throws IOException;
	/**
	 * this method will handle alert based on the user input 
	 * @param okorcancel - ok/cancel
	 * @return
	 */
	public String alertHandling(String okorcancel);
	public void switchToFrame(String locatorType, String locatorValue);
	public void switchBackFromFrame() ;
	/**
	 * This method switch the control to child window
	 * @param index 0 means parent window & 1 means first child window
	 */
	public void switchToWindow(int index) ;
	/**
	 * This method will return you the text available in the element (means text in between the tags)
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public String getText(String locatorType, String locatorValue);
	/**
	 * this method will return you the value of attribute that have been passed
	 * @param locatorType
	 * @param locatorValue
	 * @param attribute
	 * @return
	 */
	public String getAtrribute(String locatorType, String locatorValue,String attribute);
	/**
	 * this method will close particular window of the browser
	 */
	public void closeBrowser();
	/**
	 * this method will close  the browser
	 */
	public void closeAllBrowsers() ;
	public void frameMessage(String locatorType, String locatorValue) ;

	
	
	
	
	

}
