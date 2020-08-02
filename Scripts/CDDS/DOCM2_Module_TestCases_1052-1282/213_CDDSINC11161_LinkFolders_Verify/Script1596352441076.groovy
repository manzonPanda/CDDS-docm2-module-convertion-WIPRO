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

'Wait for Loading Icon to finish'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listFilter frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 30)

'Wait for FolderTitle element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 1))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Initialize driver'
WebDriver driver = DriverFactory.getWebDriver()

'Click on the Link folder'
driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 1)}')]")).click()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/TIFolderContent_iframe_Obj'), 30)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Delay for few sec'
WebUI.delay(5)

'Click on  Actions button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Create Link element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/CreateLink_Obj'), 10)

'Click on Create Link button '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/CreateLink_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Change Window'
WebUI.switchToWindowIndex(1)
WebUI.maximizeWindow()

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), 30)

'Wait for Link Title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a Link Title'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'Link', 1))

'Click Folder Link radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkSourceFolderLink_Radio_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on the folder select image : index 1'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Change Window'
WebUI.switchToWindowIndex(2)
WebUI.maximizeWindow()

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 30)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'BusinessUnit', 1), false)

'Enter Link Folder'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 2))

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for the folder searched to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Select_Radio_Obj'), 10)

'Click on folder searched radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Select_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(3)

'Change Window'
WebUI.switchToWindowIndex(1)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for a while'
WebUI.delay(15)

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/TIFolderContent_iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), 30)

try{
	'Click on the Link folder'
	WebElement linkName = driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('Link', 1)}')]"))
	linkName.click()
	
	'Delay for a while'
	WebUI.delay(5)
	
	'Switch frame'
	WebUI.switchToDefaultContent()
	WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
	WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)


	'Verify_Exist'
	WebElement pageTitle = driver.findElement(By.xpath("//td[@class='page-title']"))
	
	if( pageTitle.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 2)) ){
		KeywordUtil.markPassed("Verified: Folder ${pageTitle.getAttribute("innerText")} has been linked to ${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 1)}.")
	}else{
		KeywordUtil.markFailedAndStop("FAILED: Failed to link folder ${pageTitle.getAttribute("innerText")}.")
	}
}catch(Exception e){
	KeywordUtil.markFailedAndStop("FAILED: Document Link search error. .")
}

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
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 30)

'Wait for FolderTitle element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 2))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the Link folder'
driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 2)}')]")).click()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/TIFolderContent_iframe_Obj'), 30)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Delay for few sec'
WebUI.delay(5)

'Click on  Actions button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Create Link element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/CreateLink_Obj'), 10)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Click on Create Link button '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/CreateLink_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Change Window'
WebUI.switchToWindowIndex(1)
WebUI.maximizeWindow()

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), 30)

'Wait for Link Title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a Link Title'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'Link', 2))

'Click Folder Link radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkSourceFolderLink_Radio_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on the folder select image : index 1'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Change Window'
WebUI.switchToWindowIndex(2)
WebUI.maximizeWindow()

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 30)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'BusinessUnit', 3), false)

'Enter Link Folder'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 3))

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for the folder searched to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Select_Radio_Obj'), 10)

'Click on folder searched radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Select_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(5)

'Change Window'
WebUI.switchToWindowIndex(1)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for a while'
WebUI.delay(15)

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/TIFolderContent_iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), 30)

try{
	'Click on the Link folder'
	WebElement linkName = driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('Link', 2)}')]"))
	linkName.click()

	'Delay for a while'
	WebUI.delay(5)

	'Switch frame'
	WebUI.switchToDefaultContent()
	WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
	WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)


	'Verify_Exist'
	WebElement pageTitle = driver.findElement(By.xpath("//td[@class='page-title']"))

	if( pageTitle.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 3)) ){
		KeywordUtil.markPassed("Verified: Folder ${pageTitle.getAttribute("innerText")} has been linked to ${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 2)}.")
	}else{
		KeywordUtil.markFailedAndStop("FAILED: Failed to link folder ${pageTitle.getAttribute("innerText")}.")
	}
}catch(Exception e){
	KeywordUtil.markFailedAndStop("FAILED: Document Link search error. .")
}

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
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 30)

'Wait for FolderTitle element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), GlobalVariable.Element_Timeout)

'Set a FolderTitle'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 3))

'Wait for Find btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to listDisplay frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the Link folder'
driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 3)}')]")).click()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/TIFolderContent_iframe_Obj'), 30)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), 10)

'Delay for few sec'
WebUI.delay(5)

'Click on  Actions button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Create Link element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/CreateLink_Obj'), 10)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Click on Create Link button '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/CreateLink_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Change Window'
WebUI.switchToWindowIndex(1)
WebUI.maximizeWindow()

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), 30)

'Wait for Link Title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkTitle_Obj'), GlobalVariable.Element_Timeout)

'Set a Link Title'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkTitle_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'Link', 3))

'Click Folder Link radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/LinkSourceFolderLink_Radio_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on the folder select image : index 1'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Icon_Action_Search', [('index') : '1']), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Change Window'
WebUI.switchToWindowIndex(2)
WebUI.maximizeWindow()

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), 30)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/BusinessUnit_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'BusinessUnit', 4), false)

'Enter Link Folder'
WebUI.setText(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/FolderTitleSearch_Obj'), findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue(
		'FolderTitle', 4))

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Find_Button'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Loading Icon to finish'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.waitForElementNotVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for the folder searched to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Select_Radio_Obj'), 10)

'Click on folder searched radio button'
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Select_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)

'Click on  Submit btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(5)

'Change Window'
WebUI.switchToWindowIndex(1)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delay for a while'
WebUI.delay(15)

'Switch frame'
WebUI.switchToDefaultContent()
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/DOCM2_Module_Objects/213_CDDSINC11161_Objects/TIFolderContent_iframe_Obj'), 30)
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), 30)

try{
	'Click on the Link folder'
	WebElement linkName = driver.findElement(By.xpath("//a[contains(text(),'${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('Link', 3)}')]"))
	linkName.click()

	'Delay for a while'
	WebUI.delay(5)

	'Switch frame'
	WebUI.switchToDefaultContent()
	WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 30)
	WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), 30)


	'Verify_Exist'
	WebElement pageTitle = driver.findElement(By.xpath("//td[@class='page-title']"))

	if( pageTitle.getAttribute("innerText").contains(findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 4)) ){
		KeywordUtil.markPassed("Verified: Folder ${pageTitle.getAttribute("innerText")} has been linked to ${findTestData('CDDS/DOCM2_Module_TestData/213_CDDSINC11161/Folders').getValue('FolderTitle', 3)}.")
	}else{
		KeywordUtil.markFailedAndStop("FAILED: Failed to link folder ${pageTitle.getAttribute("innerText")}.")
	}
}catch(Exception e){
	KeywordUtil.markFailedAndStop("FAILED: Document Link search error. .")
}

'Close Browser'
WebUI.closeWindowIndex(0)










