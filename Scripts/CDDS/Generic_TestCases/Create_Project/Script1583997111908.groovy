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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.delay(GlobalVariable.Wait_Time)

'Loading Icon not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for CreateProject  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Create_Project_Obj'), GlobalVariable.Element_Timeout)

'Click on  CreateProject  '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Create_Project_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectName'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), ProjectName)

'Wait for ProjectAbbreviation element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectAbbreviation_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectAbbreviation'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectAbbreviation_Obj'), ProjectAbbreviation)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/BusinessUnit_Obj'), BusinessUnit, 
    false)

'Wait for AssociateSchema element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Associate_Schema_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a AssociateSchema '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Associate_Schema_Obj'), AssociateSchema, 
    false)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for ProjectAbbreviation element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectOwner_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectOwner'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectOwner_Obj'), ProjectOwner)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'creating a Select ProjectOwnerXpath dynamic xpath'
not_run: String ProjectOwnerXpath = ('//b[contains(text(),"' + 'x') + '")]'

'creating the Select ProjectOwner xpath object'
not_run: TestObject ProjectOwnerObj = new TestObject('objectName')

'adding property in Select ProjectOwner dynamic xpath'
not_run: ProjectOwnerObj.addProperty('xpath', ConditionType.EQUALS, ProjectOwnerXpath)

'Wait for  Select ProjectOwner  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Select_Project_Owner_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Click on Select ProjectOwner'
WebUI.mouseOver(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Select_Project_Owner_Obj'), FailureHandling.OPTIONAL)

'Click on Select ProjectOwner'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Select_Project_Owner_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on Select ProjectOwner'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Select_Project_Owner_Obj'), FailureHandling.OPTIONAL)

'Get the Current TestCasesName '
if (GlobalVariable.currentTestCaseId.equals(TC_Name_Path)) {
    'Verify Grant TI  View Access'
    WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Grant TI View Access_Obj'), GlobalVariable.Element_Timeout)

    'Verify Grant TI  Team Member Access'
    WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Grant_TI_Team_Member_Access_Obj'), 
        GlobalVariable.Element_Timeout)
}

if (GlobalVariable.currentTestCaseId.equals(TC_Name_Path1)) {
    'Wait for Element  Grant TI  View Access to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/GrantTIViewAccess_Checkbox_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on   Grant TI  View Access '
    WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/GrantTIViewAccess_Checkbox_Obj'), FailureHandling.STOP_ON_FAILURE)
}

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.waitForAlert(GlobalVariable.Wait_Time)

'ActualGetTextAlert'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

    WebUI.delay(10)

    WebUI.switchToWindowIndex(0)
} else {
}

