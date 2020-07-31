import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('MainMenu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'BusinessGroup', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'AssociatedSchema', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'TeamName', 1), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'TeamDescription', 1), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'TeamBaseSiteSelect', 1)], FailureHandling.STOP_ON_FAILURE)

'switch to default content'
WebUI.switchToDefaultContent()

CucumberKW.comment('')

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('MainMenu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/BusinessUnit'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BusinessGroup', 
        1), false)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Project name'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('ProjectName', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Assign a value to string'
String Project = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
    'ProjectName', 1)

'creating a IC dynamic xpath'
String ProjectNameXpath = ('//a[contains(.,"' + Project) + '")]'

'creating the SubMenu xpath object'
TestObject ProjectObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ProjectObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Click on Project Link'
WebUI.click(ProjectObj)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on the Project name tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/ProjectName_tab'))

WebUI.comment('=========')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/ProjectActions_Navigation_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Actions||Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Actions'))

'Unable to click on Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Edit'))

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Yes is checked'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/CreateTask_No'), 
    3)

'Verify No is checked by default'
WebUI.verifyElementChecked(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/CreateTask_No'), 
    3)

'Click on Yes'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/CreateTask_Yes'))

WebUI.switchToDefaultContent()

'Click on Done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Done'))

'Create Requirement'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Requirement'), 
    [('On_Behalf_Of') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'OnBehalfOf', 1), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Title_Requirement', 1), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Priority_Requirement', 1), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Description_Requirement', 1), ('Team_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'TeamName', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Edit Requirement'), 
    [('Keyword1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Keyword', 1), ('Title1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Keyword', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on the Project name tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/ProjectName_tab'))

WebUI.comment('=========')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/ProjectActions_Navigation_frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Actions||Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Actions'))

'Unable to click on Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Edit'))

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Yes is checked'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/CreateTask_Yes'), 
    3)

'Verify Yes is checked'
WebUI.verifyElementChecked(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/CreateTask_Yes'), 
    3)

'Click on No'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/CreateTask_No'))

'Click on Done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Done'))

'Create Requirement'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Requirement'), 
    [('On_Behalf_Of') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'OnBehalfOf', 1), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Title_Requirement', 2), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Priority_Requirement', 1), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Description_Requirement', 1), ('Team_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'TeamName', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Edit Requirement'), 
    [('Keyword1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Keyword', 2), ('Title1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
            'Keyword', 2)], FailureHandling.STOP_ON_FAILURE)

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('5.Keyword-Requirement_Approved_State,Title-ON,Type-Requirement')

'Keyword as Requirement_Bug_State'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('Keyword', 2))

'Select Type as Bug'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('Type', 
        2), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Short wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get text from the table that no data found'
no_Data = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_No Matching Data found'))

WebUI.verifyEqual(no_Data, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue(
        'No data', 1))

WebUI.closeBrowser()

