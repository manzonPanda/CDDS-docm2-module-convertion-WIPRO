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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to Business Units'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue('MainMenu', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Business unit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Create_BU_tab_obj'), GlobalVariable.Element_Timeout)

'Click on create Business unit...'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Create_BU_tab_obj'))

WebUI.delay(15)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Company name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Company_name_obj'), GlobalVariable.Element_Timeout)

'Select the company name required'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Company_name_obj'), findTestData(
        'CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue('Company', 1), false)

'Wait for Business Unit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/BU_Name_obj'), GlobalVariable.Element_Timeout)

'Set random value'
String random_number = RandomStringUtils.randomNumeric(2)

'set the path'
String path = 'TI_UM_BU_' + random_number

'set the Business Unit name required'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/BU_Name_obj'), path)

WebUI.delay(5)

'Wait for File site element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/FileSite_obj'), GlobalVariable.Element_Timeout)

WebUI.delay(10)

'Select the File site required'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/FileSite_obj'), findTestData(
        'CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue('File Site', 1), false)

'Wait for Release note element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Release_Note_obj'), GlobalVariable.Element_Timeout)

'Check the radio box of release note element'
WebUI.check(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Release_Note_obj'))

'Wait for Limit request element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Limit_request_obj'), GlobalVariable.Element_Timeout)

'Check the radio box of limit request element'
WebUI.check(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Limit_request_obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Done_Button_obj'), GlobalVariable.Element_Timeout)

'Click on Done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Done_Button_obj'))

WebUI.delay(15)

'wait for alert to be visible (In case the comany name is already existing)'
if (WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
    'Get the alert Text'
    ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

    'Print the alert text'
    println(ActualGetTextAlert)

    'Check if the alert text contains "already exists"'
    if (ActualGetTextAlert.contains('already exist')) {
        WebUI.acceptAlert(FailureHandling.OPTIONAL)

        println('alert accepted')
    }
    
    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for loading object to be not visible'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Loading_obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Navigate to  Business unit Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BU name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Search_BUname_obj'), GlobalVariable.Element_Timeout)

'Set the BU name to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Search_BUname_obj'), path)

'Wait for Find button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Find_button_obj'), GlobalVariable.Element_Timeout)

'Click the find button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Find_button_obj'))

'Navigate Company Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Company name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Table_company_obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Company Name'
ActualCompanyName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Table_company_obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Company Name'
println(ActualCompanyName)

'Verify Equal Actual CompanyName with expected Company Name'
WebUI.verifyEqual(ActualCompanyName.trim(), findTestData('CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue('Company', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result BU name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Table_BUname_obj'), GlobalVariable.Element_Timeout)

'Get the Actual BU name value'
ActualBUName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Table_BUname_obj'), FailureHandling.STOP_ON_FAILURE)

'Print Actual BU name value'
println(ActualBUName)

'Verify Equal Actual BU name value with expected BU name value'
WebUI.verifyEqual(ActualBUName.trim(), path, FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result File site element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Table_FileSite_obj'), GlobalVariable.Element_Timeout)

'Get the Actual file site value'
ActualFilesiteName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_BusinessUnit_in_TI/Table_FileSite_obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual File site value'
println(ActualFilesiteName)

'Verify Equal Actual File site value with expected File site value'
WebUI.verifyEqual(ActualFilesiteName.trim(), findTestData('CDDS/UM_Module_TestData/Create_BusinessUnit_in_TI').getValue(
        'File Site', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout and close the browser'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

