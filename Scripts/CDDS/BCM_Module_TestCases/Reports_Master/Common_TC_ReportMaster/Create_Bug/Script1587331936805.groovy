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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.annotation.Keyword as Keyword

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Swicth to BCM Project Inbox Command frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectInboxCommand_frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'If Create BCM collaps expand it'
if (WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'), 
    GlobalVariable.Short_Wait)) {
    'Wait for Create BCM option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on CreateBCM '
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Common_TC_ReportMaster_Objects/Expand_CreateBCM_Obj'))

    'Wait for Bug option element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Bug_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Bug tab'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Bug_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
} else {
    'Wait for Bug option element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Bug_Obj'), 
        GlobalVariable.Element_Timeout)

    'Click on Bug tab'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Bug_Obj'), 
        FailureHandling.STOP_ON_FAILURE)
}

'Switch to Page navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Creating variable for taking test data from data file'
String Expected_Team1 = Expected_Team

'Wait for Team select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Team'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
    Expected_Team1, false)

'Creating variable for taking test data from data file'
String Expected_Severity1 = Expected_Severity

'Wait for Severity select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Severity_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Severity'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Severity_Obj'), 
    Expected_Severity1, false)

'Wait for Calender Icon to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Calender_Icon_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Calender Icon'
not_run: WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Calender_Icon_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Date to be visible'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Date_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Date'
not_run: WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Date_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
not_run: WebUI.delay(GlobalVariable.Short_Wait)

'Creating variable for taking test data from data file'
String Expected_Title1 = Expected_Title

'Wait for Title field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Title'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
    Expected_Title1)

'Creating variable for taking test data from data file'
String Expected_Description1 = Expected_Description

'Wait for Description field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
    Expected_Description1)

'Creating variable for taking test data from data file'
String Expected_While_Doing1 = Expected_While_Doing

'Wait for While Doing select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_While_Doing_Obj'), 
    GlobalVariable.Element_Timeout)

'Select While Doing'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_While_Doing_Obj'), 
    Expected_While_Doing1, false)

'Creating variable for taking test data from data file'
String Expected_Location_Found1 = Expected_Location_Found

'Wait for Location found select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Location_Found_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Location Found'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Location_Found_Obj'), 
    Expected_Location_Found1, false)

'Creating variable for taking test data from data file'
String Expected_Location_Found_Identifire1 = Expected_Location_Found_Identifire

'Wait for Location Fount Identifire field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/LocationFound_Identifire_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter Location Fount Identifire'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/LocationFound_Identifire_Obj'), 
    Expected_Location_Found_Identifire1)

'Creating variable for taking test data from data file'
String Expected_Classification1 = Expected_Classification

'Wait for Clasification select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Select Clasification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
    Expected_Classification1, false, FailureHandling.OPTIONAL)

'Creating variable for taking test data from data file'
String Expected_Sub_Classification1 = Expected_Sub_Classification

'Wait for Sub Clasification select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_SubClassification_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Select Sub Clasification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_SubClassification_Obj'), 
    Expected_Sub_Classification1, false, FailureHandling.OPTIONAL)

'Creating variable for taking test data from data file'
String Expected_FiledObjType1 = Expected_FiledObjType

'Wait for Filed on Object Type field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Filed_On_ObjectType_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Enter filed on object type'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Filed_On_ObjectType_Obj'), 
    Expected_FiledObjType1, FailureHandling.OPTIONAL)

'Creating variable for taking test data from data file'
String Expected_FiledObjName1 = Expected_FiledObjName

'Wait for Filed on Object Name field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Filed_On_ObjectName_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Enter filed on object Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Filed_On_ObjectName_Obj'), 
    Expected_FiledObjName1, FailureHandling.OPTIONAL)

'Creating variable for taking test data from data file'
String Expected_FiledObjVersion1 = Expected_FiledObjVersion

'Wait for Filed on Object Version field element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Filed_On_ObjectVersion_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Enter filed on object Version'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Filed_On_ObjectVersion_Obj'), 
    Expected_FiledObjVersion1, FailureHandling.OPTIONAL)

'Wait for Choose file btn to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/ChooseFile_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Choose file Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/ChooseFile_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Get file directory'
def PrjDir = RunConfiguration.getProjectDir()

'Creating variable for taking test data from data file'
String Expected_FilePath1 = Expected_FilePath

'Get File exact path'
def FilePath = (PrjDir + '/') + Expected_FilePath1

//println (se.replaceAll('/', '\\'))
'Replace forward slash into backward slash'
def pathdatafile = FilePath.replace('/', '\\')

'Get the file path'
not_run: String filePath = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/Reports_Master_Create_Bug_TestData').getValue(
    'FILE_PATH', 1)

StringSelection sdata = new StringSelection(pathdatafile)

Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sdata, null)

'Using robot functionality to handle system window'
Robot robot = new Robot()

'wait'
robot.delay(2)

'Using robot functionality to handle system window'
robot.keyPress(KeyEvent.VK_ENTER)

'Using robot functionality to handle system window'
robot.keyRelease(KeyEvent.VK_ENTER)

'wait'
robot.delay(1)

'Using robot functionality to handle system window'
robot.keyPress(KeyEvent.VK_CONTROL)

'Using robot functionality to handle system window'
robot.keyPress(KeyEvent.VK_V)

'wait'
robot.delay(1)

'Using robot functionality to handle system window'
robot.keyRelease(KeyEvent.VK_V)

'Using robot functionality to handle system window'
robot.keyRelease(KeyEvent.VK_CONTROL)

'wait'
robot.delay(1)

'Using robot functionality to handle system window'
robot.keyPress(KeyEvent.VK_ENTER)

'Using robot functionality to handle system window'
robot.keyRelease(KeyEvent.VK_ENTER)

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Creating variable for taking test data from data file'
String Expected_ProjectMember_List1 = Expected_ProjectMember_List

'Wait for Project Member List select option to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/ProjectMember_List_Obj'), 
    GlobalVariable.Element_Timeout)

'Select Project Member List'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/ProjectMember_List_Obj'), 
    Expected_ProjectMember_List1, false)

'Wait for Next icon to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Forward_Icon_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on next Icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Forward_Icon_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done button to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Project_Objects/Done_Btn_Obj'))

'Wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait'
WebUI.delay(GlobalVariable.Wait_Time)

