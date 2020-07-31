import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
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

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/ProjectName_obj'), GlobalVariable.Element_Timeout)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/ProjectName_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
        'Projectname', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectName1 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
    'Projectname', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath1 = ('//a[contains(text(),"' + ProjectName1) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj1 = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj1.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath1)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj1, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.click(ProjectNameObj1)

WebUI.delay(GlobalVariable.Wait_Time)

'Create new requirement'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Requirement'), 
    [('On_Behalf_Of') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 1), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
            'Requirement_Creation', 1), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 3), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 4), ('Team_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 5)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Default content'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the keyword  field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Requirement_Creation', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

'Check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

'Select Requirement in type drop down'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

'Select state as Assigned for requirement'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        10), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

def Deferred_requirement = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'Requirement_Creation', 1)

'creating  dynamic xpath to verify the Requirement title name '
String RequirementXpath = ('//td[contains(text(),"' + Deferred_requirement) + '")]'

TestObject RequirementObj = new TestObject('objectName')

'\r\n'
RequirementObj.addProperty('xpath', ConditionType.EQUALS, RequirementXpath)

'\r\n\r\n'
WebUI.waitForElementVisible(RequirementObj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(RequirementObj, Deferred_requirement, FailureHandling.STOP_ON_FAILURE)

'Verify status of newly created requirement'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/VerifyStatus_obj'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/VerifyStatus_obj'), GlobalVariable.Wait_Time)

'select Check box of requirement'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Req_Checkbox_obj'), GlobalVariable.Wait_Time)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Req_Checkbox_obj'))

WebUI.delay(GlobalVariable.Short_Wait)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Portal_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Swicth to BCM Command frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Edit_Change_obj'), GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Edit_Change_obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Wait for assign dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assign_State_obj'), GlobalVariable.Wait_Time)

'Click on  Assign status button '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assign_State_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        1), false)

'Wait for Assignee name text field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assignee_name_box_obj'), 
    GlobalVariable.Wait_Time)

'Set Assignee text to Muralitharan, Gopalan'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assignee_name_box_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Assigned_State').getValue('Assignee', 
        1))

WebUI.sendKeys(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assignee_name_box_obj'), Keys.chord(Keys.ARROW_DOWN, 
        Keys.ENTER, Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.OPTIONAL)

WebUI.delay(20)

'Switch to Default content'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Requirement_Creation', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

'check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

'Select requirement in type dropdown'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

'Select state as Assigned for requirement'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        9), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

def Deferred_requirement1 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'Requirement_Creation', 1)

'creating  dynamic xpath for verifying the requirement of assigned state'
String RequirementXpath1 = ('//td[contains(text(),"' + Deferred_requirement1) + '")]'

TestObject RequirementObj1 = new TestObject('objectName')

RequirementObj1.addProperty('xpath', ConditionType.EQUALS, RequirementXpath1)

WebUI.waitForElementVisible(RequirementObj1, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Verify requirement name of asssigned state element to be visible'
WebUI.verifyElementText(RequirementObj1, Deferred_requirement1, FailureHandling.STOP_ON_FAILURE)

def status_Assigned = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'State', 2)

'creating  dynamic xpath to verify the assigned status'
String Assign_Xpath = ('//td[contains(text(),"' + status_Assigned) + '")]'

TestObject AssignObj = new TestObject('objectName')

AssignObj.addProperty('xpath', ConditionType.EQUALS, Assign_Xpath)

WebUI.waitForElementVisible(AssignObj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify the Requirement with Assigned status '
WebUI.verifyElementText(AssignObj, status_Assigned, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/ProjectName_obj'), GlobalVariable.Element_Timeout)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/ProjectName_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
        'Projectname', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectName = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
    'Projectname', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj, ProjectName, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.click(ProjectNameObj)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Default content'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Requirement_Creation', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/IdCheckbox_obj'), GlobalVariable.Wait_Time)

'Uncheck the ID checkbox'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/IdCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

'Check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

'Select Requirement as type in dropdown'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Element_Timeout)

'Select state as Assigned for requirement'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        9), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Select check box for requirement of Assigned state'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Req_Checkbox_obj'), GlobalVariable.Wait_Time)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Req_Checkbox_obj'))

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Portal_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Swicth to BCM Command frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Edit/Change button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Edit_Change_obj'), GlobalVariable.Wait_Time)

'Click on  Edit/change button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Edit_Change_obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Status Change button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assign_State_obj'), GlobalVariable.Wait_Time)

'Click on  Assessed state '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assign_State_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        3), false)

'Wait for Classification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Classification_obj'), GlobalVariable.Wait_Time)

'select Classification element from dropdown'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Classification_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Clasification', 
        1), false)

'Wait for SubClassification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/SubClassification_obj'), 
    GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/SubClassification_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Clasification', 
        2), FailureHandling.STOP_ON_FAILURE)

'Wait for BCM Difficulty element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMDifficulty_obj'), GlobalVariable.Wait_Time)

'Select BCM Difficulty level dropdown'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMDifficulty_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        1), false)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnSoftware'), GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnSoftware'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        2), false)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactAreaMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactAreaMinimum'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 3))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactAreaMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactAreaMaximum'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 4))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactAreaTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactAreaTypical'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 5))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactCostMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactCostMinimum'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 6))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactCostMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactCostMaximum'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 7))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactCostTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactCostTypical'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 8))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffort'), GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffort'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        9), false)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffortMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffortMinimum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        10))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffortMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffortMaximum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        11))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffortTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactEffortTypical'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        12))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformance'), 
    GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformance'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        13), false)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformanceMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformanceMinimum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        14))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformanceMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformanceMaximum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        15))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformanceTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPerformanceTypical'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        16))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPower'), GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPower'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        17), false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPowerMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPowerMinimum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        18))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPowerMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPowerMaximum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        19))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPowerTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactPowerTypical'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        20))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMAssessmentEffortMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMAssessmentEffortMinimum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        21))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMAssessmentEffortMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMAssessmentEffortMaximum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        22))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMAssessmentEffortTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMAssessmentEffortTypical'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        23))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImplementationEffortMinimum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImplementationEffortMinimum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        24))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImplementationEffortMaximum'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImplementationEffortMaximum'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        25))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImplementationEffortTypical'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImplementationEffortTypical'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        26))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnSafety'), GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnSafety'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        27), false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnTest'), GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnTest'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        28), false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMTechnicalProposal'), 
    GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMTechnicalProposal'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 29))

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMRecommendation'), GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMRecommendation'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Properties', 
        30), false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMOtherImpacts'), GlobalVariable.Wait_Time)

'Enter value for all mandatory fields'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMOtherImpacts'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Properties', 31))

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    GlobalVariable.Wait_Time)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(20)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Requirement_Creation', 1))

'select Requirement in  Type dropdown'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

'wait for state drop down to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Wait_Time)

'Select  assessed state in state drop down'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        4), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Wait_Time)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

def Deferred_requirement3 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'Requirement_Creation', 1)

String RequirementXpath3 = ('//td[contains(text(),"' + Deferred_requirement3) + '")]'

'creating dynamic xpath for verifyng the title name'
TestObject RequirementObj3 = new TestObject('objectName')

RequirementObj3.addProperty('xpath', ConditionType.EQUALS, RequirementXpath3)

'Wait for title name  element to be visible'
WebUI.waitForElementVisible(RequirementObj3, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify requirement  title'
WebUI.verifyElementText(RequirementObj3, Deferred_requirement3, FailureHandling.STOP_ON_FAILURE)

def status_Assigned3 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'State', 5)

'creating dynamic xpath to verify status'
String Assign_Xpath3 = ('//td[contains(text(),"' + status_Assigned3) + '")]'

TestObject AssignObj3 = new TestObject('objectName')

AssignObj3.addProperty('xpath', ConditionType.EQUALS, Assign_Xpath3)

'Wait for  status Assessed to be visible'
WebUI.waitForElementVisible(AssignObj3, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify  Assessed status'
WebUI.verifyElementText(AssignObj3, status_Assigned3, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/ProjectName_obj'), GlobalVariable.Element_Timeout)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/ProjectName_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
        'Projectname', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectName2 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
    'Projectname', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectName2Xpath = ('//a[contains(text(),"' + ProjectName2) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectName2Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectName2Obj.addProperty('xpath', ConditionType.EQUALS, ProjectName2Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectName2Obj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.click(ProjectName2Obj)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Default content'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Requirement_Creation', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/IdCheckbox_obj'), GlobalVariable.Wait_Time)

'Uncheck the ID checkbox'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/IdCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

'Check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

'Select Requirement as type in dropdown'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Element_Timeout)

'Select state as Assigned for requirement'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        4), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Select check box for requirement of Assigned state'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Req_Checkbox_obj'), GlobalVariable.Wait_Time)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Req_Checkbox_obj'))

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Portal_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Swicth to BCM Command frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Edit/Change button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Edit_Change_obj'), GlobalVariable.Wait_Time)

'Click on  Edit/change button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Edit_Change_obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for assign dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assign_State_obj'), GlobalVariable.Wait_Time)

'Click on  Assign status button '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Assign_State_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        6), false)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMTIInternalComments'), 
    GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMTIInternalComments'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('Comments', 
        1), FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMCCBFeedback'), GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMCCBFeedback'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Comments', 2), FailureHandling.STOP_ON_FAILURE)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    GlobalVariable.Wait_Time)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.delay(20)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
        'Requirement_Creation', 1))

'select Requirement in  Type dropdown'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

'wait for state drop down to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Wait_Time)

'Select  assessed state in state drop down'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue('State', 
        7), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Wait_Time)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

def Deferred_requirement4 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'Requirement_Creation', 1)

String RequirementXpath4 = ('//td[contains(text(),"' + Deferred_requirement4) + '")]'

'creating dynamic xpath for verifyng the title name'
TestObject RequirementObj4 = new TestObject('objectName')

RequirementObj4.addProperty('xpath', ConditionType.EQUALS, RequirementXpath4)

'Wait for title name  element to be visible'
WebUI.waitForElementVisible(RequirementObj4, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify requirement  title'
WebUI.verifyElementText(RequirementObj4, Deferred_requirement4, FailureHandling.STOP_ON_FAILURE)

def status_Assigned4 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Deferred_State').getValue(
    'State', 8)

'creating dynamic xpath to verify status'
String Assign_Xpath4 = ('//td[contains(text(),"' + status_Assigned4) + '")]'

TestObject AssignObj4 = new TestObject('objectName')

AssignObj4.addProperty('xpath', ConditionType.EQUALS, Assign_Xpath4)

'Wait for  status Assessed to be visible'
WebUI.waitForElementVisible(AssignObj4, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify  Assessed status'
WebUI.verifyElementText(AssignObj4, status_Assigned4, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

