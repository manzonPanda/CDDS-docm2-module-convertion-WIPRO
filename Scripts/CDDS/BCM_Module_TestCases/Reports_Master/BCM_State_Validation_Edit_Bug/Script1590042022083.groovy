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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue('Main_Menu', 1)
        , ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

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

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Project_Inbox_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Keyword_Obj'), GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/Generic_Objects/Common_Objects/Keyword_Obj'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'BCMTitle', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/ID_Checkbox'), GlobalVariable.Element_Timeout)

WebUI.uncheck(findTestObject('CDDS/Generic_Objects/Common_Objects/ID_Checkbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Title_Checkbox'), GlobalVariable.Element_Timeout)

WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Title_Checkbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Type_Dropdown'), GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Common_Objects/Type_Dropdown'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'typeSelect', 1), false)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/State_Check_dropdown'), GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Common_Objects/State_Check_dropdown'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'StateCheck', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Project_Inbox_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

def Bug_Title = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
    'BCMTitle', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String Bug_TitleXpath = ('(//td[contains(text(),"' + Bug_Title) + '")])[1]'

'creating the Select ProjectName xpath object'
TestObject Bug_TitleObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
Bug_TitleObj.addProperty('xpath', ConditionType.EQUALS, Bug_TitleXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(Bug_TitleObj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Table_Checkbox'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Table_Checkbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Project_Inbox_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/Edit or Change State'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/Edit or Change State'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/State_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/State_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Edit_Bug').getValue('State', 1), 
    false, FailureHandling.STOP_ON_FAILURE)

'Wait for Name Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/Related_Label'), 
    GlobalVariable.Element_Timeout)

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/Related_Label'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

title = WebUI.getWindowTitle()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 12))

'Maximise the window'
WebUI.maximizeWindow()

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Table_Checkbox'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Table_Checkbox'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Name Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), GlobalVariable.Element_Timeout)

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'))

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/Assigned_To_Fix'), 
    GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Edit_Bug/Assigned_To_Fix'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Edit_Bug').getValue('Assigned_To_Fix', 
        1), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Name Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Name_Obj'), GlobalVariable.Element_Timeout)

'Wait for Name Element to be visible'
WebUI.mouseOver(findTestObject('CDDS/Generic_Objects/Common_Objects/Name_Obj'), FailureHandling.OPTIONAL)

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Name_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Name Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), GlobalVariable.Element_Timeout)

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3), FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Project_Inbox_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Keyword_Obj'), GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/Generic_Objects/Common_Objects/Keyword_Obj'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'BCMTitle', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/ID_Checkbox'), GlobalVariable.Element_Timeout)

WebUI.uncheck(findTestObject('CDDS/Generic_Objects/Common_Objects/ID_Checkbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Title_Checkbox'), GlobalVariable.Element_Timeout)

WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Title_Checkbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Type_Dropdown'), GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Common_Objects/Type_Dropdown'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'typeSelect', 1), false)

WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/State_Check_dropdown'), GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Common_Objects/State_Check_dropdown'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'StateCheck', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Project_Inbox_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Get Actual Bug title value'
String Actual_TeamName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug/Get_TeamName'))

'Triming got bug title value'
String Actual_Type_trim = Actual_TeamName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_Type_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'TeamName', 1), false, FailureHandling.OPTIONAL)

'Get Actual CR title value'
String Actual_BugTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug/Get_BugTitle'))

'Triming got bug title value'
String Actual_BugTitle_trim = Actual_BugTitle.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_BugTitle_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
        'BCMTitle', 1), false, FailureHandling.OPTIONAL)

'Get Actual Incident title value'
String Actual_State = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug/Get_State_Status'))

'Triming got bug title value'
String Actual_State_trim = Actual_State.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_State, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Edit_Bug').getValue(
        'State', 1), false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()

