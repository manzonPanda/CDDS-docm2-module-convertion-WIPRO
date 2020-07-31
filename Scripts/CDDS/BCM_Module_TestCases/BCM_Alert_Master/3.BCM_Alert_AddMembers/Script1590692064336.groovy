import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Main Menu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Sub Menu', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue(
            'AssociateSchema', 1)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Team'), 
    [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('ProjectName', 1), ('TeamName') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('TeamName', 1), ('TeamDescription') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('TeamDescription', 1), ('TeamBaseSite') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('TeamBaseSite', 1)], FailureHandling.STOP_ON_FAILURE)

'switch to default content'
WebUI.switchToDefaultContent()

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Main Menu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Sub Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Project name'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('ProjectName', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Assign a value to string'
String Project = findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('ProjectName', 1)

'creating a IC dynamic xpath'
String ProjectNameXpath = ('//a[contains(.,"' + Project) + '")]'

'creating the SubMenu xpath object'
TestObject ProjectObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ProjectObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

WebUI.click(ProjectObj)

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/teams_tab'), 
    GlobalVariable.Wait_Time)

'Click on Teams tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Team_Inbox/teams_tab'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Wait_Time)

'Switch to list display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Assign a value to string'
String Team = findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Team').getValue('TeamName', 1)

'creating a IC dynamic xpath'
String TeamNameXpath = ('//a[contains(.,"' + Team) + '")]'

'creating the SubMenu xpath object'
TestObject TeamObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
TeamObj.addProperty('xpath', ConditionType.EQUALS, TeamNameXpath)

WebUI.click(TeamObj)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Click on Membership tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Membership'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessGroups'), GlobalVariable.Wait_Time)

'Click on Actions||Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Actions'))

'Click on Add members'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Add Members'))

WebUI.switchToWindowIndex(1)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'Select Type as Person'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Type'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue('Type', 1), false)

'Enter User id as x1049683'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/UserId'), findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue(
        'UserId', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Click on checkbox to select the member'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/SelectMember'))

'Select access as Member'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/MemberAccessSelect'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue('MemberAccess', 1), false)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Apply and select more'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Apply and Select More'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'Select Type as Person'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Type'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue('Type', 1), false)

'Enter User id as x1048749'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/UserId'), findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue(
        'UserId', 2))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Click on checkbox to select the member'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/SelectMember'))

'Select access as Member'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/MemberAccessSelect'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue('MemberAccess', 1), false)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Submit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Submit'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessGroups'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on Added Member1 XID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Verify_AddMember1'))

'Get text of Added Member1 XID'
member1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Verify_AddMember1'))

'Verify added member'
WebUI.verifyEqual(findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue('UserId', 1), 
    member1)

'Click on Added Member2 XID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Verify_AddMember2'))

'Get text of Added Member2 XID'
member2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Verify_AddMember2'))

'Verify added member'
WebUI.verifyEqual(findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_Alert_AddMembers').getValue('UserId', 2), 
    member2)

'Select Member1'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Delete_Member1'))

'Select Member2'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Delete_Member2'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessGroups'), GlobalVariable.Wait_Time)

'Click on Actions||Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Actions'))

'Click on Remove member'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Remove from Team'))

'Click on OK'
WebUI.acceptAlert()

WebUI.closeBrowser()

