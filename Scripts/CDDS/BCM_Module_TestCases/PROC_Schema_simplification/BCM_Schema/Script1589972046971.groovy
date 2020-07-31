import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Login to Application with user ID : a0131608'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Saving Project Name as a string'
String Project = findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue('Project_Name', 
    1)

'creating dynamic xpath for project name in header'
String Project_Header_Xpath = ('//li[@name="li_type_BCMProject" and @title="' + Project) + '"]'

'creating dynamic xpath for project name in header\r\n'
TestObject ProjectName_Header = new TestObject('objectName')

'creating dynamic xpath for project name in header'
ProjectName_Header.addProperty('xpath', ConditionType.EQUALS, Project_Header_Xpath)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/1.CreateThe BCM project And Verify Properties'), 
    [('ProjectName') : Project, ('Project_Header') : ProjectName_Header], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/2.Check Full View And Verify'), [('Project') : Project
        , ('Project_Header') : ProjectName_Header], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/3.Changing Bug View to Short View'), 
    [('Project') : Project, ('Project_Header') : ProjectName_Header], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/4.Uncheck Bug_Verify Properties'), 
    [('ProjectName_Header') : ProjectName_Header, ('ProjectName') : Project], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/5.Check Bug_ReVerify Properties'), 
    [('ProjectName_Header') : ProjectName_Header, ('ProjectName') : Project], FailureHandling.STOP_ON_FAILURE)

'Saving Project Name as a string'
String Project1 = findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_Schema').getValue('Project_Name', 
    2)

'creating dynamic xpath for project name in header'
String Project_Header_Xpath1 = ('//li[@name="li_type_BCMProject" and @title="' + Project1) + '"]'

'creating dynamic xpath for project name in header\r\n'
TestObject ProjectName_Header1 = new TestObject('objectName')

'creating dynamic xpath for project name in header'
ProjectName_Header1.addProperty('xpath', ConditionType.EQUALS, Project_Header_Xpath1)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/6.Create 2nd BCMProject And Verify Properties'), 
    [('ProjectName') : Project1, ('Project_Header') : ProjectName_Header1], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/PROC_Schema_simplification/7.Create IC_check Bug Schema'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

