package testCasesTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite()
	public void beforeSuite() {
		System.out.println("Before suite is executed");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass is executed");
		
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest is executed");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite is executed");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass is executed");
		
	}
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest is executed");
	}
	
	@Test(invocationCount = 5, threadPoolSize = 3)
	public void test() {
		System.out.println("Test is executed");
	}
	

}
