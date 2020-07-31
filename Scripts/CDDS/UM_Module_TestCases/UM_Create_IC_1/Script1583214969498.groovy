import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.google.common.util.concurrent.AbstractFuture.Failure as Failure
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

'login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Create_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Window_Title', 1))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set IC name'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Name_Obj'), GlobalVariable.Element_Timeout)

'Set IC name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Name_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'IC_Name', 1))

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Model', 1), false)

'Select IC model\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Model_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Model', 2), false)

'Select workflowtemplete\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/WorkflowTemplate_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'IC_Name', 3), false, FailureHandling.OPTIONAL)

'Select library\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Library_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Library', 1), false)

'Select Technology\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Technology_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Technology', 1), false)

'Select Technology\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IP_Classification_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'IP_Class', 1), false)

'Set Variant'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Variant_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'IC_Name', 2))

'Set secondary owner'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Secondary_Owner_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Owner', 1))

'Click on name'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Name_Obj'))

'Click on create new project'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectType_New_Obj'))

'Select CMsystem\t\r\n\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CM_system_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'CM_system', 1), false)

'Set random value'
String random_number = RandomStringUtils.randomNumeric(3)

'set the path'
String path = ('UM_IC_' + random_number) + '_CMPath'

'Set CM path'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CMPath_Obj'), path)

'Select CM path type\t\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CMPathType_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Path', 2), false)

'Select CM path type\t\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Category_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'IC_Category', 1), false)

'Click on No'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Release_Package_no_Obj'))

'Click on search'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ActionSearch_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Window_Title', 2))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Company name_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Company', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Select_company_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Submit_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Window_Title', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set description'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Description_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Path', 1))

'Click on search'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CustomerName_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Window_Title', 2))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Company name_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Company', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Select_company_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Submit_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Window_Title', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for project abberivation\r\n\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), GlobalVariable.Wait_Time)

'Double click\r\n\t'
WebUI.doubleClick(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

'Double click\r\n\t'
WebUI.clearText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

'Set abberivation\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'IC_Name', 4))

'Set abberivation\r\n\t'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/AssociatedSchema_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue(
        'Associated schema', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

