import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Non_Support_Role_Username], 
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
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue('ShowProject', 1), false)

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

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj, ProjectName, FailureHandling.OPTIONAL)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

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
WebUI.waitForElementPresent(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Create_Team_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Create Team element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_Team_Objects/Create_Team_Obj'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/Create_Team'), [('Team_Name') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Team_Name', 1), ('Team_Description') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Team_Description', 1), ('Team_BaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Team_BaseSite', 1)], FailureHandling.STOP_ON_FAILURE)

def TeamName = findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue('Team_Name', 1)

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

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Team_Details_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Team'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Team Member_Non TI-User_IC Component/Membership'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Action Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Team_Details_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Swicth to BCM Team Result frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectTeamMembersAccessGroups'), GlobalVariable.Element_Timeout)

WebUI.delay(GlobalVariable.Short_Wait)

'Wait for Actions button element to be visible'
WebUI.verifyElementPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Actions button element to be visible'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Actions button element to be visible'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Members and Access'))

WebUI.delay(GlobalVariable.Short_Wait, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Bug_Add_Member'), [('SetMember') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'SetMember', 1), ('Company') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Company', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Bug_Add_Member'), [('SetMember') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'SetMember_External', 1), ('Company') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Company_External', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/Create_Bug'), [('Team') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Team_Name', 1), ('Severity') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Severity', 1), ('Description') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Bug_Description', 1), ('Classification') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Classification', 1), ('Title') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Bug_Title', 1), ('On_Behalf_Of') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'On_Behalf_Of', 1), ('Found_While_Doing') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Found_While_Doing', 1), ('FILE1') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'File', 1), ('Location_Found') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Location_Found', 1), ('Location_Found_Identifier') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Location_Found_Identifier', 1), ('Subclassification') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'Subclassification', 1), ('CC_List') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue(
            'CC_List', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.delay(GlobalVariable.Wait_Time)

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
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/Base_Data_Creation').getValue('ShowProject', 1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/BCM_SMC_BCM_SCM_Non_Member_Non_TI_Program_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for  Select ProjectName  element to be visible'
WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Wait for  Select ProjectName  element to be visible'
WebUI.verifyElementText(ProjectNameObj, ProjectName, FailureHandling.OPTIONAL)

'Click on Select ProjectName'
WebUI.click(ProjectNameObj, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/Create_Requirement'), [('TIInternalComments') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('TIInternalComments', 1), ('ExternalID') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('ExternalID', 1), ('OtherID') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('OtherID', 1), ('ContactDepartment') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('ContactDepartment', 1), ('ExternalComments') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('ExternalComments', 1), ('RespondingTeam') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('RespondingTeam', 2), ('Description') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('Description', 1), ('Title') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('Title', 1), ('Priority') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('Priority', 1), ('Subclassification') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('Subclassification', 1), ('Classification') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('Classification', 1), ('Justification') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('Justification', 1), ('FilePath') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_SMC_TestData/Create_Requirement').getValue('FilePath', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

