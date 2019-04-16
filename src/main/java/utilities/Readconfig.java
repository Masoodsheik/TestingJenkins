package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	Properties prop;
	FileInputStream fsys;

	public Readconfig() {

		File src = new File("./Configuration/config.properities");
		try {
			fsys = new FileInputStream(src);
			prop = new Properties();
			prop.load(fsys);
		} catch (FileNotFoundException e) {
			System.out.println("Exception is" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is for properties" + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String getUrl = prop.getProperty("baseUrl");
		return getUrl;
	}

	public String getUserName() {
		String getUName = prop.getProperty("username");
		return getUName;
	}

	public String getPassword() {
		String getPassword = prop.getProperty("password");
		return getPassword;
	}

	public String getfirefoxpath() {

		String getfirefoxpath = prop.getProperty("firefoxpath");
		return getfirefoxpath;
	}

	public String getChromepath() {

		String getfirefoxpath = prop.getProperty("chromepath");
		return getfirefoxpath;
	}

	public String getTitles() {

		String getPageTitles = prop.getProperty("pageTitle");
		return getPageTitles;
	}

	public String SetBrowserName() {
		String getBrowserName = prop.getProperty("browsername");
		return getBrowserName;
	}

}
