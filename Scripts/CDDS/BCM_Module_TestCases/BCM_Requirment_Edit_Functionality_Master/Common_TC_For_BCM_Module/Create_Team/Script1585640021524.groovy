import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/ProjectName_Obj'), ProjectName)

'Wait for Select Business Unit to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Business_Unit_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Business Unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Business_Unit_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Assigned_State_TestData').getValue(
        'Business_Unit', 1), false)

'Wait for Show element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Show_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Show'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Select_Show_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Requirment_Edit_Functionality_Master_TestData/BCM_State_Validation_Edit_Functionality_Assigned_State_TestData').getValue(
        'Show', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj, FailureHandling.OPTIONAL)

'Switch to Default Content'
WebUI.switchToDefaultContent()

//String SubMenuXpath = ('//label[text()="' + SubMenu) + '"]'
'creating a ProjectNameLink dynamic xpath'
String ProjectNameLinkXpath = ('(//label[text()="' + ProjectName) + '"])[1]'

'creating the ProjectNameLink xpath object'
TestObject ProjectNameLinkObj = new TestObject('objectName')

'adding property in ProjectNameLink dynamic xpath'
ProjectNameLinkObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameLinkXpath)

'Wait for ProjectNameLink  element to be visible'
WebUI.waitForElementVisible(ProjectNameLinkObj, GlobalVariable.Element_Timeout)

'Click on ProjectNameLink'
WebUI.click(ProjectNameLinkObj)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Action_Default_Obj'), GlobalVariable.Element_Timeout)

'Verfiy Action Default'
WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Action_Default_Obj'), GlobalVariable.Element_Timeout)

'Switch to Default content'
WebUI.switchToDefaultContent()

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Create_Team_Obj'), GlobalVariable.Element_Timeout)

'Click on  Create Team'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Create_Team_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for TeamName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/TeamName_Obj'), GlobalVariable.Element_Timeout)

'Set the TeamName'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/TeamName_Obj'), TeamName)

'Wait for TeamDescription element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Description_Obj'), GlobalVariable.Element_Timeout)

'Set the TeamDescription'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Description_Obj'), TeamDescription)

'Wait for TeamBaseSite element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Base_Site_Obj'), GlobalVariable.Element_Timeout)

'Set the TeamBaseSite'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Base_Site_Obj'), TeamBaseSite, false)

'Wait for BCMElementsFill element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/BCMElementsFill_Obj'), GlobalVariable.Element_Timeout)

'Select the BCMElementsFill'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/BCMElementsFill_Obj'))

'Switch to Default'
WebUI.switchToDefaultContent()

'Wait for BCMElementsFill element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Done_Btn_Obj'))

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

