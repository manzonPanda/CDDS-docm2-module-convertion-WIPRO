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

'Login to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to My Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC Component'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Element to be Visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Create_Obj'), 
    GlobalVariable.Element_Timeout)

'Click onn Create'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Create_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for SoftMacro element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SoftMacro_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Soft Macro'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SoftMacro_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait  for IC Name Element  tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IC_Component_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Set IC Component name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IC_Component_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('ICName', 
        1))

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('BusinessUnit', 
        1), false)

'Wait for Variant Element  tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IC_Component_Variant_Obj'), 
    GlobalVariable.Element_Timeout)

'Set  the IC Component Variant'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IC_Component_Variant_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('Variant', 
        1))

'Wait for Library Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Library_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select the Library'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Library_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('Library', 
        1), false)

'Wait for Arrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on  Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for IP Classification elemen to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select  IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('IPClassification', 
        1), false)

'Wait for MMR Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MMR_Radio_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  MMR Radio'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MMR_Radio_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Secondary owner Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Secondary_Owner_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Secondary Owner'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Secondary_Owner_Obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Create_IC_1').getValue('Owner', 1))

'Wait for Name Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Name_Obj'))

'Wait for Project TypeNew element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectType_New_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on CreateNew Project'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectType_New_Obj'))

'Wait for  CMsystem\telement to be visible\r\n\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/CM_system_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select CMsystem\t\r\n\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/CM_system_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('CMSystem', 
        1), false)

'Get the Random Number '
String random_number = RandomStringUtils.randomNumeric(3)

'Concatenate the CMpath with RandomNumber'
String CMPath = ('BCM_SMC_IC' + random_number) + '_CMPath'

'Set theCM path'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/CMPath_Obj'), 
    CMPath)

'Wait for CMPath Type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/CMPathType_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select CM path type\t\r\n'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/CMPathType_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('PathType', 
        1), false)

'Wait for Release Package No element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Release_Package_no_Obj'), 
    GlobalVariable.Element_Timeout)

'Select No Release Package Require'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Release_Package_no_Obj'))

'Wait for Action Search Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ActionSearch_Obj'), 
    GlobalVariable.Element_Timeout)

'Click o  Action Search'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ActionSearch_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 4))

'Maximize the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Company name_Obj'), 
    GlobalVariable.Element_Timeout)

'Set company name\r\n\t'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Company name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('Company', 
        1))

'Wait for Find Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'))

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Company checkbox element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Select_company_Obj'), 
    GlobalVariable.Element_Timeout)

'Select the Company Checkbox'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Select_company_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait Submit btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Submit_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Submit Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Submit_Obj'))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Description Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Description_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Description_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('Description', 
        1))

'Switch to window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Done_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Done_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Loading_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for project abberivation\r\n\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectAbbreviation_Obj'), 
    GlobalVariable.Element_Timeout)

'Double click\r\n\t'
WebUI.doubleClick(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectAbbreviation_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Clrear  project Abbreviation'
WebUI.clearText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectAbbreviation_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Set abberivation\r\n\t'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectAbbreviation_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('ProjectAbbreviation', 
        1))

'Set abberivation\r\n\t'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/AssociatedSchema_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Set abberivation\r\n\t'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/AssociatedSchema_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('AssociatedSchema', 
        1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Done_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Done_Obj'))

WebUI.waitForAlert(GlobalVariable.Wait_Time)

'ActualGetTextAlert'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

WebUI.closeBrowser()

'Login to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to My Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC Component'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('BusinessUnit', 
        1), false)

'Wait for IP Classification elemen to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select  IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('IPClassification', 
        1), false)

'Wait  for IC Name Element  tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SearchComponent_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Set IC Component name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SearchComponent_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('ICName', 
        1))

'Wait for My Component  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Component'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'))

'Wait for My Component  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Component'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'))

'Wait for Find Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'))

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for My Component  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Component'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'))

'Wait for Find Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'))

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'get the IC Component Name'
def ICCompName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue(
    'ICName', 1)

'creating a Select ProjectNameXpath dynamic xpath'
String ICCOmpNameXpath = ('//a[contains(text(),"' + ICCompName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ICCompNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ICCompNameObj.addProperty('xpath', ConditionType.EQUALS, ICCOmpNameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ICCompNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on Select ProjectName'
WebUI.click(ICCompNameObj, FailureHandling.OPTIONAL)

'Switch to Default Content'
WebUI.switchToDefaultContent()

//String SubMenuXpath = ('//label[text()="' + SubMenu) + '"]'
'creating a ProjectNameLink dynamic xpath'
String ICCompNameLinkXpath = ('//label[contains(text(),"' + ICCompName) + '")]'

'creating the ProjectNameLink xpath object'
TestObject ICCompNameLinkObj = new TestObject('objectName')

'adding property in ProjectNameLink dynamic xpath'
ICCompNameLinkObj.addProperty('xpath', ConditionType.EQUALS, ICCompNameLinkXpath)

'Wait for ProjectNameLink  element to be visible'
WebUI.waitForElementVisible(ICCompNameLinkObj, GlobalVariable.Element_Timeout)

'Click on ProjectNameLink'
WebUI.click(ICCompNameLinkObj)

'Switch to Default frame'
WebUI.switchToDefaultContent()

'Wait for BCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/BCM_Element_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on BCM Element '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/BCM_Element_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth toTIRelatedBCMElementsFiledOn  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIRelatedBCMElementsFiledOn_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Verify Create BCM Not Exist'
WebUI.verifyElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to Default frame'
WebUI.switchToDefaultContent()

'Wait for Members Auth element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Members_Auth_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on MemberAuth Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Members_Auth_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth toTIRelatedBCMElementsFiledOn  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

'Verify Action Element not present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Switch to Default frame'
WebUI.switchToDefaultContent()

'Close the browser'
WebUI.closeBrowser()

'Login to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to My Desk'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Design Repository to IC Component'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC Component'], FailureHandling.STOP_ON_FAILURE)

'navigate search frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('BusinessUnit', 
        1), false)

'Wait for IP Classification elemen to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select  IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('IPClassification', 
        1), false)

'Wait  for IC Name Element  tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SearchComponent_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Set IC Component name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SearchComponent_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_TI_User_IC Component').getValue('ICName', 
        1))

'Wait for My Component  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Component'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'))

'Wait for Find Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'))

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for SelectCheckbox  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'SelectCheckbox  '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for SelectCheckbox  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Delete_Obj'), 
    GlobalVariable.Element_Timeout)

'SelectCheckbox  '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Delete_Obj'))

'Accept the OK btn'
WebUI.acceptAlert()

'Close the browser'
WebUI.closeBrowser()

