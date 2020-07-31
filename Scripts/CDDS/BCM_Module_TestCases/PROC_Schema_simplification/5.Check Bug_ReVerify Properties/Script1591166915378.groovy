import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_BCMProjectProperties'), [:], FailureHandling.STOP_ON_FAILURE)

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

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Bug_Checkbox'), GlobalVariable.Wait_Time)

WebUI.check(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Bug_Checkbox'), FailureHandling.STOP_ON_FAILURE)

'Adding delay'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Button_Done'), FailureHandling.STOP_ON_FAILURE)

'Adding delay'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

WebUI.switchToDefaultContent()

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(ProjectName_Header, GlobalVariable.Wait_Time)

'Click on project name on the top left corner'
WebUI.click(ProjectName_Header)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Naviagate_to_Project_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Project_Navigation_Frame/BCMProjectProperties_Frame'), GlobalVariable.Element_Timeout)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Iframe_Navigations/Navigation_BCMProjectProperties'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/ActiveBCMElements'), GlobalVariable.Wait_Time)

String Active_ChangeRequest = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Active_Elements_Name'))

println(Active_ChangeRequest)

WebUI.verifyMatch(Active_ChangeRequest, 'Bug\nChangeRequest\nRequirement\nAction\nAlert\nIncident ', false)

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/Bug Default View'), GlobalVariable.Wait_Time)

'Verify Project name is visible in the header (top left corner)'
WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/PROC_Schema_simplification/PROC short view'), GlobalVariable.Wait_Time)

