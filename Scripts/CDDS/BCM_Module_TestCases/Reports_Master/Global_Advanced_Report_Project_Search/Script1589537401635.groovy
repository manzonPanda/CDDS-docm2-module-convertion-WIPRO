import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login to CDDS Url or Navigate to CDDS Url'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Incidents_TestData').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk Tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Expand Bug and Change Management (BCM) and then click on Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Reports'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Advanced Reports element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Create_Advanced_Report_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Create Advanced Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Create_Advanced_Report_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Create Reports element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_FileName'), 
    GlobalVariable.Element_Timeout)

'Click on Create Report'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Create_GLobal_Report/Project_FileName'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 10))

'Maximise the window'
WebUI.maximizeWindow()

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            1), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 1)], FailureHandling.STOP_ON_FAILURE)

def ProjectName = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
    'ProjectName', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Click on Select ProjectName'
WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            2), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Searches/No_Matching_Data_Found'), 
    GlobalVariable.Wait_Time)

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            1), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 2)], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Searches/No_Matching_Data_Found'), 
    GlobalVariable.Wait_Time)

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            1), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 2), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Searches/No_Matching_Data_Found'), 
    GlobalVariable.Wait_Time)

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            3), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 2), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 2), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 3), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 3)], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

//if(WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)
not_run: for (int j = 0; j < 50; j++) {
    'Navigate to Action Frame'
    not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on AddMember'
    not_run: WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/NextPage_Button'))

    'Navigate to Action Frame'
    not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    not_run: WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    not_run: if (WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
        not_run: WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

        break
    }
}

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            3), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 2), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 3), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 3)], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

for (int i = 0; i < 50; i++) {
    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on AddMember'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/NextPage_Button'))

    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    if (WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

        break
    }
}

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            3), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 2), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 2), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 3), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

for (int k = 0; k < 50; k++) {
    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on AddMember'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/NextPage_Button'))

    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    if (WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

        break
    }
}

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            3), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 3), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 3)], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

for (int a = 0; a < 50; a++) {
    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on AddMember'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/NextPage_Button'))

    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    if (WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

        break
    }
}

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            3), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 2), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 3), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 3)], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

not_run: for (int b = 0; b < 50; b++) {
    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on AddMember'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Global_Report_Project_Search_Objects/NextPage_Button'))

    'Navigate to Action Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

    if (WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

        break
    }
}

WebUI.comment('============================================')

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Project_Search'), [('ProjectName') : findTestData(
            'CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue('ProjectName', 
            4), ('ShowProjects') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ShowProjects', 2), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'BusinessUnit', 2), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectAbbreviation', 4), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Global_Advanced_Report_Project_Search').getValue(
            'ProjectOwner', 3)], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Cancel button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Cancel button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Report_Objects/Cancel_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.closeBrowser()

