package br.ce.wcaquino.appium;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Desafios {
	
	private static String platformName = "Android";
	private static String deviceName = "emulator-5554";
	private static String pathApk = "C:\\Users\\Auditeste0242\\Desktop\\cursos\\appium\\projetos\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk";
	
	protected AndroidDriver<MobileElement> driver;
	
	@Before
	public void setUp() {
		openApk();
	}
	
	@After
	public void turnOff() {
		closeApk();
	}
	
	@Test
	public void desafioAula17() {
		
		String initialMenu = "Formulário";
		String name = "Thiago Benites";
		String console = "PS4";
		
		clickListItem(By.className("android.widget.TextView"), initialMenu);
		writeField(MobileBy.AccessibilityId("nome"), name);
		selectItemCombobox(MobileBy.AccessibilityId("console"), By.className("android.widget.CheckedTextView"), console);
		clickElement(MobileBy.AccessibilityId("check"));
		clickElement(MobileBy.AccessibilityId("switch"));
		
		//Click no botão salvar
		clickListItem(By.className("android.widget.TextView"), "SALVAR");
		wait(2);
		// Exemplo de xpath: "//android.widget.TextView[starts-with(@text, 'Console: ')]"
		elementExistXPath("//android.widget.TextView[@text='Nome: " + name + "']");
		elementExistXPath("//android.widget.TextView[@text='Console: " + console.toLowerCase() + "']");
		elementExistXPath("//android.widget.TextView[@text='Switch: Off']");
		elementExistXPath("//android.widget.TextView[@text='Checkbox: Marcado']");
		
	}
	
	private void openApk() {
		
		try {
			
		    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", platformName);
		    desiredCapabilities.setCapability("deviceName", deviceName);
		    //desiredCapabilities.setCapability("automationName", "uiautomator2");
		    
		    // Instala app. Caso esteja instalada apenas reseta
		    desiredCapabilities.setCapability(MobileCapabilityType.APP, pathApk);
		    
		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		} catch(Exception e) {
			Assert.fail("Não foi possível iniciar/instalar o APK\nException: " + e.getMessage());
		}

	}
	
	private void closeApk() {
	
		try {
			
			driver.quit();
			
		} catch(Exception e) {
			Assert.fail("Não foi possível fechar o APK\nException: " + e.getMessage());
		}

	}
	
	private void clickListItem(By byList, String value) {
		
		try {
			
		    List<MobileElement> items = driver.findElements(byList);
		    
		    for(MobileElement item : items) {
		    	if(item.getText().equals(value)) {
		    		item.click();
		    		break;
		    	}
		    }
			
		} catch(Exception e) {
			Assert.fail("Não foi efetuar click em: " + value);
		}

	}
	
	private void writeField(By byField, String value) {
		
		try {
			
			driver.findElement(byField).sendKeys(value);
			
			if(!driver.findElement(byField).getText().equals(value)) {
				Assert.fail("Não foi possível preencher o campo com o valor: " + value);
			}		
			
		} catch (Exception e) {
			Assert.fail("Não foi possível preencher o campo com o valor: " + value);
		}
		
	}
	
	private void selectItemCombobox(By byComboBox, By byList, String value) {
		
		Boolean itemFound = false;
		
		try {
			driver.findElement(byComboBox).click();
			List<MobileElement> items = driver.findElements(byList);
			
		    for (MobileElement item : items) {
				if (item.getText().equals(value)) {
					item.click();
					itemFound = true;
					break;
				}
			}
		    
		    if (itemFound == false) {
		    	Assert.fail("Não foi possível localizar o item: " + value);
			}
			
		} catch(Exception e) {
			Assert.fail("Não foi possível efetuar click no item: " + value + "\nException: " + e.getMessage());
		}

	}
	
	private void clickElement(By byElement) {
		
		try {
			
			driver.findElement(byElement).click();
			
		} catch (Exception e) {
			Assert.fail("Não foi possível efetuar click no elemento\nException: " + e.getMessage());
		}
		
	}
	
	private void wait(int seconds) {
		
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			Assert.fail("Error wait \nException: " + e.getMessage());
		}
		
	}
	
	private void elementExistXPath(String xPath) {
		
		try {
			
			if(!driver.findElement(By.xpath(xPath)).isDisplayed()) {
				Assert.fail("O elemento " + xPath + " não existe");
			}
			
		} catch (Exception e) {
			Assert.fail("O elemento " + xPath + " não existe");
		}
		
	}

}
