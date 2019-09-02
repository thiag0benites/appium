package br.ce.wcaquino.appium.core;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Actions {
	
	private AndroidDriver<MobileElement> driver;
	
	public Actions() {
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
	
}
