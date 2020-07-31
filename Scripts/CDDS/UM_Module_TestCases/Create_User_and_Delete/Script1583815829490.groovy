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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_User'), [('Company') : findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue(
            'Company', 1), ('BusinessUnit') : findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('BusinessUnit', 
            1), ('AID_XID') : findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('AID_XID', 1), ('CDDSRoles') : findTestData(
            'CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('CDDSRoles', 1), ('FileSite') : findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue(
            'FileSite', 1)], FailureHandling.STOP_ON_FAILURE)

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Users'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'get the actual Company'
String actualCompany = findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('Company', 1)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_ Company_Dropdown_Obj'), 
    actualCompany, false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue(
        'AID_XID', 1))

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_UserId_Obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualSearchUserId = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_UserId_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualSearchUserId)

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualSearchUserId.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('AID_XID', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Company  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_Company_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchCompany'
ActualSearchCompany = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_Company_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchCompany)

'Verify Equal ActualSearchCompany with expected SearchCompany'
WebUI.verifyEqual(ActualSearchCompany.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('Company', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result BusinessUnit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_BusinessUnit_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the ActualSearchBusinessUnit'
ActualSearchBusinessUnit = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_BusinessUnit_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchBusinessUnit'
println(ActualSearchBusinessUnit)

'Verify Equal ActualSearchBusinessUnit with expected SearchBusinessUnit'
WebUI.verifyEqual(ActualSearchBusinessUnit.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue(
        'BusinessUnit', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Delete_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Delete_Obj'), FailureHandling.STOP_ON_FAILURE)

'Accept Alert'
WebUI.acceptAlert()

'Accept Alert'
WebUI.acceptAlert()

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Users'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'get the actual Company'
String actualCompany1 = findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('Company', 1)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_ Company_Dropdown_Obj'), 
    actualCompany1, false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue(
        'AID_XID', 1))

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_UserId_Obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualSearchUserId1 = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_UserId_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualSearchUserId1)

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualSearchUserId1.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('AID_XID', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Company  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_Company_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchCompany'
ActualSearchCompany1 = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_Company_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchCompany1)

'Verify Equal ActualSearchCompany with expected SearchCompany'
WebUI.verifyEqual(ActualSearchCompany1.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('Company', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result BusinessUnit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_BusinessUnit_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the ActualSearchBusinessUnit'
ActualSearchBusinessUnit1 = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_BusinessUnit_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchBusinessUnit'
println(ActualSearchBusinessUnit1)

'Verify Equal ActualSearchBusinessUnit with expected SearchBusinessUnit'
WebUI.verifyEqual(ActualSearchBusinessUnit1.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue(
        'BusinessUnit', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result State  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_State_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualState'
ActualSearchState = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/Table_State_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchState'
println(ActualSearchState)

'Verify Equal ActualSearchStatewith expected SearchState'
WebUI.verifyEqual(ActualSearchState.trim(), findTestData('CDDS/UM_Module_TestData/Create_User_and_Delete').getValue('State', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Close the browser'
WebUI.closeBrowser()

