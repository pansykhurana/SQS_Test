package com.theinternettests.tests;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RetrieveWebTableCOntent {

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



	@Test(priority=2)
	public static void retrieveWebTableContent() {
		int rows_count,col_count;
		String cellText = null;
		//Navigate to the Web page
		driver.get(pro.getProperty("APP_URL"));
		driver.manage().window().maximize();
		//Identify the table
		WebElement Table = driver.findElement(By.xpath("//table"));
		//Read specific cell value
		//WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));

		//System.out.println("Data for Row 2 and Column 3 is "+cell.getText()+".");
		//Fetch # of rows in a table
		List<WebElement> rows = Table.findElements(By.tagName("tr"));

		rows_count = rows.size();
		//Iterate through the rows
		for(int i= 0; i<rows_count; i++){
			//Fetch # of columns in a row
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			col_count = columns.size();
			//Iterate through the columns within particular row
			for(int j=0; j<col_count; j++){
				cellText =  columns.get(j).getText();
				System.out.print(cellText+"  ");
			}
			System.out.println("");
		}
		
	}



	@AfterTest

	public void tearDown() throws Exception {
		driver.quit();

		


	}

}
