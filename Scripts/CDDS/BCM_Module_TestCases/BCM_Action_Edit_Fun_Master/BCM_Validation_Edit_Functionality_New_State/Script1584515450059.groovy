import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Assign a role to variable'
    String role = findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
        'Role', index)

    'Print the role'
    println('BCM_State_Validation_Edit_Functionality_New_State || ' + role)

    'Validation edit functionlity'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Action_Edit_Fun_Master/Generic _Validation_Edit_Functionality'), 
        [('Criteria') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Criteria', index), ('Type') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Type', index), ('Select_project') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Project', index), ('Project_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Project_Name', index), ('BU') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'BU', index), ('Schema') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Associate_schema', index), ('Owner') : GlobalVariable.Non_Support_Role_Username, ('State_type') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'StateCheck', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Description', index), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Priority', index), ('Assignee') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue(
                'Name', 3)], FailureHandling.STOP_ON_FAILURE)

    'Switch to window'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify the option target state'
    WebUI.verifyOptionsPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Target_state_Obj'), 
        ['Close:Closed', 'Assign:Assigned', 'Defer:Deferred', 'Reject:Rejected'], FailureHandling.OPTIONAL)

    'Vetrify the BCM description and priority'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Action_Edit_Fun_Master/Verify BCM priority and description'), 
        [('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Priority', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM Validate edit functionality Action New State').getValue(
                'Description', index)], FailureHandling.STOP_ON_FAILURE)

    'Validation of different role'
    println(('BCM_State_Validation_Edit_Functionality_New_State || ' + role) + ' is verifed')
}

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

