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

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for LogoutQuestion element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Logout_Objects/Profile_Icon_Obj'), GlobalVariable.Element_Timeout)

'Wait for LogoutQuestion element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/Logout_Objects/Profile_Icon_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for LogoutQuestion element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/Logout_Objects/Profile_Icon_Obj'), FailureHandling.OPTIONAL)

'Wait for Signout elemen to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Logout_Objects/Signout_Obj'), GlobalVariable.Element_Timeout)

'Click on Signout'
WebUI.click(findTestObject('CDDS/Generic_Objects/Logout_Objects/Signout_Obj'), FailureHandling.OPTIONAL)

'Close the browser'
WebUI.closeBrowser()

