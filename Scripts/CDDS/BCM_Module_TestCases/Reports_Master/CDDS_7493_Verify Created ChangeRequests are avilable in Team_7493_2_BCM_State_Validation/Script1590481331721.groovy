import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Get the Validate_Requirement_With_Different_State from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CDDS_7493_CreateChangeRequest_1_BCM_State_Validation')

for (def index : (1..data.getRowNumbers())) {
    'Login to CDDS Application or navigate to CDDS Application'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue('User_ID', 
                index)], FailureHandling.STOP_ON_FAILURE)

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue('Main_Menu', 
                index), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
                'Sub_Menu', index)], FailureHandling.STOP_ON_FAILURE)

    def Project_Name = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
        'ProjectName', 2)

    'Get the Data Value'
    def val = 1

    WebUI.delay(GlobalVariable.Wait_Time)

    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
        GlobalVariable.Element_Timeout)

    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
        Project_Name)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(GlobalVariable.Wait_Time)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    //def ProjectName = Project_Name
    //println(ProjectName)
    'creating a Select ProjectNameXpath dynamic xpath'
    String ProjectNameXpath = ('//a[contains(text(),"' + Project_Name) + '")]'

    'creating the Select ProjectName xpath object'
    TestObject ProjectNameObj = new TestObject('objectName')

    'adding property in Select ProjectName dynamic xpath'
    ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

    'Wait for  Select ProjectName  element to be visible'
    WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

    'Wait for  Select ProjectName  element to be visible'
    WebUI.click(ProjectNameObj)

    WebUI.delay(GlobalVariable.Wait_Time)

    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Project Inbox Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Project Inbox Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Keyword_Obj'), GlobalVariable.Element_Timeout)

    WebUI.setText(findTestObject('CDDS/Generic_Objects/Common_Objects/Keyword_Obj'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CDDS_7493_CreateChangeRequest_1_BCM_State_Validation').getValue(
            'BCMTitle', index))

    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/State_Check_dropdown'), GlobalVariable.Element_Timeout)

    WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Common_Objects/State_Check_dropdown'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CDDS_7493_CreateChangeRequest_1_BCM_State_Validation').getValue(
            'StateCheck', index), false)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(GlobalVariable.Wait_Time)

    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to Details Display Frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to Portal Frame\r\n'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Project Inbox Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

    'Swicth to BCM Project Inbox Command frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Get Actual CR title value'
    String Actual_CRTitle = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/CDDS_7493_CreateChangeRequest_1_BCM_State_Validation/Get_CR_Title'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    'Triming got bug title value'
    String Actual_CRTitle_trim = Actual_CRTitle.trim()

    'Verify actual and expected value'
    WebUI.verifyMatch(Actual_CRTitle_trim, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CDDS_7493_CreateChangeRequest_1_BCM_State_Validation').getValue(
            'BCMTitle', index), false, FailureHandling.CONTINUE_ON_FAILURE)

    'Get Actual Incident title value'
    String Actual_State = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Bug/Get_State_Status'))

    'Triming got bug title value'
    String Actual_State_trim = Actual_State.trim()

    'Verify actual and expected value'
    WebUI.verifyMatch(Actual_State, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CDDS_7493_CreateChangeRequest_1_BCM_State_Validation').getValue(
            'State_CR', index), false, FailureHandling.STOP_ON_FAILURE)

    WebUI.closeBrowser()
}

