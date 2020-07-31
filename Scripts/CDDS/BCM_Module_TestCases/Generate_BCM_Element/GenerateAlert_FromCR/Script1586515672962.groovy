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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue(
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

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to frame'
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

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'wait for criteria'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Title', 1))

'Click on title chcek box'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Title_checkbox_Obj'))

'Click on ID chcek box'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/ID_checkbox_Obj'))

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Type_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('Type', 1), false)

'Select statecheck'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('State', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Navigate to frame'
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

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for RtlLabel to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), 
    GlobalVariable.Element_Timeout)

'entertext in RTlLabel '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), FailureHandling.STOP_ON_FAILURE)

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
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Generate_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Create BCM button element to be visible'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Generate_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Generate_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for aler button element to be visible'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Alert_Obj'), 
    GlobalVariable.Wait_Time)

'Wait for aler button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Alert_Obj'), 
    GlobalVariable.Wait_Time)

'Click on  alert button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Alert_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Priority to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/BCMPriority_Obj'), 
    GlobalVariable.Element_Timeout)

'Select priority'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/BCMPriority_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('Priority', 1), false)

'Wait for search to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Clickvon search icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenerateAlert_FromBug/Search_Obj'), FailureHandling.STOP_ON_FAILURE)

'switch to default'
WebUI.switchToDefaultContent()

'Switch to  window'
WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('Title', 
        1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for ProjectName  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectName'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
        'Project_Name', 1))

'Wait for find to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for loading img'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for loading img not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for table and ow  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), 
    GlobalVariable.Element_Timeout)

'Clickon checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Tablerow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for submit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Submit_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on submit button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCM_Create_Bug/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Close the window'
WebUI.closeWindowTitle(findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('Title', 
        1), FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for done to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for loading img'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for loading img not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for loading img'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Close the window'
WebUI.closeWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

'verify project'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Generate_BCM_Element/verify_project'), [('Type') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('Typeselect', 1), ('State_type') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenerateAlert_FromCR').getValue('State', 1), ('Keyword') : findTestData(
            'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('Title', 1)], FailureHandling.STOP_ON_FAILURE)

'logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

