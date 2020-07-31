import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
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
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
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
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('State', 
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
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('State', 
        6), false)

'Wait for assign dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMPriority'), GlobalVariable.Wait_Time)

'Click on  Assign status button '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMPriority'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('Properties_Approved_State', 
        1), false)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnSoftware'), GlobalVariable.Wait_Time)

'Click on  Actions button '
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/BCMImpactOnSoftware'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('Properties_Approved_State', 
        2), false)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    GlobalVariable.Wait_Time)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

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
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
        'Requirement_Creation', 1))

'select Requirement in  Type dropdown'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

'wait for state drop down to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Wait_Time)

'Select  assessed state in state drop down'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('State', 
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

def Closed_requirement4 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
    'Requirement_Creation', 1)

String RequirementXpath4 = ('//td[contains(text(),"' + Closed_requirement4) + '")]'

'creating dynamic xpath for verifyng the title name'
TestObject RequirementObj4 = new TestObject('objectName')

RequirementObj4.addProperty('xpath', ConditionType.EQUALS, RequirementXpath4)

'Wait for title name  element to be visible'
WebUI.waitForElementVisible(RequirementObj4, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify requirement  title'
WebUI.verifyElementText(RequirementObj4, Closed_requirement4, FailureHandling.STOP_ON_FAILURE)

def status_Assigned4 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
    'State', 8)

'creating dynamic xpath to verify status'
String Assign_Xpath4 = ('//td[contains(text(),"' + status_Assigned4) + '")]'

TestObject AssignObj4 = new TestObject('objectName')

AssignObj4.addProperty('xpath', ConditionType.EQUALS, Assign_Xpath4)

'Wait for  status Assessed to be visible'
WebUI.waitForElementVisible(AssignObj4, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'verify  Assessed status'
WebUI.verifyElementText(AssignObj4, status_Assigned4, FailureHandling.STOP_ON_FAILURE)

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
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('State', 
        9), false)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    GlobalVariable.Wait_Time)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.OPTIONAL)

WebUI.delay(20)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
        'Requirement_Creation', 1))

'select Requirement in  Type dropdown'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

'wait for state drop down to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Wait_Time)

'Select  assessed state in state drop down'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue('State', 
        10), false)

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

def Closed_requirement5 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
    'Requirement_Creation', 1)

String RequirementXpath5 = ('//td[contains(text(),"' + Closed_requirement5) + '")]'

'creating dynamic xpath for verifyng the title name'
TestObject RequirementObj5 = new TestObject('objectName')

RequirementObj5.addProperty('xpath', ConditionType.EQUALS, RequirementXpath5)

'verify requirement  title'
WebUI.verifyElementText(RequirementObj5, Closed_requirement5, FailureHandling.STOP_ON_FAILURE)

def status_Assigned5 = findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_Closed_State').getValue(
    'State', 11)

'creating dynamic xpath to verify status'
String Assign_Xpath5 = ('//td[contains(text(),"' + status_Assigned5) + '")]'

TestObject AssignObj5 = new TestObject('objectName')

AssignObj5.addProperty('xpath', ConditionType.EQUALS, Assign_Xpath5)

'verify  Assessed status'
WebUI.verifyElementText(AssignObj5, status_Assigned5, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

