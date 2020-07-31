import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login to CDDS Url or Navigate to CDDS Url'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Reports'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Edit_Global_Report/Report_Name'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Edit_Global_Report/Report_Name'), findTestData(
        'CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue('AdvancedReportName', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for search project to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Edit_Global_Report/Report_Checkbox'), 
    GlobalVariable.Element_Timeout)

'Click on project link'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Edit_Global_Report/Report_Checkbox'))

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Run element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Run_Report_Objects/Run_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Run'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Run_Report_Objects/Run_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'AdvancedReport_Window_Title', 1))

WebUI.maximizeWindow()

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default content'
WebUI.switchToDefaultContent()

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
String Actual_BugType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/Type_Bug'))

'Triming got bug Type value'
String Actual_BugType1 = Actual_BugType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
        'Classification', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Type value'
String Actual_CRType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/Type_CR'))

'Triming got CR Type value'
String Actual_CRType1 = Actual_CRType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_IncidentType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/Type_Incident'))

'Triming got Incident Type value'
String Actual_IncidentType1 = Actual_IncidentType.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentType1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Bug Project value'
String Actual_BugStatus = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/State_Status_Bug'))

'Triming got bug Project value'
String Actual_BugStatus1 = Actual_BugStatus.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugStatus1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'Status_Bug', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Project value'
String Actual_CRStatus = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/State_Status_CR'))

'Triming got CR Project value'
String Actual_CRStatus1 = Actual_CRStatus.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRStatus1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'Status_CR', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Project value'
String Actual_IncidentStatus = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/State_Status_Incident'))

'Triming got Incident Project value'
String Actual_IncidentStatus1 = Actual_IncidentStatus.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentStatus1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'Status_Incident', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Bug Description value'
String Actual_BugClassification = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/Classification_Bug'))

'Triming got bug Description value'
String Actual_BugClassification1 = Actual_BugClassification.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugClassification, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'Classification_Bug', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Description value'
String Actual_CRClassification = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/Classification_CR'))

'Triming got CR Description value'
String Actual_CRClassification1 = Actual_CRClassification.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_CRClassification, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'Classification_CR', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Description value'
String Actual_IncidentClassification = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Run_Global_Report/Classification_Incident'))

'Triming got Incident Description value'
String Actual_IncidentClassification1 = Actual_IncidentClassification.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_IncidentClassification1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
        'Classification_Incident', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

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

'Close the browser'
WebUI.closeBrowser()

