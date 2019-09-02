package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class MenuPage {
	
	private BasePage actions = new BasePage();
	
	public void accessForm() {	
		actions.clickListItem(By.className("android.widget.TextView"), "Formulário");	
	}

}
