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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'ProjectName', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'ProjectAbbreviation', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'BusinessUnit', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'ProjectOwner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'AssociateSchema', val), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'TC_Name_Path1', val), ('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'TC_Name_Path', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'ProjectName', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'TeamName', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'TeamDescription', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'TeamBaseSite', val)], FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
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
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/BCM_Select_Radio_Obj'), 
    GlobalVariable.Element_Timeout)

'Select the BCMRadio select'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/BCM_Select_Radio_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Member Access element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/MemberAccess_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Member Access'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/MemberAccess_Obj'))

'Add Member '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Bug_Add_Member'), [('SetMember') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
            'SetMember', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to list filter frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for MemberType element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Member_Type_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Member Type as Person'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Member_Type_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue('MemberType', 1), false)

'Wait for SearchUserId element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Search_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the SearchUserId'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Search_UserId_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue('SetMember', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Buttton element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Find_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to ListDisplay  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for VerifyMemberId element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Verify_MemberId_Obj'), 
    GlobalVariable.Element_Timeout)

'Get VerifyMemberId '
ActualMemberId1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Verify_MemberId_Obj'))

'Verify  Equal ActualVerifyMemberId with Expected MemberId'
WebUI.verifyEqual(ActualMemberId1, findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
        'SetMember', 1))

WebUI.closeBrowser()

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/ProjectName_Obj'), findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue(
        'ProjectName', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Add_Members_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Get the Project Name from TestData File'
def ProjectName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Add_Members').getValue('ProjectName', 
    1)

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

'Switch to Default Content'
WebUI.switchToDefaultContent()

//String SubMenuXpath = ('//label[text()="' + SubMenu) + '"]'
'creating a ProjectNameLink dynamic xpath'
String ProjectNameLinkXpath = ('(//label[text()="' + ProjectName) + '"])[1]'

'creating the ProjectNameLink xpath object'
TestObject ProjectNameLinkObj = new TestObject('objectName')

'adding property in ProjectNameLink dynamic xpath'
ProjectNameLinkObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameLinkXpath)

'Wait for ProjectNameLink  element to be visible'
WebUI.waitForElementVisible(ProjectNameLinkObj, GlobalVariable.Element_Timeout)

'Click on ProjectNameLink'
WebUI.click(ProjectNameLinkObj)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Action_Default_Obj'), GlobalVariable.Element_Timeout)

'Verfiy Action Default'
WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Action_Default_Obj'), GlobalVariable.Element_Timeout)

'Switch to Default content'
WebUI.switchToDefaultContent()

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), FailureHandling.STOP_ON_FAILURE)

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
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/BCM_Select_Radio_Obj'), 
    GlobalVariable.Element_Timeout)

'Select the BCMRadio select'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/BCM_Select_Radio_Obj'))

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

WebUI.closeBrowser()

