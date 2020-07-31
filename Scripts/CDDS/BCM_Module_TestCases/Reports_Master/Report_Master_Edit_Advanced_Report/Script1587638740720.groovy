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

'Login to CDDS Url or Navigate to CDDS Url'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue('Main_Menu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : '', ('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue('Project_Name', 
            1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
            'Project_Abbr', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
            'Business_Group', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
            'UserID', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
            'Associated_Schema', 1), ('TC_Name_Path1') : ''], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Business unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Business_Unit_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Bussiness unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Business_Unit_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Business_Group', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Project_Name', 1))

'Wait for Show select field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Show_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Show'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Show_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Show', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for search project to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Click_On_Link_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on project link'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Click_On_Link_Obj'))

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Create Bug'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_Bug'), [('Expected_Team') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue('Team_Name', 
            1), ('Expected_Severity') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Severity', 1), ('Expected_Title') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Title', 1), ('Expected_Description') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Description', 1), ('Expected_While_Doing') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'While_Doing', 1), ('Expected_Location_Found') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Location_Found', 1), ('Expected_Location_Found_Identifire') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Location_Identifire', 1), ('Expected_Classification') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Classification', 1), ('Expected_Sub_Classification') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Sub_Classification', 1), ('Expected_FiledObjType') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Object_Type', 1), ('Expected_FiledObjName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Object_Name', 1), ('Expected_FiledObjVersion') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Object_Version', 1), ('Expected_FilePath') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'FILE_PATH', 1), ('Expected_ProjectMember_List') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
            'Project_Member_List', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Create Request'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_CR'), [('Expected_Title') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue('Title', 1), ('Expected_Priority') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue('Priority', 1)
        , ('Expected_Description') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Description', 1), ('Expected_Justification') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Justification', 1), ('Expected_Classification') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Classification', 1), ('Expected_Sub_Classification') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Sub_Classification', 1), ('Expected_Team') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Team_Name', 1), ('Expected_Release') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Release', 1), ('Expected_Internal_Comment') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'TI_Internal_Comment', 1), ('Expected_External_Comment') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'TI_External_Comment', 1), ('Expected_Contact_Team') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'Contact_Team', 1), ('Expected_CQID') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'CQ_ID', 1), ('Expected_ExternalID') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
            'External_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Incident'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_Incidents'), [('External_Classification') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Classification', 1), ('External_Saverity') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Severity', 1), ('External_Priority') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Priority', 1), ('External_Title') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Title', 1), ('External_Description') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Description', 1), ('External_Team') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Team_Name', 1), ('External_FiledObjName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Filed_Object_Name', 1), ('External_FiledObjRevision') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Filed_Object_Revision', 1), ('External_FiledObjType') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Filed_Object_Type', 1), ('External_ReleasePkg') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Filed_Object_ReleasePkg', 1), ('External_LocationFound_ID') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'Location_FoundID', 1), ('External_Internal_Comment') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'TI_Internal_Comment', 1), ('External_External_Comment') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'TI_External_Comment', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Reports Tab to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Reports Tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Tab_Obj'))

'Create Advanced Report'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_Advanced_Report'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Report_Name', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Created Report to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Select_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Select created report'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Select_Checkbox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Edit Report element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Edit_Report_Objects/Edit_Report_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Edit Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Edit_Report_Objects/Edit_Report_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get Actual Report name'
String Actual_Report = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Edit_Report_Objects/Get_Report_Name_Obj'))

'triming actual Report name'
String Actual_Report1 = Actual_Report.trim()

'Verify actual and expected Report name matched'
WebUI.verifyMatch(Actual_Report1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Report_Name', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual project name'
String Actual_Project = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_Projects_Obj'))

'triming actual project name'
String Actual_Project1 = Actual_Project.trim()

'Verify actual and expected project name matched'
WebUI.verifyMatch(Actual_Project1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Project_Name', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Verify team name present'
WebUI.verifyOptionPresentByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Team_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue(
        'Team_Name', 1), false, GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Verify all BCM Element types List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ElementType_Obj'), 
    ['Action', 'Alert', 'Bug', 'Change Request', 'Incident', 'Requirement'], FailureHandling.OPTIONAL)

'Wait for need by date checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Edit_Report_Objects/NeedByDate_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'check Need By Date checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Edit_Report_Objects/NeedByDate_Checkbox_Obj'))

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Run/Save button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Run/Save button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to List display frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ListDisplay_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Get Actual Bug title value'
String Actual_BugTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_BugTitle_Obj'))

'Triming got bug title value'
String Actual_BugTitle1 = Actual_BugTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugTitle1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
        'Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR title value'
String Actual_CRTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_CRTitle_Obj'))

'Triming got CR title value'
String Actual_CRTitle1 = Actual_CRTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRTitle1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
        'Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident title value'
String Actual_IncidentTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_IncidentTitle_Obj'))

'Triming got Incident title value'
String Actual_IncidentTitle1 = Actual_IncidentTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentTitle1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
        'Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Bug type value'
String Actual_BugType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Get_BugType_Obj'))

'Triming got bug Type value'
String Actual_BugType1 = Actual_BugType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
        'Classification', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Type value'
String Actual_CRType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Get_CRType_Obj'))

'Triming got CR Type value'
String Actual_CRType1 = Actual_CRType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_IncidentType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Get_IncidentType_Obj'))

'Triming got Incident Type value'
String Actual_IncidentType1 = Actual_IncidentType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Verify added column need by date to be present'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Report_Master_Edit_Advanced_Report_Objects/NeedByDate_Clm_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to listfoot frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/listFoot_frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Delete Created report'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_Report'), [('Expected_ReportName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Report_Master_Edit_Advanced_Report_TestData').getValue('Report_Name', 
            1)], FailureHandling.STOP_ON_FAILURE)

'Delete Bug'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_Bug'), [:], FailureHandling.STOP_ON_FAILURE)

'Delete Change Requests'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_CR'), [:], FailureHandling.STOP_ON_FAILURE)

'Delete Incidents'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_Incidents'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'Close the browser'
WebUI.closeBrowser()

