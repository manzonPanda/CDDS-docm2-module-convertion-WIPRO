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

'Login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for close'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/Close_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Scroll to close'
WebUI.scrollToElement(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/Close_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Click on  create CDDS incident'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/Close_Obj'), FailureHandling.OPTIONAL)

'Wait for help tool'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Help_tool_Obj'), GlobalVariable.Element_Timeout)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Click on help tool'
WebUI.mouseOver(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Help_tool_Obj'))

'Click on  create CDDS incident'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Create CDDS Incident_Obj'))

'Switch to window'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/BCMClassification_Obj'), 
    findTestData('CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Classification', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading image is not visible'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for serverity'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/BCMSeverity_Obj'), 
    GlobalVariable.Element_Timeout)

'Select severity'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/BCMSeverity_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Priority', 1), false)

'Click on no'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/EDGECompany_Obj'))

'Set partner company name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/BCMPartnerCompanyName_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Name', 1))

'Set value for TI pass company'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Ti_pass_company_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Name', 5))

'Select site'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/FileSiteAvail_Obj'), 
    findTestData('CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Site', 1), false)

'Click on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/FileSitearrow_Obj'))

'Select default site'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Default filesite_Obj'), 
    findTestData('CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Site', 1), false)

'Set purpose for request'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Purposeforrequest_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Name', 3))

'Set value for Volume Ti partner'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/VolumeTIPartner'), findTestData('CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue(
        'Name', 4))

'Set value for Volume partner TI'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/VolumePartnerTI'), findTestData('CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue(
        'Name', 4))

'Set value for Engagement Manager'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/EngagementManager_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateCompany_FromGlobalMenu_Edge').getValue('Id', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/Done_Obj'))

'Wait till loading image is not visible'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu_Edge/loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

