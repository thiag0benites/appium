package br.ce.wcaquino.appium.core;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static String platformName = "Android";
	private static String deviceName = "emulator-5554";
	private static String pathApk = "C:\\Users\\Auditeste0242\\Desktop\\cursos\\appium\\projetos\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk";

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}

		return driver;
	}

	private static void createDriver() {

		try {

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			// desiredCapabilities.setCapability("automationName", "uiautomator2");

			// Instala app. Caso esteja instalada apenas reseta
			desiredCapabilities.setCapability(MobileCapabilityType.APP, pathApk);

			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			Assert.fail("Não foi possível iniciar/instalar o APK\nException: " + e.getMessage());
		}

	}

	public static void killDriver() {

		try {
			if(driver != null) { driver.quit(); driver = null; }  
		} catch (Exception e) {
			Assert.fail("Não foi possível fechar o APK\nException: " + e.getMessage());
		}

	}
}
