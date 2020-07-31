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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to Companies'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Company').getValue('MainMenu', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Company').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for CreateCompany element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Create_Company_tab_obj'), GlobalVariable.Element_Timeout)

'Click on Create Company'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Company/Create_Company_tab_obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Company Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/company_name_obj'), GlobalVariable.Element_Timeout)

'Set random value'
String random_number = RandomStringUtils.randomNumeric(2)

'set the path'
String path = 'UM_Comp_' + random_number

'Set the company name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Company/company_name_obj'), path)

'Set the company name'
not_run: WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Company/company_name_obj'), findTestData('CDDS/UM_Module_TestData/Create_Company').getValue(
        'Company', 1))

'Wait for Group Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/TIpass_relaship_obj'), GlobalVariable.Element_Timeout)

'Set the TI Pass relationship'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Company/TIpass_relaship_obj'), findTestData('CDDS/UM_Module_TestData/Create_Company').getValue(
        'TIPass relationship', 1))

'Wait for Group Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Roles_select_obj'), GlobalVariable.Element_Timeout)

'Select the role required'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Company/Roles_select_obj'), findTestData('CDDS/UM_Module_TestData/Create_Company').getValue(
        'Roles', 1), false)

'Save the selected role by clicking on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Company/Roles_save_arrow_obj'))

'Wait for Group Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/FileSite_select_obj'), GlobalVariable.Element_Timeout)

'Select the File site required'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Company/FileSite_select_obj'), findTestData('CDDS/UM_Module_TestData/Create_Company').getValue(
        'FileSite', 1), false)

'Save the selected File site by clicking on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Company/Filesite_save_arrow_obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Done_btn_obj'), GlobalVariable.Element_Timeout)

'Mouse over the done button'
WebUI.mouseOver(findTestObject('CDDS/UM_Module_Objects/Create_Company/Done_btn_obj'))

'Click on Done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Company/Done_btn_obj'))

'wait for alert to be visible (In case the comany name is already existing)'
if (WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
    'Get the alert Text'
    ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

    'Print the alert text'
    println(ActualGetTextAlert)

    'Check if the alert text contains "already exists"'
    if (ActualGetTextAlert.contains('already exist')) {
        WebUI.acceptAlert(FailureHandling.OPTIONAL)

        println('alert accepted')
    }
    
    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till the loading symbol is not visible'
WebUI.waitForElementNotVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Loading_obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Navigate to  company Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for comany element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/search_company_obj'), GlobalVariable.Element_Timeout)

'Set the compant to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Company/search_company_obj'), path)

'Wait for Find button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Find_btn_obj'), GlobalVariable.Element_Timeout)

'Click the find button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Company/Find_btn_obj'))

'Navigate Company Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Company name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Table_CompanyName_obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Company Name'
CompanyName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_Company/Table_CompanyName_obj'), FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Company Name'
println(CompanyName)

'Verify Equal Actual CompanyName with expected Company Name'
WebUI.verifyEqual(CompanyName.trim(), path, FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result TI pass element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Table_TIPass_obj'), GlobalVariable.Element_Timeout)

'Get the Actual TI pass value'
TIPassName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_Company/Table_TIPass_obj'), FailureHandling.STOP_ON_FAILURE)

'Print Actual TI pass value'
println(TIPassName)

'Verify Equal Actual TI Pass value with expected TI pass value'
WebUI.verifyEqual(TIPassName.trim(), findTestData('CDDS/UM_Module_TestData/Create_Company').getValue('TIPass relationship', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

