import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Create a User'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_User'), [('Company') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
            'Company', 1), ('BusinessUnit') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('BusinessUnit', 
            1), ('AID_XID') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('AID_XID', 1), ('CDDSRoles') : findTestData(
            'CDDS/Generic_TestData/UM_Create_User_Request').getValue('CDDSRoles', 1), ('FileSite') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
            'FileSite', 1)], FailureHandling.STOP_ON_FAILURE)

'Set the UserId Password as Blank'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/UserId_Set'), [('UserID') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
            'AID_XID', 1)], FailureHandling.STOP_ON_FAILURE)

'Login to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
            'AID_XID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'User Requests'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create User Request element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/CreateUsersReq_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create User Request'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/CreateUsersReq_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Enter User Request and Submit'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/User_Request_Form'), [('Company') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
            'Company', 1), ('BusinessUnit') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('BusinessUnit', 
            1), ('UserId') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('AID_XID2', 1), ('CDDSRoles') : findTestData(
            'CDDS/Generic_TestData/UM_Create_User_Request').getValue('CDDSRoles', 1), ('FileSites') : findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
            'FileSite', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if ActualAlert contain exist '
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))
}

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to My Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User Request'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'User Requests'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Search_ Company_Dropdown_Obj'), 
    findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('Company', 1), false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as '
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Search_UserId_Obj'), findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
        'AID_XID2', 1))

'Wait for  State element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/State_Select_Obj'), GlobalVariable.Element_Timeout)

'Select Select  drpdown as Requested'
WebUI.selectOptionByValue(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/State_Select_Obj'), findTestData(
        'CDDS/Generic_TestData/UM_Create_User_Request').getValue('State', 1), false)

'Wait for MyAssigened Request element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/MyAssignedReq_Obj'), GlobalVariable.Element_Timeout)

'Uncheck  MyAssigened Request '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/MyAssignedReq_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result BusinessUnit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Table_BusinessUnit_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the ActualSearchBusinessUnit'
ActualSearchBusinessUnit = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Table_BusinessUnit_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchBusinessUnit'
println(ActualSearchBusinessUnit)

'Verify Equal ActualSearchBusinessUnit with expected SearchBusinessUnit'
WebUI.verifyEqual(ActualSearchBusinessUnit.trim(), findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue(
        'BusinessUnit', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result State  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Table_State_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchState'
ActualSearchState = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Table_State_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchState'
println(ActualSearchState)

'Verify Equal ActualSearchState with expected Search State'
WebUI.verifyEqual(ActualSearchState.trim(), findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('State', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Close Browser'
WebUI.closeBrowser()

