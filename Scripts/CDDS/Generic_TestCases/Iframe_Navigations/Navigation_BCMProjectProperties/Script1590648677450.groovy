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

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Iframe_DetailsDisplay'), GlobalVariable.Element_Timeout)

'Switch to Portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectProperties_Frame_Obj'), GlobalVariable.Element_Timeout)

