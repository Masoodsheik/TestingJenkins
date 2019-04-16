package com.Geico;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.Readconfig;

public class Baseclass {

	Readconfig objconfig = new Readconfig();
	public static WebDriver driver;
	String baseUrl = objconfig.getApplicationUrl();
	String browsername = objconfig.SetBrowserName();
	String pageTitle = objconfig.getTitles();
	String UserName=objconfig.getUserName();
	String Password=objconfig.getPassword();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String brname) {

		logger = Logger.getLogger("Geico");
		PropertyConfigurator.configure("log4j.properities");
		
		if(brname.equals(browsername))
		{
		System.setProperty("webdriver.gecko.driver", objconfig.getfirefoxpath());
		driver = new FirefoxDriver();
		
		}else if(brname.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", objconfig.getChromepath());
			driver=new ChromeDriver();
		}
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {
		driver.close();
		logger.info("Browser closed");
	}
	
	public void CaptureScreenshot(WebDriver driver,String scrnames) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcedir=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			File targetscr=new File(System.getProperty("user.dir")+"/Screenshots/"+scrnames+".png");
			FileUtils.copyFile(sourcedir, targetscr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		
		
	}
	

}
