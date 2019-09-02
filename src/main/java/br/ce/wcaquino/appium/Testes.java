package br.ce.wcaquino.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.Actions;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Testes {

	private AndroidDriver<MobileElement> driver;
	private Actions actions;
	
	@Before
	public void setUp() {
		driver = DriverFactory.getDriver();
		actions = new Actions();	
		actions.clickListItem(By.className("android.widget.TextView"), "Formulário");
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void PreencherCampoNome() throws MalformedURLException {
	    
		String name = "Thiago Benites";
		actions.writeField(MobileBy.AccessibilityId("nome"), name);

	}
	
	@Test
	public void PreencherCombobox() throws MalformedURLException {
	    
	    String console = "PS4";
	    actions.selectItemCombobox(MobileBy.AccessibilityId("console"), console);

	}
	
	@Test
	public void ClickSwitchCheckbox() throws MalformedURLException {
		
	    MobileElement check = driver.findElement(MobileBy.AccessibilityId("check"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
		actions.clickElement(MobileBy.AccessibilityId("check"));
		actions.clickElement(MobileBy.AccessibilityId("switch"));
	    
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	}
	
	@Test
	public void DesafioAula17() {
		
		String initialMenu = "Formulário";
		String name = "Thiago Benites";
		String console = "PS4";
		
		actions.clickListItem(By.className("android.widget.TextView"), initialMenu);
		actions.writeField(MobileBy.AccessibilityId("nome"), name);
		actions.selectItemCombobox(MobileBy.AccessibilityId("console"), console);
		actions.clickElement(MobileBy.AccessibilityId("check"));
		actions.clickElement(MobileBy.AccessibilityId("switch"));
		
		//Click no botão salvar
		actions.clickListItem(By.className("android.widget.TextView"), "SALVAR");
		actions.wait(2);
		// Exemplo de xpath: "//android.widget.TextView[starts-with(@text, 'Console: ')]"
		actions.elementExistXPath("//android.widget.TextView[@text='Nome: " + name + "']");
		actions.elementExistXPath("//android.widget.TextView[@text='Console: " + console.toLowerCase() + "']");
		actions.elementExistXPath("//android.widget.TextView[@text='Switch: Off']");
		actions.elementExistXPath("//android.widget.TextView[@text='Checkbox: Marcado']");
		
	}
	
}
