package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormPage extends BasePage{
	
	public void writeName(String name) {
		writeField(MobileBy.AccessibilityId("nome"), name);
	}
	
	public void selectConsole(String console) {
		selectItemCombobox(MobileBy.AccessibilityId("console"), console);
	}
	
	public boolean checkboxIsChecked() {
		return checkboxSwitchIsChecked(MobileBy.AccessibilityId("check"));
	}
	
	public boolean switchIsChecked() {
		return checkboxSwitchIsChecked(MobileBy.AccessibilityId("switch"));
	}
	
	public void clickCheckbox() {
		clickElement(MobileBy.AccessibilityId("check"));
	}
	
	public void clickSwitch() {
		clickElement(MobileBy.AccessibilityId("switch"));
	}
	
	public void save() {
		clickListItem(By.className("android.widget.TextView"), "SALVAR");
	}
	
	public void saveLong() {
		clickListItem(By.className("android.widget.TextView"), "SALVAR DEMORADO");
	}
	
	public void validRegistration(String name, String console) {
		// Exemplo de xpath: "//android.widget.TextView[starts-with(@text, 'Console: ')]"
		elementExistXPath("//android.widget.TextView[@text='Nome: " + name + "']");
		elementExistXPath("//android.widget.TextView[@text='Console: " + console.toLowerCase() + "']");
		elementExistXPath("//android.widget.TextView[@text='Switch: Off']");
		elementExistXPath("//android.widget.TextView[@text='Checkbox: Marcado']");
	}
}
