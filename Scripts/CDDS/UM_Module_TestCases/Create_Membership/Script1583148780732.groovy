import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
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
            'GroupName', 2), ('Company') : findTestData('CDDS/Generic_TestData/Create_Group').getValue('Company', 2), ('Description') : findTestData(
            'CDDS/Generic_TestData/Create_Group').getValue('Description', 2)], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_GroupName_Obj'), GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_GroupName_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue(
        'GroupName', 1))

'Wait for MyGroups Checkbox element to be visible '
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/MyGroups_ChkBx_Obj'), GlobalVariable.Element_Timeout)

'Check the MyGroups Checkbox '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/MyGroups_ChkBx_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate to Table Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Table GroupName  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Table_GroupName_Obj'), GlobalVariable.Element_Timeout)

'Select the GroupName Link'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Table_GroupName_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to DisplayDetails  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add Member  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Add_Member_Obj'), GlobalVariable.Element_Timeout)

'Click on  Add Member  '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Add_Member_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Add Member window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 2))

'Maximize the Add Member Window'
WebUI.maximizeWindow()

'Navigate to Search page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search UserID  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the SearchUserID  as X1048749'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue(
        'UserID', 1))

'Wait for Find btn  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Select Member Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Select_Member_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Scroll to Member Checkbox element'
WebUI.scrollToElement(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Select_Member_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Select  the Member Checkbox '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Select_Member_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Search UserID  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the SearchUserID  as X1048749'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_UserId_Obj'), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue(
        'UserID', 1))

'Wait for Find btn  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate  to Table Frame2'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame_2'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Group name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_Table_UserId_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Group Name'
ActualUserID = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Search_Table_UserId_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual SearchGroupName'
println(ActualUserID)

'Verify Equal Actual SearchGroupNamewith expected SearchGroupName'
WebUI.verifyEqual(ActualUserID.trim(), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue('UserID', 1), 
    FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Company  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Table_Company_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchCompany'
ActualSearchCompany = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Table_Company_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchCompany)

'Verify Equal ActualSearchCompany with expected SearchCompany'
WebUI.verifyEqual(ActualSearchCompany.trim(), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue('Company', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Function  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Table_Function_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchFunction'
ActualSearchFunction = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Table_Function_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchFunction)

'Verify Equal ActualSearchFunction with expected SearchFunction'
WebUI.verifyEqual(ActualSearchFunction.trim(), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue('Function', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate  to Table Frame2'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame_2'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Select Member Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Select_Member_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Scroll to Member Checkbox element'
WebUI.scrollToElement(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Select_Member_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Select  the Member Checkbox '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Select_Member_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Display Details frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Remove Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Remove_Member_Obj'), GlobalVariable.Element_Timeout)

'Click on Remove Member'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Membership_Objects/Remove_Member_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on Ok Button Alert popup'
WebUI.acceptAlert()

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

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_ Company_Dropdown_Obj'), 
    findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue('Company', 1), false)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_GroupName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1  in Search field'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_Group_and_Add_Members/Search_GroupName_Obj'), findTestData(
        'CDDS/UM_Module_TestData/Create_Membership').getValue('GroupName', 1))

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

'Wait for Few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Close the Browser'
WebUI.closeBrowser()

