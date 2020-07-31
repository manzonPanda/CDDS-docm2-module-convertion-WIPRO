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
            'CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('MENU1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue(
            'MENU2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for the page load'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Users text header visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Users_Text_Obj'), GlobalVariable.Element_Timeout)

'Verify Users text present'
WebUI.verifyElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Users_Text_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Company option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Select_Company'), GlobalVariable.Element_Timeout)

'Select Company'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Select_Company'), findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue(
        'SELECT', 1), false)

'wait for UserID Field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/UserID_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter UserID'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/UserID_Field_Obj'), findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue(
        'TEXT', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Find_Btn'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Find_Btn'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get User ID'
String Get_UserID = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Get_UserID_Obj'))

'Triming geting  user id'
String GetUserID = Get_UserID.trim()

'Verify userid macthed'
WebUI.verifyMatch(GetUserID, findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('TEXT', 1), false)

'Get State'
String Get_State = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Get_State_Obj'))

'Triming geting state value'
String GetState = Get_State.trim()

'Verify state value macthed'
WebUI.verifyMatch(GetState, findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('TEXT', 2), false)

'Wait for User visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Select_User'), GlobalVariable.Element_Timeout)

'Select User'
WebUI.check(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Select_User'))

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for UnSuspend element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Unsuspend_Obj'), GlobalVariable.Element_Timeout)

'Click on UnSuspend... option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Unsuspend_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to new window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('WINDOW_TITLE', 1))

'Maximize New Window'
WebUI.maximizeWindow()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait for Reasion for Unsuspension Field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Reasion_for_UnSuspension_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter reasion for Unsuspension'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Reasion_for_UnSuspension_Field_Obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('TEXT', 3), FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Done_Btn'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Done_Btn'))

'wait till search icon visible'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Search_Icon_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'wait'
WebUI.delay(3)

'Switch to default window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('WINDOW_TITLE', 2))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get User ID'
String Get_UserID1 = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Get_UserID_Obj'))

'Triming geting  user id'
String GetUserID1 = Get_UserID1.trim()

'Verify userid macthed'
WebUI.verifyMatch(GetUserID1, findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('TEXT', 1), false)

'Get State'
String Get_State1 = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_UNSuspend_the_User/Get_State_Obj'))

'Triming geting state value'
String GetState1 = Get_State1.trim()

'Verify state updated value macthed'
WebUI.verifyMatch(GetState1, findTestData('CDDS/UM_Module_TestData/UM_UNSuspend_the_User').getValue('TEXT', 4), false)

'Logout or close the browser'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

