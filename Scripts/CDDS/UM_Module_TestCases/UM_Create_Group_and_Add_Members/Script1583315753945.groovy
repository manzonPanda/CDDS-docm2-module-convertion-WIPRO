import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Groups'], FailureHandling.STOP_ON_FAILURE)

'Create a Group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Groups'), [('GroupName') : findTestData('CDDS/Generic_TestData/Create_Group').getValue(
            'GroupName', 5), ('Company') : findTestData('CDDS/Generic_TestData/Create_Group').getValue('Company', 5), ('Description') : findTestData(
            'CDDS/Generic_TestData/Create_Group').getValue('Description', 5)], FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the GroupName'
String GroupName = findTestData('CDDS/Generic_TestData/Create_Group').getValue('GroupName', 5)

'creating a GroupName dynamic xpath'
String GroupNameXpath = ('//a[contains(text(),"' + GroupName) + '")]'

'creating the SubMenu xpath object'
TestObject GroupNameObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
GroupNameObj.addProperty('xpath', ConditionType.EQUALS, GroupNameXpath)

'Wait for SubMenu  element to be visible'
WebUI.waitForElementVisible(GroupNameObj, GlobalVariable.Element_Timeout)

//'Scroll to  SubMenu  element '
//WebUI.scrollToElement(GroupNameObj, GlobalVariable.Element_Timeout)
'Click on SubMenu'
WebUI.click(GroupNameObj)

'Add Members with x1048749'
WebUI.callTestCase(findTestCase('CDDS/UM_Module_TestCases/Add_Members'), [('UserID') : findTestData('CDDS/UM_Module_TestData/Add_Members').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Add Members with x0275811'
WebUI.callTestCase(findTestCase('CDDS/UM_Module_TestCases/Add_Members'), [('UserID') : findTestData('CDDS/UM_Module_TestData/Add_Members').getValue(
            'UserID', 2)], FailureHandling.STOP_ON_FAILURE)

'switch to Default '
WebUI.switchToDefaultContent()

'Navigate to My Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Groups'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_ Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the CompanyName'
String Company = findTestData('CDDS/Generic_TestData/Create_Group').getValue('Company', 5)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_ Company_Dropdown_Obj'), 
    Company, false)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_GroupName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1  in Search field'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_GroupName_Obj'), GroupName)

'Wait for MyGroups Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/MyGroups_ChkBx_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on MyGroup Checkbox'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/MyGroups_ChkBx_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Delete the Group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Group'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

