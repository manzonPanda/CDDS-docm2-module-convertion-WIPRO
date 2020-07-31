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

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to DisplayDetails  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add Member  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Add_Member_Obj'), GlobalVariable.Element_Timeout)

'Click on  Add Member  '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Add_Member_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Add Member window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 2))

'Maximize the Add Member Window'
WebUI.maximizeWindow()

'Navigate to Search page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search UserID  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the SearchUserID  as X1048749'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Search_UserId_Obj'), UserID)

'Wait for Find btn  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Table frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Select Member Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Select_Member_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Scroll to Member Checkbox element'
WebUI.scrollToElement(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Select_Member_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Select  the Member Checkbox '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Select_Member_CheckBox_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Done btn Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Done btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Done_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Search UserID  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Set the SearchUserID  as X1048749'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Search_UserId_Obj'), GlobalVariable.Non_Support_Role_Username)

'Wait for Find btn  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Navigate  to Table Frame2'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame_2'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Search result Group name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Search_Table_UserId_Obj'), GlobalVariable.Element_Timeout)

'Get the Actual Search Group Name'
ActualUserID = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Search_Table_UserId_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print Actual SearchGroupName'
println(ActualUserID)

'Verify Equal Actual SearchGroupNamewith expected SearchGroupName'
WebUI.verifyEqual(ActualUserID.trim(), GlobalVariable.Non_Support_Role_Username, FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Company  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Table_Company_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchCompany'
ActualSearchCompany = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Table_Company_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchCompany)

'Verify Equal ActualSearchCompany with expected SearchCompany'
WebUI.verifyEqual(ActualSearchCompany.trim(), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue('Company', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Function  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Table_Function_Obj'), GlobalVariable.Element_Timeout)

'Get the ActualSearchFunction'
ActualSearchFunction = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/Add_Members_Objects/Table_Function_Obj'), FailureHandling.STOP_ON_FAILURE)

'Print ActualSearchCompany'
println(ActualSearchFunction)

'Verify Equal ActualSearchFunction with expected SearchFunction'
WebUI.verifyEqual(ActualSearchFunction.trim(), findTestData('CDDS/UM_Module_TestData/Create_Membership').getValue('Function', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

