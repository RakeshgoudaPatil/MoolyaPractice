package testLeafCases;

import org.testng.annotations.Test;

import wrapper.ProjectSpecficWrapper;



public class MergeLead extends ProjectSpecficWrapper {
	
	@Test
	public void mergeLead() throws Exception{
		linkhandling("Leads");
		linkhandling("Merge Leads");
		buttonHandling("xpath","(//img[@alt='Lookup'])[1]");
		switchToWindow(1);
		textBoxHandling("name","firstName", "Gopinath");
		buttonHandling("xpath","//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		String sText = getText("Xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		System.out.println(sText);
		buttonHandlingWithoutSnap("Xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToWindow(0);
		buttonHandling("xpath","(//img[@alt='Lookup'])[2]");
		switchToWindow(1);
		textBoxHandling("name","firstName", "Babu");
		buttonHandling("xpath","//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		buttonHandlingWithoutSnap("Xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToWindow(0);
		buttonHandlingWithoutSnap("link","Merge");
		alertHandling("ok");
		linkhandling("Find Leads");
		textBoxHandling("xpath","//label[contains(text(),'Lead ID:')]/following::input", sText);
		buttonHandlingWithoutSnap("Xpath","//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		//verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
			
	}

}
