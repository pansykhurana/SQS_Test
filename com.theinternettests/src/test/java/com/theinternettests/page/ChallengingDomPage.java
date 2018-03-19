package com.theinternettests.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengingDomPage {

	private static WebElement element = null;
	public static String ChallengingDomHeader;
	public static String Link_ForkmeonGitHub;
	
	
	//public void readProperties() throws IOException{
		public static void main(String[] args) throws FileNotFoundException,IOException {
		Properties pro = new Properties();
		FileInputStream fileobj = new FileInputStream("./ObjectRepo.Properties");
		pro.load(fileobj);
		ChallengingDomHeader = pro.getProperty("ChallengingDOM.headertxt_challengingdom.xpath");
		Link_ForkmeonGitHub = pro.getProperty("ChallengingDOM.Link_ForkmeonGithub.xpath");
		System.out.println(ChallengingDomHeader);
	}
	
	
	//Challenging DOM Header
	public static WebElement text_ChallengingDOM(WebDriver driver)
	{
		element = driver.findElement(By.xpath(ChallengingDomPage.ChallengingDomHeader));
		return element;
	}
	
	
	//Link_Forkme on GitHub
	public static WebElement link_ForkmeOnGitHub(WebDriver driver)
	{
		element = driver.findElement(By.xpath(ChallengingDomPage.Link_ForkmeonGitHub));
		return element;
	}
	
	
}
