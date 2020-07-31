import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
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

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_Global_Reports'), 
    [('ReportName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
            'ReportName', 1)], FailureHandling.OPTIONAL)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue('ReportName', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ReportName = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
    'ReportName', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ReportNameXpath = ('//a[contains(text(),"' + ReportName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ReportNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ReportNameObj.addProperty('xpath', ConditionType.EQUALS, ReportNameXpath)

'Click on Select ProjectName'
WebUI.verifyElementNotPresent(ReportNameObj, GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Delete_Global_Reports'), 
    [('ReportName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
            'AdvancedReportName', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Advanced_Report_Objects/Report_Name_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue('AdvancedReportName', 
        1))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def AdvancedReportName = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Create_Global_Report_TestData').getValue(
    'AdvancedReportName', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String AdvancedReportNameXpath = ('//a[contains(text(),"' + AdvancedReportName) + '")]'

'creating the Select ProjectName xpath object'
TestObject AdvancedReportNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
AdvancedReportNameObj.addProperty('xpath', ConditionType.EQUALS, AdvancedReportNameXpath)

'Click on Select ProjectName'
WebUI.verifyElementNotPresent(AdvancedReportNameObj, GlobalVariable.Wait_Time)

WebUI.closeBrowser()

