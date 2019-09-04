package br.ce.wcaquino.appium.core;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	private AndroidDriver<MobileElement> driver;
	
	public BasePage() {
		driver = DriverFactory.getDriver();
	}

	public void clickListItem(By byList, String value) {
		
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
	
	public void writeField(By byField, String value) {
		
		try {
			
			driver.findElement(byField).sendKeys(value);
			
			if(!driver.findElement(byField).getText().equals(value)) {
				Assert.fail("Não foi possível preencher o campo com o valor: " + value);
			}		
			
		} catch (Exception e) {
			Assert.fail("Não foi possível preencher o campo com o valor: " + value);
		}
		
	}
	
	public void selectItemCombobox(By byComboBox, String value) {
		
		Boolean itemFound = false;
		
		try {
			driver.findElement(byComboBox).click();
			List<MobileElement> items = driver.findElements(By.className("android.widget.CheckedTextView"));
			
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
	
	public void clickElement(By byElement) {
		
		try {
			
			driver.findElement(byElement).click();
			
		} catch (Exception e) {
			Assert.fail("Não foi possível efetuar click no elemento\nException: " + e.getMessage());
		}
		
	}
	
	public void wait(int seconds) {
		
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			Assert.fail("Error wait \nException: " + e.getMessage());
		}
		
	}
	
	public void elementExistXPath(String xPath) {
		
		try {
			
			if(!driver.findElement(By.xpath(xPath)).isDisplayed()) {
				Assert.fail("O elemento " + xPath + " não existe");
			}
			
		} catch (Exception e) {
			Assert.fail("O elemento " + xPath + " não existe");
		}
		
	}
	
	public void elementExistText(String text) {
		
		List<MobileElement> elements = driver.findElements(By.xpath("//*[@text='" + text + "']"));
		
		if (elements.size() == 0) {
			Assert.fail("O elemento " + text + " não existe");
		}
		
	}
	
	public boolean checkboxSwitchIsChecked(By by) {
		
		try {
			
			return Boolean.parseBoolean(driver.findElement(by).getAttribute("checked"));
			
		} catch (Exception e) {
			Assert.fail("Erro ao checar statu do checkbox ou switch");
			return false;
		}
		
	}
	
	public boolean pageDisplayed(By by, int timeOutSeconds) {
		
		boolean displayed = false;
		int time = 1;
		
		try {
			
			while (time <= timeOutSeconds) {
				
				wait(1);
				
				if (driver.findElement(by).isDisplayed()) {
					displayed = true;
					break;
			    }
				
				time++;
			}

			return displayed;
			
		} catch (Exception e) {
			Assert.fail("Erro pageDisplayed\nException: " + e.getMessage());
			return false;
		}

	}
	
	public void loadedPage(By by, int attempts) {
		
		boolean loaded = false;
		int attempt = 1;
		
		while(attempt <= attempts) {
			
			if (!pageDisplayed(by, 3)) {
				DriverFactory.killDriver();
				wait(3);	
			} else {
				loaded = true;
				break;
			}
			
			attempt++;
		}
		
		if(loaded == false) {
			Assert.fail("A tela não foi carregada corretamente");
		}
		
	}
	
}
