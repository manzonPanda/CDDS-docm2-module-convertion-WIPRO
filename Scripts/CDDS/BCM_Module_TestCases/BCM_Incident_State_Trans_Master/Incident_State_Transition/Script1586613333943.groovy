import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Delay for few seconds.'
not_run: WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to my desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to BCM menu and Projects Submenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to search page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Project name element  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'set project name object '
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
        'ProjectName', 1))

'Wait for Find Button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'click find button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Find_Button_obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

String project = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
    'ProjectName', 1)

String Created_Xpath = ('//a[contains(.,"' + project) + '")]'

println(Created_Xpath)

TestObject ProjectLinkObj = new TestObject('objectName')

ProjectLinkObj.addProperty('xpath', ConditionType.EQUALS, Created_Xpath)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(ProjectLinkObj, GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(ProjectLinkObj)

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
not_run: WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/iframe_BCMincidentInbox_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/BCM_Frame'), GlobalVariable.Element_Timeout)

'Switch to list filter frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Keyword object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Keyword_obj'), 
    GlobalVariable.Element_Timeout)

'set keyword object value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Keyword_obj'), Keyword)

'Wait for ID object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/ID_obj'), GlobalVariable.Element_Timeout)

'uncheck ID element'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/ID_obj'))

'Wait for select title object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/SelectTitle_obj'), 
    GlobalVariable.Element_Timeout)

'check select title object'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/SelectTitle_obj'))

'Wait for Select type to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Select_Type_obj'), 
    GlobalVariable.Element_Timeout)

'select type from drop down'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Select_Type_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
        'Type', 1), false)

'Wait for State check object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/State_Check'), 
    GlobalVariable.Element_Timeout)

'select state from drop down'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/State_Check'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
        'State', 1), false)

'Wait for Find button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Find_Button_obj'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/BCM_Frame'), GlobalVariable.Element_Timeout)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Checkbox_Incident_obj'), 
    GlobalVariable.Element_Timeout)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Checkbox_Incident_obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/BCM_Frame'), GlobalVariable.Element_Timeout)

'Wait for BCM action element t o be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/BCMActions_obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM action'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/BCMActions_obj'))

'Wait for BCM action element t o be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Edit_state_obj'), 
    GlobalVariable.Element_Timeout)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Edit_state_obj'))

WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BCM action element t o be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/State_obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/State_obj'), State, 
    false, FailureHandling.OPTIONAL)

WebUI.delay(GlobalVariable.Short_Wait)

if (!(State.equals('New'))) {
    'Wait for BCM action element t o be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Assignee_obj'), 
        GlobalVariable.Element_Timeout)

    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Assignee_obj'), Assignee)

    WebUI.delay(GlobalVariable.Short_Wait)

    'Wait for BCM action element t o be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Assigned_dropdown_obj'), 
        GlobalVariable.Element_Timeout)

    WebUI.mouseOver(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Assigned_dropdown_obj'), 
        FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Assigned_dropdown_obj'))

    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Assigned_dropdown_obj'), 
        FailureHandling.OPTIONAL)
}

'Wait for BCM action element t o be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Resolution_Description_obj'), 
    GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Resolution_Description_obj'), 
    ResolutionDescription)

WebUI.switchToDefaultContent()

'Wait for BCM action element t o be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Done_button_obj'), 
    GlobalVariable.Element_Timeout)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Done_button_obj'))

WebUI.delay(30)

WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/BCM_Frame'), GlobalVariable.Element_Timeout)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Get Second User id'
String Actual_Title = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Table_Title_obj'))

println(Actual_Title.trim())

'Verify Actual and Expected Userid match'
WebUI.verifyMatch(Actual_Title.trim(), Keyword, false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Second User id'
String Actual_State = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_State_Trans_Master_Objects/Table_State_obj'))

println(Actual_State.trim())

'Verify Actual and Expected Userid match'
WebUI.verifyMatch(Actual_State.trim(), ExpectedState, false, FailureHandling.OPTIONAL)

