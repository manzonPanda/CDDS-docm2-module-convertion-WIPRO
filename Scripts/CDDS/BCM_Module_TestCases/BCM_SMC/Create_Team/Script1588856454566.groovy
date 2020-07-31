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

'Navigate to Pagination frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for TeamName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/TeamName_Obj'), GlobalVariable.Element_Timeout)

'Set the TeamName'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/TeamName_Obj'), Team_Name)

'Wait for TeamDescription element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Description_Obj'), GlobalVariable.Element_Timeout)

'Set the TeamDescription'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Description_Obj'), Team_Description)

'Wait for TeamBaseSite element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Base_Site_Obj'), GlobalVariable.Element_Timeout)

'Set the TeamBaseSite'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Team_Base_Site_Obj'), Team_BaseSite, 
    false)

'Wait for BCMElementsFill element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/BCMElementsFill_Obj'), GlobalVariable.Element_Timeout)

'Select the BCMElementsFill'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/BCMElementsFill_Obj'))

'Switch to Default'
WebUI.switchToDefaultContent()

'Wait for BCMElementsFill element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Done_Btn_Obj'))

'Click on Done'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Done_Btn_Obj'), FailureHandling.OPTIONAL)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.waitForAlert(GlobalVariable.Wait_Time)

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

