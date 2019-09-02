package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.Actions;
import io.appium.java_client.MobileBy;

public class FormPage {

	private Actions actions = new Actions();
	
	public void writeName(String name) {
		actions.writeField(MobileBy.AccessibilityId("nome"), name);
	}
	
	public void selectConsole(String console) {
		actions.selectItemCombobox(MobileBy.AccessibilityId("console"), console);
	}
	
	public boolean checkboxIsChecked() {
		return actions.checkboxSwitchIsChecked(MobileBy.AccessibilityId("check"));
	}
	
	public boolean switchIsChecked() {
		return actions.checkboxSwitchIsChecked(MobileBy.AccessibilityId("switch"));
	}
	
	public void clickCheckbox() {
		actions.clickElement(MobileBy.AccessibilityId("check"));
	}
	
	public void clickSwitch() {
		actions.clickElement(MobileBy.AccessibilityId("switch"));
	}
	
	public void save() {
		actions.clickListItem(By.className("android.widget.TextView"), "SALVAR");
		actions.wait(2);
	}
	
	public void validRegistration(String name, String console) {
		// Exemplo de xpath: "//android.widget.TextView[starts-with(@text, 'Console: ')]"
		actions.elementExistXPath("//android.widget.TextView[@text='Nome: " + name + "']");
		actions.elementExistXPath("//android.widget.TextView[@text='Console: " + console.toLowerCase() + "']");
		actions.elementExistXPath("//android.widget.TextView[@text='Switch: Off']");
		actions.elementExistXPath("//android.widget.TextView[@text='Checkbox: Marcado']");
	}
}
