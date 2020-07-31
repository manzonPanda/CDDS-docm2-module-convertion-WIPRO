import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Wait for  company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Select_Company_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

/*'Get the Company Name'
Company = findTestData('CDDS/Generic_TestData/UM_Create_User_Request').getValue('Company', 1)
*/
//println(Company)
'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Select_Company_Dropdown_Obj'), 
    Company, false)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for  BusinessUnit dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Select_BusinessUnit_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select BusinessUnit  as TI_UM_BU_1'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Select_BusinessUnit_Obj'), BusinessUnit, 
    false)

'Wait for Arrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on  Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for AID_XID Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/AID_XID_Obj'), GlobalVariable.Element_Timeout)

'Set the AID_XID as UserId'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/AID_XID_Obj'), UserId)

'Wait for  CDDSRoles dropdown element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Select_CDDSRoles_Obj'), GlobalVariable.Element_Timeout)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Select CDDS Roles drpdown as TIEmployee'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Select_CDDSRoles_Obj'), CDDSRoles, 
    false)

'Wait for CDDSArrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/CDDSRole_Arrow_Obj'), GlobalVariable.Element_Timeout)

'Click on CDDS Arrow btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/CDDSRole_Arrow_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for  FileSites dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Files_Sites_Dropdown_Obj'), 
    GlobalVariable.Element_Timeout)

'Select CDDS Roles drpdown as TI (Bangalore)'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Files_Sites_Dropdown_Obj'), 
    FileSites, false)

'Wait for CDDSArrow Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Account_Approver_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Click on CDDS Arrow btn'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Account_Approver_Obj'), GlobalVariable.Support_Role_Username, 
    FailureHandling.OPTIONAL)

'Wait for few Seconds'
WebUI.delay(GlobalVariable.Short_Wait, FailureHandling.OPTIONAL)

'creating a Select Accountapprover dynamic xpath'
String AccountApproverXpath = ('//b[contains(text(),"' + GlobalVariable.Support_Role_Username) + '")]'

'creating the Select Accountapprover xpath object'
TestObject AccountapproverObj = new TestObject('objectName')

'adding property in Select Accountapprover dynamic xpath'
AccountapproverObj.addProperty('xpath', ConditionType.EQUALS, AccountApproverXpath)

'Wait for  Select Accountapprover  element to be visible'
WebUI.waitForElementVisible(AccountapproverObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on Select Accountapprover'
WebUI.click(AccountapproverObj, FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Users_Request_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default'
WebUI.switchToDefaultContent()

