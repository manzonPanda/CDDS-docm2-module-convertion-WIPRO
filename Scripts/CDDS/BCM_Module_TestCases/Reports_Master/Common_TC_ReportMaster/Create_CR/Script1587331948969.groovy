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

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'If Create BCM collaps expand it'
if (WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'), 
    GlobalVariable.Short_Wait)) {
    'Wait for Create BCM option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on CreateBCM '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'))

    'Wait for Change Requist element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Change Request tab'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
} else {
    'Wait for Change Requist element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Change Request tab'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
}

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_Title1 = Expected_Title

'Wait for Title field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Title'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
    Expected_Title1)

'Creating variable for taking test data value from data file'
String Expected_Priority1 = Expected_Priority

'Wait for Priority select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Select_Priority_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Priority'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Select_Priority_Obj'), 
    Expected_Priority1, false)

'Wait for Calender Icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Calender_Icon_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Calender Icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Calender_Icon_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Date_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Date'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Date_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Creating variable for taking test data value from data file'
String Expected_Description1 = Expected_Description

'Wait for Description field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
    Expected_Description1)

'Creating variable for taking test data value from data file'
String Expected_Justification1 = Expected_Justification

'Wait for Justification field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Justification_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Justification '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Justification_Field_Obj'), 
    Expected_Justification1)

'Creating variable for taking test data value from data file'
String Expected_Classification1 = Expected_Classification

'Wait for Clasification select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Clasification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
    Expected_Classification1, false)

'Creating variable for taking test data value from data file'
String Expected_Sub_Classification1 = Expected_Sub_Classification

'Wait for Sub Clasification field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Sub_Classification_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Sub Clasification'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Sub_Classification_Obj'), 
    Expected_Sub_Classification1, FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_Team1 = Expected_Team

'Wait for Team select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Team'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
    Expected_Team1, false)

'Creating variable for taking test data value from data file'
String Expected_Release1 = Expected_Release

'Wait for Release field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Release_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Release'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Release_Obj'), 
    Expected_Release1, FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_Internal_Comment1 = Expected_Internal_Comment

'Wait for TI Internal Comment field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_InternalComment_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter TI Internal comment'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_InternalComment_Obj'), 
    Expected_Internal_Comment1, FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_External_Comment1 = Expected_External_Comment

'Wait for TI External Comment field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_External_Comment_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter TI External comment'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_External_Comment_Obj'), 
    Expected_External_Comment1, FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_Contact_Team1 = Expected_Contact_Team

'Wait for Contact Dept Or Team field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Contact_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Contact Dept Or Team'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Contact_Team_Obj'), 
    Expected_Contact_Team1, FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_CQID1 = Expected_CQID

'Wait for CQ ID field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/CQ_ID_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter CQ ID'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/CQ_ID_Obj'), 
    Expected_CQID1, FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data value from data file'
String Expected_ExternalID1 = Expected_ExternalID

'Wait for External ID field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/External_ID_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter External ID'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/External_ID_Obj'), 
    Expected_ExternalID1, FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'))

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

