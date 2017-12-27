package testCases;

import org.testng.annotations.Test;


import wrapper.ProjectSpecficWrapper;

public class TC02 extends ProjectSpecficWrapper{
	@Test()
	public void Duplicate() {
		Login();
		buttonHandling("xpath", "//a[(text()='Leads')]");
		linkhandling("Find Leads");
		buttonHandling("xpath", "//span[contains(text(),'Email')]");
		textBoxHandling("xpath", "//input[@name='emailAddress']", "yuvaaraaj@yahoo.com");
		
		
		
	}
	
	
	
	
	

}
