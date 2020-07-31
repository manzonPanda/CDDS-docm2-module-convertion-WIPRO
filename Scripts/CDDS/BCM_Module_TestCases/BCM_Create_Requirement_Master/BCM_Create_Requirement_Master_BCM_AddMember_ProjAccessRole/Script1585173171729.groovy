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

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Name', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Team_Name', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Team_Description', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Team_Base_Site', val)], FailureHandling.STOP_ON_FAILURE)

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

'Wait for BCMElementsFill element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_Objects/BCM_Select_Radio_Obj'), 
    GlobalVariable.Element_Timeout)

'Select the BCMRadio select'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_Objects/BCM_Select_Radio_Obj'))

'Call generic TC addmemeber project access'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/AddMember_Project_Access'), [('MemberType') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Type', 1), ('SetMember') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Person_ID', 1), ('AccessType') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
            'Member_Access', 1)], FailureHandling.STOP_ON_FAILURE)

'Get User Access Type'
String Actual_AccessType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_Objects/Access_Type_Obj'))

'Trim Geting User Access type'
String Actual_Access_Type = Actual_AccessType.trim()

'Verify Actual and Expected Access Type matched'
WebUI.verifyMatch(Actual_Access_Type, findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_AddMember_ProjAccessRole_TestData').getValue(
        'Member_Access', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

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
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Delete_Option_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Delete Option'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Delete_Option_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(2)

'Accept aleart popup'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Close the browser'
WebUI.closeBrowser()

