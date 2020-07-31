import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Non Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : GlobalVariable.Support_Role_Username], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Main Menu', 1), ('SubMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Verify_My_Inbox').getValue('Sub Menu', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Wait_Time)

'Create Project'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue(
            'AssociateSchema', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Project name'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue('ProjectName', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.delay(GlobalVariable.Wait_Time)

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Assign a value to string'
String Project = findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue('ProjectName', 1)

'creating a IC dynamic xpath'
String ProjectNameXpath = ('//a[contains(.,"' + Project) + '")]'

'creating the SubMenu xpath object'
TestObject ProjectObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ProjectObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

'Click on Project Link'
WebUI.click(ProjectObj)

WebUI.delay(GlobalVariable.Wait_Time)

'Create Alert'
WebUI.comment('==========================')

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Conten frame '
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Details Display Frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to Portal Frame\r\n'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Portal_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Swicth to BCM Command frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Iframe_BCMProjectInboxCommand'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Actions button '
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Actions_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for Create BCM element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Create_BCM_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on  Create BCM'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Requirment_Edit_Functionality_Master_Objects/BCM_State_Validation_Edit_Functionality_Assigned_State_Objects/Create_BCM_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/Alert_Obj'))

'Switch to page content frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select Priority as 2-High'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/priority'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('Priority', 1), 
    false)

'Select Originating Team as Alert_Team,, Alert Team is is not in the dropdown Alert_DSPS1 team is there in dropdown'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/OriginatingTeam'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('Team', 1), false)

'Eneter Title as Auto_Test_PO_Alert'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/Team'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('Title', 1))

'Eneter Title as Auto_Test_PO_Alert_Description'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/Description'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('Description', 1))

'Click on Project Recepients Icon'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/RecepientProjects'))

WebUI.delay(7)

'Switch to new page'
WebUI.switchToWindowIndex(2)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Project name'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/Create_Project').getValue('ProjectName', 1))

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Select the project(checkbox)'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/Project_select'))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Submit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/3.BCM_Alert_AddMembers/Submit'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
not_run: WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Enter name as FOB_NameTest1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/FieldOnObject_Name'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('FieldOnObject_Name', 
        1))

'Enter Revision/Variant as FOB_RevTest1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/FieldOnObject_Variant'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('FieldOnObject_Variant', 
        1))

'Enter Type as FOB_TypeTest1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/FieldOnObject_Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('FieldOnObject_Type', 
        1))

'Select LocationFound as RTL'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/LocationFound'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('LocationFound', 
        1), false)

'Enter Location found Id as LFID'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/LocationFoundId'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('LocationFoundId', 
        1))

'Enter Response nstructions  as Alert-ResponserInstrs'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/ResponseInstructions'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('ResponseInstructions', 
        1))

'Enter Response Final Instructions as Alert-ResponserInstrs-Finalnoticemessage'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/ResponseFinalInstructions'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('ResponseFinalInstructions', 
        1))

'Enter Response Comments as Alert-Testcomments'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Alert_Master/5.BCM_State_Validation_CreateAlert/Comments'), findTestData(
        'CDDS/BCM_Module_TestData/BCM_Alert_Master/BCM_State_Validation_CreateAlert').getValue('LocationFoundId', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on Done'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Done'))

