package newCheckBoxSelector

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.Keys


public class checkboxSelector {
	@Keyword
	def checkboxselectionfromdropdown(TestObject object,String option){

		WebElement checkbox= WebUiCommonHelper.findWebElement(object, 30)

		List<WebElement> Div = checkbox.findElements(By.tagName('div'))
		println('No. of div: ' + Div.size());

		for (int i=0; i < Div.size(); i++) {

			List<WebElement> Cols = Div.get(i).findElements(By.xpath('//*/div/span[2]'))
			println('No. of cols: ' + Cols.size())
			for(WebElement e : Cols) {
				if(e.getAttribute('innerHTML').equals(option)){
					println("match");

					e.click();
				}
				//					e.findElement(By.xpath('//*/div/span[1]')).click;
				//					e.findElement(By.xpath('//*/div/input')).click;
				//					e.findElement(By.xpath('//*/div/span[1]')).click;

			}

			//			for (int j = 0; j < Cols.size(); j++) {
			//				println(Cols.get(j).getText())
			//
			//				if (Cols.get(j).getText().equals(option)) {
			//					Cols.get(j).findElement(By.tagName('a')).click()
			//					table: break
			//				}
			//			}
		}
	}
}
