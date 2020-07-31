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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Login to CDDS Url or Navigate to CDDS Url'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Business unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Business_Unit_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Bussiness unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Business_Unit_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue('Business_Unit', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue('ProjectName', 1))

'Wait for Show select field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Show_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Show'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Show_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue('ShowProjects', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectName = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue('ProjectName', 
    1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Click on Select ProjectName'
WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj, FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Option'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Option'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Reports element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Create_Graph'), 
    GlobalVariable.Element_Timeout)

'Click on Create Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Create_Graph'), FailureHandling.STOP_ON_FAILURE)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Report Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter report name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Report_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue('GraphName', 1))

'Get Actual Bug title value'
String Actual_ProjectName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Project_Name_Field'))

'Triming got bug title value'
String Actual_ProjectName1 = Actual_ProjectName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_ProjectName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'ProjectName', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR title value'
String Actual_TeamName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Teams_Selection'))

'Triming got CR title value'
String Actual_TeamName1 = Actual_TeamName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_TeamName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'TeamName', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Verify all BCM Element types List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ElementType_Obj'), 
    ['Action', 'Alert', 'Bug', 'Change Request', 'Incident', 'Requirement'], FailureHandling.OPTIONAL)

'Verify Severity List  present'
WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/SeverityList_Obj'), 
    ['1-Production Stop', '2-High', '3-Medium', '4-Low', '5-None'], FailureHandling.OPTIONAL)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Run/Save button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Run/Save button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowIndex(1)

'Switch to create window'
not_run: WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'Window_Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Get Actual CR title value'
String Actual_GraphName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Name'))

'Triming got CR title value'
String Actual_GraphName1 = Actual_GraphName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_GraphName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'Window_Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

WebUI.comment('===================================================')

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Checkbox'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Checkbox'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Run_Graph'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Run_Graph'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowIndex(1)

'Switch to create window'
not_run: WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'Window_Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Get Actual CR title value'
String Run_GraphName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Name'), 
    FailureHandling.CONTINUE_ON_FAILURE)

'Triming got CR title value'
String Run_GraphName1 = Run_GraphName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Run_GraphName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'Window_Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

WebUI.comment('===================================================')

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Checkbox'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Checkbox'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Edit_Graph'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Edit_Graph'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowIndex(1)

'Switch to create window'
not_run: WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'Window_Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Wait for Few Seconds'
not_run: WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Run/Save button to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Run/Save button'
not_run: WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/RunSave_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
not_run: WebUI.delay(GlobalVariable.Short_Wait)

'Get Actual CR title value'
String Edit_GraphName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Name'), 
    FailureHandling.CONTINUE_ON_FAILURE)

'Triming got CR title value'
String Edit_GraphName1 = Edit_GraphName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Edit_GraphName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue(
        'Window_Title', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
not_run: WebUI.switchToDefaultContent()

'Switch to create window'
not_run: WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

WebUI.comment('===================================================')

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Checkbox'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Graph/Graph_Checkbox'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Delete_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Delete_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Alert popup'
WebUI.waitForAlert(GlobalVariable.Element_Timeout)

'Accept Alert Popup'
WebUI.acceptAlert()

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

def ReportName = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Graph').getValue('ReportName', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ReportNameXpath = ('//a[contains(text(),"' + ReportName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ReportNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ReportNameObj.addProperty('xpath', ConditionType.EQUALS, ReportNameXpath)

'Click on Select ProjectName'
WebUI.verifyElementNotPresent(ReportNameObj, GlobalVariable.Wait_Time)

WebUI.closeBrowser()

