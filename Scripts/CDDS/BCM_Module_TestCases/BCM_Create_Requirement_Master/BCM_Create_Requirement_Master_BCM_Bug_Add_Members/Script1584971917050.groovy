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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testdata.InternalData as InternalData

'Login to CDDS Application or navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Project_Name', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Team_Name', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Team_Description', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Team_Base_Site', val)], FailureHandling.STOP_ON_FAILURE)

'Switch to fefault content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
        'Project_Name', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Project Link  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Project_Link_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Project Link'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Project_Link_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for team tab to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Team_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Team tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Team_Tab_Obj'))

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
String TeamName = GetTeam

'Dynamic Xpath of created team name'
String Createdteam_Xpath = ('(//input[@name="emxTableRowId"])/../../td//a[contains(.,"' + TeamName) + '")]'

//('//div[@class="modal-body"]//label[contains(.,"'+ Str) + '")]'
'Dynamic object of created team name'
TestObject Getteamname = new TestObject('objectName')

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

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Membership_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Membership_Tab_Obj'))

'Switch to Team member access group frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectTeamMembersAccessGroups'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Actions'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'))

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/AddMember_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/AddMember_Obj'))

'Switch ti window title or new window'
WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
        'Window_Title', 1))

'Maximize new window'
WebUI.maximizeWindow()

'Get the Create_Requirement Add person data request from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Select type to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Select_Type_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select type'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Select_Type_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Type', index), false)

    'Wait for UserID field element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/UserId_Field_Obj'), 
        GlobalVariable.Element_Timeout)

    'Set UserID'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/UserId_Field_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Person_ID', index))

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Find_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Member access to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Select_MemberAcces_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Member Access '
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Select_MemberAcces_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
            'Member_Access', index), false)

    'Wait for Select Member Checkbox to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Select_Member_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Member'
    WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Select_Member_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    if (index == 1) {
        'Wait for Apply and SelectMore btn element to be visible'
        WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Apply_SelectMore_Btn_Obj'), 
            GlobalVariable.Element_Timeout)

        'Click on Apply and SelectMore'
        WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/Apply_SelectMore_Btn_Obj'), 
            FailureHandling.STOP_ON_FAILURE)
    } else {
        'Wait for Submit btn element to be visible'
        WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Submit_Btn_Obj'), 
            GlobalVariable.Element_Timeout)

        'Click on Submit btn'
        WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Submit_Btn_Obj'), 
            FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetails frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to Team member access group frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectTeamMembersAccessGroups'), 
    GlobalVariable.Element_Timeout)

'Switch to List Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Get first User id'
String ActualUserId1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/UserID1_Obj'))

'Trim Geting First UserID'
String Actual_UserId1 = ActualUserId1.trim()

'Verify Actual and Expected Userid match'
WebUI.verifyMatch(Actual_UserId1, findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
        'Person_ID', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Second User id'
String ActualUserId2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_Objects/UserID2_Obj'))

'Trim Geting Second UserID'
String Actual_UserId2 = ActualUserId2.trim()

'Verify Actual and Expected Userid match'
WebUI.verifyMatch(Actual_UserId2, findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_BCM_Bug_Add_Members_TestData').getValue(
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

