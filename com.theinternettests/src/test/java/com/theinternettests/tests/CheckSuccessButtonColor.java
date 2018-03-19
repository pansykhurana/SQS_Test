package com.theinternettests.tests;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckSuccessButtonColor {

	public static WebDriver driver;	
	public static FileInputStream fileobj;
	public static Properties pro;
	public static String ChallengingDomHeader;
	public static String Link_ForkmeonGitHub;
	public static String button_theinternetpage;
	public static String alertbutton_theinternetpage;
	public static String successbutton_theinternetpage;
	@BeforeTest
	@BeforeClass
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
		driver.get(pro.getProperty("APP_URL"));

	}

	@Test(priority=4)
	public static void checkSuccessButtonColor() {
		/*System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	     driver = new ChromeDriver();
	    System.out.println("APP_URL");
	    driver.get(pro.getProperty("APP_URL"));*/

		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			WebElement element1 = driver.findElement(By.cssSelector(successbutton_theinternetpage));

			String color2 = element1.getCssValue("background-color");
			System.out.println(color2);
			String hex2 = Color.fromString(color2).asHex();
			System.out.println(hex2);

			//System.out.println(Color.fromString(element1.getCssValue("color")).asHex());
			AssertJUnit.assertTrue("BackGround Color is not matching as expected",hex2.equals("#5da423") );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

	@AfterTest
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();

		driver.close();



	}

}
