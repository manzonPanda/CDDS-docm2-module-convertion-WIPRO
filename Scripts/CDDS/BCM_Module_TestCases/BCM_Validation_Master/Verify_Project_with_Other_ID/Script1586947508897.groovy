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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue('MainMenu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
        'BusinessUnit', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue('ProjectName', 
        1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/ProjectFilter_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/ProjectFilter_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
        'ProjectFilter', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the project name from data file'
String ExpectedprojectName = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
    'ProjectName', 1)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/TableVerify_Project_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualProjectName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/TableVerify_Project_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualProjectName.trim())

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualProjectName.trim(), ExpectedprojectName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/SearchBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
        'BusinessUnit', 1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue('ProjectName', 
        1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/ProjectFilter_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/ProjectFilter_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
        'ProjectFilter', 2), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the project name from data file'
String ExpectedErrorMessage = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_Project_with_Other_ID_Datafile').getValue(
    'ErrorMessage', 1)

'Wait for Search result Userid element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/TableVerify_Error_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Userid'
ActualErrorMessage = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_Project_with_Other_ID_Objects/TableVerify_Error_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Userid'
println(ActualErrorMessage.trim())

'Verify Equal Actual SearchUserID with expected SearchUserid'
WebUI.verifyEqual(ActualErrorMessage.trim(), ExpectedErrorMessage, FailureHandling.CONTINUE_ON_FAILURE)

