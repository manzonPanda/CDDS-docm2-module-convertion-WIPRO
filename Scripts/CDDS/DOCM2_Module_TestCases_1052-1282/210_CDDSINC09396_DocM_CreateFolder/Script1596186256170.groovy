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
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Create_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Folder Title  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'FolderTitle', 1))

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'BusinessUnit', 1), false)

'Wait for FolderDescription element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderDescription_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderDescription'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderDescription_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'FolderDescription', 1))

'Select NO for internal folder'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/InternalFolderNo_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click image telescope : index 1'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)
	
'Switch to Company Search window'
WebUI.switchToWindowIndex(2)
WebUI.maximizeWindow()
WebUI.delay(3)

/////Search for the first company//////
'Switch to listFilter frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 0)

'Wait for Company Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/CompanyName_Obj'), GlobalVariable.Element_Timeout)

'Set a Company Name'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/CompanyName_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'CompanyOne', 1))

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(3)

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), 0)

'Wait for the searched company to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Select_Radio_Obj'), 10)

'Click on searched company radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Select_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to content frame'
WebUI.switchToDefaultContent()

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(5)

/////Search for the second company//////
'Switch to frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for image telescope to be visible: index 1'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)

'Click image telescope : index 1'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)

'Switch to Company Search window'
WebUI.switchToWindowIndex(2)
WebUI.maximizeWindow()
WebUI.delay(3)

'Switch to listFilter frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 0)

'Wait for Company Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/CompanyName_Obj'), GlobalVariable.Element_Timeout)

'Set a Company Name'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/CompanyName_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'CompanyTwo', 1))

'Click on  Find btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(3)

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), 0)

'Wait for the searched company to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Select_Radio_Obj'), 10)

'Click on searched company radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Select_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to content frame'
WebUI.switchToDefaultContent()

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(5)

'Switch to default window'
WebUI.switchToDefaultContent()

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch default window'
WebUI.switchToWindowIndex(0)

'Refresh the current web page'
WebUI.refresh()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Folders SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
		, ('SubMenu') : 'Folders'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Folder Title  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderTitleSearch_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'FolderTitle', 1))

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'BusinessUnit', 1), false)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

//Validation Part :: Verify Folder Created or not

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Initialize driver'
WebDriver driver = DriverFactory.getWebDriver()

List <WebElement> tableRows = driver.findElements(By.xpath('//table[@id="TIFolderContentList"]/tbody/tr'))
//List <WebElement> tableRows = tableElement.findElements(By.tagName("tr"))
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
	WebElement businessUnit = tableRows[i].findElements(By.tagName("td"))[1]
	WebElement title = tableRows[i].findElements(By.tagName("td"))[2]
	WebElement description = tableRows[i].findElements(By.tagName("td"))[4]
	if( businessUnit.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue('BusinessUnit', 1))
		&& title.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue('FolderTitle', 1))
		&& description.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue('FolderDescription', 1))
	){
		KeywordUtil.markPassed("VERIFIED: Folder ${title.getAttribute("innerText")} created.")
		errorFound = false
		break;
	}else{
		errorFound=true
	}
}

(errorFound) ?  KeywordUtil.markFailedAndStop("FAILED: Folder not created."):""

'Close Browser'
WebUI.closeWindowIndex(0)

/////////Verify Folder Visible for this User//////////

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click DOCM MainMenu and Folders SubMenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
		, ('SubMenu') : 'Folders'], FailureHandling.STOP_ON_FAILURE)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Folder Title  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderTitleSearch_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'FolderTitle', 1))

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/210_CDDSINC09396_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue(
		'BusinessUnit', 1), false)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to content frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

//Validation Part :: Verify Folder Visible for this User

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

try{
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
		WebElement businessUnit = tableRows[i].findElements(By.tagName("td"))[1]
		WebElement title = tableRows[i].findElements(By.tagName("td"))[2]
		WebElement description = tableRows[i].findElements(By.tagName("td"))[4]
		if( businessUnit.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue('BusinessUnit', 1))
			&& title.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue('FolderTitle', 1))
			&& description.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/210_CDDSINC09396/Create_Folder').getValue('FolderDescription', 1))
		){
			KeywordUtil.markPassed("VERIFIED: Folder ${title.getAttribute("innerText")} created.")
			errorFound = false
			break;
		}else{
			errorFound=true
		}
	}
	(errorFound) ?  KeywordUtil.markFailedAndStop("FAILED: Folder not created."):""

}catch(Exception e){
	KeywordUtil.markFailedAndStop("FAILED: Folder search error. Some field does not matched.")
}

'Close Browser'
WebUI.closeWindowIndex(0)

