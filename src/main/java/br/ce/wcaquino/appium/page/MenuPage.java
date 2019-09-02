package br.ce.wcaquino.appium.page;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage{
	
	public void accessForm(int attempts) {	
		
		boolean loadedForm = false;
		
		for(int attempt = 1; attempt<=attempts; attempt++) {
			
			loadedPage((MobileBy.xpath("//android.widget.TextView[@text='Formulário']")), 3);
			clickListItem(By.className("android.widget.TextView"), "Formulário");
			
			if(pageDisplayed(MobileBy.xpath("//android.widget.TextView[@text='CT Appium']"), 3)) {
				loadedForm = true;
				break;
			}
		}
		
		if (!loadedForm) {
			Assert.fail("Não foi possível carregar a tela Formulário");
		}

	}

}
