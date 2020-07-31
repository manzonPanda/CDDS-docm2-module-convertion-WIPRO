import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Main Menu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Sub Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'AssociatedSchema', 1)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Team'), 
    [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'TeamName', 1), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'TeamDescription', 1), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
            'TeamBaseSite', 1)], FailureHandling.STOP_ON_FAILURE)

'switch to default content'
WebUI.switchToDefaultContent()

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Main Menu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Sub Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/BusinessUnit'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('BusinessUnit', 1), 
    false)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Project name'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('ProjectName', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Assign a value to string'
String Project = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('ProjectName', 
    1)

'creating a IC dynamic xpath'
String ProjectNameXpath = ('//a[contains(.,"' + Project) + '")]'

'creating the SubMenu xpath object'
TestObject ProjectObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ProjectObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

WebUI.click(ProjectObj)

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/teams_tab'), 
    GlobalVariable.Wait_Time)

'Click on Teams tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/teams_tab'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Wait_Time)

'Switch to list display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Assign a value to string'
String Team = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Team', 
    1)

'creating a IC dynamic xpath'
String TeamNameXpath = ('//a[contains(.,"' + Team) + '")]'

'creating the SubMenu xpath object'
TestObject TeamObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
TeamObj.addProperty('xpath', ConditionType.EQUALS, TeamNameXpath)

WebUI.click(TeamObj)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('1.Criteria-Contains All,Keyword-PM_Test_Bug_5,Title-ON,ID-ON')

'Criteria as contains All'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 1), false)

'Keyword as PM_Test_Bug_5'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Keyword', 1))

'Title ON'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_Check'))

'ID ON'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/ID_Check'))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

String title_1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_verify'))

'Verify Title as PM_Test_Bug_5'
WebUI.verifyEqual(title_1, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Keyword', 3))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('2.Criteria-Contains All,Keyword-PM_Test_Bug_5,Title-ON,state-Assigned')

'Criteria as contains All'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 1), false)

'Keyword as PM_Test_Bug_5'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Keyword', 1))

'Title ON'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_Check'))

'Select State as Assigned'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('State', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

String title_2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_verify'))

'Verify Title as PM_Test_Bug_5'
WebUI.verifyEqual(title_2, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Keyword', 3))

'get text of state status from table'
state_status_2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_State_status'))

'Verify State as Assigned:New'
WebUI.verifyEqual(state_status_2, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'State', 2))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('3.Criteria-Contains Any,Keyword-PM_Test_Bug_5,Title-ON,Type-Bug,Severity-3-Medium')

'Criteria as contains Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 2), false)

'Keyword as PM_Test_Bug_5'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Keyword', 1))

'Title ON'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_Check'))

'Select Type as Bug'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Type', 1), false)

'Select severity as 3-Medium'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Severity'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Severity', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

String title_3 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_verify'))

'Verify Title as PM_Test_Bug_5'
WebUI.verifyEqual(title_3, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Keyword', 3))

'get text of state status from table'
state_status_3 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_State_status'))

'Verify State as Assigned:New'
WebUI.verifyEqual(state_status_3, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'State', 2))

'Get text of Severity 3-Medium from table'
severity_3 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_Severity'))

'Verify Severity as 3-Medium '
WebUI.verifyEqual(severity_3, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Severity', 2))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('4.Criteria-Exact Match,TYpe-Bug,Severity-3 Medium')

'Criteria as Exact Match'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 3), false)

'Select Type as Bug'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Type', 1), false)

'Select severity as 3-Medium'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Severity'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Severity', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Get text of Severity 3-Medium from table'
severity_4 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_Severity'))

'Verify Severity as 3-Medium '
WebUI.verifyEqual(severity_4, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Severity', 2))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('5.Criteria-Substring Match,Type-Bug,My Element-All elements,State-Assigned')

'Criteria as Substring Match'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 4), false)

'Select Type as Bug'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Type', 1), false)

'Select Show elements as All elements'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Show Elements'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Show Elements', 
        2), false)

'Select State as Assigned'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('State', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

String title_5 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_verify'))

'Verify Title as PM_Test_Bug_5'
WebUI.verifyEqual(title_5, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Keyword', 3))

'Get text of Severity 3-Medium from table'
severity_5 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_Severity'))

'Verify Severity as 3-Medium '
WebUI.verifyEqual(severity_5, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Severity', 2))

'get text of state status from table'
state_status_5 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_State_status'))

'Verify State as Assigned:New'
WebUI.verifyEqual(state_status_5, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'State', 2))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('6.Criteria-Contains Any,Keyword-PM_Test_Bug_5,Title-ON,Type-Action,Severity-3 Medium')

'Criteria as contains Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 2), false)

'Keyword as PM_Test_Bug_5'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Keyword', 1))

'Title ON'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_Check'))

'Select Type as Action'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Type', 2), false)

'Select severity as 3-Medium'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Severity'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Severity', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('7.Just Reset')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

String title_7 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_verify'))

'Verify Title as PM_Test_Bug_5'
WebUI.verifyEqual(title_7, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'Keyword', 3))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/TeamFilters_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Reset'))

WebUI.comment('8.Criteria-Contains Any,Keyword-&^*&^*&(^*&(,Title-ON,Type-Action,Severity-3 Medium')

'Criteria as contains Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Criteria'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Criteria', 2), false)

'Keyword as &^*&^*&(^*&('
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Keyword', 2))

'Title ON'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Title_Check'))

'Select Type as Action'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Type', 2), false)

'Select severity as 3-Medium'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Severity'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue('Severity', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.acceptAlert()

not_run: WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Verify_TeamTable_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Get text from the table that no data found'
not_run: no_Data = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/Verify_No matching Data found'))

not_run: WebUI.verifyEqual(no_Data, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Team_Inbox').getValue(
        'No data', 1))

WebUI.closeBrowser()

