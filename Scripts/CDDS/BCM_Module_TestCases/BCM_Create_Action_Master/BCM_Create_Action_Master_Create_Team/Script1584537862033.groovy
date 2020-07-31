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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/Generic_TestData/Create_Team').getValue(
            'ProjectName', val), ('ProjectAbbreviation') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('ProjectAbbreviation', 
            val), ('BusinessUnit') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('BusinessUnit', val), ('ProjectOwner') : findTestData(
            'CDDS/Generic_TestData/Create_Team').getValue('ProjectOwner', val), ('AssociateSchema') : findTestData('CDDS/Generic_TestData/Create_Team').getValue(
            'AssociateSchema', val), ('TC_Name_Path') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('TC_Name_Path', 
            val),('TC_Name_Path1') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('TC_Name_Path1', 
            val)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/Generic_TestData/Create_Team').getValue(
            'ProjectName', val), ('TeamName') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamName', val)
        , ('TeamDescription') : findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamDescription', val), ('TeamBaseSite') : findTestData(
            'CDDS/Generic_TestData/Create_Team').getValue('TeamBaseSite', val)], FailureHandling.STOP_ON_FAILURE)

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

'Wait for ModifyTeam element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/Modify_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on ModifyTeam '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/Modify_Team_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for TeamName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/TeamName_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the TeamName'
ActualTeamName = WebUI.getAttribute(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Action_Master_Objects/BCM_Create_Action_Master_Create_Team_Objects/TeamName_Obj'), 
    'value')

'Verify Equal Actual TeamName with expected TeamName'
WebUI.verifyEqual(ActualTeamName, findTestData('CDDS/Generic_TestData/Create_Team').getValue('TeamName', val), FailureHandling.CONTINUE_ON_FAILURE)

'Close the window'
WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Delete the Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Team'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the browser'
WebUI.closeBrowser()

