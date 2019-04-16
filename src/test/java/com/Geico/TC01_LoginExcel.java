package com.Geico;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import utilities.XLUtils;

public class TC01_LoginExcel extends Baseclass{
	String xlpath = "D:\\Geico\\src\\main\\java\\TestData\\DDT.xlsx";
	
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String UserName,String Password) {
		
		LoginPage objDDT=new LoginPage(driver);
		objDDT.SetUserName(UserName);
		objDDT.SetPassword(Password);
		objDDT.ClickSubmit();
		
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		XLUtils obj=new XLUtils();

			int rownum=XLUtils.getRowCount(xlpath, "Sheet1");
			int colcount=XLUtils.getCellCount(xlpath, "Sheet1", 1);
			String [][] logindata =new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++) {
				
				for(int j=0 ;j<colcount;j++) {
					
					logindata[i-1][j]=XLUtils.getCellData(xlpath, "Sheet1", i,j);
				}
			}
			
			
	
		return logindata;
	}
	
}
