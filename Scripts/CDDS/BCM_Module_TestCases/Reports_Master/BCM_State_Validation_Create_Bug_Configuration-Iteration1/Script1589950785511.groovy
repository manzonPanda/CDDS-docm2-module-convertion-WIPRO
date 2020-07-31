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

'Login to CDDS Application or navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business Unit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Business_Unit'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Business_Unit'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('OwningBU', 
        1), false)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
    GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('ProjectName', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def Project_Name = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
    'ProjectName', 1)

//def ProjectName = Project_Name
//println(ProjectName)
'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + Project_Name) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj, Project_Name, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.click(ProjectNameObj)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Default content'
WebUI.switchToDefaultContent()

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_Team_Project'), 
    [('TeamName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
            'TeamName', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_Team_Project'), 
    [('TeamName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
            'TeamName', 2)], FailureHandling.STOP_ON_FAILURE)

'Switch to Default content'
WebUI.switchToDefaultContent()

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Configurations_Option'), 
    GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Configurations_Option'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectConfigurationsDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Bug_Configuration'), 
    GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Bug_Configuration'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Team_Auto-Assign'), 
    GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Team_Auto-Assign'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Team Element to be visible'
WebUI.verifyElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Team_Auto-Assign'), 
    FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectConfigDetailsTeamAutoAssign_Frame'), GlobalVariable.Element_Timeout)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Action_button'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Verify Action Button not present'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Action_button'))

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Edit_button'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Verify Action Button not present'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Edit_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.delay(GlobalVariable.Short_Wait)

'Get Actual CR title value'
String Actual_Title = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Edit _Title'))

'Triming got CR title value'
String Actual_Title1 = Actual_Title.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_Title1, findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 11), false, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Verify Action Button not present'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Auto_Assignment_Attribute'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Attribute_Select'), 
    GlobalVariable.Wait_Time)

'Verify Action Button not present'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Attribute_Select'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'AttributeSelect', 1), false)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/TeamBug'), 
    GlobalVariable.Wait_Time)

'Verify Action Button not present'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/TeamBug'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'TeamName', 1), false)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/TeamDesign_Environment_Issue'), 
    GlobalVariable.Wait_Time)

'Verify Action Button not present'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/TeamDesign_Environment_Issue'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'TeamName', 1), false)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/TeamTDL_Bug'), 
    GlobalVariable.Wait_Time)

'Verify Action Button not present'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/TeamTDL_Bug'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'TeamName', 2), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Create_IC/Done_button'), 
    GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Create_IC/Done_button'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectConfigDetailsTeamAutoAssign_Frame'), GlobalVariable.Element_Timeout)

'Switch to List display frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/ListDisplay_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Get Actual Bug title value'
String Actual_Type = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Type_Obj'))

'Triming got bug title value'
String Actual_Type_trim = Actual_Type.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_Type_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'Type', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR title value'
String Actual_Type1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Type1_Obj'))

'Triming got bug title value'
String Actual_Type1_trim = Actual_Type1.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_Type1_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_CR_TestData').getValue(
        'Title', 1), false, FailureHandling.OPTIONAL)

'Get Actual Incident title value'
String Actual_Type2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Type2_Obj'))

'Triming got bug title value'
String Actual_Type2_trim = Actual_Type2.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_Type2_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'Type', 2), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Type value'
String Actual_AttributeName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Get_AttributeName'))

'Triming got bug title value'
String Actual_AttributeName_trim = Actual_AttributeName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_AttributeName_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'AttributeName', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_AttributeName1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Get_AttributeName1'))

'Triming got bug title value'
String Actual_AttributeName1_trim = Actual_AttributeName1.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_AttributeName1_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'AttributeName', 2), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_AttributeName2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Get_AttributeName2'))

'Triming got bug title value'
String Actual_AttributeName2_trim = Actual_AttributeName2.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_AttributeName2_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'AttributeName', 3), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual CR Type value'
String Actual_TeamName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Get_TeamName'))

'Triming got bug title value'
String Actual_TeamName_trim = Actual_TeamName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_TeamName_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'TeamName', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_TeamName1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Get_TeamName1'))

'Triming got bug title value'
String Actual_TeamName1_trim = Actual_TeamName1.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_TeamName1_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'TeamName', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Type value'
String Actual_TeamName2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug_Configuration/Get_TeamName2'))

'Triming got bug title value'
String Actual_TeamName2_trim = Actual_TeamName2.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_TeamName2_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug_Configuration').getValue(
        'TeamName', 2), false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

