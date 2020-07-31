import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Program').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Assign a value to  variable '
String program = program

'creating a program dynamic xpath'
String programXpath = ('//a[contains(.,"' + program) + '")]'

'creating the program xpath object'
TestObject programObj = new TestObject('objectName')

'adding property in program dynamic xpath'
programObj.addProperty('xpath', ConditionType.EQUALS, programXpath)

'Wait for program  element to be visible'
WebUI.waitForElementVisible(programObj, GlobalVariable.Short_Wait)

'Scroll to  program  element '
WebUI.scrollToElement(programObj, GlobalVariable.Element_Timeout)

'Click on program'
WebUI.click(programObj)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for member element to be visible'
WebUI.waitForElementVisible(findTestObject('Object Repository/CDDS/UM_Module_Objects/Create_Program/Member_dd_Obj'), GlobalVariable.Element_Timeout)

'Click on member'
WebUI.click(findTestObject('Object Repository/CDDS/UM_Module_Objects/Create_Program/Member_dd_Obj'))

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame_2'), [:], FailureHandling.STOP_ON_FAILURE)

/*//td[contains(.,'a0393993')]/..//input[@name="emxTableRowId"]*/
'Assign a value to  variable '
String id = Id

'creating a program dynamic xpath'
String idXpath = ('//td[contains(.,"' + id) + '")]/..//input[@name="emxTableRowId"]'

'creating the program xpath object'
TestObject idObj = new TestObject('objectName')

'adding property in program dynamic xpath'
idObj.addProperty('xpath', ConditionType.EQUALS, idXpath)

'Wait for program  element to be visible'
WebUI.waitForElementVisible(idObj, GlobalVariable.Short_Wait)

'Scroll to  program  element '
WebUI.scrollToElement(idObj, GlobalVariable.Element_Timeout)

'Click on program'
WebUI.click(idObj)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on remove Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Remove_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on ok\r\n'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on ok\r\n'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Refresh the page'
WebUI.refresh()

'Switch to default'
WebUI.switchToDefaultContent()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Program').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/Create_Program').getValue('Menu1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/Create_Program').getValue(
            'Menu2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a program dynamic xpath'
String programcheckXpath = ('//td[contains(.,"' + program) + '")]/..//input[@name="emxTableRowId"]'

'creating the program xpath object'
TestObject programcheckObj = new TestObject('objectName')

'adding property in program dynamic xpath'
programcheckObj.addProperty('xpath', ConditionType.EQUALS, programcheckXpath)

'Wait for program  element to be visible'
WebUI.waitForElementVisible(programcheckObj, GlobalVariable.Short_Wait)

'Scroll to  program  element '
WebUI.scrollToElement(programcheckObj, GlobalVariable.Element_Timeout)

//WebUI.click(programobj)
'Click on program'
WebUI.click(programcheckObj)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on delete Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Program/Delete_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on ok\r\n'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on ok\r\n'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for program  element to be not  visible'
WebUI.waitForElementNotVisible(programcheckObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

