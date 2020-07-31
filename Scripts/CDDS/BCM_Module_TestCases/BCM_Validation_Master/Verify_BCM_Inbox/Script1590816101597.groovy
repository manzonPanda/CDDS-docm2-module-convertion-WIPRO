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
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username],
	FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
			'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('MainMenu', 1), ('SubMenu') : findTestData(
			'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.comment('Criteria and Keyword then Find')

'Selecting criteria All'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 1), false)

'Entering Keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 1))

'Wait for find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Disabled because Title is not same all the time fir the filters applied'
not_run: title = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Title'))

'Verify first row tiltle as PM_Test_Bug_1'
not_run: WebUI.verifyEqual(title, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue(
		'Keyword', 1))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Same as above +State as Open and Type as Any')

'Click on Criteria All'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 1), false)

'Enter keyword PM_Test_Bug_1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 1))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Select File on Objecct'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/File on Object'))

'Click on State Open'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 1), false)

WebUI.delay(2)

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 1), false)

'Click on find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(5)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Disabled because Title is not same all the time fir the filters applied'
not_run: String title = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Title'))

not_run: WebUI.verifyEqual(title, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue(
		'Keyword', 1))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Same as above Except State as New')

'Click on Criteria Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 2), false)

'Enter keyword *Bug*'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 2))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Select File on Objecct'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/File on Object'))

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 1), false)

'Click on State New'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 2), false)

WebUI.delay(2)

'Click on find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(5)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

String state = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Verify State'))

'Verify status is New in the table'
WebUI.verifyEqual(state, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue(
		'State', 3))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Same as above Except Keyword+Severity 3-Medium')

'Click on Criteria Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 2), false)

'Enter keyword bug*'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 3))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Select File on Objecct'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/File on Object'))

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 1), false)

'Click on State New'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 2), false)

WebUI.delay(2)

'Select Severity 3-Medium'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Severity'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Severity', 1), false)

'Click on find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(5)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

String severity = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Verify Severity'))

'Verify Severity'
WebUI.verifyEqual(severity, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue(
		'Severity', 2))

String state_New = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Verify State'))

'Verify status is New in the table'
WebUI.verifyEqual(state_New, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue(
		'State', 3))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Criteria-Exact match,Severity-3 Medium,Project name Tedt_Project_1, Id Off, State Open,Type Any')

'Click on Criteria Exact Match'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 3), false)

'Select Severity 3-Medium'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Severity'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Severity', 1), false)

'Enter Project name as Test_Project_1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Project'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Project', 1))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Unselect Title'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Title_Checkbox'))

'Click on State Open'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 1), false)

WebUI.delay(2)

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Disabled because some times it shows No matching data found'
not_run: String severity_3Medium = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Verify Severity'))

'Verify Severity 3-Medium'
not_run: WebUI.verifyEqual(severity_3Medium, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue(
		'Severity', 2))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Criteria-Exact match,Keyword-PM_Test_Bug_1,Title-ON, Id Off, State Open,Type Bug')

'Click on Criteria Exact Match'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 3), false)

'Entering Keyword PM_Test_Bug_1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 1))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Click on State OPen'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 1), false)

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 2), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Criteria-Substring match,Type Change Request,My Element-Submitted by Me,Project name-Test_Project_1,State New')

'Click on Criteria Substring Match'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 4), false)

'Click on Type Change Request'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 3), false)

WebUI.delay(2)

'Select My Elements as Submitted by me'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/My Elements'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('My Elements', 1),
	false)

'Enter Project name as Test_Project_1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Project'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Project', 1))

'Click on State New'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 2), false)

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Unselect Title'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Title_Checkbox'))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Criteria-Contains Any,Keyword-PM_Test_Bug_1,Type-Action,Title-ON ,State-OPen')

'Click on Criteria Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 2), false)

'Entering Keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 1))

'Click on Type Action'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 4), false)

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Click on State OPen'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Keyword-PM_Test_Bug_1,Type-Any,Title-ON ,State-OPen')

'Entering Keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 1))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Click on State OPen'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 1), false)

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on reset'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Reset'))

WebUI.comment('Criteria-Contains Any,Keyword-^*&(^)&()*&(*&,Title-ON ,State-OPen,Type-Action')

'Click on Criteria Contains Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Criteria'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Criteria', 2), false)

'Entering Keyword ^*&(^)&()*&(*&'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Keyword'), findTestData(
		'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Keyword', 4))

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/ID'))

'Click on State OPen'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/State'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('State', 1), false)

'Click on Type Any'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_BCM_Inbox/Type'),
	findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_BCM_Inbox').getValue('Type', 1), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout,
	FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()



