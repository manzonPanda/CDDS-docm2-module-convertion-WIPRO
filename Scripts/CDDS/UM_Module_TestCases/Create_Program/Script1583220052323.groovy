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

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Program').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Program/Create Program_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Create Program_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select Owing BU'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Program/BusinessUnit_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Program/BusinessUnit_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'BU', 1), false)

'Select Technology'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Program/Technology_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Technology', 1), false)

'Select Model'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Program/Engagement Model_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Model', 1), false)

'Select Workflow'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Program/WorkflowTemplate_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Workflow', 1), false)

'Set random value'
String random_number = RandomStringUtils.randomNumeric(3)

'set the path'
String name = 'UM_Program' + random_number

String abberivation = ('UM_Program_' + random_number) + 'abbrv'

'Set Program name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Program/ProgramName_Obj'), name)

'Set program version'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Program/ProgramVersion_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Version', 1))

'Set program Description'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Program/ProgramDescription_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Description', 1))

'Click on Calendar'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Calendar_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on Calendar'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Today_Obj'), FailureHandling.STOP_ON_FAILURE)

'Set secondary owner'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Program/SecondaryOwner_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Sec_owner', 1))

'Click on name'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Name_Obj'))

'Click on create new project'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectType_New_Obj'))

'Click on search'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Project company_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Window_Title', 2))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Company name_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
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
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/Create_Program').getValue('Window_Title', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for project abberivation\r\n\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), GlobalVariable.Wait_Time)

'Double click\r\n\t'
WebUI.doubleClick(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

'Set abberivation\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), abberivation)

'Set abberivation\r\n\t'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/AssociatedSchema_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Associated schema', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait till done is not visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Program/Program_Header_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Program').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Set abberivation\r\n\t'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Program/Keyword_obj'), name)

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Program_Obj'))

'Click on find'
WebUI.doubleClick(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a program dynamic xpath'
String nameXpath = ('//a[contains(.,"' + name) + '")]'

println(nameXpath)

'creating the program xpath object'
TestObject namebj = new TestObject('objectName')

'adding property in program dynamic xpath'
namebj.addProperty('xpath', ConditionType.EQUALS, nameXpath)

'Wait for program  element to be visible'
WebUI.waitForElementVisible(namebj, GlobalVariable.Short_Wait)

'Scroll to  program  element '
WebUI.scrollToElement(namebj, GlobalVariable.Element_Timeout)

'Click on program'
WebUI.click(namebj)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on member'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Program/Member_Obj'), GlobalVariable.Wait_Time)

'Click on member'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Member_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for add member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Program/Action_Member_Obj'), GlobalVariable.Wait_Time)

'Click on  add member'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Action_Member_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/Create_Program').getValue('Window_Title', 4))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to frame\r\n\t\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select Type a person'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Program/Type_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Name', 2), false)

'Select ID'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Program/UserID_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Sec_owner', 1), FailureHandling.STOP_ON_FAILURE)

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select Secondary Owner'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Program/Function_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
        'Sec_owner', 2), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/Create_Program/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/UM_Module_TestCases/Delete Member delete program'), [('program') : name, ('Id') : findTestData(
            'CDDS/UM_Module_TestData/Create_Program').getValue('Sec_owner', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

