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

'Login to CDDS application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_Non_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Question element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/Question_Obj'), GlobalVariable.Element_Timeout)

'Mousehover Question element'
WebUI.mouseOver(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/Question_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for CDDS Support menu element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/CDDS_Support_Menu_Obj'), GlobalVariable.Element_Timeout)

'Click on  CDDS Support menu '
WebUI.click(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/CDDS_Support_Menu_Obj'), FailureHandling.STOP_ON_FAILURE)

'switch to page frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Blank_User Password element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/Blank_User_Password_Obj'), GlobalVariable.Element_Timeout)

'Click on Blank_User Password'
WebUI.click(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/Blank_User_Password_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for UserID element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the  UserID '
WebUI.setText(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/UserId_Obj'), UserID)

'Wait for BlankPWD btn element  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/Blank_Pwd_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Blank PWD btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/UserId_Set_Objects/Blank_Pwd_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'close the browser'
WebUI.closeBrowser()

