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

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_Name'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_Name'), ProjectName)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/Project_Owner'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/Project_Owner'), 
    ProjectOwner)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/ProjectAbbreviation_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/ProjectAbbreviation_Obj'), 
    ProjectAbbreviation)

'Wait for  Business unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/Business_Unit_Dropdown'), 
    GlobalVariable.Element_Timeout)

'Select Bussiness unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/Business_Unit_Dropdown'), 
    BusinessUnit, false)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Show_Project'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Show_Project'), 
    ShowProjects, false)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Find_Button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Find_Button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

