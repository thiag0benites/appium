package br.ce.wcaquino.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName(); //Pega nome do teste atual

	@AfterClass
	public static void finishClass() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		printScreen();
		DriverFactory.getDriver().resetApp();
	}
	
	public void printScreen() {
		
		try {
			File img = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("target/screenshots/" + testName.getMethodName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
