import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states')

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to my desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to BCM menu and Projects Submenu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Project_Abbr', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Business_Group', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Project_Owner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Associated_Schema', 1)], FailureHandling.STOP_ON_FAILURE)

'Create a Team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Team_Name', 1), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Team_Description', 1), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
            'Team_Base_Site', 1)], FailureHandling.STOP_ON_FAILURE)

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Assign a Title to variable'
    String Title_print = findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
        'Title', index)

    'Print the Title'
    println((('ITERATION' + index) + 'BCM_State_Validation_Create_Incident_with_all_access roles ') + Title_print)

    'Validation create incident'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Incident_Master/Create_Incident_with_different_State'), 
        [('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
                'Title', index), ('Keyword') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_State_Validation_Create_Incident_with_different_states').getValue(
                'Title', index)], FailureHandling.STOP_ON_FAILURE)

    'Wait for sometime'
    WebUI.delay(GlobalVariable.Wait_Time)
}

'Switch to Default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

