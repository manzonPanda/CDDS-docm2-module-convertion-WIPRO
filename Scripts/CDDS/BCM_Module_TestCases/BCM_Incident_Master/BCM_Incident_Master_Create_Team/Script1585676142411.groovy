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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Team').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Team').getValue('MainMenu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Team').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 2

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/Generic_TestData/Create_Team').getValue(
            'ProjectName', val), ('ProjectAbbreviation') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('ProjectAbbreviation', 
            val), ('BusinessUnit') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('BusinessUnit', val), ('ProjectOwner') : findTestData(
            'CDDS/Generic_TestData/Create_Team').getValue('ProjectOwner', val), ('AssociateSchema') : findTestData('CDDS/Generic_TestData/Create_Team').getValue(
            'AssociateSchema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/Generic_TestData/Create_Team').getValue(
            'ProjectName', val), ('TeamName') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamName', val)
        , ('TeamDescription') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamDescription', val), ('TeamBaseSite') : findTestData(
            'CDDS/Generic_TestData/Create_Team').getValue('TeamBaseSite', val)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
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
String Expected_TeamName = findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamName', val)

'Dynamic Xpath of created team name'
String Createdteam_Xpath = ('(//input[@name="emxTableRowId"])/../../td//a[contains(.,"' + Expected_TeamName) + '")]'

'Dynamic object of created team name'
TestObject Getteamname = new TestObject('objectName')

'Create object'
Getteamname.addProperty('xpath', ConditionType.EQUALS, Createdteam_Xpath)

'Getting created team name into variable'
String Actual_CreatedTeam = WebUI.getText(Getteamname)

'Verify created team match'
WebUI.verifyEqual(Actual_CreatedTeam.trim(), findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamName', val))

'Delete the Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Team'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to defult\r\n'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

