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

'Login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/UM_DZ_vs_Standard').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/UM_DZ_vs_Standard').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Company_select element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Company_select_Obj'), GlobalVariable.Element_Timeout)

'Select company'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Company_select_Obj'), findTestData('CDDS/UM_Module_TestData/UM_DZ_vs_Standard').getValue(
        'Company', 1), false)

'Set Userid'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/UserId_Obj'), findTestData('CDDS/UM_Module_TestData/UM_DZ_vs_Standard').getValue(
        'Id', 1))

'Click on find'
WebUI.doubleClick(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Find_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for checkbox  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Checkbox_Obj'), GlobalVariable.Element_Timeout)

'Click on Checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Checkbox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for edit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Edit_Obj'), GlobalVariable.Element_Timeout)

'Click on edit Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Edit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Standard_ element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Standard_Obj'), GlobalVariable.Element_Timeout)

'Click on Standard_ Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Standard_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Checkbox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for edit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Edit_Obj'), GlobalVariable.Element_Timeout)

'Click on edit Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Edit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  secure id /ODC element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Secure_ID_Obj'), GlobalVariable.Element_Timeout)

'Click on  secure id /ODC '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Secure_ID_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

'Wait till done is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_DZ_vs_Standard/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

