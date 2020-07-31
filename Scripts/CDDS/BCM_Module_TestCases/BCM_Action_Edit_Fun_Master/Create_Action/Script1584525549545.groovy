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

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create BCM button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Create BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  ActiCreate BCMons button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Create BCM_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Action_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Action_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to window create action'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMPriority_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Create_Action').getValue('Priority', 1), false)

'Enter the title'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Title_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Create_Action').getValue('Title', 1))

'Enter the description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMDescription_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Create_Action').getValue('Description', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Done_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()
