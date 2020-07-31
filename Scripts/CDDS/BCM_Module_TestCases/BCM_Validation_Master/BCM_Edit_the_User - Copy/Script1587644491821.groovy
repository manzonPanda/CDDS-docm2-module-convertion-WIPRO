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

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue('MainMenu', 1)
        , ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue('Company', 1), false)

'Wait for Search AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_UserId_Obj'), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue(
        'UserID', 1))

'Wait for FindBtn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  FindBtn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for checkbox Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Select the checkbox'
WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'))

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for actions button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on action button\r\n'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Wait for Edit... Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Edit_the_User_Objects/Edit_User_obj'), 
    GlobalVariable.Element_Timeout)

'Click on edit...'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Edit_the_User_Objects/Edit_User_obj'))

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search Selected BU Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Edit_the_User_Objects/Selected_BU_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on selected BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Edit_the_User_Objects/Selected_BU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue('Old_BU', 
        1), false)

'Wait for Search BU previous arrow button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Edit_the_User_Objects/BUArrow_Previous_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on BU previous arrow button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/BCM_Edit_the_User_Objects/BUArrow_Previous_Obj'))

'Wait for required BU elemet to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Select the required BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_BusinessUnit_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue('New_BU', 1), false)

'Wait for Arrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on  Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for required CDDS Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_CDDSRoles_Obj'), GlobalVariable.Element_Timeout)

'Click on required CDDS role'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_CDDSRoles_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue('CDDS_Role', 1), 
    false)

'Wait for CDDSArrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/CDDSRole_Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on CDDS Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/CDDSRole_Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for required CDDS Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_CDDSRoles_Obj'), GlobalVariable.Element_Timeout)

'Click on required CDDS role'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Select_CDDSRoles_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/BCM_Edit_the_User_Datafile').getValue('CDDS_Role', 2), 
    false)

'Wait for CDDSArrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/CDDSRole_Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on CDDS Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/CDDSRole_Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for some seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on done button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Done_Btn_Obj'))

'Wait till the loading symbol is not visible'
WebUI.waitForElementNotVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Loading_obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for few seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

