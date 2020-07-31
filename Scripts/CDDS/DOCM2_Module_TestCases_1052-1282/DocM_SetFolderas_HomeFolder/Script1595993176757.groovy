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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//continue with already opened browser port 9222
//System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
//
//System.setProperty('webdriver.chrome.driver', 'C:\\Users\\x1047437\\Desktop\\Katalon_Studio_Windows_64-7.5.0\\configuration\\resources\\drivers\\chromedriver.exe')
//
//ChromeOptions options = new ChromeOptions()
//
//options.setExperimentalOption('debuggerAddress', 'localhost:9222')
//
//WebDriver driver = new ChromeDriver(options)
//
//DriverFactory.changeWebDriver(driver)


'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
		, ('SubMenu') : 'Folders'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Verifiy for Root folder checkbox to be visible'
WebUI.verifyElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/RootFolder_Obj'), FailureHandling.STOP_ON_FAILURE)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/FolderTitle_Obj'),"Test_Auto_Folder4")

'Click Root folder checkbox'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/RootFolder_Obj'), FailureHandling.STOP_ON_FAILURE)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/BusinessUnit_Obj'),"WTBU-SW", false)

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

//Validation Part :: Verify_NotExist
'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Initialize driver'
WebDriver driver = DriverFactory.getWebDriver()

List <WebElement> tableRows = driver.findElements(By.xpath('//table[@id="TIFolderContentList"]/tbody/tr'))
/* Column name
 * 0-checkbox
 * 1-Business Unit
 * 2-Title
 * 3-Folder Path
 * 4-Description
 * 5-Owner
 * 6-Creation Date
 */
boolean errorFound = false
for (int i=1; i<=tableRows.size()-1; i++){
	WebElement title = tableRows[i].findElements(By.tagName("td"))[2]
	if( !title.getAttribute("innerText").contains("Test_Auto_SubFolder1_4") ){
		KeywordUtil.markPassed("VERIFIED: SubFolder ${title.getAttribute("innerText")} does not exist.")
		errorFound = false
		break;
	}else{
		errorFound=true
	}
}
(errorFound) ?  KeywordUtil.markFailedAndStop("FAILED: SubFolder exist."):""

'Click Folder checkbox'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/Select_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Set as Home Folder element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/SetAsHomeFolder_Obj'), GlobalVariable.Element_Timeout)

'Click the Set as Home Folder button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/SetFolderas_HomeFolder_Objects/SetAsHomeFolder_Obj'), FailureHandling.STOP_ON_FAILURE)

'Accept alert when the alert is shown'
WebUI.waitForAlert(GlobalVariable.Wait_Time)
WebUI.acceptAlert()

'Accept alert when the alert is shown'
WebUI.waitForAlert(GlobalVariable.Wait_Time)
WebUI.acceptAlert()

'Close Browser'
WebUI.closeWindowIndex(0)

