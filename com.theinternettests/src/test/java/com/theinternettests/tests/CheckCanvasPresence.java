package com.theinternettests.tests;




import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckCanvasPresence {

	public static WebDriver driver;	
	public static FileInputStream fileobj;
	public static Properties pro;
	public static String ChallengingDomHeader;
	public static String Link_ForkmeonGitHub;
	public static String button_theinternetpage;
	public static String alertbutton_theinternetpage;
	public static String successbutton_theinternetpage;
	public static String WebTable_Header;

	
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

		


	}



	@Test(priority=7)
	public static void checkCanvasPresence() {
		
		driver.get(pro.getProperty("APP_URL"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//driver.get("https://the-internet.herokuapp.com/challenging_dom");
		driver.manage().window().maximize();
		//Identify the table

		WebElement element = driver.findElement(By.xpath("//canvas"));
		if (element.isDisplayed()) {
			System.out.println("Answer: field is present");
		}
		driver.close();

	}


	@AfterTest
	
	public void tearDown() throws Exception {
		driver.quit();

		



	}

}

