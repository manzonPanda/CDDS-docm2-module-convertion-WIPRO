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
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//continue with already opened browser port 9222
System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())

System.setProperty('webdriver.chrome.driver', 'C:\\Users\\x1047437\\Desktop\\Katalon_Studio_Windows_64-7.5.0\\configuration\\resources\\drivers\\chromedriver.exe')

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('debuggerAddress', 'localhost:9222')

WebDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

//WebDriver driver = DriverFactory.getWebDriver()
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)
//'Delay for few sec'
//WebUI.delay(GlobalVariable.Wait_Time)
//
//'Navigate to MyDesk tab'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)
//
//'Click DOCM MainMenu and Folders SubMenu'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
//        , ('SubMenu') : 'Documents and Unmanaged Data'], FailureHandling.STOP_ON_FAILURE)
//
//'Wait for Loading Icon to finish'
//WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)
//
//'Wait for Actions button element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)
//
//'Navigate to Action frame'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)
//
//'Click on  Actions button '
//WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)
//
//'Wait for Create Document element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Obj'), GlobalVariable.Element_Timeout)
//
//'Click on  Create Document'
//WebUI.click(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Obj'), FailureHandling.STOP_ON_FAILURE)
//
////new window opened
//'Navigate to pageContent frame'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

//'Wait for Document Title element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/DocumentTitle_Obj'), GlobalVariable.Element_Timeout)
//
//'Set a DocumentTitle'
//WebUI.setText(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/DocumentTitle_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Create_Document').getValue(
//        'FolderTitle', 1), false)
//
//'Wait for BusinessUnit element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)
//
//'Wait for Few Seconds'
//WebUI.delay(GlobalVariable.Short_Wait)
//
//'Select a BusinessUnit'
//WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/BusinessUnit_Obj'), findTestData(
//        'CDDS/DOCM1_Module_TestData/Create_Document').getValue('BusinessUnit', 1), false)

//'Wait for image telescope to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '1']),
//	GlobalVariable.Element_Timeout)
//
//'Click image telescope'
//WebUI.click(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)
//
//'Delay for few sec'
//WebUI.delay(GlobalVariable.Wait_Time)

//new window opened
//'Navigate to listFilter frame'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

//'Wait for Folder Title  element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/FolderTitle_Obj'), GlobalVariable.Element_Timeout)
//
//'Set a FolderTitle'
//WebUI.setText(findTestObject('CDDS/DOCM1_Module_Objects/FolderTitle_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue(
//		'FolderTitle', 1))
//
//'Wait for Find btn Element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)
//
//'Click on  Find btn'
//WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)
//
//'Delay for few sec'
//WebUI.delay(GlobalVariable.Short_Wait)
//
//'Wait for Loading Icon to finish'
//WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

//'Navigate to listDisplay frame'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

//'Wait for radio button element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Select_Radio_Obj'), GlobalVariable.Element_Timeout)
//
//'Select the radio button'
//WebUI.click(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Select_Radio_Obj'))

//'Switch to content frame'
//WebUI.switchToDefaultContent()
//WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)
//
//
//'Wait for Submit btn Element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)
//
//'Click on  Submit btn '
//WebUI.click(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to pageContent frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

//'Wait for Document Type element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/DocumentType_Obj'), GlobalVariable.Element_Timeout)
//
//'Set a Document Type'
//WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/DocumentType_Obj'), findTestData(
//        'CDDS/DOCM1_Module_TestData/Create_Document').getValue('DocumentType', 1), false)
//
//'Wait for Document Subtype element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/DocumentSubtype_Obj'), GlobalVariable.Element_Timeout)
//
//'Select a Document Subtype '
//WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/DocumentSubtype_Obj'), findTestData(
//		'CDDS/DOCM1_Module_TestData/Create_Document').getValue('DocumentSubtype', 1), false)
//
//'Wait for Maturity Level element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/MaturityLevel_Obj'), GlobalVariable.Element_Timeout)
//
//'Select a Maturity Level'
//WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/MaturityLevel_Obj'), findTestData(
//		'CDDS/DOCM1_Module_TestData/Create_Document').getValue('MaturityLevel', 1), false)

//'Wait for template based element to be visible'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/TemplateBased_Obj'), GlobalVariable.Element_Timeout)
//
//'Verify template based check box is not checked'
//WebUI.verifyElementNotChecked(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/TemplateBased_Obj'), 30)

//'Upload a document file'
//WebUI.uploadFile(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/UploadDocumentFile_Obj'),"C:\\Test_Automation\\Test1.txt")

//'Wait for Few Seconds'
//WebUI.delay(GlobalVariable.Short_Wait)

//'Wait for image telescope to be visible : index 3'
//WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '3']),
//	GlobalVariable.Element_Timeout)
//
'Click image telescope : index 3'
WebUI.click(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '3']), FailureHandling.STOP_ON_FAILURE)

//new window opened
'Switch to Select Approvers window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 18))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to ListFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Select_Approver_Objects/Type_Obj'), GlobalVariable.Element_Timeout)

'Select a Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Select_Approver_Objects/Type_Obj'), findTestData(
		'CDDS/DOCM1_Module_TestData/Select_Approvers').getValue('Type', 1), false)

'Wait for User ID element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Select_Approver_Objects/UserID_Obj'), GlobalVariable.Element_Timeout)

'Set a User ID'
WebUI.setText(findTestObject('CDDS/DOCM1_Module_Objects/Create_Document_Objects/Select_Approver_Objects/UserID_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Select_Approvers').getValue(
        'UserID', 1), false)



