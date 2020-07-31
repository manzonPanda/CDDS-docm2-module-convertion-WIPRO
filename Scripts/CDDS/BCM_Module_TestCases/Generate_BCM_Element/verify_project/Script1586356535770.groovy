import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/* '
*/
'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

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
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'wait for criteria'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), Keyword)

'Click on title chcek box'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Title_checkbox_Obj'))

'Click on ID chcek box'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/ID_checkbox_Obj'))

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Type_Obj'), Type, 
    false)

'Select statecheck'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    State_type, false)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

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

'creating a IncidentXpath dynamic xpath'
String CRXpath = ('//td[text()="' + Keyword) + '"]'

'creating the Select incident xpath object'
TestObject CRObj = new TestObject('objectName')

'adding property in Select incident dynamic xpath'
CRObj.addProperty('xpath', ConditionType.EQUALS, CRXpath)

'wait till BCM action is visible'
WebUI.waitForElementVisible(CRObj, GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'verifyBCM action is visible'
WebUI.verifyElementVisible(CRObj, FailureHandling.OPTIONAL)

