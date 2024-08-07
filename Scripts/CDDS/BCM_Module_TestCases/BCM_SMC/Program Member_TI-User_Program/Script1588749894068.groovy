import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue('ProjectName', 1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Program Member_TI-User_Program').getValue('ShowProject', 1), 
    false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

def ProjectName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue('ProjectName', 1)

println(ProjectName)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath = ('//a[contains(text(),"' + ProjectName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Click on Select ProjectName'
WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Verify Project Not Found'
not_run: WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Team Member_Non TI-User_Program').getValue('ProjectNotFound', 
        1), FailureHandling.OPTIONAL)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/ProjectName_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue('ProjectName', 1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Program Member_TI-User_Program').getValue('ShowProject', 2), 
    false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Select ProjectName'
WebUI.verifyElementPresent(ProjectNameObj, GlobalVariable.Wait_Time)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj, ProjectName, FailureHandling.CONTINUE_ON_FAILURE)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'creating a Select ProjectNameXpath dynamic xpath'
String ProjectNameXpath1 = ('//label[contains(text(),"' + ProjectName) + '")]'

println(ProjectNameXpath1)

'creating the Select ProjectName xpath object'
TestObject ProjectNameObj1 = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProjectNameObj1.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath1)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj1, ProjectName, FailureHandling.CONTINUE_ON_FAILURE)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj1, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Naviagate_to_Project_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Project_Navigation_Frame/BCMProjectProperties_Frame'), GlobalVariable.Element_Timeout)

'Verify Action Button not present'
WebUI.verifyElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.CONTINUE_ON_FAILURE)

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

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Create_Program_Project_Objects/Create_BCM_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to Default content'
WebUI.switchToDefaultContent()

'Wait for Team Element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), GlobalVariable.Element_Timeout)

'Click on Team'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Teams_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamsResult_Frame_Obj'), GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create Team element to be visible'
WebUI.verifyElementNotPresent(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Create_Team_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.CONTINUE_ON_FAILURE)

def TeamName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Program Member_TI-User_Program').getValue('Team_Name', 
    1)

println(TeamName)

'creating a Select TeamNameXpath dynamic xpath'
String TeamNameXpath = ('//a[contains(text(),"' + TeamName) + '")]'

'creating the Select TeamName xpath object'
TestObject TeamNameObj = new TestObject('objectName')

'adding property in Select TeamName dynamic xpath'
TeamNameObj.addProperty('xpath', ConditionType.EQUALS, TeamNameXpath)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Team_Navigation_Page'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Select TeamName  element to be visible'
WebUI.waitForElementVisible(TeamNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on Select TeamName'
WebUI.click(TeamNameObj, FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Team_Details_Frame/TIDetails_frame'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Team_Details_Frame/BCMProjectTeamInboxBCMElements frame'), GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Create_Program_Project_Objects/Create_BCM_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Team_Details_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Team Member_Non TI-User_IC Component/Membership'), FailureHandling.STOP_ON_FAILURE)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Team_Details_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessGroups'), GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Actions button element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Wait for AddMember element to be visible'
WebUI.verifyElementNotPresent(findTestObject('CDDS/Generic_Objects/Bug_Add_Member/AddMember_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Switch to Default content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Menu Collapsed element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), GlobalVariable.Element_Timeout)

'Click on  Menu Collapsed'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate Design  Management DM tab to Create Program'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DMCMyDesk'
        , ('SubMenu') : 'Programs'], FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Base_Data_Creation1_Objects/Keyword_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Keyword_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Program Member_TI-User_Program').getValue('Program_Name', 1))

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Program'
WebUI.check(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Base_Data_Creation1_Objects/Find_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

def ProgramName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Team Member_Non TI-User_Program').getValue('Project_Name', 
    1)

println(ProgramName)

'creating a Select ProjectNameXpath dynamic xpath'
String ProgramNameXpath = ('//a[contains(text(),"' + ProgramName) + '")]'

'creating the Select ProjectName xpath object'
TestObject ProgramNameObj = new TestObject('objectName')

'adding property in Select ProjectName dynamic xpath'
ProgramNameObj.addProperty('xpath', ConditionType.EQUALS, ProgramNameXpath)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Select ProjectName'
WebUI.verifyElementNotPresent(ProgramNameObj, GlobalVariable.Wait_Time)

'Verify Project Not Found'
not_run: WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Program Member_TI-User_Program').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_Base_Data_Creation1_Objects/Keyword_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Keyword_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_BCM_FP').getValue('ProjectName', 1))

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.uncheck(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/MyProgram_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Select ProjectName'
WebUI.verifyElementNotPresent(ProgramNameObj, GlobalVariable.Wait_Time)

'Verify Project Not Found'
not_run: WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SCM_Non_Member_Non_TI_Program').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

