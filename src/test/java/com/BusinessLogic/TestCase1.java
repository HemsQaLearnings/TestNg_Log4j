package com.BusinessLogic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Generic_Utils.BaseClass;
import com.PomPages.Pom_HomePage;

@Listeners(com.Generic_Utils.LisImplClass.class)
public class TestCase1 extends BaseClass
{

	private WebElement empsearch;

	@Test(retryAnalyzer = com.Generic_Utils.RetryImplclass.class)
	public void HomePage_test() throws InterruptedException, IOException
	{
		
	try {
		logger.info("******** Starting TC_01_HomePageTest *********");
		//SoftAssert sf=new SoftAssert();
		Pom_HomePage hp=new Pom_HomePage(driver);
		/*
		 * String getdashboardtext = hp.getDashboard().getText();
		 * System.out.println(getdashboardtext+"===> Home Page is Displayed");
		 */
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hp.getPim())).click();
		
		//hp.getPim().click();
		Thread.sleep(3000);
	//	wLib.waituntilElementTobeClickable(driver, 10, hp.getPim());
		wLib.waituntilElementTobeClickable(driver, 10, hp.getAddEmployee());
		logger.info("******** Clicked on AddEmployee major Tab *********");
		Thread.sleep(3000);
		hp.getAddEmployee().click();
		Thread.sleep(3000);
		hp.OragneHrm_HomePageTask("Hems","Qa","learnings");
		Thread.sleep(3000);
		hp.getSave_btn().click();
		logger.info("******** Added Employee details *********");
		/*
		 * Assert.assertTrue(false); // to get the screenshot //sf.assertTrue(true);
		 * //sf.assertTrue(false);
		 */		
		Thread.sleep(3000);
		hp.getGetPim2().click();
		Thread.sleep(3000);
		hp.getEmployeeList().click();
		logger.info("******** Clicked on EmployeeList details Major Tab *********");
		Thread.sleep(3000);
		empsearch = wait.until(ExpectedConditions.visibilityOf(hp.getEmployeeNameSearch()));
		empsearch.sendKeys("Hems Qa learnings");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		logger.info("******** Clicked on Submit Major Tab *********");
		WebElement verifyEmpName = hp.getVerifyEmpName();
		Thread.sleep(3000);
		String getemptext = verifyEmpName.getText();
		Thread.sleep(3000);
		Assert.assertTrue(false); // to get the screenshot make it false
		//sf.assertTrue(true);
		//sf.assertTrue(false);
		System.out.println(getemptext);
		//sf.assertAll();
		logger.info("******** Verification Completed *********");
	}
	catch(Exception e)
	{
		logger.error("Test Failed");
		logger.debug("Debug failure");
		Assert.fail();
		
	}
	logger.info("Tc01 completed sucessfully");
	}
}


