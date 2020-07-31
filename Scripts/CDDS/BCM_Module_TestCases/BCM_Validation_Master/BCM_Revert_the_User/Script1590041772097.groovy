import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('MainMenu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Select company as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Company'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('Company', 1), 
    false)

'Enter User ID (Shaek)'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/UserId'), GlobalVariable.Non_Support_Role_Username)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Scroll to get the row id'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Select row'), 
    5)

'Select the user ID row'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Select row'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Actions||Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Actions'))

'Unable to click on Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Edit'))

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select Proc HW BU from selected BU list'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Business Unit_selected'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('BusinessUnit', 
        1), false)

'Click on Prev arrow'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Business Unit_Prev'))

'Select BU ITS-Design systems from available BU list'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Business Unit_Available'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('BusinessUnit', 
        2), false)

'Click on Next arrow'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/Business Unit_Next'))

'Select CCDS Roles BU as API User'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/CDDS Roles_Selected'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('BusinessUnit', 
        3), false)

'Click on Prev arrow'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/CDDS Roles_Prev'))

'Select CCDS Roles BU as TI Business Unit Admin'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/CDDS Roles_Selected'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('BusinessUnit', 
        4), false)

'Click on Prev arrow'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/CDDS Roles_Prev'))

'Select CCDS Roles BU as TI User Admin'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/CDDS Roles_Selected'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Revert_the_User').getValue('BusinessUnit', 
        5), false)

'Click on Prev arrow'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Revert_the_User/CDDS Roles_Prev'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

