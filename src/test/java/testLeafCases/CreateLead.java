package testLeafCases;



import org.testng.annotations.Test;

import wrapper.ProjectSpecficWrapper;


public class CreateLead extends ProjectSpecficWrapper{
	
	@Test
	public void createLead() throws Exception{
		launchBrowserAndApp("chrome", "http://www.leaftaps.com/opentaps");
		textBoxHandling("id", "username", "DemoSalesManager");
		textBoxHandling("name", "PASSWORD", "crmsfa");
		buttonHandling("className", "decorativeSubmit");
		linkhandling("CRM/SFA");
		linkhandling("Leads");
		linkhandling("Create Lead");
		textBoxHandling("id","createLeadForm_companyName","Qeagle");
		textBoxHandling("id","createLeadForm_firstName", "Gopinath");
		textBoxHandling("id","createLeadForm_lastName", "Jayakumar");		
		textBoxHandling("id","createLeadForm_primaryEmail", "gopinath@testleaf.com");
		textBoxHandling("id","createLeadForm_primaryPhoneNumber", "9597704568");
		buttonHandling("className","submitButton");
	}
}









