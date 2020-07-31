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
InternalData data = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation')

for (def index : (1..data.getRowNumbers())) {
    'Login to CDDS Application or navigate to CDDS Application'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue('User_ID', 
                index)], FailureHandling.STOP_ON_FAILURE)

    'Navigate to MyDesk tab'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Navigate  Bug and Change Management (BCM) tab to Projects'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
                'CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue('Main_Menu', 
                index), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_Create_Bug').getValue(
                'Sub_Menu', index)], FailureHandling.STOP_ON_FAILURE)

    'Get the Data Value'
    def val = 1

    def Project_Name = findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/BCM_State_Validation_CreateIC').getValue(
        'ProjectName', 2)

    WebUI.delay(GlobalVariable.Wait_Time)

    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
        GlobalVariable.Element_Timeout)

    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/ProjectName'), 
        Project_Name)

    'Wait for Find btn element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        GlobalVariable.Element_Timeout)

    'Click on Find Btn'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/BCM_State_Validation_CreateIC/Find_button'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(GlobalVariable.Wait_Time)

    'Navigate to Table Verify Frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    //def ProjectName = Project_Name
    //println(ProjectName)
    'creating a Select ProjectNameXpath dynamic xpath'
    String ProjectNameXpath = ('//a[contains(text(),"' + Project_Name) + '")]'

    'creating the Select ProjectName xpath object'
    TestObject ProjectNameObj = new TestObject('objectName')

    'adding property in Select ProjectName dynamic xpath'
    ProjectNameObj.addProperty('xpath', ConditionType.EQUALS, ProjectNameXpath)

    'Wait for  Select ProjectName  element to be visible'
    WebUI.waitForElementVisible(ProjectNameObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

    'Wait for  Select ProjectName  element to be visible'
    WebUI.verifyElementText(ProjectNameObj, Project_Name, FailureHandling.OPTIONAL)

    'Wait for  Select ProjectName  element to be visible'
    WebUI.click(ProjectNameObj)

    WebUI.delay(GlobalVariable.Wait_Time)

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

    WebUI.delay(GlobalVariable.Wait_Time)

    'Wait for Team select option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Team'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Team_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'TeamName', index), false)

    'Wait for Severity select option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Severity_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Severity'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Severity_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMSeverity', index), false)

    'Wait for Title field element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Title'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Title_Field_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMTitle', index))

    'Wait for Description field element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Description'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Description_Field_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMDescription', index))

    'Wait for While Doing select option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_While_Doing_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select While Doing'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_While_Doing_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMWhileDoing', index), false)

    'Wait for Location found select option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Location_Found_Obj'), 
        GlobalVariable.Element_Timeout)

    'Select Location Found'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Location_Found_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMLocationFound', index), false)

    'Wait for Location Fount Identifire field element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/LocationFound_Identifire_Obj'), 
        GlobalVariable.Element_Timeout)

    'Enter Location Fount Identifire'
    WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/LocationFound_Identifire_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMLocationFoundIDLabel', index))

    'Wait for Clasification select option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Select Clasification'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_Classification_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMClassification', index), false, FailureHandling.OPTIONAL)

    'Wait for Sub Clasification select option to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_SubClassification_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Select Sub Clasification'
    WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/Reports_Master_Objects/Reports_Master_Create_Bug_Objects/Select_SubClassification_Obj'), 
        findTestData('CDDS/BCM_Module_TestData/Reports_Master_TestData/CreateBugs_Team_7493_2_BCM_State_Validation').getValue(
            'BCMSubClassification', index), false, FailureHandling.OPTIONAL)

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

    WebUI.closeBrowser()
}

