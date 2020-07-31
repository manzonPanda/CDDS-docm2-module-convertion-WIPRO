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

'Switch to Default'
WebUI.switchToDefaultContent()

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'login to CDDS with Non Support Role'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'UserID', index)], FailureHandling.STOP_ON_FAILURE)

    'Assign a role to variable'
    String role = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
        'Role', index)

    'Print the role'
    println('BCM_State_Validation_Edit_Functionality_New_State || ' + role)

    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Edit_Functionality_Master/Edit project'), 
        [('Criteria') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'Criteria', index), ('Type') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'Type', index), ('Select_project') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'Project', index), ('Project_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'Project_Name', index), ('BU') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'BU', index), ('Schema') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'Associate_schema', index), ('Owner') : GlobalVariable.Non_Support_Role_Username, ('State_type') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/BCM_Edit_Functionality_New_State').getValue(
                'StateCheck', index), ('Assignee') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue(
                'Name', 3), ('Priority_Incident') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                'Priority_Incident', index), ('Description_Incident') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                'Description_Incident', index), ('Title_Incident') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                'Title_Incident', index), ('Keyword') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                'Title_Incident', index)], FailureHandling.STOP_ON_FAILURE)

    'Switch to default'
    WebUI.switchToDefaultContent()

    if (index > 3) {
       
        WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Edit_Functionality_Master/Select classification and verify priority description'), 
            [('Title_Incident') :  findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                    'Title_Incident', index), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                    'Priority_Incident', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Edit_Functionality_Master/Create_Incident').getValue(
                    'Description_Incident', index)], FailureHandling.STOP_ON_FAILURE)
    } else {
        'Switch to default'
        WebUI.switchToDefaultContent()

        'Click on find'
        WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Done_Obj'))

        'Wait for alert'
        WebUI.waitForAlert(GlobalVariable.Short_Wait, FailureHandling.OPTIONAL)

        'Click on ok'
        WebUI.acceptAlert(FailureHandling.OPTIONAL)

        'Switch to default'
        WebUI.switchToDefaultContent()
    }
    
    'Validation of different role'
    println(('BCM_State_Validation_Edit_Functionality_New_State || ' + role) + ' is verifed')

    'Refresh the page'
    WebUI.refresh()

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Wait_Time)

    'Switch to default'
    WebUI.switchToDefaultContent()
}

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

