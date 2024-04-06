package org.plan;


import org.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SpecialInsurancePresent extends BaseClass {

	@BeforeClass
	private void launchBrowser() {
		browserlaunch();
		maximization();
	}

	@Test(priority=-11,groups= {"Form"})
	private void findYourPlanIsPresent() {

		geturl("https://www.internationalstudentinsurance.com/");
		boolean contains = driver.getPageSource().contains("Find your plan");

		SoftAssert s=new SoftAssert();
		s.assertTrue(contains,"check find your plan is present or not");
		s.assertAll();
		

	}
	@Test(priority=-9)
	private void dentIns() throws InterruptedException {

		ElementPojo e=new ElementPojo();
		String text = e.getDentalIns().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "Dental & Vision Insurance");
		s.assertAll();
	}
	
	
	@Test(priority=-8)
	private void f1stdIns() {
		
	ElementPojo e=new ElementPojo();
	String text = e.getF1stdIns().getText();
	SoftAssert s=new SoftAssert();
	s.assertEquals(text, "F-1 Student Insurance");
	s.assertAll();
	}
	@Test(priority=-7)
	private void depdncIns()  {
		
		ElementPojo e=new ElementPojo();
		String text = e.getDepIns().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "Dependent Insurance");
		s.assertAll();
		
	}
	@Test(priority=-6)
	private void hghSclIns()  {
		ElementPojo e=new ElementPojo();
		String text = e.getHghSclIns().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "High School Insurance");
		s.assertAll();
	}
	@Test(priority=-5)
	private void jvisaIns() {

		ElementPojo e=new ElementPojo();
		String text = e.getJ1Stdins().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "J Visa Insurance");
		s.assertAll();
	}
	
	@Test(priority=-4)
	private void optIns() {
		ElementPojo e=new ElementPojo();
		String text = e.getOptIns().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "OPT Insurance");
		s.assertAll();
		
	}
	@Test(priority=-3)
	private void schVisaIns() {

		ElementPojo e=new ElementPojo();
		String text = e.getSchengenVisaIns().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "Schengen Visa Insurance");
		s.assertAll();
	}
	@Test(priority=-2)
	private void stdAbdIns() {

		ElementPojo e=new ElementPojo();
		String text = e.getStdyAbdIns().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(text, "Study Abroad Insurance");
		s.assertAll();
		
	}
}
