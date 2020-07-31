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
            'CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('MENU1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('MENU2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for the page load'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Users text header visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Users_Text_Obj'), GlobalVariable.Element_Timeout)

'Verify Users text present'
WebUI.verifyElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Users_Text_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Company option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Select_Company'), GlobalVariable.Element_Timeout)

'Select Company'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Select_Company'), findTestData(
        'CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('SELECT', 1), false)

'wait for UserID Field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/UserID_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter UserID'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/UserID_Field_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue(
        'TEXT', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Find_Btn'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Find_Btn'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get User ID'
String Get_UserID = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Get_UserID_Obj'))

'Triming geting  user id'
String GetUserID = Get_UserID.trim()

'Verify userid macthed'
WebUI.verifyMatch(GetUserID, findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('TEXT', 1), 
    false)

'Get Role'
String Get_Role = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Get_Role_Obj'))

'Triming geting Role value'
String GetRole = Get_Role.trim()

'Verify Role value macthed'
WebUI.verifyMatch(GetRole, findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('TEXT', 2), 
    false)

'Logout or close the browser'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Login or Navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue(
            'TEXT', 1)], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('MENU1', 2), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('MENU2', 2)], FailureHandling.STOP_ON_FAILURE)

'Wait for the page load'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Business Unit option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Select_Business_Unit'), 
    GlobalVariable.Element_Timeout)

'Select Business Unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Select_Business_Unit'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('SELECT', 2), false)

'wait for IP Classification option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Select_IP_Classification_Obj'), 
    GlobalVariable.Element_Timeout)

'Select IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Select_IP_Classification_Obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Non_TI_Member').getValue('SELECT', 3), false)

'Wait for My IC Checkbox visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/My_IC_Obj'), GlobalVariable.Element_Timeout)

'Unchecked My IC '
WebUI.uncheck(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/My_IC_Obj'))

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Find_Btn'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Find_Btn'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for element for the visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Empty_Table_Obj'), GlobalVariable.Element_Timeout)

'Verify table value not exists'
WebUI.verifyElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Non_TI_Member/Empty_Table_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Logout or close the browser'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

