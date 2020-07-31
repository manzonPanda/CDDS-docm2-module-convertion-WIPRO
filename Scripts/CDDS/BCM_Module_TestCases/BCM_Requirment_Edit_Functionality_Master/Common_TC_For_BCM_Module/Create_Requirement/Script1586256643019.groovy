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

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

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
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Create_BCM_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Requirements element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Requirement_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Requirements '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Requirement_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Create Actual variable for On Behalf Of'
String Actual_On_Behalf_Of = On_Behalf_Of

'Wait for On Behalf of element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/On_Behalf_Of_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter On Behalf of value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/On_Behalf_Of_Obj'), 
    Actual_On_Behalf_Of)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for On behalf of person name to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on On behalf of person name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Create Actual variable for Title'
String Actual_Title = Title

'Wait for Title field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Title_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Title'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Title_Obj'), 
    Actual_Title)

'Create Actual variable for Select Priority'
String Actual_Priority = Priority

'Wait for select priority option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Priority_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Priority'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Priority_Obj'), 
    Actual_Priority, false)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Target_Date_Icon_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Target date icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Target_Date_Icon_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Date_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on the date'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Date_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Create Actual variable for Enter Description'
String Actual_Description = Description

'Wait for Description field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Description_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Description '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Description_Obj'), 
    Actual_Description)

'Create Actual variable for select Team name'
String Actual_Team_Name = Team_Name

'Wait for select Team option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Team'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Team_Obj'), 
    Actual_Team_Name, false)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

