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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create project\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'TC_Name_Path', 1), ('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'AssociateSchema', 1), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'TC_Name_Path1', 1)], FailureHandling.STOP_ON_FAILURE)

'create team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'TeamName', 1), ('TeamDescription') : '', ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
            'TeamSite', 1)], FailureHandling.STOP_ON_FAILURE)

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
String TeamName = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
    'TeamName', 1)

'Dynamic Xpath of created team name'
String Createdteam_Xpath = ('(//input[@name="emxTableRowId"])/../../td//a[contains(.,"' + TeamName) + '")]'

//('//div[@class="modal-body"]//label[contains(.,"'+ Str) + '")]'
'Dynamic object of created team name'
TestObject Getteamname = new TestObject('objectName')

'Add xpath team object'
Getteamname.addProperty('xpath', ConditionType.EQUALS, Createdteam_Xpath)

'Click on team name'
WebUI.click(Getteamname)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetails frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Membership tab element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Membership_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on membership tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Membership_Tab_Obj'))

'Switch to BCM Project team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessGroups_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/BCMActions_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Actions'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/BCMActions_obj'))

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/AddMember_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/AddMember_Obj'))

'Switch ti window title or new window'
WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'Window_Title', 1))

'Maximize new window'
WebUI.maximizeWindow()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for name field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Name_Txtbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Set person name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Name_Txtbox_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue('PersonName', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Member access to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Select_MemberAcces_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Member Access '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Select_MemberAcces_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'Member_Access', 1), false)

'Wait for Select Member Checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Select_Member_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Member'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Select_Member_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'delay'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Submit btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Submit_Button_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Submit btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Submit_Button_Obj'), FailureHandling.STOP_ON_FAILURE)

'close browser'
WebUI.closeBrowser()

'delay'
WebUI.delay(GlobalVariable.Wait_Time)

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

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BU element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    GlobalVariable.Element_Timeout)

'select business unit to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'BusinessUnit', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue('ProjectName', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the project name from data file'
String project = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
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

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM project inbox frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for create bug tab element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/CreateBug_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on create bug tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/CreateBug_Tab_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'create bug'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Create_Bug_Generic'), [('val') : 2], FailureHandling.STOP_ON_FAILURE)

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

'Switch to BCM inbox  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Switch list filter frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for keyword element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Keyword_Object'), 
    GlobalVariable.Element_Timeout)

'set keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Keyword_Object'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Title', 
        2))

'Wait for title checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Titlecheckbox_Obj'), 
    GlobalVariable.Element_Timeout)

'check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Titlecheckbox_Obj'))

'Wait for find button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'click find button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'))

'delay'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM project inboc Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Switch list Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Search result team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search team'
ActualTeamName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Team_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search team'
println(ActualTeamName.trim())

'Verify Equal Actual team with expected team'
WebUI.verifyEqual(ActualTeamName.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'TeamName', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Get the Actual Search title'
ActualTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Title_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search title'
println(ActualTitle.trim())

'Verify Equal Actual title with expected title'
WebUI.verifyEqual(ActualTitle.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'Title', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Get the Actual Search severity'
ActualSeverity = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Verify_Severity_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search severity'
println(ActualSeverity.trim())

'Verify Equal Actual severity with expected severity'
WebUI.verifyEqual(ActualSeverity.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'Severity', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Get the Actual Search submitter'
ActualSubmitter = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/Verify_Submitter_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search submitter'
println(ActualSubmitter.trim())

'Verify Equal Actual submitter with expected submitter'
WebUI.verifyEqual(ActualSubmitter.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'Submitter', 1), FailureHandling.CONTINUE_ON_FAILURE)

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

'Switch to BCM project inbox Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for BCM action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/BCMActions_obj'), 
    GlobalVariable.Element_Timeout)

'click on action'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/BCMActions_obj'))

'Wait for edit state element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Edit_ChangeState_Obj'), 
    GlobalVariable.Element_Timeout)

'click on edit state'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Edit_ChangeState_Obj'))

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Title_Obj'), 
    GlobalVariable.Element_Timeout)

'get the actual search title'
ActualBugTitle = WebUI.getAttribute(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Title_Obj'), 
    'value')

'print the actual title'
println(ActualBugTitle.trim())

'Verify Equal Actual title with expected title'
WebUI.verifyEqual(ActualBugTitle.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue(
        'Title', 2), FailureHandling.OPTIONAL)

'Wait for state element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/State_obj'), 
    GlobalVariable.Element_Timeout)

'select state'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/State_obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'State', 1), false)

'Wait for BCM assignee element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/BCMAssignee_Obj'), 
    GlobalVariable.Element_Timeout)

'set the BCM assignee name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_Project_Member_Objects/BCMAssignee_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_with_Project_Member_Datafile').getValue(
        'PersonName', 1))

'delay'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/DropDownName_Click_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the required assgnee name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/DropDownName_Click_Obj'))

'switch to default'
WebUI.switchToDefaultContent()

'Wait for Done button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'click on done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'))

'close browser'
WebUI.closeBrowser()



