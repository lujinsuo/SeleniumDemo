package main.java.com.dbyl.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import main.java.com.dbyl.libarary.utils.ReadExcelUtil;

/**
 * This is to verify testng annotation execute
 * 
 * @author Young
 *
 */
public class TestngExample {
	private int a;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws Exception {
		String[][] array = ReadExcelUtil.getLocatorMap();
		for (String[] temp : array) {
			for (String str : temp) {
				System.out.println(str);
			}
		}
		System.out.println("This Before Suite Method, will run one time");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		a = 2;
		System.out.println("This is beforClass method. The Value of a is: " + a);

	}

	@BeforeClass
	public void beforeClass() {
		a = 1;
		System.out.println("This is beforeClass method .The Value of a is: " + a);
	}

	@Test(enabled = false,groups = { "TestngExample", "The Test Group 1" }, priority = 3)
	public void testExample1() {
		a = 3;
		System.out.println("This is Test  method1 .The Value of a is: " + a);
		Assert.fail();
	}

	@Test(groups = { "TestngExample", "The Test Group 2" }, priority = 2)
	public void testExample2() {
		a = 4;
		System.out.println("This is Test  method2 .The Value of a is: " + a);
	}

	@Test(enabled = true, threadPoolSize = 5, invocationCount = 10)
	public void parallelTest() throws InterruptedException {
		System.out.println("Current Thread Id: " + Thread.currentThread().getId());
		Thread.sleep(5000);
	}

	/**
	 * This test will skip
	 */
	@Test(priority = 1)
	public void skipTest() {
		throw new SkipException("skip the test");
	}

	@AfterClass
	public void afterClass() {
		a = 5;
		System.out.println("This is AfterClass Method .The Value of a is: " + a);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException {
		a = 6;
		Thread.sleep(3000);
		System.out.println("This is AfterMethod Method .The Value of a is: " + a);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("This is after AfterSuite Method");
	}
}
