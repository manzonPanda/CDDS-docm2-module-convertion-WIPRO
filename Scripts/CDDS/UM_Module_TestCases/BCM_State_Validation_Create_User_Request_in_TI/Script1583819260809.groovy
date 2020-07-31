import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Login in to application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Get the Create User request from Data file'
InternalData data = findTestData('CDDS/UM_Module_TestData/BCM_State_Validation_Create_User_Request_in_TI')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to Default'
    WebUI.switchToDefaultContent()

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
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/BCM_State_Validation_Create_User_Request_in_TI/CreateUsersReq_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Create User Request'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/BCM_State_Validation_Create_User_Request_in_TI/CreateUsersReq_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Navigate to User Page   frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Enter User Request and Submit'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/User_Request_Form'), [('Company') : findTestData('CDDS/UM_Module_TestData/BCM_State_Validation_Create_User_Request_in_TI').getValue(
                'Company', index), ('BusinessUnit') : findTestData('CDDS/UM_Module_TestData/BCM_State_Validation_Create_User_Request_in_TI').getValue(
                'BusinessUnit', index), ('UserId') : findTestData('CDDS/UM_Module_TestData/BCM_State_Validation_Create_User_Request_in_TI').getValue(
                'AID_XID', index), ('CDDSRoles') : findTestData('CDDS/UM_Module_TestData/BCM_State_Validation_Create_User_Request_in_TI').getValue(
                'CDDSRoles', index), ('FileSites') : findTestData('CDDS/UM_Module_TestData/BCM_State_Validation_Create_User_Request_in_TI').getValue(
                'FileSite', index)], FailureHandling.STOP_ON_FAILURE)

	KeywordUtil.markPassed("TEST CASE PASSED ITERATION::"+index)
    'Get the Alert text'
    ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

    if (ActualGetTextAlert.contains('already exist')) {
        WebUI.acceptAlert()

        WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
    } else {
        not_run: WebUI.acceptAlert()

        not_run: WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
    }
}

WebUI.closeBrowser()

