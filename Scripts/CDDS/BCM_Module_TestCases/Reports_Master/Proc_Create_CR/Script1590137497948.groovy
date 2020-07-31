import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Login to CDDS Application or navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
            'Main_Menu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
            'Sub_Menu', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/ProjectGroup_Name'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/ProjectGroup_Name'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
        'Group_Name', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectGroup_Name = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
    'Group_Name', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectGroup_NameXpath = ('//a[contains(text(),"' + ProjectGroup_Name) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectGroup_NameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectGroup_NameObj.addProperty('xpath', ConditionType.EQUALS, ProjectGroup_NameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectGroup_NameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.click(ProjectGroup_NameObj)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.switchToDefaultContent()

'Wait for  Select ProjectName  element to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Bug_in_ProjectGroup/Group_Inbox'))

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/detailsDisplay2_Iframe'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'If Create BCM collaps expand it'
if (WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'), 
    GlobalVariable.Short_Wait)) {
    'Wait for Create BCM option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on CreateBCM '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'))

    'Wait for Change Requist element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Change Request tab'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
} else {
    'Wait for Change Requist element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Change Request tab'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Change_Request_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
}

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Severity select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Bug_in_ProjectGroup/Project_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Severity'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Bug_in_ProjectGroup/Project_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('ProjectName', 
        1), false)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Bug_in_ProjectGroup/Next_Button'), 
    GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_Bug_in_ProjectGroup/Next_Button'))

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Title field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Title'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMTitle', 1))

'Wait for Priority select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Select_Priority_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Priority'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Select_Priority_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMCustomerPriority', 1), 
    false)

'Wait for Calender Icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Calender_Icon_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Calender Icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Calender_Icon_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Date_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Date'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Date_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Description field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMDescription', 1))

'Wait for Justification field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Justification_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Justification '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Justification_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMJustification', 1))

'Wait for Clasification select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Clasification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMClassification', 1), false)

'Wait for Sub Clasification field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Sub_Classification_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Sub Clasification'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Sub_Classification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMSubClassification', 1), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Team select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Team'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMRespondingTeam', 1), false)

'Wait for Release field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Release_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Release'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Release_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('txt_release', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for TI Internal Comment field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_InternalComment_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter TI Internal comment'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_InternalComment_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMTIInternalComments', 1), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for TI External Comment field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_External_Comment_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter TI External comment'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/TI_External_Comment_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('ExternalComments', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Contact Dept Or Team field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Contact_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Contact Dept Or Team'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/Contact_Team_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMContactDepartment', 1), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for CQ ID field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/CQ_ID_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter CQ ID'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/CQ_ID_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMOtherID', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for External ID field to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/External_ID_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter External ID'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_CR_Objects/External_ID_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_CR').getValue('BCMExternalID', 1), FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'))

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

WebUI.closeBrowser()

