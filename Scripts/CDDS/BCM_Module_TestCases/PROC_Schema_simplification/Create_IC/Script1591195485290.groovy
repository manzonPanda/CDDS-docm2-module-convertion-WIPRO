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

WebUI.switchToDefaultContent()

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), IC_Name)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a IC dynamic xpath'
String ICXpath = ('//a[contains(.,"' + IC_Name) + '")]/../..//input'

'creating the SubMenu xpath object'
TestObject ICObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ICObj.addProperty('xpath', ConditionType.EQUALS, ICXpath)

'Wait for IC  element to be visible'
if (WebUI.waitForElementVisible(ICObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
    'Wait for IC  element to be visible'
    WebUI.waitForElementVisible(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

    'Scroll to  IC  element '
    WebUI.scrollToElement(ICObj, GlobalVariable.Element_Timeout)

    'Click on IC'
    WebUI.click(ICObj)

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Action element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on Action Btn'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for delete element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Delete_Obj'), GlobalVariable.Element_Timeout)

    'Click on delete Btn'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Delete_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for alert'
    WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Click on yes'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Click on yes'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Wait for IC  element not to  visible'
    WebUI.waitForElementNotPresent(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)
}

WebUI.switchToDefaultContent()

'Calling test case to Navigate to MProjecty Desk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Create_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/Create_IC').getValue('Window_Title', 1))

'Maximize the window'
WebUI.maximizeWindow()

'Loading Icon not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_Number'), findTestData(
        'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 1))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/OwningBU'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 2), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_Name'), findTestData(
        'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 3))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_Variant'), findTestData(
        'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 4))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_EngModel'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 5), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_WorkflowTemp'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 6), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_Library'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 7), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_Technology'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 8), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_Classification'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 9), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/Sec_Owner'), findTestData(
        'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 10))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/BCM_ProjType_New'))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_ECCN'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 12), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_CMSysyem'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 13), false)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_CMPath'), findTestData(
        'CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 14))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Create_IC_Objects/IC_CMPathType'), 
    findTestData('CDDS/BCM_Module_TestData/PROC_Schema_simplification/BCM_IC').getValue('IC1_Specifications', 15), f