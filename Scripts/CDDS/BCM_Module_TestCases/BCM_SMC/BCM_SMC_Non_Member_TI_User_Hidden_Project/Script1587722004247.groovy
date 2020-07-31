import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

def RandomNum = RandomStringUtils.randomNumeric(3)

GlobalVariable.RandomNumber = RandomNum

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/BCM_SMC_Create_IC_Component'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Program_Project').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business Unit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('BusinessUnit', 
        1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ProjectName_Obj'), 
    ((findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber) + '-') + findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue(
        'ComponentVariant', 1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ShowProject_My', 
        1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business Unit  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('BusinessUnit', 
        1), false)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ProjectName_Obj'), 
    ((findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber) + '-') + findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue(
        'ComponentVariant', 1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ShowProject', 
        1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def PrName = ((findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue(
    'ProgramName', 1) + GlobalVariable.RandomNumber) + '-') + findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue(
    'ComponentVariant', 1)

println(PrName)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + PrName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj, PrName, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Menu Collapsed element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), GlobalVariable.Element_Timeout)

'Click on  Menu Collapsed'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC Component'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('BusinessUnit', 
        1), false)

'Wait for IPCalssification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/IPClass_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/IPClass_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('IPClassificatioin', 
        1), false)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Member_Non_TI_Hidden_Program_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Program_Project').getValue(
        'ProjectNotFound', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('BusinessUnit', 
        1), false)

'Wait for IPCalssification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/IPClass_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/IPClass_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('IPClassificatioin', 
        1), false)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def PrName1 = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_Hidden_Project').getValue(
    'ProgramName', 1) + GlobalVariable.RandomNumber

println(PrName1)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath1 = ('//a[contains(text(),"' + PrName1) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj1 = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj1.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath1)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj1, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj1, PrName1, FailureHandling.CONTINUE_ON_FAILURE)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj1, PrName1, FailureHandling.CONTINUE_ON_FAILURE)

'Click on Project Name '
WebUI.click(ProjectNameObj1)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for BCM Element element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BCM_Elements_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM Element'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/BCM_Elements_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM Project Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIRelatedBCMElementsFiledOn_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Create_IC_Component_Objects/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Create_IC_Component_Objects/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify Create BCM Not Present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for BCM Element element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MemberAuth_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM Element'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_TI_User_Hidden_Project_Objects/MemberAuth_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM Project Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

'Verify Action not Present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Create_IC_Component_Objects/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Close the Browser'
WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/BCM_SMC_Delete_IC_Component'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

