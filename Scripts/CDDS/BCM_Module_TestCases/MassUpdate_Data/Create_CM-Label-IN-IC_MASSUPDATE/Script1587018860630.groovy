import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Select Owing BU'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'OwingBU', 1), false)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'Search_Name', 1))

'Assign a value to string'
String IC = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Name', 1)

'Click on find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a IC dynamic xpath'
String ICXpath = ('//a[contains(.,"' + IC) + '")]'

'creating the SubMenu xpath object'
TestObject ICObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ICObj.addProperty('xpath', ConditionType.EQUALS, ICXpath)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  IC  element '
WebUI.scrollToElement(ICObj, GlobalVariable.Element_Timeout)

'Click on IC'
WebUI.click(ICObj, FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for CM label to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CM_Label_Btn_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on CM label'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CM_Label_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add CM Label... to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/Add CM Label_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Add CM Label... Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/Add CM Label_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CMLabel_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CMLabel_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('ProjectAbbreviation', 
        1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Delay for fe sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on unique\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Unique_Obj'))

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

String CMlabel = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'ProjectAbbreviation', 1)

'creating a IC dynamic xpath'
String CMlabelXpath1 = ('//a[contains(.,"' + CMlabel) + '")]'

'creating the Ic xpath object'
TestObject CMlabelObj1 = new TestObject('objectName')

'adding property in Ic dynamic xpath'
CMlabelObj1.addProperty('xpath', ConditionType.EQUALS, CMlabelXpath1)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(CMlabelObj1, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  IC  element '
WebUI.scrollToElement(CMlabelObj1, GlobalVariable.Element_Timeout)

'Click on IC'
WebUI.verifyElementVisible(CMlabelObj1, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

