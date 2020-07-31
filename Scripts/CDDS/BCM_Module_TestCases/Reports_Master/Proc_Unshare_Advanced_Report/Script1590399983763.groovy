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

WebUI.delay(GlobalVariable.Wait_Time)

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

'Wait for  Select ProjectName  element to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Create_Report/Reports_Tab'))

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Edit_Report/Report_Name'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Edit_Report/Report_Name'), findTestData(
        'CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_AdvancedReport').getValue('ReportName', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Table_Checkbox'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.check(findTestObject('CDDS/Generic_Objects/Common_Objects/Table_Checkbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Share/Unshare element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Share_Unshare_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Share/Unshare'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Share_Unshare_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to new window'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Select project option element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Select_Project_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Select project'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Select_Project_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('ProjectName', 
        1), false)

'Wait for Remove Project Icon element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Remove_Project_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Remove Project Icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Unshare_Report_Objects/Remove_Project_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done Button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Edit_Report/Report_Name'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Edit_Report/Report_Name'), findTestData(
        'CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_AdvancedReport').getValue('ReportName', 1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Actions_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Get Actual CR Description value'
String Actual_Shared = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Share_Report/Get_Private_Shared_Cell'))

'Triming got CR Description value'
String Actual_Shared1 = Actual_Shared.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_Shared1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_AdvancedReport').getValue(
        'Report_Shared', 2), false, FailureHandling.CONTINUE_ON_FAILURE)

'Get Actual Incident Description value'
String Actual_ReportName = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Proc_Share_Report/Get_ReportName'))

'Triming got Incident Description value'
String Actual_ReportName1 = Actual_ReportName.trim()

'Verify actual and expected value'
WebUI.verifyMatch(Actual_ReportName1, findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Proc_Create_AdvancedReport').getValue(
        'ReportName', 1), false, FailureHandling.CONTINUE_ON_FAILURE)

'Close the browser'
WebUI.closeBrowser()

