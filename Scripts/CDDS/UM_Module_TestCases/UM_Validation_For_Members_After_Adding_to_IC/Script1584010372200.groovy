import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for IC name select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IC_Name_obj'), 
    GlobalVariable.Element_Timeout)

'Set the IC name to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IC_Name_obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('IC Name', 1))

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

/*//td[contains(.,'x1048749')]*/
'Assign value to variable'
String IC = findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('IC Name', 1)

'creating a IC dynamic xpath'
String ICXpath = ('//a[contains(.,"' + IC) + '")]'

'creating the SubMenu xpath object'
TestObject ICObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ICObj.addProperty('xpath', ConditionType.EQUALS, ICXpath)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  IC  element '
WebUI.scrollToElement(ICObj, GlobalVariable.Element_Timeout)

'Click on IC'
WebUI.click(ICObj)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Member_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on IC'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Member_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/PortalDisplay_iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/TI_Member_iframe_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

String person = GlobalVariable.Non_Support_Role_Username

'creating a IC dynamic xpath'
String personXpath = ('//td[@class="verbatim" and contains(.,"' + person) + '")]'

'creating the SubMenu xpath object'
TestObject personObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
personObj.addProperty('xpath', ConditionType.EQUALS, personXpath)

'Wait for IC  element to be visible'
if (WebUI.waitForElementNotPresent(personObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
    'Switch to default'
    WebUI.switchToDefaultContent()

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/PortalDisplay_iframe_Obj'), 
        GlobalVariable.Element_Timeout)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/TI_Member_iframe_Obj'), 
        GlobalVariable.Element_Timeout)

    'Wait for Action Btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on Action btn'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for Add Member  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Add_member_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  Add Member  '
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Add_member_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Switch to Add Member window'
    WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue(
            'Window_Title', 1))

    'Maximize the Add Member Window'
    WebUI.maximizeWindow()

    'Navigate to Search page frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for type  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Type_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select the type to be searched'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Type_Obj'), 
        findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('Type', 1), false)

    'Wait for Search UserID  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Search_UserId_Obj'), 
        GlobalVariable.Element_Timeout)

    'Set the SearchUserID  as X1048749'
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Search_UserId_Obj'), 
        findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('Username2', 1))

    'Wait for Find btn  element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on Find Btn '
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait till loading img is not present'
    WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Loading_Obj'), 
        GlobalVariable.Element_Timeout)

    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on Designer'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Designer_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Click on CDC_Top'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/CDC_Top_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'Click on done'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Done_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to default'
    WebUI.switchToDefaultContent()
}

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Launch the browser'
WebUI.openBrowser('')

'Maximize the window'
WebUI.maximizeWindow()

'Navigate to Application URL'
WebUI.navigateToUrl(GlobalVariable.Application_Url)

'Wait for Login Page Header element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_header_Obj'), GlobalVariable.Element_Timeout)

'Wait for Username element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Element_Timeout)

'Enter the Username'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Non_Support_Role_Username)

'Wait for  login button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on login button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  welcome element  is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Welcome_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate Design Repository  tab to IC'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'NAvigate to search page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business unit select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/BU_obj'), 
    GlobalVariable.Element_Timeout)

'Select the Business Unit to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/BU_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('BusinessUnit', 1), false)

'Wait for IP classification select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IPClassification_obj'), 
    GlobalVariable.Element_Timeout)

'Select the IP classification to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IPClassification_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('IP Classification', 1), 
    false)

'Wait for IC name select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IC_Name_obj'), 
    GlobalVariable.Element_Timeout)

'Set the IC name to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IC_Name_obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('IC Name', 1))

'Wait for my IC checkbox object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout)

if (WebUI.verifyElementNotChecked(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)) {
    'Check the My IC checkboc'
    WebUI.check(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'))
}

'Wait for Find button object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Find_btn_obj'), 
    GlobalVariable.Element_Timeout)

'Click on the Find button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Find_btn_obj'))

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result IC name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Table_ICname_obj'), 
    GlobalVariable.Element_Timeout)

'Get the Search IC name'
SearchICName = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Table_ICname_obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Search IC name'
println(SearchICName)

'Verify Equal actual SearchICname with expected SearchICname'
WebUI.verifyEqual(SearchICName.trim(), findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue(
        'IC Name', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Open browser'
WebUI.closeBrowser()

'Launch the browser'
WebUI.openBrowser('')

'Maximize the window'
WebUI.maximizeWindow()

'Navigate to Application URL'
WebUI.navigateToUrl(GlobalVariable.Application_Url)

'Wait for Login Page Header element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_header_Obj'), GlobalVariable.Element_Timeout)

'Wait for Username element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Element_Timeout)

'Enter the Username'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue(
        'Username2', 1))

'enter the password'
WebUI.setEncryptedText(findTestObject('CDDS/Generic_Objects/Login_Objects/O_password'), '', FailureHandling.OPTIONAL)

'Wait for  login button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on login button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  welcome element  is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Welcome_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Business unit select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/BU_obj'), 
    GlobalVariable.Element_Timeout)

'Select the Business Unit to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/BU_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('BusinessUnit', 1), false)

'Wait for IP classification select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IPClassification_obj'), 
    GlobalVariable.Element_Timeout)

'Select the IP classification to be searched'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IPClassification_obj'), 
    findTestData('CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('IP Classification', 1), 
    false)

'Wait for IC name select object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IC_Name_obj'), 
    GlobalVariable.Element_Timeout)

'Set the IC name to be searched'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/IC_Name_obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Validation_For_Members_After_Adding_to_IC').getValue('IC Name', 1))

'Wait for my IC checkbox object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout)

'Check the My IC checkboc'
WebUI.uncheck(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'))

if (WebUI.verifyElementNotChecked(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)) {
    'Check the My IC checkboc'
    WebUI.check(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/MyIC_checkbox_obj'))
}

'Wait for Find button object to be visible.'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Find_btn_obj'), 
    GlobalVariable.Element_Timeout)

'Click on the Find button'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/Find_btn_obj'))

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify the table values'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/New_row_Obj'), 
    GlobalVariable.Element_Timeout)

'Verify the table values'
WebUI.verifyElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Validation_For_Members_After_Adding_to_IC/New_row_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

