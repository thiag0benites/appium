package br.ce.wcaquino.appium.test;

import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void waitSplashDisappear() {
		menu.accessSplash();
		splash.isSplachScreenVisible();
		splash.elementExistText("About...");
	}

	
}
