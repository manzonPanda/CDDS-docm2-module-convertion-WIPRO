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

'Login to the application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

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

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectName'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
        'Project_Name', 1))

'Wait for ProjectAbbreviation element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectAbbreviation_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectAbbreviation'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectAbbreviation_Obj'), findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
        'ProjectAbbreviation', 1))

'Wait for ProjectDescription element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/ProjectDescription_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectDescription'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/ProjectDescription_Obj'), findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
        'ProjectDescription', 1))

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/BusinessUnit_Obj'), findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
        'BusinessGroup', 1), false)

'Wait for ProjectAbbreviation element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectOwner_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectOwner'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectOwner_Obj'), findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
        'UserID', 1))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for  Select ProjectOwner  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Select_Project_Owner_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Click on Select ProjectOwner'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Select_Project_Owner_Obj'), FailureHandling.OPTIONAL)

'Wait for AssociateSchema element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Associate_Schema_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a AssociateSchema '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Associate_Schema_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue('AssociatedSchema', 1), false)

'Wait for TITeamMembrAccess element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/TITeamMembrAccess_Obj'), GlobalVariable.Element_Timeout)

'Wait for TITeamMembrAccess element to be visible'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/TITeamMembrAccess_Obj'), GlobalVariable.Wait_Time)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select a TITeamMembrAccess '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateProject/TITeamMembrAccess_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time)

'ActualGetTextAlert'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
}

'Close the window'
WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1), FailureHandling.OPTIONAL)

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

