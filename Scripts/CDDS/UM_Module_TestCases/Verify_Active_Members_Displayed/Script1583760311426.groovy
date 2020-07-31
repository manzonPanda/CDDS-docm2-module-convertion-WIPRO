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

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Users'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Search_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Search_UserId_Obj'), findTestData(
        'CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('AID_XID', 1))

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result State element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_State_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search State'
ActuaState = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_State_Obj'), 
    FailureHandling.OPTIONAL)
println (ActuaState)
def ExpectedState = findTestData('CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('State', 1)
println (ExpectedState)
if (ActuaState.trim().equals(ExpectedState)) {
    'Navigate User Search Table frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Search result Userid element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/User_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Get the Actual Search Userid'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/User_Checkbox_Obj'))

    'Navigate to Actions Button  frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for Unsuspended element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Unsuspend_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Unsuspended'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Unsuspend_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Navigate to Page Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Reason_Comments_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Reason_Comments_Obj'), findTestData(
            'CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('Reason', 2))

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Wait for Done btn Element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Done_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Done btn '
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)
}
'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/User_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/User_Checkbox_Obj'))

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Suspend element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Suspend_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Suspend'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Suspend_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Reason_Comments_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Reason_Comments_Obj'), findTestData(
        'CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('Reason', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Search_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Search_UserId_Obj'), findTestData(
        'CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('AID_XID', 1))

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualSearchUserId = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_UserId_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualSearchUserId)

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualSearchUserId.trim(), findTestData('CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue(
        'AID_XID', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result State element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_State_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search State'
ActualSearchState = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_State_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search State'
println(ActualSearchState)

'Verify Equal ActualSearchState with expected SearchState'
WebUI.verifyEqual(ActualSearchState.trim(), findTestData('CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue(
        'State', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/User_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/User_Checkbox_Obj'))

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Unsuspended element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Unsuspend_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Unsuspended'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Unsuspend_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Reason_Comments_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Reason_Comments_Obj'), findTestData(
        'CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('Reason', 2))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Search_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Search_UserId_Obj'), findTestData(
        'CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue('AID_XID', 1))

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualSearchUserId = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_UserId_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualSearchUserId)

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualSearchUserId.trim(), findTestData('CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue(
        'AID_XID', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result State element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_State_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search State'
ActualSearchState = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Verify_Active_Members_Diplayed_Objects/Table_State_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search State'
println(ActualSearchState)

'Verify Equal ActualSearchState with expected SearchState'
WebUI.verifyEqual(ActualSearchState.trim(), findTestData('CDDS/UM_Module_TestData/Verify_Active_Members_Diplayed').getValue(
        'State', 2), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()
