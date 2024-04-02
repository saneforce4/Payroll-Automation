import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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


def Data = TestDataFactory.findTestData('Apply Full day Leave')

def dateFormat = new SimpleDateFormat('MM/dd/yyyy')

def currentDate = Calendar.getInstance().getTime()

def currentDateStr = dateFormat.format(currentDate)

for (int i = 1; i <= Data.getRowNumbers(); i++) {
    
	def url = Data.getValue('URL', i)

    def username = Data.getValue('Username', i)

    def password = Data.getValue('Password', i)

    def LeaveRemarks = Data.getValue('LeaveRemark', i)

    WebUI.openBrowser('')

    WebUI.maximizeWindow()

    WebUI.navigateToUrl(url)

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/UserName'), username)

    WebUI.setText(findTestObject('Object Repository/Page_2GrowHR - Login/Password'), password)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Password - view icon'))

    delay(2)

    WebUI.click(findTestObject('Object Repository/Page_2GrowHR - Login/Login Button'))

    delay(2)

    WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/a_Reports_nav-link menu-link d-none d-md-block'))

    WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/a_Leave'))
	
	delay(2)
    
	WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/a_Leave Form'))

    WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/div_----Select----'))

    WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/span_Mounika m  (CBS0679)'))
	
	WebElement LeaveType = DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="layout-wrapper"]/div[15]/div/div/div/div[1]/div/div[3]/form/div[1]/div[1]/div[2]/div/div/button'))
	 
	LeaveType.click()
	
	WebElement SelectLeaveType = DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="bs-select-4-9"]'))
	 
	SelectLeaveType.click()
	
	WebUI.setText(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/textarea__Reason'), LeaveRemarks+ ''+currentDateStr)
	
	delay(2)
	
	WebUI.scrollToElement(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/select_Full DayHalf Day'), 10)
	
	delay(2)
	
	//WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/button_APPLY'))
	
	WebUI.click(findTestObject('Object Repository/Leave/Page_2GrowHr - Attendance/a_Leave History'))
	
	WebElement ReportRange = DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="reportrange"]'))
	 
	ReportRange.click() 
	
	WebElement TodayReport = DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="myDIV1"]/div[2]/div[1]/ul/li[1]'))
	 
	TodayReport.click()
	
	delay(4)
	
	WebElement Logout = DriverFactory.getWebDriver().findElement(By.xpath('//a[@class="nav-link" and @href="/Home/LogOut"]'))
	
    Logout.click()
	
	delay(2)
	
	WebUI.closeBrowser()
	
	}
