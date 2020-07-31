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

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Reports element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Create_Reports_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Create Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Create_Reports_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Report Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter report name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Report_TestData').getValue('Report_Name', 
        1))

'Get Actual project name'
String Actual_Project = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Get_Projects_Obj'))

'triming actual project name'
String Actual_Project1 = Actual_Project.trim()

'Verify actual and expected project name matched'
WebUI.verifyMatch(Actual_Project1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Report_TestData').getValue(
        'Project_Name', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Verify team name present'
WebUI.verifyOptionPresentByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Team_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Report_TestData').getValue('Team_Name', 
        1), false, GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Verify all BCM Element types List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ElementType_Obj'), 
    ['Action', 'Alert', 'Bug', 'Change Request', 'Incident', 'Requirement'], FailureHandling.OPTIONAL)

'Verify Severity List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/SeverityList_Obj'), 
    ['1-Production Stop', '2-High', '3-Medium', '4-Low', '5-None'], FailureHandling.OPTIONAL)

'Verify Priority List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/PriorityList_Obj'), 
    ['1-Urgent', '2-High', '3-Medium', '4-Low', '5-None'], FailureHandling.OPTIONAL)

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Checkbox1_Obj'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Checkbox1_Obj'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Checkbox2_Obj'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Checkbox2_Obj'))

'Wait for Display field checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Checkbox3_Obj'), 
    GlobalVariable.Element_Timeout)

'check Display field checkbox '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Checkbox3_Obj'))

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

