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
//System.setProperty('webdriver.chrome.driver', 'C:\\Users\\x1047437\\Desktop\\Katalon_Studio_Windows_64-7.5.0\\configuration\\resources\\drivers\\chromedriver.exe')
//ChromeOptions options = new ChromeOptions()
//options.setExperimentalOption('debuggerAddress', 'localhost:9222')
//WebDriver driver = new ChromeDriver(options)
//DriverFactory.changeWebDriver(driver)


'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
		, ('SubMenu') : 'Business Units'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for business unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Set business unit'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/28_CDDSINC08861').getValue(
		'BusinessUnit', 1))

'Delay for few sec'
WebUI.delay(3)

'Click Find Button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Initialize driver'
WebDriver driver = DriverFactory.getWebDriver()

'Click on BU link'
WebElement link = driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/28_CDDSINC08861').getValue('BusinessUnit', 1)}')]"))
link.click()

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_frame_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/UMCBusinessUnitProperties_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Edit button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Edit_Obj'), 10)

'Click on Edit button '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Edit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'new window opened'
WebUI.switchToWindowIndex(1)
WebUI.delay(3)
WebUI.maximizeWindow()

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for ReqDevCycle radio button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/ReqDevCycleNo_Obj'), 10)

'Click on ReqDevCycle radio button NO'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/ReqDevCycleNo_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on  Done btn'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few seconds'
WebUI.delay(5)

'Close Browser'
WebUI.closeWindowIndex(0)

///////////////////////////////line:1215/////////////////////////////

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
		, ('SubMenu') : 'Documents and Unmanaged Data'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Document element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Create_Document_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create Document'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Create_Document_Obj'), FailureHandling.STOP_ON_FAILURE)

//new window opened
'Navigate to pageContent frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Document Title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/DocumentTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a DocumentTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/DocumentTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue(
		'DocumentTitle', 1))

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/BusinessUnitSelect_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/BusinessUnitSelect_Obj'), findTestData(
		'CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('BusinessUnit', 1), false)

'Wait for image telescope to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '1']),
	GlobalVariable.Element_Timeout)

'Click image telescope'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'new window opened'
WebUI.switchToWindowTitle(findTestData('CDDS/DOCM2_Module_TestData/Create_Document/WindowTitle').getValue('WindowName', 4))
WebUI.maximizeWindow()

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Folder Title  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/FolderTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/FolderTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue(
		'FolderTitle', 1))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(10)

'Wait for radio button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Radio_Obj'), GlobalVariable.Element_Timeout)

'Select the radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Radio_Obj'))

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Submit btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to pageContent frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Document Type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/DocumentType_Obj'), GlobalVariable.Element_Timeout)

'Set a Document Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/DocumentType_Obj'), findTestData(
		'CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('DocumentType', 1), false)

'Wait for Document Subtype element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/DocumentSubtype_Obj'), GlobalVariable.Element_Timeout)

'Select a Document Subtype '
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/DocumentSubtype_Obj'), findTestData(
		'CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('DocumentSubtype', 1), false)

'Wait for Maturity Level element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/MaturityLevel_Obj'), GlobalVariable.Element_Timeout)

'Select a Maturity Level'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/MaturityLevel_Obj'), findTestData(
		'CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('MaturityLevel', 1), false)

'Wait for template based element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/TemplateBased_Obj'), GlobalVariable.Element_Timeout)

'Verify template based check box is not checked'
WebUI.verifyElementNotChecked(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/TemplateBased_Obj'), 30)

'Upload a document file'
WebUI.uploadFile(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/UploadDocumentFile_Obj'),"C:\\Test_Automation\\Test1.txt")

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for image telescope to be visible : index 2'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '2']),
	GlobalVariable.Element_Timeout)

'Click image telescope : index 2'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '2']), FailureHandling.STOP_ON_FAILURE)

//new window opened
'Switch to Select Reviewer window'
WebUI.switchToWindowTitle(findTestData('CDDS/DOCM2_Module_TestData/Create_Document/WindowTitle').getValue('WindowName', 5))
WebUI.maximizeWindow()

'Switch to ListFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/Type_Obj'),
	GlobalVariable.Element_Timeout)

'Select a Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/Type_Obj'),
	findTestData('CDDS/DOCM2_Module_TestData/Create_Document/Select_Reviewer').getValue('Type', 1), false)

'Wait for User ID element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/UserID_Obj'),
	GlobalVariable.Element_Timeout)

'Set a User ID'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/UserID_Obj'), findTestData(
		'CDDS/DOCM2_Module_TestData/Create_Document/Select_Reviewer').getValue('UserID', 1))

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Choose role radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/Role_Obj',[('value') : 'M']))

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Submit btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to pageContent frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for image telescope to be visible : index 3'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '3']),
	GlobalVariable.Element_Timeout)

'Click image telescope : index 3'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Icon_Action_Search', [('index') : '3']), FailureHandling.STOP_ON_FAILURE)

//new window opened
'Switch to Select Approver window'
WebUI.switchToWindowTitle(findTestData('CDDS/DOCM2_Module_TestData/Create_Document/WindowTitle').getValue('WindowName', 3))
WebUI.maximizeWindow()

'Switch to ListFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/Type_Obj'),
	GlobalVariable.Element_Timeout)

'Select a Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/Type_Obj'),
	findTestData('CDDS/DOCM2_Module_TestData/Create_Document/Select_Approver').getValue('Type', 1), false)

'Wait for User ID element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/UserID_Obj'),
	GlobalVariable.Element_Timeout)

'Set a User ID'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/UserID_Obj'), findTestData(
		'CDDS/DOCM2_Module_TestData/Create_Document/Select_Approver').getValue('UserID', 1))

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Choose role radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Select_Approver_Reviewer_Objects/Role_Obj',[('value') : 'M']))

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Submit btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to pageContent frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Description element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Description_Obj'), GlobalVariable.Element_Timeout)

'Set a Description'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Description_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue(
		'Description', 1))

'Set a Revision'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Revision_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue(
		'Revision', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to pageContent frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Ok btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Ok_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Ok btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Ok_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(60)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Close all Browsers'
WebUI.closeWindowIndex(0)
WebUI.closeWindowIndex(0)


///////////////////////////////line:1255/////////////////////////////

//Verify Doument Created or not
'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
		, ('SubMenu') : 'Documents and Unmanaged Data'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/28_CDDSINC08861').getValue(
		'BusinessUnit', 1), false)

'Wait for Keyword element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Keyword_Obj'), GlobalVariable.Element_Timeout)

'Set a Keyword'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Keyword_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue(
		'DocumentTitle', 1))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Initialize driver'
WebDriver driver2 = DriverFactory.getWebDriver()

'Verify Document Created or not'
List <WebElement> tableRows = driver2.findElements(By.xpath('//table[@id="TIDocumentSummary"]/tbody/tr'))
/* Column name
 * 0-checkbox
 * 1-Type
 * 2-Title
 * 3-Revision
 * 4-Folder Path
 * 5-Business Unit
 * 6-Document Type
 * 7-Document Subtype
 * 8-State
 * 9-Maturity Level
 * 10-Owner
 * 11-Description
 * 12-Creation Date
 */
boolean errorFound = false
for (int i=1; i<=tableRows.size()-1; i++){
	List <WebElement> tableRowsTemp = driver2.findElements(By.xpath("//table[@id='TIDocumentSummary']/tbody/tr[${i+1}]/td"))
	WebElement title = tableRowsTemp[2]
	WebElement businessUnit = tableRowsTemp[5]

	if( title.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('DocumentTitle', 1))
		&& businessUnit.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/28_CDDSINC08861').getValue('BusinessUnit', 1))
	){
		KeywordUtil.markPassed("VERIFIED: Document ${title.getAttribute("innerText")} created.")
		errorFound = false
		break;
	}else{
		errorFound=true
	}
}
(errorFound) ?  KeywordUtil.markFailedAndStop("FAILED: Document not created."):""

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on created document'
WebElement documentLink = driver2.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('DocumentTitle', 1)}')]"))
documentLink.click()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Lifecycle tab to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/LifeCycleTab_Obj'), GlobalVariable.Element_Timeout)

'Click on Lifecycle tab '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/LifeCycleTab_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/TIDocumentLifecycle_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Change State to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/ChangeState_Obj'), GlobalVariable.Element_Timeout)

'Click on Change State'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/ChangeState_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Accept alert when the alert is shown'
WebUI.waitForAlert(GlobalVariable.Wait_Time)
WebUI.acceptAlert()

'Delay for few sec'
WebUI.delay(10)

'Close Browsers'
WebUI.closeWindowIndex(0)

////////LOGIN Reviewer to approve document////////////

'Login Reviewer'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id'):findTestData('CDDS/DOCM2_Module_TestData/Create_Document/Select_Reviewer').getValue('UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click My Inbox MainMenu and Tasks'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIMyInboxItems'
		, ('SubMenu') : 'Tasks'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Initialize driver'
WebDriver driver3 = DriverFactory.getWebDriver()

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Task Link'
driver3.findElement(By.xpath('//*[contains(text(),"ITK00000")]')).click()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to opened window'
WebUI.switchToWindowIndex(1)

'Maximise the window'
WebUI.maximizeWindow()

'Navigate to pageContent frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 0)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Comment text area element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Tasks_Objects/Comments_Obj'), GlobalVariable.Element_Timeout)

'Enter Reviewed comments'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Tasks_Objects/Comments_Obj'), "Reviewed-Comments")

'Navigate to detailsDisplay frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 0)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Approve element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Tasks_Objects/Approve_Obj'), 10)
	
'Click on  Approve button '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Tasks_Objects/Approve_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(60)

'Close Browsers'
WebUI.closeWindowIndex(0)
WebUI.closeWindowIndex(0)


////////////////////Login default user////////////////////////

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click My Inbox MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIMyInboxItems'
		, ('SubMenu') : 'Documents and Unmanaged Data'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Keyword element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Keyword_Obj'), GlobalVariable.Element_Timeout)

'Set a Keyword'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Keyword_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue(
		'DocumentTitle', 1))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Document:link'
WebElement link3 = driver3.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/Create_Document').getValue('DocumentTitle', 1)}')]"))
link3.click()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to portDisplay frame'
//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_PortalDisplay'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)

'Wait for Lifecycle tab Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/LifeCycleTab_Obj'), GlobalVariable.Element_Timeout)

'Click on Lifecycle'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/LifeCycleTab_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to pageContent frame'
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/TIDocumentLifecycle_IFrame_Obj'), 0)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_IFrame_Obj'), 0)


'Verify Document in Reviewed state or not'
WebElement stateStatus = driver3.findElement(By.xpath('//*[@class="stateNameHighlight"]'))

if(stateStatus.getAttribute("innerText").contains("Reviewed")){
	KeywordUtil.markPassed("VERIFIED: Document is changed to Reviewed state.")
}else{
	KeywordUtil.markFailedAndStop("FAILED: Document doesn't changed in Reviewed state.")
}

'Delay for few sec'
WebUI.delay(3)

'Close Browser'
WebUI.closeWindowIndex(0)

/////////////////////////////line:1273/////////////////////////////

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
		, ('SubMenu') : 'Business Units'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for business unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Set business unit'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/28_CDDSINC08861').getValue(
		'BusinessUnit', 1))

'Delay for few sec'
WebUI.delay(3)

'Click Find Button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Initialize driver'
WebDriver driver4 = DriverFactory.getWebDriver()

'Click on BU link'
WebElement link4 = driver4.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/28_CDDSINC08861/28_CDDSINC08861').getValue('BusinessUnit', 1)}')]"))
link4.click()

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_frame_Obj'), GlobalVariable.Element_Timeout)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/UMCBusinessUnitProperties_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Edit button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Edit_Obj'), 10)

'Click on Edit button '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/Edit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'new window opened'
WebUI.switchToWindowIndex(1)
WebUI.delay(3)
WebUI.maximizeWindow()

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for ReqDevCycle radio button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/ReqDevCycleNo_Obj'), 10)

'Click on ReqDevCycle radio button YES'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/28_CDDSINC08861_Objects/ReqDevCycleYes_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on  Done btn'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_Document_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few seconds'
WebUI.delay(5)

'Close Browser'
WebUI.closeWindowIndex(0)













