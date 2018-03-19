package com.theinternettests.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyApplicationLaunch {
	
	public static WebDriver driver;	
	public static FileInputStream fileobj;
	public static Properties pro;
	public static String ChallengingDomHeader;
	public static String Link_ForkmeonGitHub;
	public static String button_theinternetpage;
	public static String alertbutton_theinternetpage;
	public static String successbutton_theinternetpage;
	public static String APP_URL;
	
	
	@BeforeTest
	public void setUpMethod() throws Exception {
		pro = new Properties();
		fileobj = new FileInputStream("./ApplicationDetails.Properties");
		pro.load(fileobj);
		APP_URL = pro.getProperty("APP_URL");
		ChallengingDomHeader = pro.getProperty("ChallengingDOM.headertxt_challengingdom.xpath");
		Link_ForkmeonGitHub = pro.getProperty("ChallengingDOM.Link_ForkmeonGithub.xpath");
		button_theinternetpage = pro.getProperty("ChallengingDOM.button");
		alertbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_alert.css");
		successbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_success.css");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//System.out.println("APP_URL");
		


	}

	@Test(priority=1)
	//Check Application Launch Successful
	public static void appLaunch()
	{

	

		driver.get(pro.getProperty("APP_URL"));

		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}
		//driver.close();
	}

	

	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

		driver.close();


	}

}
