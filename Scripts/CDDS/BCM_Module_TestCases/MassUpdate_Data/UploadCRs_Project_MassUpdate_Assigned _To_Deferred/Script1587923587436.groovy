import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/CreateCROtherState'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Upload Mass Update XLS button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs__Project_MassUpdate__New_To_Assigned/Upload Update XLS_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Upload Mass Update XLS... button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs__Project_MassUpdate__New_To_Assigned/Upload Update XLS_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'get the project location'
String pathapp = RunConfiguration.getProjectDir()

'print the path'
println(pathapp)

'navigate the to filr path'
String Filepath1 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Deferred').getValue(
    'File_path', 1)

'navigate the to file path'
pathapp123 = ((pathapp + '/Data Files/CDDS/') + Filepath1)

'get the file path'
println(pathapp123)

'replace \'/\' with \'\\\\\''
String spath1 = pathapp123.replaceAll('/', '\\\\')

'navigate the to filr path'
println(spath1)

'Wait for Attach file to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Chose_file_Obj'), 
    GlobalVariable.Element_Timeout)

'Upload file'
WebUI.uploadFile(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Chose_file_Obj'), 
    spath1)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for next  button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  next button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Delay for fe sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for next  button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  next button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'switch to index 0'
WebUI.closeWindowIndex(1, FailureHandling.OPTIONAL)

'switch to index 0'
WebUI.switchToWindowIndex(0)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'wait for keyword'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('Name', 1))

'wait for statecheck'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select statecheck'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs__Project_MassUpdate_New_To_Assigned').getValue('State', 
        1), false)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Assign a value to string'
String title1 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Name', 1)

'Assign a value to state'
String state1 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs__Project_MassUpdate_New_To_Assigned').getValue(
    'State', 1)

'creating a team dynamic xpath'
String titleXpath1 = ((('(//td[contains(.,"' + title1) + '")]/../..//td[contains(text(),"') + state1) + '")])[1]'

'creating the team xpath object'
TestObject titleObj1 = new TestObject('objectName')

'adding property in team dynamic xpath'
titleObj1.addProperty('xpath', ConditionType.EQUALS, titleXpath1)

'Wait for team  element to be visible'
WebUI.waitForElementVisible(titleObj1, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  team element '
WebUI.verifyElementVisible(titleObj1, FailureHandling.CONTINUE_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Close browser'
WebUI.closeBrowser()

'Delay for few sec'
WebUI.delay(GlobalVariable.Wait_Time)

'Launch the browser'
WebUI.openBrowser('')

'Maximize the window'
WebUI.maximizeWindow()

'Navigate to Application URL'
WebUI.navigateToUrl(GlobalVariable.Application_Url)

'Wait for Login Page Header element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_header_Obj'), GlobalVariable.Element_Timeout)

'Wait for Username element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Element_Timeout)

String LoginId = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Assessed').getValue(
    'UserID', 1)

'Enter the Username'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), LoginId)

'Wait for  login button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on login button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  welcome element  is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Welcome_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

'login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Assessed').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for  Owing BU'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'OwingBU', 1), false)

'Wait till project name is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Assign a value to string'
String name = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Name', 1)

'Enter project name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Add team add member/ProjectName_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('Search_Name', 1))

'wait for find'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Loading  Element not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a project dynamic xpath'
String projectXpath = ('//a[contains(.,"' + name) + '")]'

'creating the project xpath object'
TestObject projectObj = new TestObject('objectName')

'adding property in project dynamic xpath'
projectObj.addProperty('xpath', ConditionType.EQUALS, projectXpath)

'Wait for PROJECT  element to be visible'
WebUI.waitForElementVisible(projectObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  project element '
WebUI.scrollToElement(projectObj, GlobalVariable.Element_Timeout)

'Click on project'
WebUI.click(projectObj, FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for project  element to be visible'
WebUI.waitForElementVisible(projectObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Upload Mass Update XLS button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs__Project_MassUpdate__New_To_Assigned/Upload Update XLS_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Upload Mass Update XLS... button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs__Project_MassUpdate__New_To_Assigned/Upload Update XLS_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate the to filr path'
String Filepath2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Deferred').getValue(
    'File_path', 2)

'navigate the to file path'
pathapp2 = ((pathapp + '/Data Files/CDDS/') + Filepath2)

'get the file path'
println(pathapp2)

'replace \'/\' with \'\\\\\''
String spath2 = pathapp2.replaceAll('/', '\\\\')

'navigate the to filr path'
println(spath2)

'Wait for Attach file to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Chose_file_Obj'), 
    GlobalVariable.Element_Timeout)

'Upload file'
WebUI.uploadFile(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Chose_file_Obj'), 
    spath2)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for next  button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  next button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Delay for fe sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for next  button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  next button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'switch to index 0'
WebUI.closeWindowIndex(1, FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'switch to index 0'
WebUI.switchToWindowIndex(0)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'wait for keyword'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('Name', 1))

'wait for statecheck'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select statecheck'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Assessed').getValue(
        'State', 1), false)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Assign a value to string'
String title = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Name', 1)

'Assign a value to state'
String state = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Assessed').getValue(
    'State', 1)

'creating a team dynamic xpath'
String titleXpath = ((('(//td[contains(.,"' + title) + '")]/../..//td[contains(text(),"') + state) + '")])[1]'

'creating the team xpath object'
TestObject titleObj = new TestObject('objectName')

'adding property in team dynamic xpath'
titleObj.addProperty('xpath', ConditionType.EQUALS, titleXpath)

'Wait for team  element to be visible'
WebUI.waitForElementVisible(titleObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  team element '
WebUI.verifyElementVisible(titleObj, FailureHandling.CONTINUE_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Upload Mass Update XLS button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs__Project_MassUpdate__New_To_Assigned/Upload Update XLS_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Upload Mass Update XLS... button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs__Project_MassUpdate__New_To_Assigned/Upload Update XLS_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'navigate the to filr path'
String Filepath3 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Deferred').getValue(
    'File_path', 3)

'navigate the to file path'
pathapp3 = ((pathapp + '/Data Files/CDDS/') + Filepath3)

'get the file path'
println(pathapp3)

'replace \'/\' with \'\\\\\''
String spath3 = pathapp3.replaceAll('/', '\\\\')

'navigate the to filr path'
println(spath3)

'Wait for Attach file to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Chose_file_Obj'), 
    GlobalVariable.Element_Timeout)

'Upload file'
WebUI.uploadFile(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Chose_file_Obj'), 
    spath3)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for next  button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  next button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Delay for fe sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for next  button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  next button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UploadCRs_In_Project_ThroughMassUpdate/Next_btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait, FailureHandling.OPTIONAL)

'click on ok'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Switch to default'
WebUI.switchToDefaultContent()

'switch to index 0'
WebUI.closeWindowIndex(1, FailureHandling.OPTIONAL)

'switch to index 0'
WebUI.switchToWindowIndex(0)

'wait for alert'
WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait, FailureHandling.OPTIONAL)

'click on ok'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'wait for keyword'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter keyword'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Keyword_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('Name', 1))

'wait for statecheck'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.STOP_ON_FAILURE)

'Select statecheck'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/StateCheck_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Deferred').getValue(
        'State', 1), false)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for  find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/Verify _project/Find_btn_Obj'))

'Navigate to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Portal_dispaly_iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/BCMProjectInboxCommand_Iframe'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Assign a value to string'
String title2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'Name', 1)

'Assign a value to state'
String state2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UploadCRs_Project_MassUpdate_Assigned_To_Deferred').getValue(
    'State', 1)

'creating a team dynamic xpath'
String titleXpath2 = ((('(//td[contains(.,"' + title2) + '")]/../..//td[contains(text(),"') + state2) + '")])[1]'

'creating the team xpath object'
TestObject titleObj2 = new TestObject('objectName')

'adding property in team dynamic xpath'
titleObj2.addProperty('xpath', ConditionType.EQUALS, titleXpath2)

'Wait for team  element to be visible'
WebUI.waitForElementVisible(titleObj2, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  team element '
WebUI.verifyElementVisible(titleObj2, FailureHandling.CONTINUE_ON_FAILURE)

'Delay for few sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Close broswer'
WebUI.closeBrowser()

