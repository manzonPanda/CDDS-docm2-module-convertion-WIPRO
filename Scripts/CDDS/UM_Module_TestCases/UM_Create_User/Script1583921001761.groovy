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

'Create A User'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_User'), [('Company') : findTestData('CDDS/Generic_TestData/UM_Create_User').getValue(
            'Company', 1), ('BusinessUnit') : findTestData('CDDS/Generic_TestData/UM_Create_User').getValue('BusinessUnit', 
            1), ('AID_XID') : findTestData('CDDS/Generic_TestData/UM_Create_User').getValue('AID_XID', 1), ('CDDSRoles') : findTestData(
            'CDDS/Generic_TestData/UM_Create_User').getValue('CDDSRoles', 1), ('FileSite') : findTestData('CDDS/Generic_TestData/UM_Create_User').getValue(
            'FileSite', 1)], FailureHandling.STOP_ON_FAILURE)

