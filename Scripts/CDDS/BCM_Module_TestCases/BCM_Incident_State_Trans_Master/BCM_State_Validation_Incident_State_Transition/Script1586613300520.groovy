import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
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

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition')

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

for (def index : (1..data.getRowNumbers())) {
    WebUI.switchToDefaultContent()

    'Assign a Title to variable'
    String Title_print = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
        'Title', index)

    'Print the Title'
    println((('ITERATION' + index) + 'BCM_State_Validation_Incident_State_Transition ') + Title_print)

    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_State_Trans_Master/Incident_State_Transition'), 
        [('Keyword') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
                'Title', index), ('State') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
                'To_State', index), ('Assignee') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
                'Assigned_To', index), ('ResolutionDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
                'ResolutionDescription', index), ('ExpectedState') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_State_Trans_Master_TestData/BCM_State_Validation_Incident_State_Transition').getValue(
                'Expected_State', index)], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(GlobalVariable.Wait_Time)
}

