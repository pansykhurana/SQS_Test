package com.theinternettests.tests;



import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckAlertButtonColor {

	public static WebDriver driver;	
	public static FileInputStream fileobj;
	public static Properties pro;
	public static String ChallengingDomHeader;
	public static String Link_ForkmeonGitHub;
	public static String button_theinternetpage;
	public static String alertbutton_theinternetpage;
	public static String successbutton_theinternetpage;


	@BeforeTest
	
	public void setUpMethod() throws Exception {
		pro = new Properties();
		fileobj = new FileInputStream("./ApplicationDetails.Properties");
		pro.load(fileobj);
		ChallengingDomHeader = pro.getProperty("ChallengingDOM.headertxt_challengingdom.xpath");
		Link_ForkmeonGitHub = pro.getProperty("ChallengingDOM.Link_ForkmeonGithub.xpath");
		button_theinternetpage = pro.getProperty("ChallengingDOM.button");
		alertbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_alert.css");
		successbutton_theinternetpage = pro.getProperty("ChallengingDOM.button_success.css");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//System.out.println("APP_URL");
		


	}


	@Test(priority=9)
	public static void checkAlertButtonColor() {
		/*System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    System.out.println("APP_URL");
	    driver.get(pro.getProperty("APP_URL"));*/
		driver.get(pro.getProperty("APP_URL"));
		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			WebElement element2 = driver.findElement(By.cssSelector(alertbutton_theinternetpage));

			String color1 = element2.getCssValue("background-color");
			System.out.println(color1);
			String hex1 = Color.fromString(color1).asHex();
			System.out.println(hex1);

			// System.out.println(Color.fromString(element2.getCssValue("color")).asHex());
			//AssertJUnit.assertTrue("BackGround Color is not matching as expected",hex1.equals("#c60f13") );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@AfterTest
	
	public void tearDown() throws Exception {
		driver.close();
		


	}

}
