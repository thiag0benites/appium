package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void PrencheCampoNome() throws MalformedURLException {
		
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    //desiredCapabilities.setCapability("automationName", "uiautomator2");
	    //desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    // Instala app. Caso esteja instalada apenas reseta
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Auditeste0242\\Desktop\\cursos\\appium\\projetos\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));
	    
	    for(MobileElement element : elements) {
	    	//System.out.println(element.getText());
	    	if(element.getText().equals("Formulário")) {
	    		element.click();
	    		break;
	    	}
	    }
	    
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Thiago Benites");
	    
	    String text = campoNome.getText();
	    Assert.assertEquals("Thiago Benites", text);
	    //driver.quit();
	    
	}
}
