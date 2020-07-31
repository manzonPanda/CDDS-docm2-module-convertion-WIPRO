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

'Login to CDDS Application or navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Project_Name', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Team_Name', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Team_Description', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Team_Base_Site', val)], FailureHandling.STOP_ON_FAILURE)

'Get the Create_Requirement request from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'switch to default content'
    WebUI.switchToDefaultContent()

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
                'Main_Menu', index), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
                'Sub_Menu', index)], FailureHandling.STOP_ON_FAILURE)

    'switch to default content'
    WebUI.switchToDefaultContent()

    'Switch to Main Window'
    WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Window_Title', 1))

    'Navigate to Pagination Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for ProjectName element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/ProjectName_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter the Project Name'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/ProjectName_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Project_Name', index))

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Project Link  to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Project_Link_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Project Link'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Project_Link_Obj'), 
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

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for Create BCM element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Create BCM'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for Requirements element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Requirement_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Requirements '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Requirement_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Switch to page content frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for On Behalf of element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/On_Behalf_Of_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter On Behalf of value'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/On_Behalf_Of_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'On_Behalf_Of', index))

    'Wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Wait for On behalf of person name to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on On behalf of person name'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for Title field to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Title_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Title'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Title_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Title', index))

    'Wait for select priority option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_Priority_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Priority'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_Priority_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Priority', index), false)

    'Wait for Target date icon to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Target_Date_Icon_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Target date icon'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Target_Date_Icon_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Wait for date to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_Date_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on the date'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_Date_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for Description field to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Description_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Description '
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Description_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Description', index))

    'Wait for select Team option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_Team_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Team'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_Team_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Team', index), false)

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

    'Swicth to List filter frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Wait for Keyword field to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Keyword_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Keyword'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Keyword_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Title', index))

    'If create requirement is project owner then check ID Checkbox'
    if (index == 3) {
        'Wait ID checkbox to be visible'
        WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/ID_Obj'), 
            GlobalVariable.Element_Timeout)

        'check ID checkbox'
        WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/ID_Obj'), 
            FailureHandling.STOP_ON_FAILURE)
    } else {
        'Wait ID checkbox to be visible'
        WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/ID_Obj'), 
            GlobalVariable.Element_Timeout)

        'Un-check ID checkbox'
        WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/ID_Obj'), 
            FailureHandling.STOP_ON_FAILURE)
    }
    
    'Wait Title checkbox to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Title_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Check title checkbox'
    WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Title_Checkbox_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Wait for select Type option visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_State_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select State'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Select_State_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'State', index), false)

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

    'Get Team name'
    String Actual_TeamName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Get_TeamName_Obj'))

    'Triming getting team name'
    String Actual_TeamName1 = Actual_TeamName.trim()

    'Verify the team name matched'
    WebUI.verifyMatch(Actual_TeamName1, findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Team', index), false, FailureHandling.CONTINUE_ON_FAILURE)

    'Get Title'
    String Actual_Title = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Get_Title_Obj'))

    'Triming getting Title'
    String Actual_Title1 = Actual_Title.trim()

    'Verify the Title matched'
    WebUI.verifyMatch(Actual_Title1, findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_State_Validation_Create_Requirement_for_all_access_roles_TestData').getValue(
            'Title', index), false, FailureHandling.CONTINUE_ON_FAILURE)

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

    'Wait for delete requirement option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Delete_Requirement_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on delete option'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Delete_Requirement_Obj'))

    'Accept Aleart'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Accept Aleart'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)
}

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for team tab to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Team_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Team tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Team_Tab_Obj'))

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM Project Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to list details frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Created get team name'
String TeamName = GetTeam

'Getting Dynamic xpath of Particular radio button'
String Select_RadioBtn = ('//a[contains(.,"' + TeamName) + '")]/../..//input'

'Create Dynamic object for Radio button'
TestObject RadioBtn = new TestObject('objectName')

RadioBtn.addProperty('xpath', ConditionType.EQUALS, Select_RadioBtn)

'Click on radio button'
WebUI.click(RadioBtn)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM Project Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Delete Option element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Delete_Requirement_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Delete Option'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Delete_Requirement_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(2)

'Accept aleart popup'
WebUI.acceptAlert()

'Close the browser'
WebUI.closeBrowser()

