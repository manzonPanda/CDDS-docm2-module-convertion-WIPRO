import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/* '
*/
'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
            'Menu1', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Set random value'
String random_number = RandomStringUtils.randomNumeric(3)

'set the abberivation'
String abberivation = 'Project_Aberivation_' + random_number

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Enter the project'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Project_Name_Obj'), 
    Project_Name)

'Select the BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/OwningBU_obj'), 
    BU, false, FailureHandling.OPTIONAL)

'Select the project'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Projects_Obj'), 
    Select_project, false)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Find_btn_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a sProjectOwnerXpath dynamic xpath'
String ProjectOwnerXpath = ('//a[contains(.,"' + Project_Name) + '")]'

'creating the Select ProjectOwner xpath object'
TestObject ProjectOwnerObj = new TestObject('objectName')

'adding property in Select ProjectOwner dynamic xpath'
ProjectOwnerObj.addProperty('xpath', ConditionType.EQUALS, ProjectOwnerXpath)

'Wait for  Select ProjectOwner  element to be visible'
WebUI.waitForElementVisible(ProjectOwnerObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

if (WebUI.waitForElementNotPresent(ProjectOwnerObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
    'Switch to default'
    WebUI.switchToDefaultContent()

    'Navigate to project'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : Project_Name, ('ProjectAbbreviation') : abberivation
            , ('BusinessUnit') : BU, ('ProjectOwner') : Owner, ('AssociateSchema') : Schema], FailureHandling.STOP_ON_FAILURE)

    'Switch to window index 0'
    WebUI.switchToWindowIndex(0)

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Wait for loading img not present'
    WebUI.waitForElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Loading_Obj'), 
        GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for  Select ProjectOwner  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Project_Name_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Set the project name'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Project_Name_Obj'), 
        Project_Name)

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Wait for  Select ProjectOwner  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Projects_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Select the project'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Projects_Obj'), 
        Select_project, false, FailureHandling.OPTIONAL)

    'Click on find'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Find_btn_Obj'))

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for  Select ProjectOwner  element to be visible'
    WebUI.waitForElementVisible(ProjectOwnerObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)
}

'Wait for  Select ProjectOwner  element to be visible'
WebUI.waitForElementVisible(ProjectOwnerObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on Select ProjectOwner'
WebUI.click(ProjectOwnerObj, FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

/*not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
not_run: WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
not_run: WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
not_run: WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/BCMProjectTeamMembers_iframe'), 
    GlobalVariable.Element_Timeout)

'Switch to frame'
not_run: WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)
*/
'click on inbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Inbox_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'wait for criteria'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Criteria_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Criteria as exact match'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Criteria_Obj'), 
    Criteria, false, FailureHandling.OPTIONAL)

'Enter keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Keyword_Obj'), 
    Keyword)

'Click on ID chcek box'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/ID_checkbox_Obj'))

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Type_Obj'), 
    Type, false)

'Select statecheck'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/StateCheck_Obj'), 
    State_type, false)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Find_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'creating a IncidentXpath dynamic xpath'
String incidentXpath = ('//*[contains(text(),"' + Title_Incident) + '")]'

'creating the Select incident xpath object'
TestObject IncidentObj = new TestObject('objectName')

'adding property in Select incident dynamic xpath'
IncidentObj.addProperty('xpath', ConditionType.EQUALS, incidentXpath)

'wait till BCM action is visible'
WebUI.waitForElementNotPresent(IncidentObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'verifyBCM action is visible'
WebUI.verifyElementVisible(IncidentObj, FailureHandling.OPTIONAL)

'If BCM action is not visible create action'
if (WebUI.waitForElementNotPresent(IncidentObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Edit_Functionality_Master/Create_Incident'), 
        [('Priority') : Priority_Incident, ('Title') : Title_Incident, ('Description') : Description_Incident], FailureHandling.STOP_ON_FAILURE)

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Navigate to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
        GlobalVariable.Wait_Time)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
        GlobalVariable.Wait_Time)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
        GlobalVariable.Wait_Time)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

    'Wait for find button\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Find_btn_Obj'), 
        GlobalVariable.Wait_Time)

    'Click on find'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Find_btn_Obj'))

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Wait_Time)

    'Click on find'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Find_btn_Obj'), 
        FailureHandling.OPTIONAL)
}

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'creating a IncidentXpath dynamic xpath'
String checkboxXpath = ('//*[contains(text(),"' + Title_Incident) + '")]/..//input[@name="emxTableRowId"]'

'creating the Select incident xpath object'
TestObject IncidentcheckboxObj = new TestObject('objectName')

'adding property in Select incident dynamic xpath'
IncidentcheckboxObj.addProperty('xpath', ConditionType.EQUALS, checkboxXpath)

'wait till BCM action is visible'
WebUI.waitForElementVisible(IncidentcheckboxObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'verifyBCM action is visible'
WebUI.click(IncidentcheckboxObj, FailureHandling.STOP_ON_FAILURE)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Edit button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Edit_ State_Obj'), 
    GlobalVariable.Wait_Time)

'Click on  Edit button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Edit_ State_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to window'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait for type to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMPriority_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMPriority_Obj'), 
    Priority_Incident, false, FailureHandling.OPTIONAL)

'wait for Classification to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMClassification_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Select Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMClassification_Obj'), 
    Classification, false, FailureHandling.OPTIONAL)

'wait for description to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMDescription_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Enter the description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMDescription_Obj'), 
    Description_Incident, FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

