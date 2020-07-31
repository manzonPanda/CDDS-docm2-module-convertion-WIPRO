import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'ProjectName', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'ProjectAbbreviation', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'BusinessUnit', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'ProjectOwner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'AssociateSchema', val), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'TC_Name_Path1', val), ('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'TC_Name_Path', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'ProjectName', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'TeamName', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'TeamDescription', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'TeamBaseSite', val)], FailureHandling.STOP_ON_FAILURE)

'Switch to Default'
WebUI.switchToDefaultContent()

'Wait for Member Access element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/MemberAccess_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Member Access'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/MemberAccess_Obj'))

'Add Member '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Bug_Add_Member'), [('SetMember') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'UserId', 2)], FailureHandling.STOP_ON_FAILURE)

'close the browser'
WebUI.closeBrowser()

'Get the Create User request from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'login to CDDS with Support Role'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
                'UserId', index)], FailureHandling.STOP_ON_FAILURE)

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
            , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

    'Navigate to Pagination Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for ProjectName element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/ProjectName_Obj'), 
        GlobalVariable.Element_Timeout)

    'Get the PrjectName from TestData'
    def ProjectName = findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
        'ProjectName', index)

    'Set the Project Name'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/ProjectName_Obj'), 
        ProjectName)

    'Wait forShow Project  element to be visible'
    not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Show_Project_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select a Project Type'
    not_run: WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Show_Project_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_all_access roles').getValue(
            'ShowProject', index), false)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Find_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'creating a Select ProjectNameXpath dynamic xpath'
    String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

    'creating the Select ProjectName xpath object'
    TestObject ProjectNameObj = new TestObject('objectName')

    'adding property in Select ProjectName dynamic xpath'
    ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

    'Wait for  Select ProjectName  element to be visible'
    WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

    'Click on Select ProjectName'
    WebUI.click(ProjectNameObj, FailureHandling.OPTIONAL)

    'Wait for Few Seconds'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Switch to Content frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Display Details Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Switch to BCMProjectInboxCommand frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

    'Wait for Actions element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on Actions'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

    'Wait for Create BCM  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Create_BCM_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Create BCM'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Create_BCM_Obj'))

    'Wait for Create BCM  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Action_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Create BCM'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Action_Obj'))

    'Navigate to Page Navigation Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Priority  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Select_Priority_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select the Priority'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Select_Priority_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'Priority', index), false)

    'Wait for Title element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Title_Obj'), 
        GlobalVariable.Element_Timeout)

    'Set the Title '
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Title_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'Title', index))

    'Wait for BCMDescription element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/BCMDescription_Obj'), 
        GlobalVariable.Element_Timeout)

    'Set the BCMDescription'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/BCMDescription_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'BCMDescription', index))

    'Wait for BCMRespondingTeam element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/BCMRespondingTeam_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select the BCMRespondingTeam'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/BCMRespondingTeam_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'TeamName', index), false)

    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Wait for Done  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Done_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Done'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Done_Btn_Obj'))

    'Wait for few Seconds'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Switch to Content frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Display Details Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Switch to BCM ProjectInboxCommand  frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

    'Switch to list filter  frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Wait for Keyword element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_Keyword_Obj'), 
        GlobalVariable.Element_Timeout)

    'Set the Keyword Value'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_Keyword_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'Title', index))

    'Wait for ID Checkbox element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_ID_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on ID UnCheck'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_ID_Checkbox_Obj'))

    'Wait for Title Checkbox element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_Title_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Title Checkbox'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_Title_Checkbox_Obj'))

    'Wait for Title Checkbox element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_Title_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Title Checkbox'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_Title_Checkbox_Obj'))

    'Wait for TypeSelect  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/TypeSelect_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select typeSelect as BCM_Action'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/TypeSelect_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'Type', index), false)

    'Wait for State element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_State_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select the State '
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Search_State_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'State', index), false)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Find_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Find btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Find_Btn_Obj'))

    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Switch to Content frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Display Details Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Switch to BCM ProjectInbox frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

    'Switch to list display frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Wait for Search result State element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Result_Title_Obj'), 
        GlobalVariable.Element_Timeout)

    'Get the Actual Title'
    ActualTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Result_Title_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Print Actual Title'
    println(ActualTitle)

    'Verify Equal ActualTitle with expected Title'
    WebUI.verifyEqual(ActualTitle.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'Title', index), FailureHandling.CONTINUE_ON_FAILURE)

    'Wait for Search Status  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Result_Status_Obj'), 
        GlobalVariable.Element_Timeout)

    'Get the ActualStatus'
    ActualStatus = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Result_Status_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Print ActualStatus'
    println(ActualStatus)

    'Verify Equal ActualStatus with expected Status'
    WebUI.verifyEqual(ActualStatus.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Create_Action_Master_TestData/BCM_State_Validation_Create_Action_with_different_states').getValue(
            'Status', index).trim(), FailureHandling.CONTINUE_ON_FAILURE)

    'Wait for radio bcm action element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Result_RadioSelect_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on bcm action radio '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Result_RadioSelect_Obj'))

    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Switch to Content frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Display Details Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/PortalDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Switch to BCMProjectInboxCommand frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

    'Wait for Actions element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on Actions'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

    'Wait for Delete element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Delete_Action_Obj'), 
        GlobalVariable.Element_Timeout)

    'Scroll to Delete element '
    WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Delete_Action_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Delete'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Delete_Action_Obj'))

    'Accept Alert'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Accept Alert'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)
}

'Switch to Default content'
WebUI.switchToDefaultContent()

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Teams_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/Teams_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

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
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/BCM_Select_Radio_Obj'), 
    GlobalVariable.Element_Timeout)

'Select the BCMRadio select'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_State_Validation_Create_Action_with_different_states/BCM_Select_Radio_Obj'))

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Delete_Team_Objects/Delete_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Delete_Team_Objects/Delete_Obj'), FailureHandling.STOP_ON_FAILURE)

'Accept the Alert '
WebUI.acceptAlert()

'Close Browser'
WebUI.closeBrowser()

