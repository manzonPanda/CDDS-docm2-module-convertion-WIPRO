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

'Login or Navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('MENU1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue(
            'MENU2', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for the page load'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Business Unit option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Business_Unit'), GlobalVariable.Element_Timeout)

'Select Business Unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Business_Unit'), findTestData(
        'CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('SELECT', 1), false)

'wait for IP Classification option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_IP_Classification_Obj'), GlobalVariable.Element_Timeout)

'Select IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_IP_Classification_Obj'), findTestData(
        'CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('SELECT', 2), false)

'wait for IC Name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/IC_Name_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter IC Name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/IC_Name_Field_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue(
        'TEXT', 2), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Find_Btn'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Find_Btn'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for IC Name  visible in the table'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/IC_Link_Obj'), GlobalVariable.Element_Timeout)

'Click on the link of IC Name'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/IC_Link_Obj'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Wait for Members/Auth Option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Members_Auth_Obj'), GlobalVariable.Element_Timeout)

'Click on Members/Auth Option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Members_Auth_Obj'))

'Wait for page load'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/PortalDisplay_iframe'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/ITMembers_Iframe'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add Members element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Add_Members_Obj'), GlobalVariable.Element_Timeout)

'Click on Add Members option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Add_Members_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to new window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('WINDOW_TITLE', 1))

'Maximize New Window'
WebUI.maximizeWindow()

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Business Type option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Type'), GlobalVariable.Element_Timeout)

'Select Business Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Type'), findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue(
        'SELECT', 3), false)

'wait for User name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/UserID_Obj'), GlobalVariable.Element_Timeout)

'Enter User id'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/UserID_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue(
        'TEXT', 5), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Find_Btn'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Find_Btn'))

'Wait for page to be loaded'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'wait'
WebUI.delay(3)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait for Multiple select in Fuction column visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Function'), GlobalVariable.Element_Timeout)

'Select Function value'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Function'), findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue(
        'SELECT', 4), false)

'Switch to be default content'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Done_Btn'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Done_Btn'))

'Wait for page to be loaded'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Wait till search icon visible'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Search_Icon_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to new window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('WINDOW_TITLE', 2))

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal display frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/PortalDisplay_iframe'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/ITMembers_Iframe'), GlobalVariable.Element_Timeout)

'Switch to List filter frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for User name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/UserID_Obj'), GlobalVariable.Element_Timeout)

'Enter User id'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/UserID_Obj'), findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue(
        'TEXT', 5), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Find_Btn'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Find_Btn'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal display frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/PortalDisplay_iframe'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/ITMembers_Iframe'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Get User ID'
String Get_UserID = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Get_UserID_Obj'))

'Triming geting  user id'
String GetUserID = Get_UserID.trim()

'Verify userid macthed'
WebUI.verifyMatch(GetUserID, findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('TEXT', 5), false)

'Get Function'
String Get_Function = WebUI.getText(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Get_Function_Obj'))

'Triming geting Function value'
String GetFunction = Get_Function.trim()

'Verify Function value macthed'
WebUI.verifyMatch(GetFunction, findTestData('CDDS/UM_Module_TestData/UM_Add_Group_To_IC').getValue('SELECT', 4), false)

'Wait for Group visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Group'), GlobalVariable.Element_Timeout)

'Select Group'
WebUI.check(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Select_Group'))

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display frame frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Display frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/PortalDisplay_iframe'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/ITMembers_Iframe'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Remove element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Remove_Obj'), GlobalVariable.Element_Timeout)

'Click on Remove option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Add_Group_To_IC/Remove_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(2)

'Accept Alert'
WebUI.acceptAlert()

'Logout or close browser'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

