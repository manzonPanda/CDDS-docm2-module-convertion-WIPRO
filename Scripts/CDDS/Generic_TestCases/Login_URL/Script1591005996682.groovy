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

'Launch the browser'
WebUI.openBrowser('')

'Maximize the window'
WebUI.maximizeWindow()

'Navigate to Application URL'
WebUI.navigateToUrl(GlobalVariable.Automation_URL)

'Wait for Login Page Header element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_header_Obj'), GlobalVariable.Element_Timeout)

'Wait for Username element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Element_Timeout)

String LoginId = Login_Id

'Enter the Username'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), LoginId)

'Wait for  login button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on login button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'))

WebUI.delay(3)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait for  welcome element  is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Welcome_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

