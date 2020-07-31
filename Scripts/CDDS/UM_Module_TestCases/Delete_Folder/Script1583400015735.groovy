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

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch list frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/UM_Module_Objects/Delete_Folder_Obj/BusinessUnit_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Delete_Folder_Obj/BusinessUnit_Dropdown_Obj'), BusinessUnit, 
    false)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Delete_Folder_Obj/FolderTitle_Obj'), GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1  in Search field'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Delete_Folder_Obj/FolderTitle_Obj'), FolderTitle)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Delete_Folder_Obj/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Delete_Folder_Obj/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Delete_Groups_Objects/Delete_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Delete_Groups_Objects/Delete_Obj'), FailureHandling.STOP_ON_FAILURE)

'Accept the alert'
WebUI.acceptAlert()

