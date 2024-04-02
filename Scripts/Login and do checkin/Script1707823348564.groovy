import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.*
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

def Data = TestDataFactory.findTestData('Login and Checkin')
def dateFormat = new SimpleDateFormat('MM/dd/yyyy')
def currentDate = Calendar.getInstance().getTime()
def currentDateStr = dateFormat.format(currentDate)

for (int i = 1; i <= Data.getRowNumbers(); i++) 
	{
    def url = Data.getValue('URL', i)

    def username = Data.getValue('Username', i)

    def password = Data.getValue('Password', i)

    def checkinRemark = Data.getValue('CheckinRemark', i)

    WebUI.openBrowser('')

    WebUI.maximizeWindow()

    WebUI.navigateToUrl(url)

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/UserName'), username)
	
    WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/Password'), password)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Password - view icon'))

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Login Button'))

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Dashboard/Checkin button BR'))

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHr - Dashboard/Checkin remark'), checkinRemark)

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Dashboard/Checkin button AR'))

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Menu_Report/Attentance mouseover'))

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Menu_Report/General Attendance Summary - Report'))

    WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Menu_Report/Date selection field'))

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHr - Menu_Report/Date selection field'), currentDateStr)

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Menu_Report/Get Report button Day count attendance summary report'))

	WebUI.scrollToElement(findTestObject('Object Repository/Page_2GrowHr - Day Wise Report/Scroll to Page down'), 10)
	
    delay(5)
	
	WebUI.closeBrowser()
}
