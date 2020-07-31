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

'Login to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Member], 
    FailureHandling.STOP_ON_FAILURE)

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
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_IC').getValue('IC_Name', 1))

'Wait for My Component  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Component'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'))

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

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Non-Member_Non-TI_IC Component').getValue('Business_Unit', 1), 
    false)

'Wait for IP Classification elemen to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select  IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Non-Member_Non-TI_IC Component').getValue('IP_Classification', 
        1), false)

'Wait  for IC Name Element  tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SearchComponent_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Set IC Component name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/SearchComponent_Name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_IC').getValue('IC_Name', 1))

'Wait for My Component  Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Component'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MyComponent_Checkbox_Obj'))

'Wait for Find Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'get the IC Component Name'
def ICCompName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_IC').getValue('IC_Name', 1)

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

'Wait for BCM element to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/BCM_Element_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

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

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Wait Members/Access element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Members_Auth_Obj'), 
    GlobalVariable.Wait_Time)

'Wait Members/Access element to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Members_Auth_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TI Members Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

'Verify Action button is not present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Wait_Time)

WebUI.closeBrowser()

