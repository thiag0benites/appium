package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.Actions;

public class MenuPage {
	
	private Actions actions = new Actions();
	
	public void accessForm() {	
		actions.clickListItem(By.className("android.widget.TextView"), "Formulário");	
	}

}
