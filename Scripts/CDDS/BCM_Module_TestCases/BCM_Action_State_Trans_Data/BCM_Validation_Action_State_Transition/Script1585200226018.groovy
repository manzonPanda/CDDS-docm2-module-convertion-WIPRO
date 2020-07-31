import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the edit functionality details from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition')

'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Assign a role to variable'
    String role = findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
        'Role', index)

    'Print the role'
    println('BCM_State_Validation_Edit_Functionality_Trans_State || ' + role)

    'Switch to Default'
    WebUI.switchToDefaultContent()

    'Validation edit functionlity'
    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Action_Edit_Fun_Master/Generic _Validation_Edit_Functionality'), 
        [('Criteria') : '', ('Type') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Type', index), ('Select_project') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Project', index), ('Project_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Project_Name', index), ('BU') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'BU', index), ('Schema') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Associate_schema', index), ('Owner') : GlobalVariable.Non_Support_Role_Username, ('State_type') : findTestData(
                'CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'StateCheck', index), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Description', index), ('Priority') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Priority', index), ('Assignee') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue(
                'Name', 3)], FailureHandling.STOP_ON_FAILURE)

    if (index > 1) {
        'Switch to window'
        WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

        'Verify the option target state'
        WebUI.verifyTextPresent(findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                'Target', index), false, FailureHandling.CONTINUE_ON_FAILURE)

        'Select the target'
        WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Action_State_Trans_Data/Select assignee'), [('Target') : findTestData(
                    'CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                    'TargetState', index), ('Team') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
                    'Project_Name', index), ('Assignee') : findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue(
                    'Name', 3)], FailureHandling.STOP_ON_FAILURE)

        'Switch to default'
        WebUI.switchToDefaultContent()

        'Navigate to frame'
        WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

        'Switch to frame'
        WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
            GlobalVariable.Wait_Time)

        'Switch to frame'
        WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
            GlobalVariable.Wait_Time)

        'Switch to frame'
        WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
            GlobalVariable.Wait_Time)

        'Switch to frame'
        WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

        'Assign a targetstate to a variable'
        String TargetState = findTestData('CDDS/BCM_Module_TestData/BCM_Action_State_Trans_Data/BCM_Validation_Action_State_Transition').getValue(
            'Target_Table', index)

        'creating targetstateXpath dynamic xpath'
        String targetXpath = ('//td[contains(.,"Action_Katalon")]/../td[contains(.,"' + TargetState) + '")]'

        'creating the Select targetstate xpath object'
        TestObject targetstateObj = new TestObject('objectName')

        'adding property in Select targetstate dynamic xpath'
        targetstateObj.addProperty('xpath', ConditionType.EQUALS, targetXpath)

        'Delay for few sec'
        WebUI.delay(GlobalVariable.Short_Wait)

        'Wait for  Select targetstate  element to be visible'
        WebUI.waitForElementVisible(targetstateObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

        'verify the table'
        WebUI.verifyElementVisible(targetstateObj, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        'Switch to default'
        WebUI.switchToDefaultContent()

        'Click on find'
        WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Done_Obj'))

        'Delay for few sec'
        WebUI.delay(GlobalVariable.Wait_Time)
    }
    
    'Validation of different role'
    println(('BCM_State_Validation_Edit_Functionality_Trans_State || ' + role) + ' is verifed')

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Wait_Time)
}

'Refresh the page'
WebUI.refresh()

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

