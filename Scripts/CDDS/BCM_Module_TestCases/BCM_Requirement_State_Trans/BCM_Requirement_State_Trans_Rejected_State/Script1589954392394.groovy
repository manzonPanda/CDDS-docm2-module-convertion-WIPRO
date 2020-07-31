import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Approved_State').getValue(
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
            'Requirement_Creation', 1), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue(
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
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue(
        'Requirement_Creation', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

'Check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

'Select Requirement in type drop down'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

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

def Rejected_requirement = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue(
    'Requirement_Creation', 1)

'creating  dynamic xpath to verify the Requirement title name '
String RequirementXpath = ('//td[contains(text(),"' + Rejected_requirement) + '")]'

TestObject RequirementObj = new TestObject('objectName')

'\r\n'
RequirementObj.addProperty('xpath', ConditionType.EQUALS, RequirementXpath)

'\r\n\r\n'
WebUI.waitForElementVisible(RequirementObj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(RequirementObj, Rejected_requirement, FailureHandling.STOP_ON_FAILURE)

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
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue('State', 
        1), false)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMTIInternalComments'), 
    GlobalVariable.Wait_Time)

'Enter project name in the keyword  field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMTIInternalComments'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue('TI_Comments', 
        1))

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
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue(
        'Requirement_Creation', 1))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

'check title checkbox'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

'Select requirement in type dropdown'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Element_Timeout)

'Select state as Assigned for requirement'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue('State', 
        2), false)

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

def Rejected_requirement1 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue(
    'Requirement_Creation', 1)

'creating  dynamic xpath for verifying the requirement of assigned state'
String RequirementXpath1 = ('//td[contains(text(),"' + Rejected_requirement1) + '")]'

TestObject RequirementObj1 = new TestObject('objectName')

RequirementObj1.addProperty('xpath', ConditionType.EQUALS, RequirementXpath1)

WebUI.waitForElementVisible(RequirementObj1, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Verify requirement name of asssigned state element to be visible'
WebUI.verifyElementText(RequirementObj1, Rejected_requirement1, FailureHandling.STOP_ON_FAILURE)

def status_Rejected = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Rejected_State').getValue(
    'State', 3)

'creating  dynamic xpath to verify the assigned status'
String Assign_Xpath = ('//td[contains(text(),"' + status_Rejected) + '")]'

TestObject AssignObj = new TestObject('objectName')

AssignObj.addProperty('xpath', ConditionType.EQUALS, Assign_Xpath)

WebUI.waitForElementVisible(AssignObj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify the Requirement with Assigned status '
WebUI.verifyElementText(AssignObj, status_Rejected, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

