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
import com.kms.katalon.core.testdata.InternalData as InternalData

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_all_access roles')

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_all_access roles').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Assign a Title to variable'
    String Title_print = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_all_access roles').getValue(
        'Title', index)

    'Print the Title'
    println((('ITERATION' + index) + 'BCM_State_Validation_Create_Incident_with_all_access roles ') + Title_print)

    'Validation create incident'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Master/State_Validation_Create_Incident_with_all_access roles'), 
        [('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_all_access roles').getValue(
                'Title', index), ('Keyword') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_all_access roles').getValue(
                'Title', index), ('TestCase') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_all_access roles').getValue(
                'Title', index)], FailureHandling.STOP_ON_FAILURE)

    'Delay'
    WebUI.delay(GlobalVariable.Wait_Time)
}

'Switch to Default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

