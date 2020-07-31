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

'Create a User'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_User'), [('Company') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
            'Company', 1), ('BusinessUnit') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('BusinessUnit', 
            1), ('AID_XID') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('AID_XID', 1), ('CDDSRoles') : findTestData(
            'CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('CDDSRoles', 1), ('FileSite') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
            'FileSite', 1)], FailureHandling.STOP_ON_FAILURE)

'Set the UserID password as Blank'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/UserId_Set'), [('UserID') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
            'AID_XID', 1)], FailureHandling.STOP_ON_FAILURE)

'Login in to application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
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
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/CreateUsersReq_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create User Request'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/CreateUsersReq_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Enter User Request and Submit'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/User_Request_Form'), [('Company') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
            'Company', 1), ('BusinessUnit') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('BusinessUnit', 
            1), ('UserId') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('AID_XID2', 1), ('CDDSRoles') : findTestData(
            'CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('CDDSRoles', 1), ('FileSites') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
            'FileSite', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))
}

'Switch to Default'
WebUI.switchToDefaultContent()

'Navigate to My Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'User Requests'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_ Company_Dropdown_Obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('Company', 1), false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
        'AID_XID2', 1))

'Wait for  State element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/State_Select_Obj'), GlobalVariable.Element_Timeout)

'Select Select  drpdown as Requested'
WebUI.selectOptionByValue(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/State_Select_Obj'), findTestData(
        'CDDS/Generic_TestData/UM_Create_User_Request').getValue('State', 1), false)

'Wait for MyAssigened Request element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/MyAssignedReq_Obj'), GlobalVariable.Element_Timeout)

'Uncheck  MyAssigened Request '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/MyAssignedReq_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result BusinessUnit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchBusinessUnit'
ActualSearchBusinessUnit = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_BusinessUnit_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchBusinessUnit'
println(ActualSearchBusinessUnit)

'Verify Equal ActualSearchBusinessUnit with expected SearchBusinessUnit'
WebUI.verifyEqual(ActualSearchBusinessUnit.trim(), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
        'BusinessUnit', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result State  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_State_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchState'
ActualSearchState = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_State_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchState'
println(ActualSearchState)

'Verify Equal ActualSearchState with expected Search State'
WebUI.verifyEqual(ActualSearchState.trim(), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('State', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'close the browser'
WebUI.closeBrowser()

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'switch to default'
WebUI.switchToDefaultContent()

'Navigate to MY Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'User Requests'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_ Company_Dropdown_Obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('Company', 1), false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
        'AID_XID2', 1))

'Wait for  State element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/State_Select_Obj'), GlobalVariable.Element_Timeout)

'Select Select  drpdown as Requested'
WebUI.selectOptionByValue(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/State_Select_Obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('State', 1), false)

'Wait for MyAssigened Request element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/MyAssignedReq_Obj'), GlobalVariable.Element_Timeout)

'Uncheck  MyAssigened Request '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/MyAssignedReq_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result BusinessUnit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchBusinessUnit'
ActualSearchBusinessUnit = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_BusinessUnit_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchBusinessUnit'
println(ActualSearchBusinessUnit)

'Verify Equal ActualSearchBusinessUnit with expected SearchBusinessUnit'
WebUI.verifyEqual(ActualSearchBusinessUnit.trim(), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
        'BusinessUnit', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result State  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_State_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchState'
ActualSearchState = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_State_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchState'
println(ActualSearchState)

'Verify Equal ActualSearchState with expected Search State'
WebUI.verifyEqual(ActualSearchState.trim(), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('State', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Accept element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/AcceptandReject_Obj'), GlobalVariable.Element_Timeout)

'Click on Accept Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/AcceptandReject_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Accept element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Accept_Radio_Obj'), GlobalVariable.Element_Timeout)

'Click on Accept Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Accept_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Accept element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Accept_Comments_Obj'), GlobalVariable.Element_Timeout)

'Click on Accept Btn'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Accept_Comments_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
        'Comments', 1))

'Switch to Default'
WebUI.switchToDefaultContent()

'Wait for Accept element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Accept Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Close the browser'
WebUI.closeBrowser()

'Login in to application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
            'AID_XID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'User Requests'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_ Company_Dropdown_Obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('Company', 1), false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue(
        'AID_XID', 1))

'Wait for  State element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/State_Select_Obj'), GlobalVariable.Element_Timeout)

'Select Select  drpdown as Requested'
WebUI.selectOptionByValue(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/State_Select_Obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Accept_User_Request').getValue('State', 1), false)

'Wait for MyAssigened Request element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/MyAssignedReq_Obj'), GlobalVariable.Element_Timeout)

'Uncheck  MyAssigened Request '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/MyAssignedReq_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Table Business unit is not present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Table State is not present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Accept_User_Request/Table_State_Obj'), GlobalVariable.Element_Timeout)

'Close the Browser'
WebUI.closeBrowser()

