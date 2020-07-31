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

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Wait_Time)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Actions element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Actions'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Click on Actions'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.OPTIONAL)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddMember_Obj'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddMember_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 5))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Set Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Company_Dropdown'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Company_Dropdown'), Company, false)

'Set Member '
WebUI.setText(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Set_Member_Obj'), SetMember, FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Select  Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Select_Member_Obj'), GlobalVariable.Element_Timeout)

'Wait for Select  Member element to be visible'
WebUI.mouseOver(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Select_Member_Obj'), FailureHandling.OPTIONAL)

'Click on Select Member'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Select_Member_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on Select Member'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Select_Member_Obj'), FailureHandling.OPTIONAL)

'Wait for Member as Owner element to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Select_Owner_Radio_Obj'), GlobalVariable.Element_Timeout)

'Select the Owner'
not_run: WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Select_Owner_Radio_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for AddtoSelection element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddtoSelection_btn_Obj'), GlobalVariable.Element_Timeout)

'Click on AddtoSelection'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddtoSelection_btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Done element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

