import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Document Management tab to folders'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
        , ('SubMenu') : 'Folders'], FailureHandling.STOP_ON_FAILURE)

'Create a Folder'
WebUI.callTestCase(findTestCase('CDDS/UM_Module_TestCases/Create_Folder'), [('FolderTitle') : findTestData('CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue(
            'FolderTitle', 1), ('BusinessUnit') : findTestData('CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue(
            'BusinessUnit', 1), ('Description') : findTestData('CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue(
            'Description', 1), ('CompanyName') : findTestData('CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue('CompanyName', 
            1)], FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for DOCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/DOCM_Obj'), GlobalVariable.Element_Timeout)

'Scroll to  DOCM element'
WebUI.scrollToElement(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/DOCM_Obj'), GlobalVariable.Element_Timeout)

'Click on DOCM'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/DOCM_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for few seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Groups'], FailureHandling.STOP_ON_FAILURE)

'Create the groups'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Groups'), [('GroupName') : findTestData('CDDS/Generic_TestData/Create_Group').getValue(
            'GroupName', 3), ('Company') : findTestData('CDDS/Generic_TestData/Create_Group').getValue('Company', 3), ('Description') : findTestData(
            'CDDS/Generic_TestData/Create_Group').getValue('Description', 3)], FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

'Navigate to Verify table Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get the GroupName '
String GroupName = findTestData('CDDS/Generic_TestData/Create_Group').getValue('GroupName', 3)

'creating a GroupName dynamic xpath'
String GroupNameXpath = ('//a[contains(text(),"' + GroupName) + '")]'

'creating the SubMenu xpath object'
TestObject GroupNameObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
GroupNameObj.addProperty('xpath', ConditionType.EQUALS, GroupNameXpath)

'Wait for SubMenu  element to be visible'
WebUI.waitForElementVisible(GroupNameObj, GlobalVariable.Element_Timeout)

//'Scroll to  SubMenu  element '
//WebUI.scrollToElement(GroupNameObj, GlobalVariable.Element_Timeout)
'Click on SubMenu'
WebUI.click(GroupNameObj)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Wait for Associates folder element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Associated_Folders_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Associates folder'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Associated_Folders_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Add folder element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Add_Folder_Obj'), GlobalVariable.Element_Timeout)

'Click on Add folder'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Add_Folder_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

'Switch to Initial frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Initial_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Root Folder element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Root_Folder_Obj'), GlobalVariable.Element_Timeout)

'Select Root  folder'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Root_Folder_Obj'), findTestData(
        'CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue('FolderTitle', 1), false)

'Wait for Access Level element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Access_Level_Obj'), GlobalVariable.Element_Timeout)

'Select Access Level'
WebUI.selectOptionByValue(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Access_Level_Obj'), findTestData(
        'CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue('AccessLevel', 1), false)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to StructureTreeFrame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/StructureTree_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Folder_Group element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Folder_Group_Obj'), GlobalVariable.Element_Timeout)

'Click on FolderGroup'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Folder_Group_Obj'), FailureHandling.STOP_ON_FAILURE)

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Switch to StructureTreeFooter Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/StructureTreeFooter_Ob'), GlobalVariable.Element_Timeout)

'Wait for Submit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Submit '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/Submit_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Accept alert popup'
WebUI.acceptAlert()

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  UserManagement tab to User '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'UMCMyDesk'
        , ('SubMenu') : 'Groups'], FailureHandling.STOP_ON_FAILURE)

'Navigate to  Users Search Page Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Search company dropdown element to be visible'
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), GlobalVariable.Element_Timeout)

'Select Company drpdown as TI'
WebUI.selectOptionByLabel(findTestObject('CDDS/Generic_Objects/Create_Users_Objects/Search_ Company_Dropdown_Obj'), findTestData(
        'CDDS/Generic_TestData/Create_Group').getValue('Company', 3), false)

'Wait for Search GroupName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Search_GroupName_Obj'), GlobalVariable.Element_Timeout)

'Set the GroupName as TI_UM_Group_1  in Search field'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Search_GroupName_Obj'), findTestData('CDDS/Generic_TestData/Create_Group').getValue(
        'GroupName', 3))

'Wait for MyGroups Checkbox element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/MyGroups_ChkBx_Obj'), GlobalVariable.Element_Timeout)

'Click on MyGroup Checkbox'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/MyGroups_ChkBx_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Groups_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Delete the group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Group'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to create window'
WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3))

'Switch to Default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for UM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/UserManagement_Obj'), GlobalVariable.Element_Timeout)

'Scroll to  UM element'
WebUI.scrollToElement(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/UserManagement_Obj'), GlobalVariable.Element_Timeout)

'Click on  UM '
WebUI.click(findTestObject('CDDS/UM_Module_Objects/AttachFolderTo_Group_Objects/UserManagement_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Document Management tab to folders'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'TIDocumentManagement'
        , ('SubMenu') : 'Folders'], FailureHandling.STOP_ON_FAILURE)

'Delete the Folder from DOCM'
WebUI.callTestCase(findTestCase('CDDS/UM_Module_TestCases/Delete_Folder'), [('FolderTitle') : findTestData('CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue(
            'FolderTitle', 1), ('BusinessUnit') : findTestData('CDDS/UM_Module_TestData/AttachFolderTo_Group').getValue(
            'BusinessUnit', 1)], FailureHandling.STOP_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

