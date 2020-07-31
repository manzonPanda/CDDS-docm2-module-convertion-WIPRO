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

not_run: WebUI.refresh()

not_run: WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to MyDesk tab'
not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Pagination Frame'
not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
not_run: WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue('Project_Name', 1))

'Wait for ProjectName element to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
not_run: WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue('ShowProject', 1), false)

'Wait for Find btn element to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
not_run: WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: def ProjectName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue('Project_Name', 
    1)

not_run: println(ProjectName)

'creating a Select ProjectNameXpath dynamic xpath'
not_run: String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

'creating the Select ProjectName xpath object'
not_run: TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
not_run: ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Wait for  Select ProjectName  element to be visible'
not_run: WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
not_run: WebUI.verifyElementText(ProjectNameObj, ProjectName, FailureHandling.OPTIONAL)

'Click on Select ProjectName'
not_run: WebUI.click(ProjectNameObj, FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Select ProjectName'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Team Member_TI-User_Program/Inbox_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Inbox_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Properties frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for Action element to be visble'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create BCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/BCM_State_Validation_Create_Requirement_for_all_access_roles_Objects/Create_BCM_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Bug element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Requirement_Option'), GlobalVariable.Element_Timeout)

'Click on Bug'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Requirement_Option'), FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Title'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Title'), Title)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Priority'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Priority'), Priority, false)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Date_Selection'), GlobalVariable.Element_Timeout)

'Click on Target date icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Date_Selection'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for date to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Date'), GlobalVariable.Element_Timeout)

'Click on the date'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Select_Date'), FailureHandling.STOP_ON_FAILURE)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Description'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Description'), Description)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Justification_Obj'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Justification_Obj'), Justification)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Classification'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Classification'), Classification, 
    false)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Subclassification_Requirement'), 
    GlobalVariable.Element_Timeout)

'Set Member '
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Subclassification_Requirement'), Subclassification, 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Team_Selection'), GlobalVariable.Element_Timeout)

'Set Member '
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Team_Selection'), RespondingTeam, 
    false)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/TIInternalComments'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/TIInternalComments'), TIInternalComments)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/ExternalComments'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/ExternalComments'), ExternalComments)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/ContactDepartment'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/ContactDepartment'), ContactDepartment)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/OtherID'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/OtherID'), OtherID)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/ExternalID'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/ExternalID'), ExternalID)

'Wait for Target date icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Upload_File'), GlobalVariable.Element_Timeout)

'Wait for date to be visible'
WebUI.uploadFile(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Upload_File'), FilePath)

'Swich to default content'
WebUI.switchToDefaultContent()

'Wait Done btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Done_Button'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Done_Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Get the Alert text'
ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
if (ActualGetTextAlert.contains('already exist')) {
    WebUI.acceptAlert()

    WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))
} else {
}

