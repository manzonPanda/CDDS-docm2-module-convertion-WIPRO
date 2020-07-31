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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Main_Menu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : '', ('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Project_Name', 
            1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
            'Project_Abbr', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
            'Business_Group', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
            'UserID', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
            'Associated_Schema', 1), ('TC_Name_Path1') : ''], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Business unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Business_Unit_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Bussiness unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Business_Unit_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Business_Group', 
        1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Project_Name', 
        1))

'Wait for Show select field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Show_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Show'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Show_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Show', 
        1), false)

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

'Create Report'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_Report'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Report Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Report_Name', 
        1))

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

'Wait for Share/Unshare element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Share_Unshare_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Share/Unshare'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Share_Unshare_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to new window'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search projects icon element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Share_Report_Objects/Search_ProjectIcon_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Search projects icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Share_Report_Objects/Search_ProjectIcon_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to search project window'
WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
        'Window_Title', 1))

'Maximize search project window'
WebUI.maximizeWindow()

'Switch to list filter i frmae'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Share_Report_Objects/ProjectName_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Share_Report_Objects/ProjectName_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Project_Name', 
        2))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to list display i frmae'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Created Report to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Select_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Select created report'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Select_Checkbox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Submit btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Share_Report_Objects/Submit_Button_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Submit Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Share_Report_Objects/Submit_Button_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to new window'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done Button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

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
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Report_Name', 
        1))

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
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Select_Checkbox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Get Actual Report name from the table'
String Actual_ReportName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Get_ReportName_Obj'))

'Trim getting report name'
String Actual_ReportName1 = Actual_ReportName.trim()

'Verify Actual and Expected report name matched'
WebUI.verifyMatch(Actual_ReportName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
        'Report_Name', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Private name from the table'
String Actual_Private = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Get_Private_Obj'))

'Trim getting Private name'
String Actual_Private1 = Actual_Private.trim()

'Verify Actual and Expected Private name  to be matched'
WebUI.verifyMatch(Actual_Private1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue(
        'Private', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Delete Created report'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_Report'), [('Expected_ReportName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Share_Report_TestData').getValue('Report_Name', 
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

