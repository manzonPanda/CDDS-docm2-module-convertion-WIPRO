import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def RandomNum = RandomStringUtils.randomNumeric(3)

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DMCMyDesk'
        , ('SubMenu') : 'Programs'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Create Program_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Create Program_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business Unit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/BusinessUnit_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/BusinessUnit_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('BusinessUnit', 1), false)

'Wait for Technology  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Technology_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select Technology'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Technology_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('Technology', 1), false)

'Wait for Program Engagement  Model element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Engagement Model_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select  Program Enagagement Model'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Engagement Model_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProgramEngagementModel', 
        1), false)

'Wait for Program Workflow Template element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/WorkflowTemplate_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select ProgramWorkflowTemplate'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/WorkflowTemplate_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProgramWorkflowTemplate', 
        1), false)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProgramName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProgramName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProgramName', 1) + RandomNum)

'Wait for  ProgramRevision element to be visible '
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProgramVersion_Obj'), 
    GlobalVariable.Element_Timeout)

'Set ProgramRevision '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProgramVersion_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProgramRevision', 1))

'Wait for ProgramDescription Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProgramDescription_Obj'), 
    GlobalVariable.Element_Timeout)

'Set program Description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProgramDescription_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProgramDescription', 
        1))

'Wait for Calender element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Calendar_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Calendar'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Calendar_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Date element to be  visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Today_Obj'), 
    GlobalVariable.Element_Timeout)

'Select as Today Date'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Today_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Secondary element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/SecondaryOwner_Obj'), 
    GlobalVariable.Element_Timeout)

'Set secondary owner'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/SecondaryOwner_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('SecondaryOwner', 1))

'Wait for SecondaryOwner Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Name_Obj'))

'Wait for CreateNewProject radio element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProjectType_New_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on create new project'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProjectType_New_Obj'))

'Wait for Participant Company Search element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Project company_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on search'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Project company_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 4))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Company Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Company name_Obj'), GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Company name_Obj'), findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue(
        'CompanyName', 1))

'Wait for Find btn Element  to be visble '
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Company checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Select_company_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Select_company_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Submit Btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Submit_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Submit_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done Btn Element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Done_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Done_Obj'))

'ActualGetTextAlert'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

'Switch to default'
WebUI.switchToDefaultContent()

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for project abberivation element to be visible\r\n\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProjectAbbreviation_Obj'), 
    GlobalVariable.Element_Timeout)

'Double click on Project Abbreviation\r\n\t'
not_run: WebUI.doubleClick(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProjectAbbreviation_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Set the Project Abbreviation\t\r\n\t'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/ProjectAbbreviation_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProjectAbbreviation', 
        1) + RandomNum)

'Wait for Assciated Schema Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/AssociatedSchema_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select the Associated Schema'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/AssociatedSchema_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('AssociatedSchema', 1), 
    false)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Done_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Done_Obj'))

WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Navigate to Search Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Keyword_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Keyword_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Base_Data_Creation1').getValue('ProgramName', 1) + RandomNum)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/SearchProgram_ChkBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/SearchProgram_ChkBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Program checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Click on ProgramCheckbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait Delete  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/DeleteProgram_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Delete'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/DeleteProgram_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Click on OK Button on Alert'
WebUI.acceptAlert()

'Wait for Feqw Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Close the Browser'
WebUI.closeBrowser()

