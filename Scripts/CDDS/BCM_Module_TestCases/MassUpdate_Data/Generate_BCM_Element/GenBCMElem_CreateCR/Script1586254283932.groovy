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

'Login to the application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Find the project'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/Generate_BCM_Element/Find_Project'), [('Project_name') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Project_Name', 1), ('Select_Project') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Project', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for loading img'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for loading img not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for Inbox button'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Inbox_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'click on inbox\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Inbox_Obj'))

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create BCM button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Create BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Create BCM_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for CR button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/CR_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  CR button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/CR_Obj'), FailureHandling.STOP_ON_FAILURE)
'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for on be half of textarea to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMOnBehalfOf_Obj'), 
    GlobalVariable.Element_Timeout)

'Scroll to on behalf of\r\n'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMOnBehalfOf_Obj'), 
    GlobalVariable.Wait_Time)

'enter text in on behalf of '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMOnBehalfOf_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('OnBehalfof', 1))

'Wait for name to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Scroll to name \t\r\n'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Click on Name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
    FailureHandling.OPTIONAL)

'Wait for BCM title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMTitle_Obj'), 
    GlobalVariable.Element_Timeout)

'entertext in BCM title  '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMTitle_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Title', 1))

'Wait for Priority to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMCustomerPriority_Obj'), 
    GlobalVariable.Element_Timeout)

'Select priority'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMCustomerPriority_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Priority', 1), false)

'Wait for calender img to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Calender_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  calender button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Calender_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for today button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Today_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  today button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Today_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for descrition element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMDescription_Obj'), 
    GlobalVariable.Element_Timeout)

'Set text in BCM description textarea '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMDescription_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Description', 1))

'Wait for justification element to be visibleju'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMJustification_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter the text in justification field '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMJustification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Justification', 1))

'Wait for BCM classification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMClassification_Obj'), 
    GlobalVariable.Element_Timeout)

'select BCM classification '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMClassification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Classification', 1), 
    false)

'Wait for BCM subclassification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMSubClassification_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter the text in subclassification field '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMSubClassification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('SubClassification', 
        1))

'Wait for release button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Release_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter the text in release field '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Release_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Release', 1))

'Wait for TI Internal Comments element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/TI Internal Commets_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter the text inTI Internal Comments field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/TI Internal Commets_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('InternalComments', 
        1))

'Wait for external Comments element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/External Comments_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter the text in TI external Comments field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/External Comments_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('ExternalComments', 
        1))

'Wait for BCMContactDepartment_Obj element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMContactDepartment_Obj'), 
    GlobalVariable.Element_Timeout)

'enter text in BCMContactDepartment field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMContactDepartment_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('ContactDepartment', 
        1))

'Wait for BCM Other id to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMOtherID_Obj'), 
    GlobalVariable.Element_Timeout)

'enter text in Other id field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMOtherID_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('OtherID', 1))

'Wait for external ID element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMExternalID_Obj'), 
    GlobalVariable.Element_Timeout)

'enter text in externalid field'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/BCMExternalID_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('ExternalID', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for loading img'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for loading img not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'verify project'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Generate_BCM_Element/verify_project'), [('Type') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Type', 1), ('State_type') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('State', 1), ('Keyword') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Title', 1)], FailureHandling.STOP_ON_FAILURE)

'logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

