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
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testdata.TestDataFactory


def testData = TestDataFactory.findTestData('Multi tab')
def url = testData.getValue('URL',1)
def username = testData.getValue('Username',1) 
def password = testData.getValue('Password',1)

WebUI.openBrowser('')
WebUI.maximizeWindow()

for (i=0;i<=4;i++)
{
	WebUI.navigateToUrl(url)
	WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/UserName'),username)
	WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/Password'),password)
	WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Login Button'))
	// Execute JavaScript to open a new tab
	JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
	js.executeScript("window.open();")
	// Switch to the new tab
	WebUI.switchToWindowTitle('')
	// Navigate to the second website in the new tab
}
WebUI.closeWindowTitle('')
