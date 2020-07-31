import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Select ProjectName'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Team Member_TI-User_Program/Inbox_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Inbox_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create BCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Bug element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Bug_Obj'), GlobalVariable.Element_Timeout)

'Click on Bug'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Bug_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Team_Selection'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Team_Selection'), Team, false)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Severity'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Severity'), Severity, false)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Date_Selection'), GlobalVariable.Element_Timeout)

'Click on Target date icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Date_Selection'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Date'), GlobalVariable.Element_Timeout)

'Click on the date'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Date'), FailureHandling.STOP_ON_FAILURE)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Title'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Title'), Title)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Description'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Description'), Description)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Found while doing'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Found while doing'), Found_While_Doing, 
    false)

'Wait for On Behalf of element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/On_Behalf_Of'), GlobalVariable.Element_Timeout)

'Enter On Behalf of value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/On_Behalf_Of'), On_Behalf_Of)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for On behalf of person name to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Person'), GlobalVariable.Element_Timeout)

'Wait for On behalf of person name to be visible'
WebUI.mouseOver(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Person'), FailureHandling.OPTIONAL)

'Wait for On behalf of person name to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Person'), FailureHandling.STOP_ON_FAILURE)

'Click on On behalf of person name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Person'), FailureHandling.OPTIONAL)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/File_Type'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/File_Type'), FILE1, FailureHandling.OPTIONAL)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/File_Name'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for Team element to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/File_Name'), FILE1, FailureHandling.OPTIONAL)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/File_Version'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for Team element to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/File_Version'), FILE1, FailureHandling.OPTIONAL)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Location Found'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Location Found'), Location_Found, 
    false)

'Wait for On Behalf of element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Location Found Identifier'), 
    GlobalVariable.Element_Timeout)

'Enter On Behalf of value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Location Found Identifier'), Location_Found_Identifier)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Classification'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Classification'), Classification, 
    false)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Subclassification'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Subclassification'), Subclassification, 
    false)

'Wait for On Behalf of element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/CC_List'), GlobalVariable.Element_Timeout)

'Enter On Behalf of value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/CC_List'), CC_List)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Email_Img_Search'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Person'), [('User_ID') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'User_ID', 1)], FailureHandling.STOP_ON_FAILURE)

'Swich to default content'
WebUI.switchToDefaultContent()

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.OPTIONAL)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Done_Button'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Done_Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

