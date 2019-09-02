package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.FormPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class Testes extends BaseTest{

	private MenuPage menu = new MenuPage();
	private FormPage form = new FormPage();
	
	@Before
	public void setUp() {
		menu.accessForm(3);
	}
	
	@Test
	public void PreencherCampoNome() throws MalformedURLException {
		form.writeName("Thiago Benites");
	}
	
	@Test
	public void PreencherCombobox() throws MalformedURLException {
	    form.selectConsole("PS4");
	}
	
	@Test
	public void ClickSwitchCheckbox() throws MalformedURLException {
		    
	    Assert.assertFalse(form.checkboxIsChecked());
	    Assert.assertTrue(form.switchIsChecked());
	    
	    form.clickCheckbox();
	    form.clickSwitch();
	    
	    Assert.assertTrue(form.checkboxIsChecked());
	    Assert.assertFalse(form.switchIsChecked());
	}
	
	@Test
	public void Cadastro() {
		
		String name = "Thiago Benites";
		String console = "PS4";
		
		form.writeName(name);
		form.selectConsole(console);
		form.clickCheckbox();
		form.clickSwitch();
		form.save();
		form.validRegistration(name, console);
		
	}
	
	@Test
	public void CadastroDemorado() {
		
		String name = "Thiago Demorado";
		String console = "PS4";
		
		form.writeName(name);
		form.selectConsole(console);
		form.clickCheckbox();
		form.clickSwitch();
		form.saveLong();
		
		/*
		 * WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className
		 * )));
		 */
		
		form.validRegistration(name, console);
		
	}
	
}
