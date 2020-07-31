import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login or Navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Tips_Tricks').getValue('MENU1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Tips_Tricks').getValue(
            'MENU2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for the page load'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Wait for Help icon visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Help_Icon_Obj'), GlobalVariable.Element_Timeout)

'Click on help icon'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Help_Icon_Obj'))

'Click on help icon'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Help_Icon_Obj'), FailureHandling.OPTIONAL)

'Wait for Tips and Tricks Option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Tips_and_Tricks_Obj'), GlobalVariable.Element_Timeout)

'Click on Tips and Tricks Option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Tips_and_Tricks_Obj'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to new window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/Create_Tips_Tricks').getValue('WINDOW_TITLE', 1))

'Maximize New Window'
WebUI.maximizeWindow()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create tips and trick element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Create_Tips_Trick_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create Tips and Trick option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Create_Tips_Trick_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for title field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Title_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter title'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Title_Field_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Tips_Tricks').getValue(
        'TEXT', 1))

'Wait for Bullet icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Bullet_Icon_Obj'), GlobalVariable.Element_Timeout)

'Click on Bullet icon'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Bullet_Icon_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Discription frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Rich_text_editor_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Description field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Description_Obj'), GlobalVariable.Element_Timeout)

'Enter Description '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Description_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Tips_Tricks').getValue(
        'TEXT', 2))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Start date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Start_Date_Obj'), GlobalVariable.Element_Timeout)

'Click on Start Date icon'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Start_Date_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Start date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Select_StartDate_Obj'), GlobalVariable.Element_Timeout)

'Select on Start Date '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Select_StartDate_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for End date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/End_Date_Obj'), GlobalVariable.Element_Timeout)

'Click on End Date icon'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/End_Date_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for End date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Select_EndDate_Obj'), GlobalVariable.Element_Timeout)

'Select on End Date '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Select_EndDate_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Done_Btn'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Tips_Tricks/Done_Btn'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'close browser'
WebUI.closeBrowser()

