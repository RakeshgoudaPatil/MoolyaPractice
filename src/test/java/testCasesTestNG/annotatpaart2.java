package testCasesTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotatpaart2 {
	
		
		@BeforeSuite
		public void beforeSuite2() {
			System.out.println("Before2 suite is executed");
		}
		@BeforeClass
		public void beforeClass() {
			System.out.println("BeforeClass2 is executed");
			
		}
		@BeforeTest()
		public void beforeTest() {
			System.out.println("BeforeTest2 is executed");
		}
		@AfterSuite
		public void afterSuite() {
			System.out.println("AfterSuite2 is executed");
		}
		@AfterClass
		public void afterClass() {
			System.out.println("AfterClass2 is executed");
			
		}
		@AfterTest()
		public void afterTest() {
			System.out.println("AfterTest2 is executed");
		}
		
		@Test()
		public void test() {
			System.out.println("Test2 is executed");
		}
}
