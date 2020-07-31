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

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Reports element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Create_Advanced_Report'), 
    GlobalVariable.Element_Timeout)

'Click on Create Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Create_Advanced_Report'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Report Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter report name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Name_Obj'), 
    AdvancedReportName)

'Wait for Create Reports element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_FileName'), 
    GlobalVariable.Element_Timeout)

'Click on Create Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_FileName'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 10))

'Maximise the window'
WebUI.maximizeWindow()

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_Name'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_Name'), ProjectName)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Show_Project'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Show_Project'), 
    ShowProject, false)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Find_Button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Find_Button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Table_Checkbox'))

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Submit_button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Submit_button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get Actual project name'
String Actual_Project = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Selected_Project'))

'triming actual project name'
String Actual_Project1 = Actual_Project.trim()

'Verify actual and expected project name matched'
WebUI.verifyMatch(Actual_Project1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Report_TestData').getValue(
        'Project_Name', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Verify all BCM Element types List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ElementType_Obj'), 
    ['Action', 'Alert', 'Bug', 'Change Request', 'Incident', 'Requirement'], FailureHandling.OPTIONAL)

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Title_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Title_Checkbox'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/ExternalCommentHistory_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/ExternalCommentHistory_Checkbox'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Created_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Created_Checkbox'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/InternalCommentHistory_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/InternalCommentHistory_Checkbox'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/InternalResolutionHistory_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/InternalResolutionHistory_Checkbox'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/EstimatedDate_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/EstimatedDate_Checkbox'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/ExternalResolutionHistory_Checkbox'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/ExternalResolutionHistory_Checkbox'))

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Run/Save button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Run/Save button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to List display frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ListDisplay_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Get Actual Bug title value'
String Actual_BugTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_BugTitle_Obj'))

'Triming got bug title value'
String Actual_BugTitle1 = Actual_BugTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugTitle1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
        'Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR title value'
String Actual_CRTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_CRTitle_Obj'))

'Triming got CR title value'
String Actual_CRTitle1 = Actual_CRTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRTitle1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
        'Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident title value'
String Actual_IncidentTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_IncidentTitle_Obj'))

'Triming got Incident title value'
String Actual_IncidentTitle1 = Actual_IncidentTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentTitle1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
        'Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Bug type value'
String Actual_BugType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_BugType_Obj'))

'Triming got bug Type value'
String Actual_BugType1 = Actual_BugType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
        'Classification', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Type value'
String Actual_CRType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_CRType_Obj'))

'Triming got CR Type value'
String Actual_CRType1 = Actual_CRType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_IncidentType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_IncidentType_Obj'))

'Triming got Incident Type value'
String Actual_IncidentType1 = Actual_IncidentType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to listfoot frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/listFoot_frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

