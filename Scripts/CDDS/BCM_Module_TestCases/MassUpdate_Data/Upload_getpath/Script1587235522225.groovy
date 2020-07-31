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

'Set a value to index'
int index = Index

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Select Owing BU'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'OwingBU', index), false)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue(
        'Name', index))

'Assign a value to string'
String IC = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue('Name', 
    index)

'Click on find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a IC dynamic xpath'
String ICXpath = ('//a[contains(.,"' + IC) + '")]'

'creating the SubMenu xpath object'
TestObject ICObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ICObj.addProperty('xpath', ConditionType.EQUALS, ICXpath)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  IC  element '
WebUI.scrollToElement(ICObj, GlobalVariable.Element_Timeout)

'Click on IC'
WebUI.click(ICObj, FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for CM label to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CM_Label_Btn_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on CM label'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CM_Label_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

