package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	// base class contains only reusable methods
	// No main method
	public static WebDriver driver;
	public static Actions a;
	public static Select s;
	public static Workbook book;
	public static Sheet s2;
	public static Cell c;
	public static Row r;

	public static void browserlaunch() {
		driver = new ChromeDriver();
	}

	public static void geturl(String url) {
		driver.get(url);
	}

	public static void titleofurl() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void click(WebElement clk) {
		clk.click();
	}
	public static void doubleClick(WebElement target) {
		a=new Actions(driver);
		a.doubleClick(target).perform();
	}
	
	public static void moveToElement(WebElement ele) {
		a=new Actions(driver);
		a.moveToElement(ele).perform();
	}

	public static void passtext(String text, WebElement passtext) {
		passtext.sendKeys(text);
	}

	public static void getcrnturl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void gettext(WebElement src2) {
		String text = src2.getText();
		System.out.println(text);
	}

	public String getattribute(WebElement abt, String value) {
		String attribute = abt.getAttribute(value);
		System.out.println(attribute);
		return attribute;
	}

	public static void closebrowser() {
		driver.close();
	}

	public static void maximization() {
		driver.manage().window().maximize();
	}

	public static void draganddrop(WebElement source, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void indexselect(WebElement sel, int index) {
		s = new Select(sel);
		s.selectByIndex(index);
	}

	public static void valueSelect(WebElement val, String text) {
		s = new Select(val);
		s.selectByValue(text);
	}

	public static void visibleText(WebElement vt, String text) {
		s = new Select(vt);
		s.selectByVisibleText(text);
	}
	
	public static boolean isEnabled(WebElement enable) {

		return enable.isEnabled();

	}

	public static boolean isSelected(WebElement select) {

		return select.isSelected();

	}

	public static boolean isDisplayed(WebElement display) {

		return display.isDisplayed();

	}

	public static String readDatafromexcel(int row, int cell) throws IOException {

		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\taskofPOM\\ExcelFile\\Hotel_Booking_Details.xlsx");

		// To read the file
		FileInputStream fis = new FileInputStream(f);

		// To read exact file format .xlsx
		book = new XSSFWorkbook(fis);

		// Workbook ---> Sheet ---> row ---> cell---> datas
		s2 = book.getSheet("BookingDetails");
		r = s2.getRow(row);
		c = r.getCell(cell);
		int cellType = c.getCellType();

		String value = null;

		if (cellType == 1) {
			// String
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {

			Date d = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd-MMMM-YYYY");
			value = s.format(d);

		} else {
			// Number
			double dd = c.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);
		}
		return value;
	}

	public static void createNewExcel(Sheet string) throws IOException {

		// 1.To mention the path location
		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\taskofPOM\\ExcelFile\\Hotel_Booking_Details.xlsx");

		// 2.To create a file
		Workbook w = new XSSFWorkbook();

		// 3.Create a sheet in workbook
		Sheet newSheet = w.createSheet("Details");

		// 4.Create new row
		Row newRow = newSheet.createRow(0);

		// 5.create a cell
		Cell newCell = newRow.createCell(0);
		newCell.setCellValue("loc");

		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("written");
	}

	public static void createCell(int getRowNo, int CellNo, String cellData) throws IOException {

		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\taskofPOM\\ExcelFile\\NewExcel.xlsx");
		FileInputStream fis2 = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis2);

		Sheet newSheet = w.getSheet("Details");

		Row newRow = newSheet.getRow(getRowNo);

		Cell newCell = newRow.createCell(CellNo);
		newCell.setCellValue(cellData);

		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("written");

	}

	public static void createRow(int crtRowNo, int crtCellNo, String cellData) throws IOException {
		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\taskofPOM\\ExcelFile\\NewExcel.xlsx");
		FileInputStream fis2 = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis2);

		Sheet newSheet = w.getSheet("Details");

		Row newRow = newSheet.createRow(crtRowNo);

		Cell newCell = newRow.createCell(crtCellNo);
		newCell.setCellValue(cellData);

		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("written");

	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
