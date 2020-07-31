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

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Get the Data Value'
def val = 1

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'TC_Name_Path', val), ('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'ProjectName', val), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'ProjectAbbreviation', val), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'BusinessUnit', val), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'ProjectOwner', val), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'AssociateSchema', val), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue(
            'TC_Name_Path1', val)], FailureHandling.STOP_ON_FAILURE)

'Get the ProjectName'
def PrjName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue('ProjectName', val)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/ProjectName_Obj'), PrjName)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + PrjName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj, FailureHandling.OPTIONAL)

'Switch to Default Content'
WebUI.switchToDefaultContent()

//String SubMenuXpath = ('//label[text()="' + SubMenu) + '"]'
'creating a ProjectNameLink dynamic xpath'
String ProjectNameLinkXpath = ('(//label[text()="' + PrjName) + '"])[1]'

'creating the ProjectNameLink xpath object'
TestObject ProjectNameLinkObj = new TestObject('objectName')

'adding property in ProjectNameLink dynamic xpath'
ProjectNameLinkObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameLinkXpath)

'Wait for ProjectNameLink  element to be visible'
WebUI.waitForElementVisible(ProjectNameLinkObj, GlobalVariable.Element_Timeout)

'Click on ProjectNameLink'
WebUI.click(ProjectNameLinkObj)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/GrantTI_View_Access_Yes_Obj'), 
    GlobalVariable.Element_Timeout)

'Verfiy Grant TI Access View Yes '
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/GrantTI_View_Access_Yes_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Wait fro Action Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait fro Edit Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'), GlobalVariable.Element_Timeout)

'Click on Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Element  Grant TI  View Access to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_View_Access_Obj'), 
    GlobalVariable.Element_Timeout)

'verify  Grant TI  View Access '
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_View_Access_Obj'), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Element  Grant TI  Team Member Access to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_Team_Member_Access_Obj'), 
    GlobalVariable.Element_Timeout)

'verify  Grant TI  TEam Member Access'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_Team_Member_Access_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

//String SubMenuXpath = ('//label[text()="' + SubMenu) + '"]'
'creating a ProjectNameLink dynamic xpath'
String ProjectNameLinkXpath1 = ('(//label[text()="' + PrjName) + '"])[1]'

'creating the ProjectNameLink xpath object'
TestObject ProjectNameLinkObj1 = new TestObject('objectName')

'adding property in ProjectNameLink dynamic xpath'
ProjectNameLinkObj1.addProperty('xpath', ConditionType.EQUALS, ProjectNameLinkXpath1)

'Wait for ProjectNameLink  element to be visible'
WebUI.waitForElementVisible(ProjectNameLinkObj1, GlobalVariable.Element_Timeout)

'Click on ProjectNameLink'
WebUI.click(ProjectNameLinkObj1)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/GrantTI_Team_Member_Access_Yes_Obj'), 
    GlobalVariable.Element_Timeout)

'Verfiy Grant TI TEam Member View Yes '
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/GrantTI_Team_Member_Access_Yes_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.CONTINUE_ON_FAILURE)

'Wait fro Action Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait fro Edit Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'), GlobalVariable.Element_Timeout)

'Click on Edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to User Page   frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Feqw Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Scroll to  Grant TI  Team Member Access to be visible'
WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_Team_Member_Access_No_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Element  Grant TI  Team Member Access to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_Team_Member_Access_No_Obj'), 
    GlobalVariable.Element_Timeout)

'verify  Grant TI  TEam Member Access'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Prj_GrantTI_Team_Member_Access_No_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Close Browser'
WebUI.closeBrowser()

