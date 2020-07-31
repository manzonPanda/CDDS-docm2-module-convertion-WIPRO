import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), Company, 
    false)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Search_GroupName_Obj'), GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1  in Search field'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Search_GroupName_Obj'), GroupName)

'Wait for MyGroups Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/MyGroups_ChkBx_Obj'), GlobalVariable.Element_Timeout)

'Click on MyGroup Checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/MyGroups_ChkBx_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the Actual Search Group Name'
AGroupName = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Table_GroupName_Obj'), FailureHandling.OPTIONAL)

if (GroupName.equals(AGroupName)) {
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Group'), [:], FailureHandling.STOP_ON_FAILURE)
}

'Navigate to Actions Button  frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for CreateGroup element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_Group_tab_Obj'), GlobalVariable.Element_Timeout)

'Click on Create Group'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Create_Group_tab_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Group Name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Group_Name_Obj'), GlobalVariable.Element_Timeout)

'Set the Group Name as TI_UM_Group_1'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Group_Name_Obj'), GroupName)

/*findTestData('CDDS/Generic_TestData/Create_Group').getValue(
	'GroupName', 1)
*/
'Wait for  company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Select_Company_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Select_Company_Dropdown_Obj'), Company, 
    false)

/*findTestData(
	'CDDS/Generic_TestData/Create_Group').getValue('Company', 1)*/
'Wait for Description  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Description_Obj'), GlobalVariable.Element_Timeout)

'Set the Description as Create_Group_Testing'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Description_Obj'), Description)

/*findTestData('CDDS/Generic_TestData/Create_Group').getValue(
	'Description', 1)
*/
'Switch to Default Frame'
WebUI.switchToDefaultContent()

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Done_Btn_Obj'), FailureHandling.OPTIONAL)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Get the GroupName Text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if Actualtext contains exist "already"'
if (ActualGetTextAlert.contains('already exists')) {
    'Click on Accept Alert'
    WebUI.acceptAlert()

    'Close the Current Window title'
    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), Company, 
    false)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Search_GroupName_Obj'), GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1  in Search field'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Search_GroupName_Obj'), GroupName)

'Wait for MyGroups Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/MyGroups_ChkBx_Obj'), GlobalVariable.Element_Timeout)

'Click on MyGroup Checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/MyGroups_ChkBx_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate User Search Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Group name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Table_GroupName_Obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Group Name'
ActualGroupName = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Table_GroupName_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print Actual SearchGroupName'
println(ActualGroupName)

'Verify Equal Actual SearchGroupNamewith expected SearchGroupName'
WebUI.verifyEqual(ActualGroupName.trim(), GroupName, FailureHandling.OPTIONAL)

'Wait for Search result Company  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Table_Company_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchCompany'
ActualSearchCompany = WebUI.getText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Table_Company_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchCompany)

'Verify Equal ActualSearchCompany with expected SearchCompany'
WebUI.verifyEqual(ActualSearchCompany.trim(), Company, FailureHandling.CONTINUE_ON_FAILURE)

