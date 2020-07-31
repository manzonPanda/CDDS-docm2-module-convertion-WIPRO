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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on my desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to company'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for profile toolbar to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/profile_toolbar_Obj'), 
    GlobalVariable.Element_Timeout)

'mouse over profile toolbar'
WebUI.mouseOver(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/profile_toolbar_Obj'))

'Click on Preference'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Preferences_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/PreferencesPane_Iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Pagination'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagination_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/PreferencesBody_iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the range'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagerange_Obj'), findTestData('CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue(
        'Range', 1))

'Click on no'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagination_No_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Done_Btn_Obj'))

'Delay fro few swc'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on my desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu2', 2)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'uncheck mygroup'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Mygroup_Obj'))

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Find_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify company'
WebUI.verifyElementVisible(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/TI_Company_Obj'), FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on my desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to company'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for profile toolbar to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/profile_toolbar_Obj'), 
    GlobalVariable.Element_Timeout)

'mouse over profile toolbar'
WebUI.mouseOver(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/profile_toolbar_Obj'))

'Click on Preference'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Preferences_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/PreferencesPane_Iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Pagination'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagination_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/PreferencesBody_iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the range'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagerange_Obj'), findTestData('CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue(
        'Range', 1))

'Click on no'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagination_yes_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Done_Btn_Obj'))

'Delay fro few swc'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on my desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu2', 2)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'uncheck mygroup'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Mygroup_Obj'))

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Find_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify company'
WebUI.verifyElementVisible(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/TI_Company_Obj'), FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on my desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to company'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for profile toolbar to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/profile_toolbar_Obj'), 
    GlobalVariable.Element_Timeout)

'mouse over profile toolbar'
WebUI.mouseOver(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/profile_toolbar_Obj'))

'Click on Preference'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Preferences_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/PreferencesPane_Iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Pagination'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagination_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/PreferencesBody_iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the range'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagerange_Obj'), findTestData('CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue(
        'Range', 2))

'Click on no'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Pagination_No_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Done_Btn_Obj'))

'Delay fro few swc'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on my desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate to group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/Validate_Preferences_Pagination').getValue('Menu2', 2)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'uncheck mygroup'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Mygroup_Obj'))

'Click on find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Validate_Preferences_Pagination/Find_Obj'))

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

