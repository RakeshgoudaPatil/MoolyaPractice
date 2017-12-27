package testCases;



import org.testng.annotations.Test;


import wrapper.ProjectSpecficWrapper;

public class TC01 extends ProjectSpecficWrapper {
	@Test
	public void MergeLeads() throws InterruptedException {

		Login();
		buttonHandling("xpath", "//a[(text()='Leads')]");
		buttonHandling("xpath", "//a[contains(text(),'Merge Leads')]");
		buttonHandling("xpath", "//input[@id='ComboBox_partyIdFrom']/following::img[1]");

		switchToWindow(1);
		buttonHandlingWithoutSnap("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");

		switchToWindow(0);
		buttonHandling("xpath", "(//img[@src='/images/fieldlookup.gif'])[2] ");
		Thread.sleep(5000);
		switchToWindow(1);
		buttonHandlingWithoutSnap("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		switchToWindow(0);
		buttonHandlingWithoutSnap("xpath", "//a[@class='buttonDangerous']");
		alertHandling("ok");
	}

}
