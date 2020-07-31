import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.switchToDefaultContent()

'Calling test case to Navigate to MProjecty Desk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Calling test case to Navigate to BCM -> Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigate_Projects'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue('MainMenu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue('SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Calling test case to create a project '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : '', ('ProjectName') : ProjectName
        , ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue(
            'Abbreviation', 2), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue(
            'BusinessUnit', 2), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue(
            'ProjectOwner', 2), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue(
            'AssociateSchema', 2), ('TC_Name_Path1') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(0)

'Calling test case to Navigate to MProjecty Desk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Calling test case to Navigate to BCM -> Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigate_Projects'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue('MainMenu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue('SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Adding delay'
WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), 0)

'Verify Projects window/page is opened\r\n'
WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Page_Projects'), 0)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListFilter'), [:], FailureHandling.STOP_ON_FAILURE)

'Verfiy input field for Project Name is present'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/input_Search_ProjectName'), 
    0)

'Enter the newly created project\'s name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/input_Search_ProjectName'), ProjectName)

'Verify find button is present'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Button_Find'), 0)

'Click on find button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Button_Find'))

'Adding delay'
WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_ListDispaly'), [:], FailureHandling.STOP_ON_FAILURE)

'creating dynamic xpath for project name'
String ProjectXpath = ('//td//a[contains(text(),"' + ProjectName) + '")]'

'creating dynamic xpath for project name\r\n'
TestObject Project_Name = new TestObject('objectName')

'creating dynamic xpath for project name'
Project_Name.addProperty('xpath', ConditionType.EQUALS, ProjectXpath)

'Verify newly created project is displayed\r\n'
WebUI.verifyElementPresent(Project_Name, GlobalVariable.Wait_Time)

'Click on new project name'
WebUI.click(Project_Name)

'Adding delay'
WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(Project_Header, GlobalVariable.Wait_Time)

'Click on project name on the top left corner'
WebUI.click(Project_Header)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Naviagate_to_Project_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Project_Navigation_Frame/BCMProjectProperties_Frame'), GlobalVariable.Element_Timeout)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Verify Action Button not present'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.STOP_ON_FAILURE)

'Verify Action Button not present'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'))

WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/EditPage_BugDefaultView'), 
    GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/BugView_Radio1'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/BugView_Radio2'), GlobalVariable.Wait_Time)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/BugView_Radio2'), FailureHandling.STOP_ON_FAILURE)

boolean result = WebUI.verifyElementChecked(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/BugView_Radio2'), 
    GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Button_Done'), FailureHandling.STOP_ON_FAILURE)

'Adding delay'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

WebUI.switchToDefaultContent()

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(Project_Header, GlobalVariable.Wait_Time)

'Click on project name on the top left corner'
WebUI.click(Project_Header)

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_BCMProjectProperties'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Bug Default View'), GlobalVariable.Wait_Time)

'Verify PROC short view in Project properties view'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/FullView'), GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Inbox'), GlobalVariable.Short_Wait)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Inbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Inbox_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create BCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Bug element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Bug_Obj'), GlobalVariable.Element_Timeout)

'Click on Bug'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Bug_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.verifyElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Full_view'), GlobalVariable.Wait_Time)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_Project'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_Team'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Severity'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_Title'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_Description'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_Found While Doing'), 
    GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Filed_Loc_found'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Submitter_CreateBug'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_field on object'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_AssignedToFix'), GlobalVariable.Wait_Time)

WebUI.verifyElementVisible(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_AssignedToVerify'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Field_Classification'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Button_Cancel_bug'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Button_Cancel_bug'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

WebUI.switchToDefaultContent()

