package org.ts;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

 
public class Tsk extends BaseCls{
	
	@Test
	 private void tc01() throws IOException
	{
		 String readData = ReadData("C:\\Users\\LENOVO\\Documents\\Book2.xlsx","Sheet1",1,0);
		 findId("password").sendKeys("Sathish@98");
		 findId("login").click();
	}
	 
	@Test
	private void tc02()
	{
		WebElement id = findId("location");
		dropdown(id,1); 
	}
	 
	 
}		 
	
	

