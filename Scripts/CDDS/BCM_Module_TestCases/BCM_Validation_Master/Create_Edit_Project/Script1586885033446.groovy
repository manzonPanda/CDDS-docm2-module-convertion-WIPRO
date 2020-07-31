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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue('MainMenu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue('SubMenu', 1)], 
    FailureHandling.STOP_ON_FAILURE)

'Create project\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'TC_Name_Path', 1), ('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'AssociateSchema', 1), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
            'TC_Name_Path1', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/ProjectName_obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue('ProjectName', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Find_Button_obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to verify table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the project name from data file'
String project = findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Edit_Project_Data').getValue(
    'ProjectName', 1)

'create xpath'
String Created_Xpath = ('//a[contains(.,"' + project) + '")]'

'Print the created xpath'
println(Created_Xpath)

'create new project object'
TestObject ProjectLinkObj = new TestObject('objectName')

'add xpath to object'
ProjectLinkObj.addProperty('xpath', ConditionType.EQUALS, Created_Xpath)

'Wait for project name in table  to be visible'
WebUI.waitForElementVisible(ProjectLinkObj, GlobalVariable.Element_Timeout)

'click on the project name in the table'
WebUI.click(ProjectLinkObj)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for project name TAB  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Project_TAB_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on the project name tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Project_TAB_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm project properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for BCM actions tab  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Actions_button'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click BCM action object'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Actions_button'), 
    FailureHandling.OPTIONAL)

'wait for edit option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Edit_Obj'), 
    GlobalVariable.Element_Timeout)

'click on edit option'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Edit_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BCM Element filling object  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/BCMElementFilling_Obj'), 
    GlobalVariable.Element_Timeout)

'Select false for BCM element filling '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/BCMElementFilling_Obj'))

'Wait for TI view access object  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/TIViewAccess_Obj'), 
    GlobalVariable.Element_Timeout)

'Select false for TI view access object'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/TIViewAccess_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'Wait till the loading symbol is not visible'
WebUI.waitForElementNotVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Loading_obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for project name TAB  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Project_TAB_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on the project name tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Project_TAB_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for BCM actions tab  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Actions_button'), 
    GlobalVariable.Element_Timeout)

'Click on Actions button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Actions_button'))

'Wait for edit button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Edit_Obj'), 
    GlobalVariable.Element_Timeout)

'click on edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/Edit_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify if BCM element filling is FALSE'
WebUI.verifyElementChecked(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/BCMElementFilling_Obj'), 
    GlobalVariable.Element_Timeout)

'Verify if TI View access is FALSE'
WebUI.verifyElementChecked(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Edit_Project_Objects/TIViewAccess_Obj'), 
    GlobalVariable.Element_Timeout)

'close browser'
WebUI.closeBrowser()

