import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
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

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Requirment_Edit_Functionality_Master/Common_TC_For_BCM_Module/Create_Requirement'), 
    [('On_Behalf_Of') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 1), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 2), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 3), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 4), ('Team_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
            'Requirement_Creation', 5)], FailureHandling.STOP_ON_FAILURE)

'Switch to Default content'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), GlobalVariable.Wait_Time)

'Enter project name in the field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Keyword_obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Requirement_State_Trans/BCM_Requirement_State_Trans_New_State').getValue(
        'Keyword', 1))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'), GlobalVariable.Wait_Time)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleCheckbox_obj'))

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeDropdown_obj'), GlobalVariable.Wait_Time)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TypeValue_obj'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateDropdown_obj'), GlobalVariable.Element_Timeout)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/StateValue_obj'))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Wait_Time)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Configuration_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time)

WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleName_obj'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/TitleName_obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/VerifyStatus_obj'), GlobalVariable.Wait_Time)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/VerifyStatus_obj'), GlobalVariable.Wait_Time)

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

'Wait for Create BCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Delete_obj'), GlobalVariable.Wait_Time)

'Click on  Create BCM'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirement_State_Trans/Delete_obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Accept aleart popup'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Accept aleart popup'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.closeBrowser()

