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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue('MainMenu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'ProjectName', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'ProjectAbbreviation', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'BusinessUnit', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'ProjectOwner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Create_Project').getValue(
            'AssociateSchema', val)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

