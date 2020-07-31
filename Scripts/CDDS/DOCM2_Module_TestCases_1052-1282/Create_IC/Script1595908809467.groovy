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
		, ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Create_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

'new window opened'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
WebUI.maximizeWindow()

'Navigate to pageContent frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), 30)

'Wait for Business Unit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Select a Business Unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'BusinessUnit', 1), false)
	
'Set a IC Name'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/IC_Name_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'IC_Name', 1))

'Select the Check box None'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/NoneVariant_Obj'))

'Select IC Engagement Model'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/EngagementModel_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'EngagementModel', 1), false)

'Select IC Workflow Template'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/WorkflowTemplate_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'WorkflowTemplate', 1), false)

'Select Library'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Library_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'Library', 1), false)

'Select Technology'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Technology_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'Technology', 1), false)

'Select IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/IP_Classification_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'IP_Classification', 1), false)

'Set a Second owner'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/SecondOwner_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'SecondaryOwner', 1))

'Select User ID'
try{
	String userXpath = ('//li[@style="display: list-item;"]')
	TestObject userObj = new TestObject('UserID')
	userObj.addProperty('xpath', ConditionType.EQUALS, userXpath)
	WebUI.waitForElementVisible(userObj, GlobalVariable.Short_Wait)
	WebUI.check(userObj)

}catch(Exception e){
	KeywordUtil.markFailedAndStop("FAILED: Failed to Select User. No Matching Data Found")
}

'Select CM System'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/CMSystem_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'CM_System', 1), false)

'Set a CM Path'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/CMPath_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'CM_Path', 1))

'Set a CM Path type'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/CMPath_Type_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'CM_Path_Type', 1), false)

'Select IC Category'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/IC_Category_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'IC_Category', 1), false)

'Verify_Exist'
WebUI.verifyElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/GrantComponentLAAHA_Obj'), FailureHandling.STOP_ON_FAILURE)

'Verify_Exist'
WebUI.verifyElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/DisableRequest_NRPND_Obj'), FailureHandling.STOP_ON_FAILURE)

'Set a Description'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Description_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'Description', 1))

'Enable/Disable Release Packages radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/ReleasePackage_RadioButton_Obj'))

'Switch to content frame'
WebUI.switchToDefaultContent()

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(30)

'Navigate to pageContent frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), 30)

'Wait for Project Abbreviation to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Project_Abbreviation_Obj'), 10)

'Set a Project Abbreviation'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Project_Abbreviation_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'ProjectAbbreviation', 1))

'Select Associated Schema'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/AssociatedSchema_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'AssociatedSchema', 1), false)

'Switch to content frame'
WebUI.switchToDefaultContent()

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(120)

'Switch to default Window'
WebUI.switchToWindowIndex(0)

'Delay for few sec'
WebUI.delay(5)

'Refresh the current web page'
WebUI.refresh()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Documents and Unmanaged Data SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
		, ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 0)

'Wait for IC Name component to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/IC_Name_Component_Obj'), GlobalVariable.Element_Timeout)

'Set a IC Name'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/Create_IC_Objects/IC_Name_Component_Obj'), findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue(
		'IC_Name', 1))

'Click Find Button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Initialize driver'
WebDriver driver = DriverFactory.getWebDriver()

'Verify the table values'
List <WebElement> tableRows = driver.findElements(By.xpath('//table[@id="DRCICSearchResults"]/tbody/tr'))
/* Column name
 * 0-Checkbox
 * 1-BusinessUnit
 * 2-Ip Classification
 * 3-Library
 * 4-Technology
 * 5-IC Name
 * 6-IC Revision
 * 7-F Number
 * 8-PG
 * 9-Description
 * 10-IP Provider Summary
 * 11-Primary Owner
 * 12-State
 */
boolean errorFound = false
for (int i=1; i<=tableRows.size()-1; i++){
	List <WebElement> tableRowsTemp = driver.findElements(By.xpath("//table[@id='DRCICSearchResults']/tbody/tr[${i+1}]/td"))
	WebElement icname = tableRowsTemp[5]

	if( icname.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/Create_IC/Create_IC').getValue('IC_Name', 1))){
		KeywordUtil.markPassed("VERIFIED: IC ${icname.getAttribute("innerText")} has been created.")
		errorFound = false
		break;
	}else{
		errorFound=true
	}
}

(errorFound) ?  KeywordUtil.markFailedAndStop("FAILED: IC not created."):""

'Close Browser'
WebUI.closeWindowIndex(0)








