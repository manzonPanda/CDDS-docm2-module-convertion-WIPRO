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

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProgramName', 
        1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ShowProject_My', 
        1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProgramName', 
        1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ShowProject', 
        1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Menu Collapsed element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), GlobalVariable.Element_Timeout)

'Click on  Menu Collapsed'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate Design  Management DM tab to Create Program'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DMCMyDesk'
        , ('SubMenu') : 'Programs'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Keyword_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Keyword_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProgramName', 
        1))

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Keyword_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Keyword_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProgramName', 
        1))

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

