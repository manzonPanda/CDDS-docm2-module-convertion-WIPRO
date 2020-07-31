import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Naviagte_BCMProjectInboxCommand_frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Button_Actions'), 0)

WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Button_Actions'))

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Tab_create_BCM'), 0)

WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Tab_create_BCM'))

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/option_Bug'), 0)

WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/option_Bug'))

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

'switch to new window : CDDS: TI Collaborative Design & Delivery System'
WebUI.switchToWindowTitle('CDDS: TI Collaborative Design & Delivery System')

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Page_Header'), 0)

WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Dropdown_Team'), 0)

WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_bug/Dropdown_Team'), Team, false)

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.acceptAlert()

'Verify Actions dropdown is present'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Actions_Dropdown'), GlobalVariable.Wait_Time)

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.STOP_ON_FAILURE)

'Verify Action Button not present'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Verify Action Button not present'
WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.STOP_ON_FAILURE)

'Verify Action Button not present'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SCM_BCM_FP_Objects/Edit_Project_Obj'))

WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Short_Wait)

