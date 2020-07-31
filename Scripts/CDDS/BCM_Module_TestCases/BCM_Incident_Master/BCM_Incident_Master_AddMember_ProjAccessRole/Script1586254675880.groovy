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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Project_Name', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Team_Name', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Team_Description', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
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

'Get team name from data file'
String Team = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
    'Team_Name', 1)

'create xpath'
String Created_Xpath = ('//table[@id="BCMProjectRelatedTeams"]//a[contains(.,"' + Team) + '")]'

'Print created xpath'
println(Created_Xpath)

'create teamlink object\r\n'
TestObject TeamLinkObj = new TestObject('objectName')

'Click team link object'
TeamLinkObj.addProperty('xpath', ConditionType.EQUALS, Created_Xpath)

'Wait for team link object element to be visible'
WebUI.waitForElementPresent(TeamLinkObj, GlobalVariable.Element_Timeout)

'Click TeamLink object'
WebUI.click(TeamLinkObj)

'Call generic TC addmemeber project access'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/AddMember_Project_Access'), [('MemberType') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Type', 1), ('SetMember') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Person_ID', 1), ('AccessType') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_AddMember_ProjAccessRole_TestData').getValue(
            'Member_Access', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the browser'
WebUI.closeBrowser()

