import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'TC_Name_Path', 1), ('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'AssociateSchema', 1), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'TC_Name_Path1', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for search BU element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    GlobalVariable.Element_Timeout)

'select business unit as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'BusinessUnit', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'ProjectName', 1))

'Wait for project filter element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectFilter_Obj'), 
    GlobalVariable.Element_Timeout)

'select the projct filter as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectFilter_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'ProjectFilter', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the project name from data file'
String project = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
    'ProjectName', 1)

'create xpath'
String Created_Xpath = ('//a[contains(.,"' + project) + '")]'

'Print the created xpath'
println(Created_Xpath)

'create new project object'
TestObject ProjectLinkObj = new TestObject('objectName')

'add xpath to object'
ProjectLinkObj.addProperty('xpath', ConditionType.EQUALS, Created_Xpath)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(ProjectLinkObj, GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(ProjectLinkObj)

'delay'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch BCM project  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for create bug button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/CreateBug_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on create bug Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/CreateBug_Tab_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'create bug'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Create_Bug_Generic'), [('val') : 1], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch BCM project   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Switch list filter  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for keyword element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Keyword_Object'), 
    GlobalVariable.Element_Timeout)

'set keyword text'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Keyword_Object'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'Title', 1))

'Wait for title checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Titlecheckbox_Obj'), 
    GlobalVariable.Element_Timeout)

'check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Titlecheckbox_Obj'))

'Wait for find button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'click on find button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'))

'dely'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch BCM project inbox  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Switch list Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Search result team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search team'
ActualProjectName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Team_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search team'
println(ActualProjectName.trim())

'Verify Equal Actual team with expected team'
WebUI.verifyEqual(ActualProjectName.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'TeamName', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Get the Actual Search title'
ActualTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Title_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search title'
println(ActualTitle.trim())

'Verify Equal Actual title with expected title'
WebUI.verifyEqual(ActualTitle.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'Title', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Get the Actual Search severity'
ActualSeverity = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Severity_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search severity'
println(ActualSeverity.trim())

'Verify Equal Actual severity with expected severity'
WebUI.verifyEqual(ActualSeverity.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'Severity', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for select checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'check the select checkbox'
WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch BCM project inbox  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for BCM actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/BCMActions_obj'), 
    GlobalVariable.Element_Timeout)

'click on actions button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/BCMActions_obj'))

'Wait for edit/change state element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Edit_ChangeState_Obj'), 
    GlobalVariable.Element_Timeout)

'click on edit/change state'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Edit_ChangeState_Obj'))

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for onbehalf element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/onBehalfof_Obj'), 
    GlobalVariable.Element_Timeout)

'get the actual onbehalf of value from UI'
Actual_Onbehalfof = WebUI.getAttribute(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/onBehalfof_Obj'), 
    'value')

'print the actual onbehalf value'
println(Actual_Onbehalfof.trim())

'Verify Equal Actual onbehalfof value with expected onbehalfof value'
WebUI.verifyEqual(Actual_Onbehalfof.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'OnbehalfVerify', 1), FailureHandling.OPTIONAL)

'close browser'
WebUI.closeBrowser()

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'LoginID', 2)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'MainMenu', 2), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
            'SubMenu', 2)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for keyword element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Keyword_Object'), 
    GlobalVariable.Element_Timeout)

'set ketwor text'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Keyword_Object'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'Title', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result projectname element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Table_ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search projectname'
ActualProjectName1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Table_ProjectName_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search projectname'
println(ActualProjectName1.trim())

'Verify Equal Actual projectname with expected projectname'
WebUI.verifyEqual(ActualProjectName1.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'ProjectName', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Table_Title_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search title'
ActualTitle1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Table_Title_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search title'
println(ActualTitle1.trim())

'Verify Equal Actual title with expected title'
WebUI.verifyEqual(ActualTitle1.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'Title', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result severity element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Table_Severity_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search severity'
ActualSeverity1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Table_Severity_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search severity'
println(ActualSeverity1.trim())

'Verify Equal Actual severity with expected severity'
WebUI.verifyEqual(ActualSeverity1.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Datafile').getValue(
        'Severity', 1), FailureHandling.CONTINUE_ON_FAILURE)

'close browser'
WebUI.closeBrowser()

