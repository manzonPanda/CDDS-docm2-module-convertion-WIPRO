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
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'Get the Validate_Requirement_With_Different_State from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Login to CDDS Application or navigate to CDDS Application'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'UserID', index)], FailureHandling.STOP_ON_FAILURE)

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Main_Menu', index), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Sub_Menu', index)], FailureHandling.STOP_ON_FAILURE)

    'Get the Data Value'
    def val = 1

    'Create Project'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

    'Create a Team'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Team'), 
        [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Project_Name', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Team_Name', 1), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Team_Description', 1), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Team_Base_Site', 1)], FailureHandling.STOP_ON_FAILURE)

    'switch to default content'
    WebUI.switchToDefaultContent()

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Main_Menu', index), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Sub_Menu', index)], FailureHandling.STOP_ON_FAILURE)

    'Navigate to Pagination Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for ProjectName element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/ProjectName_Obj'), 
        GlobalVariable.Element_Timeout)

    'Set the Project Name'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/ProjectName_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Project_Name', index))

    'Wait for Select Business Unit to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Business_Unit_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Business Unit'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Business_Unit_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Business_Unit', index), false)

    'Wait for Show element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Show_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Show'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Show_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Show', index), false)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Project Link  to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Project_Link_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Project Link'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Project_Link_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Create Requirement'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Requirement'), 
        [('On_Behalf_Of') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'On_Behalf_Of', index), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Title', index), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Priority', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Description', index), ('Team_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Team_Name', index)], FailureHandling.STOP_ON_FAILURE)

    'Switch to Default Content'
    WebUI.switchToDefaultContent()

    'Switch to Conten frame '
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
        GlobalVariable.Element_Timeout)

    'Swicth to List filter frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Wait for Criteria field to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Criteria_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Criteria'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Criteria_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Criteria', index), false)

    'Wait for Keyword field to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Keyword_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Keyword'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Keyword_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Keyword', index))

    'Wait ID checkbox to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/ID_Obj'), 
        GlobalVariable.Element_Timeout)

    'Un-check ID checkbox'
    WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/ID_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait Title checkbox to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Title_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Check title checkbox'
    WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Title_Checkbox_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for select Type option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_State_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select State'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_State_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'State', index), false)

    'Wait for select Type option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Type_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Type'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Type_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Type', index), false)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to Default Content'
    WebUI.switchToDefaultContent()

    'Switch to Conten frame '
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
        GlobalVariable.Element_Timeout)

    'Switch to list display frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Wait for select all checkbox option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_All_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select all values from the table'
    WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_All_Checkbox_Obj'))

    'Switch to Default Content'
    WebUI.switchToDefaultContent()

    'Switch to Conten frame '
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
        GlobalVariable.Element_Timeout)

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for Edit and Change State option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Edit_And_ChangeState_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Edit and Change State option'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Edit_And_ChangeState_Obj'))

    'Switch to window '
    WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Window_Title', 2))

    'Mazimize window'
    WebUI.maximizeWindow()

    'Switch to page content frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Description field to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Description_Obj'), 
        GlobalVariable.Element_Timeout)

    'Edit Description '
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Description_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Edit_Description', index))

    'Wait for select priority option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Edit_Priority_Obj'), 
        GlobalVariable.Element_Timeout)

    'Edit Priority'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Edit_Priority_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Edit_Priority', index), false)

    'Swich to default content'
    WebUI.switchToDefaultContent()

    'Wait Done btn to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Done Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Switch to Default Content'
    WebUI.switchToDefaultContent()

    'Switch to Conten frame '
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
        GlobalVariable.Element_Timeout)

    'Switch to list display frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Wait for select all checkbox option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_All_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select all values from the table'
    WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_All_Checkbox_Obj'))

    'Switch to Default Content'
    WebUI.switchToDefaultContent()

    'Switch to Conten frame '
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
        GlobalVariable.Element_Timeout)

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for Edit and Change State option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Edit_And_ChangeState_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Edit and Change State option'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Edit_And_ChangeState_Obj'))

    'Switch to window '
    WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Window_Title', 2))

    'Mazimize window'
    WebUI.maximizeWindow()

    'Switch to page content frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Get Description '
    String Actual_Description = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Description_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Trim getting actual text'
    String Actual_Description1 = Actual_Description.trim()

    'Verify Actual description and Expected description matched'
    WebUI.verifyMatch(Actual_Description1, findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Edit_Description', index), false, FailureHandling.CONTINUE_ON_FAILURE)

    'Get Priority'
    String Actual_Priority = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Verify_Prioriy_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Verify Actual Priority and Expected Priority matched'
    WebUI.verifyMatch(Actual_Priority, findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Edit_Priority', index), false, FailureHandling.CONTINUE_ON_FAILURE)

    'Close window title'
    WebUI.closeWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
            'Window_Title', 2))

    'Switch to default content'
    WebUI.switchToDefaultContent()

    'Switch to Conten frame '
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
        GlobalVariable.Element_Timeout)

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for delete requirement option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Delete_Option_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on delete option'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Delete_Option_Obj'))

    'Accept Aleart'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Accept Aleart'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Delete created team'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Delete_Team'), 
        [('Expected_Team') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Approved_State_TestData').getValue(
                'Team_Name', 1)], FailureHandling.STOP_ON_FAILURE)

    'Close the browser'
    WebUI.closeBrowser()
}

