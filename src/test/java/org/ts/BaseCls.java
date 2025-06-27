package org.ts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BaseCls {
	public static WebDriver driver;
	public static void LaunchBrowser(String url)
	{
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static WebElement findId(String id)
	{
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	public static WebElement findName(String name)
	{
		WebElement element = driver.findElement(By.name(name));
		
				return element;
	}
	
	public static WebElement findXpath(String url)
	{
		WebElement element = driver.findElement(By.xpath(url));
		return element;
		
	}
	public static void sendKeys(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	public static void click(WebElement element)
	{
		element.click();
	
	}
	public static void dropdown(WebElement sk,int value)
	{
	
		Select s= new Select(sk);
		s.selectByIndex(value);
	}
	 public static String ReadData(String url,String name,int rvalue,int cvalue) throws IOException
	{
		
		File f=new File(url);
		FileInputStream fileinputstream=new FileInputStream(f);
		Workbook work=new XSSFWorkbook(fileinputstream);
		Sheet s=work.getSheet(name);
		String value = null;
        //for(int i=0;i<s.getPhysicalNumberOfRows();i++)
		//{
		   Row row2 = s.getRow(rvalue);
		  // for(int j=0;j<row2.getPhysicalNumberOfCells();j++)
	   //{
			   Cell cell = row2.getCell(cvalue);
			   CellType cellType = cell.getCellType();
		switch(cellType)
		{
		case STRING:
			value=cell.getStringCellValue();
		    LaunchBrowser("https://adactinhotelapp.com/");
			 findId("username").sendKeys(value);
		     break;
			
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim= new SimpleDateFormat("dd/MM/yy");
				value=sim.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
			    long round = Math.round(numericCellValue);
			    value=String.valueOf(round);
			     break;
			}
			default:
				break;
		}
	   
	return value;
	}}
	
