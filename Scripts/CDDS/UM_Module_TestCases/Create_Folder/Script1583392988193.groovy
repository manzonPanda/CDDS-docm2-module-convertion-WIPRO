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

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Actions element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Actions'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create folder element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Create_Obj'), GlobalVariable.Element_Timeout)

'Click on Created Folder'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for FolderTiltle element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Folder_Title_Obj'), GlobalVariable.Element_Timeout)

'Click on FolderTitle'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Folder_Title_Obj'), FolderTitle)

'Wait for Select BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Select_BusinessUnit_Obj'), GlobalVariable.Element_Timeout)

'Select the BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Select_BusinessUnit_Obj'), BusinessUnit, 
    false)

'Wait for Description element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Description_Obj'), GlobalVariable.Element_Timeout)

'Set the Description '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Description_Obj'), Description)

'Wait for No_InternalFolder  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/No_InternalFolder_Obj'), GlobalVariable.Element_Timeout)

'Select the No Internal Folder '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/No_InternalFolder_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Participant element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Participants_Image_Obj'), GlobalVariable.Element_Timeout)

'Click on  Participant '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Participants_Image_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default '
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 4))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for CompanyName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/CompanyName_Obj'), GlobalVariable.Element_Timeout)

'Set the Company Name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/CompanyName_Obj'), CompanyName)

'Wait for FindBtn_element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on FindBtn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default'
WebUI.switchToDefaultContent()

'Switch to List Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Select  Checkbox '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default'
WebUI.switchToDefaultContent()

'Wait for Submit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Submit_Obj_new'), GlobalVariable.Element_Timeout)

'Click on Submit '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Submit_Obj_new'), FailureHandling.STOP_ON_FAILURE)

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Switch to Default'
WebUI.switchToDefaultContent()

'Wait for Done element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Create_Folder_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

