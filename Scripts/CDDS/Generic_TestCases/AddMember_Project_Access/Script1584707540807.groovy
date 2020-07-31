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

WebUI.delay(5)

'Switch to Default'
WebUI.switchToDefaultContent()

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Access_Security Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Access_Security_Obj'), GlobalVariable.Element_Timeout)

'Click on AccessSecurity'
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Access_Security_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default'
WebUI.switchToDefaultContent()

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessSecurity_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Actions'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for AddAccess element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Add_access_Obj'), GlobalVariable.Element_Timeout)

'Click on AddAcess'
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Add_access_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Switch to Default'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 6))

'Maximise the window'
WebUI.maximizeWindow()

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Type element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Select_Person_Type_Obj'), GlobalVariable.Element_Timeout)

'Selecr Type as Person'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Select_Person_Type_Obj'), MemberType, 
    false)

'Wait for Search UserID element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Search_UserId_Obj'), GlobalVariable.Element_Timeout)

'Enter the Search UserID '
WebUI.setText(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Search_UserId_Obj'), SetMember, FailureHandling.STOP_ON_FAILURE)

'Wait for Find btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Find btn '
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for MemberCheckbox  element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'), GlobalVariable.Element_Timeout)

'Select the Member Checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Select_CheckBox_Obj'))

'Wait for AccessType  element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/AccessType_Obj'), GlobalVariable.Element_Timeout)

'Select AccessType  as Edit'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/AccessType_Obj'), AccessType, false)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Submit btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on submit btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Submit_Btn_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetails  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCMTeamMemberAccessSecurity frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessSecurity_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to list filter frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Find btn element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/Find_Btn_Obj'))

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to details display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetails  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCMTeamMemberAccessSecurity frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessSecurity_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to List Display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for VerifyAccessType element tobe visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/VerifyAcccessType_Obj'), GlobalVariable.Element_Timeout)

'Get the accesstype from search result'
ActualaccessType = WebUI.getText(findTestObject('CDDS/Generic_Objects/AddMember_Project_Access/VerifyAcccessType_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify Equal actualAccessType and Expected Accesstype'
WebUI.verifyEqual(ActualaccessType.trim(), AccessType, FailureHandling.CONTINUE_ON_FAILURE)

