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

'Login to CDDS Url or Navigate to CDDS Url'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue('Main_Menu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Loading Icon not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for CreateProject  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Create_Project_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  CreateProject  '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Create_Project_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'))

'Wait for Alert popup to be visible'
WebUI.waitForAlert(GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Alert popup to be present'
WebUI.verifyAlertPresent(GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Click on Alert ok button'
WebUI.acceptAlert(FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait fo project field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Entering the name of the project'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue('Project_Name', 
        1))

'Wait fo project Description field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Project_Description_Obj'), 
    GlobalVariable.Element_Timeout)

'Entering the project Description '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Project_Description_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue('Project_Description', 
        1))

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'))

'Wait for Alert popup to be visible'
WebUI.waitForAlert(GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Alert popup to be present'
WebUI.verifyAlertPresent(GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Click on Alert ok button'
WebUI.acceptAlert(FailureHandling.CONTINUE_ON_FAILURE)

'Close window title'
WebUI.closeWindowTitle(findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
        'Window_Title', 1))

'Switch to default content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue('Main_Menu', 
            1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : '', ('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue('Project_Name', 
            1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'Project_Abbr', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'Business_Group', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'UserID', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Project_TestData').getValue(
            'Associated_Schema', 1), ('TC_Name_Path1') : ''], FailureHandling.STOP_ON_FAILURE)

'Close browser'
WebUI.closeBrowser()

