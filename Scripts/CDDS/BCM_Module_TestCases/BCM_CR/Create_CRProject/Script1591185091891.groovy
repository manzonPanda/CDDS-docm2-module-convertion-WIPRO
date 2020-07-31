import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk', ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : '', ('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue('ProjectName', 1), ('ProjectAbbreviation') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue('ProjectAbbreviation', 1), ('BusinessUnit') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue('BusinessGroup', 1), ('ProjectOwner') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue('UserID', 1), ('AssociateSchema') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue('AssociatedSchema', 1), ('TC_Name_Path1') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

