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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil

//continue with already opened browser port 9222
//System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath());
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\x1047437\\Desktop\\Katalon_Studio_Windows_64-7.5.0\\configuration\\resources\\drivers\\chromedriver.exe");
//ChromeOptions options = new ChromeOptions();
//options.setExperimentalOption("debuggerAddress", "localhost:9222")
//WebDriver driver = new ChromeDriver(options);
//DriverFactory.changeWebDriver(driver)

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Folders SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
		, ('SubMenu') : 'Folders'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Create_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Folder Title  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 3))

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'BusinessUnit', 3), false)

'Wait for FolderDescription element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderDescription_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderDescription'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderDescription_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderDescription', 3))

'Switch to default window'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Close Browser'
WebUI.closeWindowIndex(0)













