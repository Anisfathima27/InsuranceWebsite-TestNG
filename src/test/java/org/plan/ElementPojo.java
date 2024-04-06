package org.plan;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementPojo extends BaseClass{

	public ElementPojo() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//select[@id='virtualagentform-destination']")
	private WebElement prmDestinationBox;
	
	@FindAll({
		@FindBy(xpath="//select[@id='virtualagentform-isstudent']"),
		@FindBy(xpath="//select[@name='VirtualAgentForm[isStudent]']")
	})
	private WebElement studentBox;
	
	@FindAll({
		@FindBy(xpath="//input[@name='VirtualAgentForm[birthDate]']"),
		@FindBy(xpath="//input[@id='virtualagentform-birthdate']")
	})
	private WebElement brthDtBox;
	
	@FindAll({
		@FindBy(xpath="//select[@name='VirtualAgentForm[homeCountry]']"),
		@FindBy(xpath="//select[@id='virtualagentform-homecountry']")
	})
	private WebElement homCntryBox;
	
	
	@FindAll({
		@FindBy(xpath="//select[@id='virtualagentform-citizenship']"),
		@FindBy(xpath="//select[@name='VirtualAgentForm[citizenship]']")
	})
	private WebElement citizenshipBox;
	
	@FindAll({
		@FindBy(xpath="//input[@id='virtualagentform-startdate']"),
		@FindBy(xpath="//input[@name='VirtualAgentForm[startDate]']")
	})
	private WebElement strtDateBox;
	
	@FindAll({
		@FindBy(xpath="//input[@id='virtualagentform-enddate']"),
		@FindBy(xpath="//input[@name='VirtualAgentForm[endDate]']")
	})
	private WebElement endDateBox;
	
	
	@FindBy(xpath="//a[@class='fa-solid fa-search text-warning']")
	private WebElement serchBox;
	
	@FindBy(xpath="//strong[text()='No Results Found']")
	private WebElement noReslt;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement viewPlanSubmit;

	@FindBy(xpath="//h3[@class='card-title-border']")
	private WebElement spclInsurance;
	
	@FindBy(xpath="//a[@href='/dental-vision-insurance/']")
	private WebElement dentalIns;
	
	
	@FindBy(xpath="//a[@href='/dependent-insurance/']")
	private WebElement depIns;
	
	@FindBy(xpath="//a[@href='/f1student/']")
	private WebElement f1stdIns;
	
	@FindBy(xpath="//a[@href='/high-school-insurance/']")
	private WebElement hghSclIns;
	
	@FindBy(xpath="//a[@href='/j1student/']")
	private WebElement j1Stdins;
	
	@FindBy(xpath="//a[@href='/opt/']")
	private WebElement optIns;
	
	@FindBy(xpath="//a[@href='/schengen-visa-insurance/']")
	private WebElement schengenVisaIns;
	
	@FindBy(xpath="//a[@href='/study-abroad/']")
	private WebElement stdyAbdIns;
	
	
	
	
	
	
	
	public WebElement getSpclInsurance() {
		return spclInsurance;
	}

	public WebElement getDentalIns() {
		return dentalIns;
	}

	public WebElement getDepIns() {
		return depIns;
	}

	public WebElement getF1stdIns() {
		return f1stdIns;
	}

	public WebElement getHghSclIns() {
		return hghSclIns;
	}

	public WebElement getJ1Stdins() {
		return j1Stdins;
	}

	public WebElement getOptIns() {
		return optIns;
	}

	public WebElement getSchengenVisaIns() {
		return schengenVisaIns;
	}

	public WebElement getStdyAbdIns() {
		return stdyAbdIns;
	}

	public WebElement getViewPlanSubmit() {
		return viewPlanSubmit;
	}

	public WebElement getNoReslt() {
		return noReslt;
	}

	public WebElement getSerchBox() {
		return serchBox;
	}

	public WebElement getPrmDestinationBox() {
		return prmDestinationBox;
	}

	public WebElement getStudentBox() {
		return studentBox;
	}

	public WebElement getBrthDtBox() {
		return brthDtBox;
	}

	public WebElement getHomCntryBox() {
		return homCntryBox;
	}

	public WebElement getCitizenshipBox() {
		return citizenshipBox;
	}

	public WebElement getStrtDateBox() {
		return strtDateBox;
	}

	public WebElement getEndDateBox() {
		return endDateBox;
	}
	
	
	
	
}
