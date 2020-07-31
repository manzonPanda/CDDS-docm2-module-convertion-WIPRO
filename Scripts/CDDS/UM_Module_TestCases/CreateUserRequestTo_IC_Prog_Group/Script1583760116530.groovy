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

'Login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  user tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Menu1', 1), ('SubMenu') : findTestData(
            'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Createuser element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Create User_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Create user'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Create User_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select company'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Company_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Company', 1), false)

'Set UserID'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Id_Obj'), findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue(
        'Id', 1))

'Select company'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/BussinessUnit_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Select company'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/BussinessUnit_Obj'), 
    findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('BU', 1), false)

'Click on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Select filesite'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Filesite_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Filesite', 1), false)

'Select role'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Role_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Role', 1), false)

'Click on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Role_Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on arrow'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Search_group_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Title', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set groupname'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Group_name_Obj'), GlobalVariable.Element_Timeout)

'Set groupname'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Group_name_Obj'), findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue(
        'Id', 2))

'Click on Find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Find_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till pages loads'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Group_checkbox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Select function'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Function_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Function', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Submit'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Submit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Search the component'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Search_ Component_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Title', 2))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set groupname'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/ComponentName_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Id', 3))

'Click on Find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Find_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till pages loads'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Group_checkbox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Select function'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Function_Component_Obj'), 
    findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Function', 2), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Submit'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Submit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Search the program'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Search_program_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Title', 3))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set groupname'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/ProgramName_Obj'), findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue(
        'Id', 4))

'Click on Find'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Find_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till pages loads'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Group_checkbox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Select function'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Function_Program_Obj'), 
    findTestData('CDDS/UM_Module_TestData/CreateUserRequestTo_IC_Prog_Group').getValue('Function', 2), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Submit'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Submit_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for done'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Done_Obj'), GlobalVariable.Element_Timeout)

'Click on done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Done_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on done'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Done_Obj'), FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till pages loads'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateUserRequestTo_IC_Prog_Group/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

