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

'login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till project name is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Assign a value to string'
String name = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Name', 1)

'Enter project name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Search_Name', 1))

'wait for find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a project dynamic xpath'
String projectXpath = ('//a[contains(.,"' + name) + '")]'

'creating the project xpath object'
TestObject projectObj = new TestObject('objectName')

'adding property in project dynamic xpath'
projectObj.addProperty('xpath', ConditionType.EQUALS, projectXpath)

'Wait for PROJECT  element to be visible'
WebUI.waitForElementVisible(projectObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  project element '
WebUI.scrollToElement(projectObj, GlobalVariable.Element_Timeout)

'Click on project'
WebUI.click(projectObj, FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for project  element to be visible'
WebUI.waitForElementVisible(projectObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Wait for team to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Team_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Click on team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Team_Obj'), FailureHandling.STOP_ON_FAILURE)

'switch to frame\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Edit_Functionality_Master/Create_Incident/Unique1_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for adminstration to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Administration_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on administration'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Administration_Obj'), FailureHandling.STOP_ON_FAILURE)

'switch to frame\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on unique'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Edit_Functionality_Master/Create_Incident/Unique1_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for membership to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Membership_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'scroll to membership to be visible'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Membership_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.STOP_ON_FAILURE)

'clicko on membership'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Membership_Obj'))


'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/BCMProjectTeamMembersAccessGroup_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'click Actions button element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add_member button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Add_member_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Add_member'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Add_member_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue('Title', 
        1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)


'Wait for type  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Type_Obj'), GlobalVariable.Element_Timeout)

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Type_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue('Type', 1), false)

'Wait for userid to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Userid_Obj'), GlobalVariable.Element_Timeout)

'scroll to userid'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Userid_Obj'), GlobalVariable.Wait_Time)

'Enter userid'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Userid_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue(
        'UserId_Search', 1))

'Wait for find button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Find_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Wait till project name is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Wait till project name is visible\r\n'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for MemberAccessSelect to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/MemberAccessSelect_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Select MemberAccessSelect'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/MemberAccessSelect_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue('Member_Access', 1), false, FailureHandling.OPTIONAL)

'Wait for first row to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), FailureHandling.OPTIONAL)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for apply and select more button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Apply and Select More_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on apply and select more button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Apply and Select More_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)
'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for type button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Type_Obj'), GlobalVariable.Element_Timeout)

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Type_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue('Type', 1), false)

'Wait for userid  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Userid_Obj'), GlobalVariable.Element_Timeout)

'scroll to userid to be visible'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Userid_Obj'), GlobalVariable.Wait_Time)

'Enter userid'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Userid_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue(
        'UserId', 1))

'Wait for find button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/Find_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Wait till project name is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Wait till project name is visible\r\n'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for fistrow button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), FailureHandling.OPTIONAL)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for submit button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Submit_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on submit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Submit_Btn_Obj'))
'Wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)
'click on ok'
WebUI.acceptAlert(FailureHandling.OPTIONAL)
'Close window'
WebUI.closeWindowIndex(1)
'Switch to window'
WebUI.switchToWindowIndex(0)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/BCMProjectTeamMembersAccessGroup_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)
'verify member'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/Verify member'), [('member') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)
'verify member'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/Verify member'), [('member') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Add_Team_AddMembers').getValue(
            'Member_Access', 1)], FailureHandling.STOP_ON_FAILURE)

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

