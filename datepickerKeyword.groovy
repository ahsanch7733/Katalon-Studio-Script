package newDatePicker

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

public class datepickerKeyword {

	@Keyword
	def yearfieldSelect(){
		WebUI.click(findTestObject('Object Repository/datePickerC/fieldselection'))
		WebUI.click(findTestObject('Object Repository/datePickerC/yearSelectField'))
	}
	@Keyword
	def yearselectionfromdropdown(TestObject object,String option){
		boolean flag= false;
		boolean set = false;
		WebElement todo= WebUiCommonHelper.findWebElement(object, 30)
		Select ddl=new Select(todo);
		WebUI.selectOptionByValue((object), option, false)
		WebUI.verifyOptionSelectedByValue((object), option, false, 60)
		set = WebUI.verifyOptionSelectedByValue((object), option, false, 60);
		println("heelo world"+set);
	}
	@Keyword
	def monthfieldSelect(){
		WebUI.click(findTestObject('Object Repository/datePickerC/monthSelectField'))
	}
	@Keyword
	def monthselectionfromdropdown(TestObject object,String option){
		boolean flag= false;
		boolean set = false;
		WebElement todo= WebUiCommonHelper.findWebElement(object, 30)
		Select ddl=new Select(todo);
		WebUI.selectOptionByValue((object), option, false)
		WebUI.verifyOptionSelectedByValue((object), option, false, 60)
		set = WebUI.verifyOptionSelectedByValue((object), option, false, 60);
		println("heelo world"+set);
	}
	@Keyword
	def itemselectionfromdropdown(TestObject object,String option){

		WebElement Table =  WebUiCommonHelper.findWebElement(object,30)

		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		println('No. of rows: ' + Rows.size())

		 for (int i = 0; i < Rows.size(); i++) {
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			println('No. of cols: ' + Cols.size())

			for (int j = 0; j < Cols.size(); j++) {
				println(Cols.get(j).getText())

				if (Cols.get(j).getText().equals(option)) {
					Cols.get(j).findElement(By.tagName('a')).click();
				
				}
			}
		}
	}
}