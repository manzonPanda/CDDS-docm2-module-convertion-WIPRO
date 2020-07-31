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

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Select type to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Select_Type_Obj'), 
    GlobalVariable.Element_Timeout)

'Select type'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Select_Type_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue('Type', 
        index), false)

'Wait for UserID field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/UserId_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Set UserID'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/UserId_Field_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue('Person_ID', 
        index))

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Member access to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Select_MemberAcces_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Member Access '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Select_MemberAcces_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Incident_Master_TestData/BCM_Incident_Master_Bug_Add_Members').getValue('Member_Access', 
        index), false)

'Wait for Select Member Checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Select_Member_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Member'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Select_Member_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'wait few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Condition check'
if (index == 1) {
    'Wait for Apply and SelectMore btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Apply_SelectMore_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Apply and SelectMore'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Apply_SelectMore_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
} else {
    'Wait for Submit btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Submit_Btn_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Submit btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Incident_Master_Objects/BCM_Incident_Master_Bug_add_Members/Submit_Btn_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
}

'wait few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

