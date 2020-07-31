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

'Navigate to my desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to BCM menu and Projects Submenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for sometime'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to search page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Project name element  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'set project name object '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/ProjectName_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'ProjectName', 1))

'Wait for sometime'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Find Button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'click find button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Find_Button_obj'))

'click find button'
WebUI.doubleClick(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Find_Button_obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for sometime'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Project_Link_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Project_Link_Obj'))

'Wait for sometime'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_Frame'), 
    GlobalVariable.Element_Timeout)

'Wait for BCM action element t o be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCMActions_obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM action'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCMActions_obj'))

//findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_GroupCollapsed_obj')
'If Verify Menu Expanded is not visible'
if (!(WebUI.verifyElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_MenuExpanded_obj'), 
    FailureHandling.OPTIONAL))) {
    'Wait for Mainmenu  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_GroupCollapsed_obj'), 
        GlobalVariable.Element_Timeout)

    'Click on MainMenu'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_GroupCollapsed_obj'))
} else {
}

'Wait for BCM Incident object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_Incident_obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM incident object'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_Incident_obj'))

'Wait for sometime'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for severity object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Severity_obj'), 
    GlobalVariable.Element_Timeout)

'Select severity object from drop down\r\n'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Severity_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'Severity', 1), false)

'Wait for Title object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Title_obj'), 
    GlobalVariable.Element_Timeout)

'Set title object value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Title_obj'), 
    Title)

'Wait for Description option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Description_obj'), 
    GlobalVariable.Element_Timeout)

'set description object value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Description_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'Description', 1))

'Wait for Responding team object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Responding_Team_obj'), 
    GlobalVariable.Element_Timeout)

'Select reponding team from drop down'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Responding_Team_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'RespondingTeam', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.delay(5)

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Done_button_obj'), 
    GlobalVariable.Element_Timeout)

'click done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Done_button_obj'))

'Wait for sometime'
WebUI.delay(findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'WaitTime', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_Frame'), 
    GlobalVariable.Element_Timeout)

'Switch to list filter frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Keyword object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Keyword_obj'), 
    GlobalVariable.Element_Timeout)

'set keyword object value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Keyword_obj'), 
    Keyword)

'Wait for ID object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/ID_obj'), 
    GlobalVariable.Element_Timeout)

'uncheck ID element'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/ID_obj'))

'Wait for select title object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/SelectTitle_obj'), 
    GlobalVariable.Element_Timeout)

'check select title object'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/SelectTitle_obj'))

'Wait for Select type to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Select_Type_obj'), 
    GlobalVariable.Element_Timeout)

'select type from drop down'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Select_Type_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'Type', 1), false)

'Wait for State check object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/State_Check'), 
    GlobalVariable.Element_Timeout)

'select state from drop down'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/State_Check'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'State', 1), false)

'Wait for Find button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'click find button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Find_Button_obj'))

'Wait for sometime'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/BCM_Frame'), 
    GlobalVariable.Element_Timeout)

'Switch to list display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Search title in table to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Table_SearchTitle_obj'), 
    GlobalVariable.Element_Timeout)

'Get value of title from search table'
Search_title = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_State_Validation_Create_Incident_with_all_access roles_Different_States/Table_SearchTitle_obj'))

'Print Actual Search Userid'
println(Search_title)

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(Search_title.trim(), Title, FailureHandling.CONTINUE_ON_FAILURE)
