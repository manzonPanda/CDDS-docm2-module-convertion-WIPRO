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

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the Random Number '
String random_number = RandomStringUtils.randomNumeric(2)

'Concatenate the CMpath with RandomNumber'
String IC_Name1 = IC_Name + random_number

'Wait  for IC Name Element  tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IC_Component_Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Set IC Component name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IC_Component_Name_Obj'), 
    IC_Name1)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/OwningBU_Obj'), 
    Owning_BU, false)

'Wait for MMR Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Variant_None'), 
    GlobalVariable.Element_Timeout)

'Click on  MMR Radio'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Variant_None'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for IP Classification elemen to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select  IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/IP_Classification_Obj'), 
    IPclassfn, false)

'Wait for MMR Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MMR_Radio_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  MMR Radio'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/MMR_Radio_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Release Package No element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Default Authorized Users'), 
    GlobalVariable.Element_Timeout)

'Select No Release Package Require'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Default Authorized Users'))

'Wait for Project TypeNew element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectType_New_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on CreateNew Project'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/ProjectType_New_Obj'))

'Wait for Release Package No element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Release_Package_no_Obj'), 
    GlobalVariable.Element_Timeout)

'Select No Release Package Require'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Release_Package_no_Obj'))

'Wait for Release Package No element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Visible_to_all_TI users'), 
    GlobalVariable.Element_Timeout)

'Select No Release Package Require'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Visible_to_all_TI users'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

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
    Company)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Find Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'))

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Find_Obj'), 
    FailureHandling.OPTIONAL)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

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

'Wait for Secondary owner Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Secondary_Owner_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Secondary Owner'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Secondary_Owner_Obj'), 
    SecondaryOwner)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Name Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Name_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Name Element to be visible'
WebUI.mouseOver(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Name_Obj'), 
    FailureHandling.OPTIONAL)

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Name_Obj'))

'Click on Owner Name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Name_Obj'), 
    FailureHandling.OPTIONAL)

'Wait for Description Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Description_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Non_Member_TI_User_IC Component_Objects/Description_Obj'), 
    Description1)

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

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

