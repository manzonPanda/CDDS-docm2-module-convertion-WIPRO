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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create project\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'TC_Name_Path', 1), ('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'AssociateSchema', 1), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'TC_Name_Path1', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'TeamName', 1), ('TeamDescription') : '', ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'TeamSite', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Member Access element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/MemberAccess_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Member Access'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/MemberAccess_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Member Access element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/AccessSecurity_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Member Access'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/AccessSecurity_Obj'))

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersSecurity_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/AddAccess_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/AddAccess_Obj'))

WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
        'Window', 1))

WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Name_Txtbox_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Name_Txtbox_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
        'TextName', 1))

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/Find_Btn_New_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/Find_Btn_New_Obj'))

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/Team_Select_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/Team_Select_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
        'TeamName', 1), false)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/AccessTypeSelect_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/AccessTypeSelect_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
        'AccessTypeSelect', 1), false)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/GroupName_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/GroupName_Checkbox_Obj'))

WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Submit_Button_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Submit_Button_Obj'))

WebUI.waitForElementNotVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Loading_obj'), 
    10)

WebUI.closeBrowser()

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'LoginID', 2)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
        'BusinessUnit', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue('ProjectName', 
        1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectFilter_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectFilter_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
        'ProjectFilter', 2), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the project name from data file'
String project = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Grant_Special_Access_To_Members_Datafile').getValue(
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

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'If Verify Menu Expanded is not visible'
if (!(WebUI.verifyElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/BCM_GroupCollapsed_obj'), 
    FailureHandling.OPTIONAL))) {
    'Wait for Mainmenu  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/BCM_GroupCollapsed_obj'), 
        GlobalVariable.Element_Timeout)

    'Click on MainMenu'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/BCM_GroupCollapsed_obj'))
} else {
}

'Wait for BCM Incident object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/BCM_Incident_obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM incident object'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Grant_Special_Access_To_Members_Objects/BCM_Incident_obj'))

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Wait for BCM Incident object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM incident object'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.acceptAlert()

'Wait for BCM Incident object to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Cancel_Button_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM incident object'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Cancel_Button_Obj'))

WebUI.closeBrowser()

