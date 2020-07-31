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

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for responding team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Responding_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'select responding team as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Responding_Team_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('TeamName', 
        val), false)

'Wait for severity element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Select_Severity_Obj'), 
    GlobalVariable.Element_Timeout)

'select severity as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Select_Severity_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Severity', 
        val), false)

'Wait for Title element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Title_Obj'), 
    GlobalVariable.Element_Timeout)

'set title'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Title_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Title', 
        val))

'Wait for description element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Description_Obj'), 
    GlobalVariable.Element_Timeout)

'set description text'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Description_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Description', 
        val))

if (val == 1) {
    'Wait for onbehalfof element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/onBehalfof_Obj'), 
        GlobalVariable.Element_Timeout)

    'set onbehalfof text'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/onBehalfof_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Onbehalf', 
            val))

    'Wait for drop down name element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/DropDownName_Click_Obj'), 
        GlobalVariable.Element_Timeout)

    'click on the required name from drop down'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/DropDownName_Click_Obj'))
}

'Wait for whiledoing element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Select_whiledoing_Obj'), 
    GlobalVariable.Element_Timeout)

'select whiledoing value as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Select_whiledoing_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Whiledoing', 
        val), false)

'Wait for type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/typename_Obj'), 
    GlobalVariable.Element_Timeout)

'set type text'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/typename_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('type', 
        val))

'Wait for name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/name_Obj'), 
    GlobalVariable.Element_Timeout)

'set name value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/name_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('type', 
        val))

'Wait for variant element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Variant_Obj'), 
    GlobalVariable.Element_Timeout)

'set variant value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Variant_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('type', 
        val))

'Wait for BCM Location element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/BCM_Location_Obj'), 
    GlobalVariable.Element_Timeout)

'select BCM location as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/BCM_Location_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('Location', 
        val), false)

'Wait for location identifier element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Location_Identifier_Obj'), 
    GlobalVariable.Element_Timeout)

'set location identifier value'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Create_Bug_with_PO_Onbehalfof_NonTeamMember_Objects/Location_Identifier_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Create_Bug_generic_Datafile').getValue('LocIdentifier', 
        val))

'switch to default'
WebUI.switchToDefaultContent()

'Wait for done button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'click on done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'))

'Wait till the loading symbol is not visible'
WebUI.waitForElementNotVisible(findTestObject('CDDS/UM_Module_Objects/Create_Company/Loading_obj'), wait, FailureHandling.OPTIONAL)

