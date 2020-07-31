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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Users'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Users link element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Create_Users_Tab_Obj'), GlobalVariable.Element_Timeout)

'Click on Users link '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Create_Users_Tab_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

'Wait for  company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_Company_Dropdown_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_Company_Dropdown_Obj'), Company, 
    false, FailureHandling.OPTIONAL)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for  BusinessUnit dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select BusinessUnit  as TI_UM_BU_1'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_BusinessUnit_Obj'), BusinessUnit, 
    false)

'Wait for Arrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on  Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/AID_XID_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/AID_XID_Obj'), AID_XID)

'Wait for  CDDSRoles dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_CDDSRoles_Obj'), GlobalVariable.Element_Timeout)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select CDDS Roles drpdown as TIEmployee'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_CDDSRoles_Obj'), CDDSRoles, false)

'Wait for CDDSArrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/CDDSRole_Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on CDDS Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/CDDSRole_Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/select approver'), GlobalVariable.Wait_Time)

'Select responsible admin'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_User_and_Delete_Objects/select approver'), AID_XID)

'Wait for  FileSites dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Files_Sites_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select CDDS Roles drpdown as TI (Bangalore)'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Files_Sites_Dropdown_Obj'), FileSite, 
    false)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'ActualGetTextAlert'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

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
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'get the actual Company'
String actualCompany = findTestData('CDDS/Generic_TestData/UM_Create_User').getValue('Company', 1)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), actualCompany, 
    false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as X0291282'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_UserId_Obj'), AID_XID)

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_UserId_Obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualSearchUserId = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_UserId_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualSearchUserId)

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualSearchUserId.trim(), AID_XID, FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Company  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_Company_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchCompany'
ActualSearchCompany = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_Company_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchCompany)

'Verify Equal ActualSearchCompany with expected SearchCompany'
WebUI.verifyEqual(ActualSearchCompany.trim(), Company, FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result BusinessUnit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchBusinessUnit'
ActualSearchBusinessUnit = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Table_BusinessUnit_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchBusinessUnit'
println(ActualSearchBusinessUnit)

'Verify Equal ActualSearchBusinessUnit with expected SearchBusinessUnit'
WebUI.verifyEqual(ActualSearchBusinessUnit.trim(), BusinessUnit, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Close the browser'
WebUI.closeBrowser()

