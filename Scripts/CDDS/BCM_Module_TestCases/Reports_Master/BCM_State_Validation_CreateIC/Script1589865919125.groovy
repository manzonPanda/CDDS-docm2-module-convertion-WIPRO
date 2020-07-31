import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Get the Validate_Requirement_With_Different_State from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC')

for (def index : (1..data.getRowNumbers())) {
    'Login to CDDS Application or navigate to CDDS Application'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('User_ID', index)], 
        FailureHandling.STOP_ON_FAILURE)

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('Main_Menu', 
                index), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'Sub_Menu', index)], FailureHandling.STOP_ON_FAILURE)

    'Get the Data Value'
    def val = 1

    WebUI.delay(GlobalVariable.Wait_Time)

    WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/Reports_Master/Common_TC_ReportMaster/Create_IC'), [('CMPathType') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('CMPathType', 
                index), ('CMPath') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'CMPath', index), ('CMSystem') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'CMSystem', index), ('ICSecOwner') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'ICSecOwner', index), ('Ipclassfn') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'Ipclassfn', index), ('technology') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'technology', index), ('Library') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'Library', index), ('WorkflowTemplate') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'WorkflowTemplate', index), ('ICVer') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'ICVersion', index), ('OwningBU') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'OwningBU', index), ('ICEngagementModel') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'ICEngagementModel', index), ('Description1') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'description', index), ('IC_Category') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'IC_Category', index), ('ICName') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'ICName', index), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'ProjectAbbreviation', index), ('AssociatedSchema') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
                'AssociatedSchema', index)], FailureHandling.OPTIONAL)

    WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 3), FailureHandling.OPTIONAL)

    WebUI.refresh(FailureHandling.OPTIONAL)

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Menu Collapsed element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), GlobalVariable.Element_Timeout)

    'Click on  Menu Collapsed'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for Few Seconds'
    WebUI.delay(GlobalVariable.Short_Wait)

    not_run: WebUI.switchToDefaultContent()

    'Navigate to My Desk'
    not_run: WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate to Design Repository to IC Component'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
            , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
        GlobalVariable.Element_Timeout)

    'Set the Project Name'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue('ProjectName', 
            index))

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(GlobalVariable.Wait_Time)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    def ProjectName = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
        'ProjectName', index)

    //def ProjectName = Project_Name
    //println(ProjectName)
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

    'Wait for  Select ProjectName  element to be visible'
    WebUI.click(ProjectNameObj)

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

    WebUI.delay(GlobalVariable.Wait_Time)

    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Naviagate_to_Project_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Project_Navigation_Frame/BCMProjectProperties_Frame'), GlobalVariable.Element_Timeout)

    'Verify Action Button not present'
    WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Action_button'), 
        GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

    'Verify Action Button not present'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Action_button'))

    'Verify Action Button not present'
    WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Edit_button'), 
        GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

    'Verify Action Button not present'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Edit_button'))

    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Switch to create window'
    WebUI.switchToWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1))

    'Maximise the window'
    WebUI.maximizeWindow()

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

    WebUI.delay(GlobalVariable.Short_Wait)

    'Verify Action Button not present'
    WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/BugDefaultView'), 
        GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

    'Verify Action Button not present'
    WebUI.check(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/BugDefaultView'))

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Verify Action Button not present'
    WebUI.waitForElementPresent(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Done_Button'), GlobalVariable.Wait_Time, 
        FailureHandling.STOP_ON_FAILURE)

    'Verify Action Button not present'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC/Base_Data_Creation/Done_Button'))

    WebUI.delay(GlobalVariable.Wait_Time)

    WebUI.closeBrowser()
}

