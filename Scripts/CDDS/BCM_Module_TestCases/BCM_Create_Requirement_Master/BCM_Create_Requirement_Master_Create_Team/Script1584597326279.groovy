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

'Login to CDDS Application or navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Project_Name', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Project_Abbr', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Business_Group', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Project_Owner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Associated_Schema', val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Project_Name', val), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Team_Name', val), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
            'Team_Description', val), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
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

'Created get team name'
String TeamName = GetTeam

'Dynamic Xpath of created team name'
String Createdteam_Xpath = ('(//input[@name="emxTableRowId"])/../../td//a[contains(.,"' + TeamName) + '")]'

//('//div[@class="modal-body"]//label[contains(.,"'+ Str) + '")]'
'Dynamic object of created team name'
TestObject Getteamname = new TestObject('objectName')

Getteamname.addProperty('xpath', ConditionType.EQUALS, Createdteam_Xpath)

'Getting created team name into variable'
String Actual_CreatedTeam1 = WebUI.getText(Getteamname)

'Getting created team trim value into varible'
String Actual_CreatedTeam = Actual_CreatedTeam1.trim()

'Verify created team match'
WebUI.verifyMatch(Actual_CreatedTeam, findTestData('CDDS/BCM_Module_TestData/BCM_Create_Requirement_Master_TestData/BCM_Create_Requirement_Master_Create_Team_TestData').getValue(
        'Team_Name', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

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
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Delete Option element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_Create_Team_Objects/Delete_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Delete Option'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_Create_Requirement_Master_Create_Team_Objects/Delete_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(2)

'Accept aleart popup'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Close the browser'
WebUI.closeBrowser()

