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

'Login to CDDS Application or navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue('Main_Menu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Project_Name', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Team_Name', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Team_Description', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Team_Base_Site', val)], FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue('Main_Menu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Page navigation Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue('Project_Name', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Project Link  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Project_Link_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Project Link'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Project_Link_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for team tab to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Team_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Team tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Team_Tab_Obj'))

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
String TeamName = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
    'Team_Name', 1)

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
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Membership_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on membership tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Membership_Tab_Obj'))

'Switch to BCM Project team member frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Iframe_BCMProjectTeamMembersAccessGroups'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Actions'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Actions_Btn_Obj'))

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/AddMember_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/AddMember_Obj'))

'Switch ti window title or new window'
WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
        'Window_Title', 1))

'Maximize new window'
WebUI.maximizeWindow()

'Call Incident_Bug_Add_Members test case'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Master/Incident_Bug_add_Members'), [('index') : 1], 
    FailureHandling.STOP_ON_FAILURE)

'wait few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Call Incident_Bug_Add_Members test case'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Master/Incident_Bug_add_Members'), [('index') : 2], 
    FailureHandling.STOP_ON_FAILURE)

'wait few seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetails frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to Team member access group frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Iframe_BCMProjectTeamMembersAccessGroups'), 
    GlobalVariable.Element_Timeout)

'Switch to List Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Get first User id'
String ActualUserId1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/UserID1_Obj'))

'Trim Geting First UserID'
String Actual_UserId1 = ActualUserId1.trim()

'Print irst user id'
println(Actual_UserId1)

'Verify Actual and Expected Userid match'
WebUI.verifyMatch(Actual_UserId1, findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
        'Person_ID', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Second User id'
String ActualUserId2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/UserID2_Obj'))

'Trim Geting Second UserID'
String Actual_UserId2 = ActualUserId2.trim()

'Print second user id'
println(Actual_UserId2)

'Verify Actual and Expected Userid match'
WebUI.verifyMatch(Actual_UserId2, findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue(
        'Person_ID', 2), false, FailureHandling.CONTINUE_ON_FAILURE)

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

'Getting Dynamic xpath of Particular radio button'
String Select_RadioBtn = ('//a[contains(.,"' + TeamName) + '")]/../..//input'

'Create Dynamic object for Radio button'
TestObject RadioBtn = new TestObject('objectName')

'Add xpath to object'
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
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Delete Option element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Delete_Option_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Delete Option'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Delete_Option_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'wait few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Accept aleart popup'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Close the browser'
WebUI.closeBrowser()

