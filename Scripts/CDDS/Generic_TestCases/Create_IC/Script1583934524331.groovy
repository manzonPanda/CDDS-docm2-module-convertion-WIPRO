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

'login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/Generic_TestData/Create_IC').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/Generic_TestData/Create_IC').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), IC)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a IC dynamic xpath'
String ICXpath = ('//a[contains(.,"' + IC) + '")]/../..//input'

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

    'Wait for IC  element to be visible'
    WebUI.waitForElementNotPresent(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)
}

'Switch to default'
WebUI.switchToDefaultContent()

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/Generic_TestData/Create_IC').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/Generic_TestData/Create_IC').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

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

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/OwningBU_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Model', 3), false)

'Set IC name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Name_Obj'), IC)

'Select IC model\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Model_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Model', 2), false)

'Select workflowtemplete\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/WorkflowTemplate_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'IC_Name', 3), false, FailureHandling.OPTIONAL)

'Select library\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/Library_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Library', 1), false)

'Select Technology\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/Technology_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Technology', 1), false)

'Select Technology\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/IP_Classification_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'IP_Class', 1), false)

'Set Variant'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/Variant_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'IC_Name', 2))

WebUI.delay(5)

'Click on create new project'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/ProjectType_New_Obj'))

WebUI.delay(3)

'Select CMsystem\t\r\n\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/CM_system_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'CM_system', 1), false)

'Set random value'
String random_number = RandomStringUtils.randomNumeric(3)

'set the path'
String path = ('UM_IC_' + random_number) + '_CMPath'

'Set CM path'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/CMPath_Obj'), path)

WebUI.delay(3)

'Set secondary owner'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/Secondary_Owner_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Owner', 1))

WebUI.delay(3)

'Click on name'
WebUI.doubleClick(findTestObject('CDDS/Generic_Objects/Create_IC/Name_Obj'))

WebUI.delay(3)

'Select CM path type\t\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/CMPathType_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Path', 2), false)

'Select CM path type\t\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Category_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'IC_Category', 1), false)

'Click on No'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Release_Package_no_Obj'))

'Click on search'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/ActionSearch_Obj'))

WebUI.delay(10)

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/Create_IC').getValue('Window_Title', 2))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/Company name_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Company', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(5)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Select_company_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Submit_Obj'))

WebUI.delay(10)

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/Create_IC').getValue('Window_Title', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set description'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/Description_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Path', 1))

'Click on search'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/CustomerName_Obj'))

WebUI.delay(5)

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/Create_IC').getValue('Window_Title', 2))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.delay(5)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/Company name_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Company', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(5)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Select_company_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Submit_Obj'))

WebUI.delay(5)

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/Create_IC').getValue('Window_Title', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Done_Obj'))

WebUI.delay(15)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for project abberivation\r\n\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/ProjectAbbreviation_Obj'), GlobalVariable.Wait_Time)

'Double click\r\n\t'
WebUI.doubleClick(findTestObject('CDDS/Generic_Objects/Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

'Double click\r\n\t'
WebUI.clearText(findTestObject('CDDS/Generic_Objects/Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

'Ste the random abberivvation'
String abberivation = IC + random_number

'Set abberivation\r\n\t'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/ProjectAbbreviation_Obj'), abberivation)

'Set abberivation\r\n\t'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_IC/AssociatedSchema_Obj'), findTestData('CDDS/Generic_TestData/Create_IC').getValue(
        'Associated schema', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Done_Obj'))

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

WebUI.delay(30)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Create_IC/Done_Obj'), GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

