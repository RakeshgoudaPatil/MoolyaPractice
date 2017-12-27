package testLeafCases;

import org.testng.annotations.Test;

import wrapper.ProjectSpecficWrapper;



public class EditLead extends ProjectSpecficWrapper {	

	@Test
	public void editLead() throws Exception{
		linkhandling("Leads");
		linkhandling("Find Leads");
		textBoxHandling("xpath","(//input[@name='firstName'])[3]", "Gopinath");
		buttonHandlingWithoutSnap("Xpath","//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		buttonHandlingWithoutSnap("Xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		verifyTitle("View Lead | opentaps CRM");
		clickByXpath("//a[contains(text(),'Edit')]");
		selectVisibileTextById("updateLeadForm_industryEnumId", "Computer Software");
		clickByXpath("//input[@class='smallSubmit']");
	}
	
}
