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
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

def Data = TestDataFactory.findTestData('LoginValidations')

for (int i = 1; i <= Data.getRowNumbers(); i++) {
    def url = Data.getValue('URL', i)

    def username = Data.getValue('Username', i)

    def password = Data.getValue('Password', i)
	
	WebUI.openBrowser('')
	
	WebUI.maximizeWindow()
	
    WebUI.navigateToUrl(url)

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/UserName'), username)

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/Password'), password)

	WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Password - view icon'))
	
    WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Login Button'))
	
	try {
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_2GrowHr - Dashboard/Dashboard'),5))
	 {
        println('Login Successfull : ' + username +' / '+password)
		WebUI.click(findTestObject('Object Repository/Page_2GrowHr - Dashboard/Logout button'))
	 }
    } catch (Exception e){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_2GrowHR - Login/Invalid Credential'), 10)
        println('Invalid Credentials  : ' + username +' / '+password)	
    }
	WebUI.closeBrowser()
}
