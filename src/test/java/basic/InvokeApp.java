package basic;


import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeApp {
	
	
	@Test
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
	}
}
