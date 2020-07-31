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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/ProjectGroup_Name'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/ProjectGroup_Name'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
        'Group_Name', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectGroup_Name = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
    'Group_Name', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectGroup_NameXpath = ('//a[contains(text(),"' + ProjectGroup_Name) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectGroup_NameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectGroup_NameObj.addProperty('xpath', ConditionType.EQUALS, ProjectGroup_NameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectGroup_NameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.click(ProjectGroup_NameObj)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

'Wait for  Select ProjectName  element to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Members_Tab'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Add_Members'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Add_Members'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Switch to Default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 16))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Type element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Type_Dropdown'), 
    GlobalVariable.Element_Timeout)

'Selecr Type as Person'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Type_Dropdown'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Add_Edit_Members').getValue('Type', 1), false)

'Wait for Type element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Company_Dropdown'), 
    GlobalVariable.Element_Timeout)

'Selecr Type as Person'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Company_Dropdown'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Add_Edit_Members').getValue('Company', 1), false)

'Wait for Search UserID element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/UserID_Textbox'), 
    GlobalVariable.Element_Timeout)

'Enter the Search UserID '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/UserID_Textbox'), findTestData(
        'CDDS/BCM_Module_TestData/Reports_Master_TestData/Add_Edit_Members').getValue('User_ID', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Find btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for AccessType  element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Access_type'), 
    GlobalVariable.Element_Timeout)

'Select AccessType  as Edit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Access_type'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Add_Edit_Members').getValue('Access', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Submit btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), GlobalVariable.Element_Timeout)

'Click on submit btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Find btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Edit_Option'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Add_Edit_Members/Edit_Option'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Switch to Default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 15))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

def Name = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Add_Edit_Members').getValue('Name', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String NameXpath = ('//font[contains(text(),"' + Name) + '")]'

'creating the Select ProjectName xpath object'
TestObject NameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
NameObj.addProperty('xpath', ConditionType.EQUALS, NameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(NameObj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Submit btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), GlobalVariable.Element_Timeout)

'Click on submit btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.closeBrowser()

