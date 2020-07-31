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

'Create IC'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_IC'), [('IC') : 'UM_IC_1_0'], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate Design Repository  tab to IC'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'NAvigate to search page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business unit select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/BU_obj'), 
    GlobalVariable.Element_Timeout)

'Select the Business Unit to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/BU_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue('BusinessUnit', 1), false)

'Wait for IP classification select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IPClassification_obj'), 
    GlobalVariable.Element_Timeout)

'Select the IP classification to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IPClassification_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue('IP Classification', 
        1), false)

'Wait for IC name select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IC_Name_obj'), 
    GlobalVariable.Element_Timeout)

'Set the IC name to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IC_Name_obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue('IC Name', 1))

'Wait for my IC checkbox object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout)

if (WebUI.verifyElementNotChecked(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)) {
    'Check the My IC checkboc'
    WebUI.check(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/MyIC_checkbox_obj'))
}

'Wait for Find button object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Find_btn_obj'), 
    GlobalVariable.Element_Timeout)

'Click on the Find button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Find_btn_obj'))

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result IC name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Table_ICname_obj'), 
    GlobalVariable.Element_Timeout)

'Get the Search IC name'
SearchICName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Table_ICname_obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Search IC name'
println(SearchICName)

'Verify Equal actual SearchICname with expected SearchICname'
WebUI.verifyEqual(SearchICName.trim(), findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue(
        'IC Name', 1), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

'Launch the browser'
WebUI.openBrowser('')

'Maximize the window'
WebUI.maximizeWindow()

'Navigate to Application URL'
WebUI.navigateToUrl(GlobalVariable.Application_Url)

'Wait for Login Page Header element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_header_Obj'), GlobalVariable.Element_Timeout)

'Wait for Username element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Element_Timeout)

'Enter the Username'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue(
        'Username2', 1))

'enter the password'
not_run: WebUI.setEncryptedText(findTestObject('CDDS/Generic_Objects/Login_Objects/O_password'), '', FailureHandling.OPTIONAL)

'Wait for  login button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on login button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  welcome element  is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Welcome_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business unit select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/BU_obj'), 
    GlobalVariable.Element_Timeout)

'Select the Business Unit to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/BU_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue('BusinessUnit', 1), false)

'Wait for IP classification select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IPClassification_obj'), 
    GlobalVariable.Element_Timeout)

'Select the IP classification to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IPClassification_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue('IP Classification', 
        1), false)

'Wait for IC name select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IC_Name_obj'), 
    GlobalVariable.Element_Timeout)

'Set the IC name to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/IC_Name_obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue('IC Name', 1))

'Wait for my IC checkbox object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout)

if (WebUI.verifyElementNotChecked(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)) {
    'Check the My IC checkboc'
    WebUI.check(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/MyIC_checkbox_obj'))
}

'Wait for Find button object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Find_btn_obj'), 
    GlobalVariable.Element_Timeout)

'Click on the Find button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Find_btn_obj'))

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for search error item element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Table_error_obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual error from UI'
SearchMessage = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_Before_Adding_to_IC/Table_error_obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual error'
println(SearchMessage)

'Verify Equal Actual error from UI with expected error'
WebUI.verifyEqual(SearchMessage.trim(), findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_Before_Adding_to_IC').getValue(
        'ErrorMessage', 1), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

