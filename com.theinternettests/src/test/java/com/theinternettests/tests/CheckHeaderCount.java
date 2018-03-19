package com.theinternettests.tests;



import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckHeaderCount {

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



	@Test(priority=5)
	public static void checkHeaderCount() {


		driver.get(pro.getProperty("APP_URL"));
		//ArrayList of column names
		ArrayList<String> colnames=new ArrayList<String>(); 
		colnames.add("Lorem"); 
		colnames.add("Ipsum");  
		colnames.add("Dolor");  
		colnames.add("Sit");  
		colnames.add("Amet");
		colnames.add("Diceret");
		colnames.add("Action");


		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Application is launched successfully");

		}else {
			System.out.println("Application is not launched successful");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			ArrayList<WebElement> Headers = (ArrayList<WebElement>) driver.findElements(By.xpath(WebTable_Header));
			System.out.println();
			if (Headers.size() == colnames.size()) {
				System.out.println("Total number of columns are matching");
				for(int i=0;i<colnames.size();i++){
					if(Headers.get(i).getText().equals(colnames.get(i))){
						System.out.println("Column value is matching : "+"Expected: "+colnames.get(i)+", Actual: "+Headers.get(i).getText());
					}else{
						System.err.println("Column value is not matching : "+"Expected: "+colnames.get(i)+", Actual: "+Headers.get(i).getText());
					}
				}
			}


			//System.out.println(Color.fromString(element1.getCssValue("color")).asHex());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}



	@AfterTest
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();

	


	}

}

