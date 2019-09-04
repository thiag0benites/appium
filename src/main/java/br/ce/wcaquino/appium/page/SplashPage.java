package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class SplashPage extends BasePage{
	
	private String textSplash = "Splash!";

	public void isSplachScreenVisible() {
		elementExistText(textSplash);
	}
	
	public void waitSplashDisappear() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("//*[@text='" + textSplash + "']")));
	}
}
