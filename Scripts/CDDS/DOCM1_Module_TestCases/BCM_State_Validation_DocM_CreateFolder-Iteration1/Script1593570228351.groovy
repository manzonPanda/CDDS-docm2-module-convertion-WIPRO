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

WebDriver driver = DriverFactory.getWebDriver()

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
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/FolderTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/FolderTitle_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue(
		'FolderTitle', 1))

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue(
		'BusinessUnit', 1), false)

'Wait for FolderDescription element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/FolderDescription_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderDescription'
WebUI.setText(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/FolderDescription_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue(
		'FolderDescription', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM1_Module_Objects/Create_Folder_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

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
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM1_Module_Objects/FolderTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM1_Module_Objects/FolderTitle_Obj'), findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue(
		'FolderTitle', 1))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

//Validation Part :: Verify_Table_Values

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

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
	if( businessUnit.getAttribute("innerText").contains(findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue('BusinessUnit', 1)) 
		&& title.getAttribute("innerText").contains(findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue('FolderTitle', 1)) 
		&& description.getAttribute("innerText").contains(findTestData('CDDS/DOCM1_Module_TestData/Create_Folder').getValue('FolderDescription', 1))
	){
		KeywordUtil.markPassed("VERIFIED: Folder ${title.getAttribute("innerText")}created.")
		errorFound = false
		break;
	}else{
		errorFound=true
	}
}

(errorFound) ?  KeywordUtil.markFailedAndStop("FAILED: Folder not created."):"" 

'Close browser'






