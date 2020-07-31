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

'Wait for Actions button element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Members_Auth'))

WebUI.delay(GlobalVariable.Short_Wait, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Wait_Time)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIMembers_Frame_Obj'), GlobalVariable.Element_Timeout)

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
WebUI.scrollToElement(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddMember_Obj'), GlobalVariable.Element_Timeout)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddMember_Obj'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddMember_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 9))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Set Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Type_Dropdown'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Type_Dropdown'), Type, false)

'Set Member '
WebUI.setText(findTestObject('CDDS/Generic_Objects/IC_Add_Member/User_ID'), User_ID1, FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Find_button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Find_button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Set Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Function'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Function'), Function, false)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Apply_and_Select_More'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Apply_and_Select_More'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Set Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Type_Dropdown'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Type_Dropdown'), Type, false)

'Set Member '
WebUI.setText(findTestObject('CDDS/Generic_Objects/IC_Add_Member/User_ID'), User_ID2, FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Find_button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Find_button'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm team member frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Set Member element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Function'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Function'), Function, false)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for AddMember element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Done_Button'), GlobalVariable.Element_Timeout)

'Click on AddMember'
WebUI.click(findTestObject('CDDS/Generic_Objects/IC_Add_Member/Done_Button'))

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

