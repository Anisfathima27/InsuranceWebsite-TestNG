package org.plan;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.base.BaseClass;
import org.jsoup.select.Evaluator.IsEmpty;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v120.runtime.Runtime.GetPropertiesResponse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.junit.ArrayAsserts;

import com.google.gson.annotations.Until;


public class ElementsPresent extends BaseClass {

	@BeforeClass(groups= {"Form"})
	private void launchBrowser() {
		browserlaunch();
		maximization();
	}

	@Test(priority=1,groups= {"Form"})
	private void findYourPlanIsPresent() {

		geturl("https://www.internationalstudentinsurance.com/");
		boolean contains = driver.getPageSource().contains("Find your plan");
		System.out.println(contains + " Find your plan available\n");
	}

	@Test(priority = 6,groups= {"Form"})
	private void citizenShipPresent() {

		ElementPojo e = new ElementPojo();
		implicitWait();

		boolean ctnShowdrodown = e.getCitizenshipBox().isDisplayed();
		if (ctnShowdrodown == true) {

			if (e.getCitizenshipBox().isEnabled()) {
				click(e.getCitizenshipBox());

				System.out.println("5.Citizenship box is enabled\n");
			} else {
				System.out.println("not enabled");
			}
			visibleText(e.getCitizenshipBox(), "Canada");
		}

		else {
			System.out.println("citizenship not available with dropdown\n");
		}
	}

	@Test(priority = 2,groups= {"Form"})
	private void prmryDestPresent() {

		ElementPojo e = new ElementPojo();
		boolean prmDestdrpdwn = e.getPrmDestinationBox().isDisplayed();
		if (prmDestdrpdwn == true) {

			if (e.getPrmDestinationBox().isEnabled()) {
				click(e.getPrmDestinationBox());
				System.out.println("1.Primary destination is enabled\n");
			} else {
				System.out.println("not enabled\n");
			}
			visibleText(e.getPrmDestinationBox(), "India");
		}

		else {
			System.out.println("primary destination not available with dropdown");
		}

	}

	@Test(priority = 3,groups= {"Form"})
	private void studentPresent() {

		ElementPojo e = new ElementPojo();
		boolean stdDrpDwn = e.getStudentBox().isDisplayed();
		if (stdDrpDwn == true) {

			if (e.getStudentBox().isEnabled()) {
				click(e.getStudentBox());
				System.out.println("2.Student box is enabled\n");

			} else {
				System.out.println("not enabled");
			}
			visibleText(e.getStudentBox(), "Yes");
		} else {
			System.out.println("student available without dropdown");
		}
	}

	@Test(priority = 4,groups= {"Form"})
	private void brthDatePresent() {
		SoftAssert s=new SoftAssert();

		ElementPojo e = new ElementPojo();

       s.assertTrue(e.getBrthDtBox().isDisplayed(), "birthdate is displayed or not");
			if (e.getBrthDtBox().isEnabled()) {
				click(e.getBrthDtBox());
				System.out.println("3.Birthdate is enabled\n");

			} else {
				System.out.println("not enabled");
			}
			passtext("25-02-2022", e.getBrthDtBox());
			s.assertAll();
			}
	
	@Test(priority = 5,groups= {"Form"})
	private void homeCountryPresent() {

		ElementPojo e = new ElementPojo();
		boolean hmDrpDwn = e.getHomCntryBox().isDisplayed();
		if (hmDrpDwn == true) {

			if (e.getHomCntryBox().isEnabled()) {
				click(e.getHomCntryBox());
				System.out.println("4.Home country is enabled\n");
			} else {
				System.out.println("not enabled");
			}
			visibleText(e.getHomCntryBox(), "India");
		} else {
			System.out.println("Home country not available with dropdown");
		}
	}

	@Test(priority = 7,groups= {"Form"})
	private void strtDatePresent() {

		ElementPojo e = new ElementPojo();

		boolean strDrpdwn = e.getStrtDateBox().isDisplayed();
		if (strDrpdwn == true) {

			if (e.getStrtDateBox().isEnabled()) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				try {
					WebElement clk = wait.until(ExpectedConditions.elementToBeClickable(e.getStrtDateBox()));
					click(clk);
				} catch (Exception e2) {

				}
				System.out.println("6.Startdate is enabled\n");
			} else {

				System.out.println("not enabled");
			}
			passtext("20-07-2024", e.getStrtDateBox());
		} else {
			System.out.println("Start date is not available with select option");
		}
			
	}

	@Test(priority = 8,groups= {"Form"})
	private void endDtPressent() {

		ElementPojo e = new ElementPojo();
		boolean endDpdwn = e.getEndDateBox().isDisplayed();
		if (endDpdwn == true) {

			if (e.getEndDateBox().isEnabled()) {
				click(e.getEndDateBox());
				System.out.println("7.Enddate is enabled\n");
			} else {

				System.out.println("not enabled");
			}
			passtext("10-02-2024", e.getEndDateBox());
		} else {
			System.out.println("end date is not available with select option");
		}

	}
	@Test(priority=9,groups= {"Form"})
	private void viewPlanSub() throws InterruptedException {
		ElementPojo e=new ElementPojo();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='submit'])[2]")));
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='submit'])[2]")));

		} catch (Exception e2) {
			// TODO: handle exception
		}
		boolean sub = e.getViewPlanSubmit().isEnabled();
		if (sub==true) {
			System.out.println("displayed");
		} else {

			System.out.println("not");
		}

		
	}

	@Test(priority = 10)
	private void stdntHealthIsPresent() {

		boolean stdhealth = driver.getPageSource().contains("Student Health");
		Assert.assertTrue(stdhealth);
	}

	@Test(priority = 11)
	private void travelMedPresent() {

		boolean trvMed = driver.getPageSource().contains("Travel Medical");
		Assert.assertTrue(trvMed);
	}

	@Test(priority = 12)
	private void mjrMedPresent() {

		boolean mjrMed = driver.getPageSource().contains("Major Medical");
		Assert.assertTrue(mjrMed);
	}

	@Test(priority=13)
	private void sclReqPresent() {

		boolean sclReq = driver.getPageSource().contains("School Requirements");
		System.out.println(sclReq);
		
	}
	@Test(priority=14)
	private void insExplPresent() {
		
		boolean insExp = driver.getPageSource().contains("Insurance Explained");	
		Assert.assertTrue(insExp);
	}
	@Test(priority=15,groups= {"Search"})
	private void srchPresent() {
		geturl("https://www.internationalstudentinsurance.com/");

        ElementPojo e=new ElementPojo();
		SoftAssert s=new SoftAssert();
		s.assertTrue(e.getSerchBox().isEnabled(), "check search box");
	}
	
	@Test(priority=16,groups= {"Search"})
	private void srchBoxEmpty() throws InterruptedException {

		ElementPojo e=new ElementPojo();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			WebElement clk = wait.until(ExpectedConditions.elementToBeClickable(e.getSerchBox()));
			click(clk);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		click(e.getSerchBox());
		WebElement bx = driver.findElement(By.xpath("//input[@id='navbar-global-search']"));
	
		passtext("  ", bx);
		Thread.sleep(3000);
		WebElement clk = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		Thread.sleep(2000);
		click(clk);
		
	}
	
		
	@Test(priority=17,groups= {"Search"})
	private void warnMsg() {

		//strong[text()='No Results Found']
		ElementPojo e=new ElementPojo();
		boolean displayed = e.getNoReslt().isDisplayed();
		System.out.println(displayed);
        String text = e.getNoReslt().getText();
        System.out.println(text);
        SoftAssert s=new SoftAssert();
        s.assertEquals(text, "No Results Found");
        s.assertAll();
	}	
	
	
	
	
	
	
	
	
	

}
