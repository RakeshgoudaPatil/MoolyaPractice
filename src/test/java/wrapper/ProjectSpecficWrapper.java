package wrapper;

import org.testng.annotations.BeforeTest;


public class ProjectSpecficWrapper extends GenericWrapperUtils {

	@BeforeTest
	public void Login() {
		launchBrowserAndApp("chrome", "http://www.leaftaps.com/opentaps");
		textBoxHandling("id", "username", "DemoSalesManager");
		textBoxHandling("name", "PASSWORD", "crmsfa");
		buttonHandling("className", "decorativeSubmit");
		linkhandling("CRM/SFA");
	}
}
