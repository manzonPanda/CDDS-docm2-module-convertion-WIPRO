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

'Navigate to frame'
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

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/CheckBox_Obj'))

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

'Navigate to frame'
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

'Wait for Edit button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Edit_ State_Obj'), 
    GlobalVariable.Wait_Time)

'Click on  Edit button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Edit_ State_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to window'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select team'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMRespondingTeam_Ob'), 
    Team, false, FailureHandling.OPTIONAL)

'Verify the option target state'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Target_state_Obj'), 
    Target, false, FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Scroll to Assignee'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Assignee_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Enter the Assignee'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Assignee_Obj'), 
    Assignee, FailureHandling.OPTIONAL)

'Wait for name to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
    GlobalVariable.Wait_Time)

'Click on Name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
    FailureHandling.OPTIONAL)

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

