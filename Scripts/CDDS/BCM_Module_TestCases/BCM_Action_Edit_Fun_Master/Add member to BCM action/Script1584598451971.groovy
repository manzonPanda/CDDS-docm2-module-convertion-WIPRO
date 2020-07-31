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

WebUI.delay(GlobalVariable.Short_Wait)

'Wit for member to be visible\t\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Member_Obj'), 
    GlobalVariable.Element_Timeout)

'click on member'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Member_Obj'))

'wait the name is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Member_name_Obj'), 
    GlobalVariable.Element_Timeout)

'Clixk onthe member name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Member_name_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/BCMProjectTeamMembers_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Type_Obj'), 
    GlobalVariable.Element_Timeout)

'Select type as person'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Type_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue('Type', 1), false, 
    FailureHandling.STOP_ON_FAILURE)

'Select company as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Company_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue('Company', 1), false, 
    FailureHandling.STOP_ON_FAILURE)

'Enter the Id'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/AddId_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue('Id', 1))

'Enter the name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue('Name', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading is not visible'
WebUI.waitForElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Loading_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to frame\t\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/BCMProjectTeamMembers_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/New match_Obj'), 
    GlobalVariable.Wait_Time)

WebUI.delay(GlobalVariable.Short_Wait)

if (WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/New match_Obj'), 
    GlobalVariable.Wait_Time)) {
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Wait_Time)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/BCMProjectTeamMembers_iframe'), 
        GlobalVariable.Wait_Time)

    'Wait for Actions button element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on  Actions button '
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for add member element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Add_Member_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on  add member '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Add_Member_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Switch  to default content '
    WebUI.switchToDefaultContent()

    'Switch to create window'
    WebUI.switchToWindowTitle(findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue(
            'Title', 1))

    'Maximise the window'
    WebUI.maximizeWindow()

    'Switch to default'
    WebUI.switchToDefaultContent()

    'wait till no is visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Email_Notification_No_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on no'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Email_Notification_No_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Enter the name'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Create_Name_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/BCM_Action_Edit_Fun_Master/Add_member to action').getValue('Name', 3))

    'Click on name'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
        GlobalVariable.Wait_Time)

    'Click on name'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Select team'
    WebUI.selectOptionByIndex(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Team_Obj'), 
        0)

    'Wait till  addbutton visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/AddMemeber_Obj'), 
        GlobalVariable.Wait_Time)

    'Click on addnme button'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/AddMemeber_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'Switch to default'
    WebUI.switchToDefaultContent()

    WebUI.delay(GlobalVariable.Short_Wait)

    'Click on done\r\n'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Done_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
}

