import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Assign a role to variable'
    String role = findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
        'Role', index)

    'Print the role'
    println('BCM_State_Validation_Edit_Functionality_Assigned_State || ' + role)

    'Validation edit functionlity'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Action_Edit_Fun_Master/Generic _Validation_Edit_Functionality'), 
        [('Criteria') : '', ('Type') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Type', index), ('Select_project') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Project', index), ('Project_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Project_Name', index), ('BU') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'BU', index), ('Schema') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Associate_schema', index), ('Owner') : GlobalVariable.Non_Support_Role_Username, ('State_type') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'StateCheck', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Description', index), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Priority', index), ('Assignee') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue(
                'Name', 3)], FailureHandling.STOP_ON_FAILURE)

    'Vetrify the BCM description and priority'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Action_Edit_Fun_Master/Verify BCM priority and description'), 
        [('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Priority', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/BCM_Validation_Edit_Functionality_Assigned_State').getValue(
                'Description', index)], FailureHandling.STOP_ON_FAILURE)

    'Validation of different role'
    println(('BCM_State_Validation_Edit_Functionality_Assigned_State || ' + role) + ' is verifed')
}

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

