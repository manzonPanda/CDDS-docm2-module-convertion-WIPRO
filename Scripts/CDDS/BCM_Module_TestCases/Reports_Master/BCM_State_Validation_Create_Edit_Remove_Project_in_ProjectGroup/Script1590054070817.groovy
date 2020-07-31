import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
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

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Group/Create_New'), GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Project_Group/Create_New'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Group/Group_Name'), GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Group/Group_Name'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
        'Group_Name', 1))

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Group/Description_Obj'), GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Group/Description_Obj'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup').getValue(
        'Description', 1))

WebUI.switchToDefaultContent()

'Wait for Action element to be visible'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Create_New_Project_Group_Title'), 
    GlobalVariable.Element_Timeout)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'ActualGetTextAlert'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

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

println(ProjectGroup_NameXpath)

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

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Related_Projects'), 
    GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Related_Projects'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Add_Project'), 
    GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Add_Project'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 13))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

//def Related_Projects = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('ICName',  1 , + '*')
'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
        'ICName', 1) + '*')

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Find_Button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Find_Button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

def Project_Name1 = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
    'ICName', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String Project_Name1Xpath = ('//b[contains(text(),"' + Project_Name1) + '")]'

'creating the Select ProjectName xpath object'
TestObject Project_Name1Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
Project_Name1Obj.addProperty('xpath', ConditionType.EQUALS, Project_Name1Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(Project_Name1Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

def Project_Name2 = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
    'ICName', 2)

'creating a Select ProjectNameXpath dynamic xpath'
String Project_Name2Xpath = ('//b[contains(text(),"' + Project_Name2) + '")]'

'creating the Select ProjectName xpath object'
TestObject Project_Name2Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
Project_Name2Obj.addProperty('xpath', ConditionType.EQUALS, Project_Name2Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(Project_Name2Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Click on AddMember'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Project1_Checkbox'))

'Click on AddMember'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Project2_Checkbox'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Select_Button'), 
    GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Select_Button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.switchToDefaultContent()

'Click onn Create'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Related_Projects'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectName1Xpath = ('//a[contains(text(),"' + Project_Name1) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectName1Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectName1Obj.addProperty('xpath', ConditionType.EQUALS, ProjectName1Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(ProjectName1Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectName2Xpath = ('//a[contains(text(),"' + Project_Name2) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectName2Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectName2Obj.addProperty('xpath', ConditionType.EQUALS, ProjectName2Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(ProjectName2Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

def BusinessUnit1 = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
    'OwningBU', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String BusinessUnit1Xpath = ('//td[contains(text(),"' + BusinessUnit1) + '")]'

'creating the Select ProjectName xpath object'
TestObject BusinessUnit1Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
BusinessUnit1Obj.addProperty('xpath', ConditionType.EQUALS, BusinessUnit1Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(BusinessUnit1Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

def BusinessUnit2 = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
    'OwningBU', 2)

'creating a Select ProjectNameXpath dynamic xpath'
String BusinessUnit2Xpath = ('//td[contains(text(),"' + BusinessUnit2) + '")]'

'creating the Select ProjectName xpath object'
TestObject BusinessUnit2Obj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
BusinessUnit2Obj.addProperty('xpath', ConditionType.EQUALS, BusinessUnit2Xpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(BusinessUnit2Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Click on AddMember'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Project1_Checkbox'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Edit_Option'), 
    GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Edit_Option'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

title1 = WebUI.getWindowTitle()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 14))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementPresent(Project_Name1Obj, GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Done_Button'), FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Select_All_Checkbox'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Remove_Option'), 
    GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_Create_Edit_Remove_Project_in_ProjectGroup/Remove_Option'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

WebUI.closeBrowser()

