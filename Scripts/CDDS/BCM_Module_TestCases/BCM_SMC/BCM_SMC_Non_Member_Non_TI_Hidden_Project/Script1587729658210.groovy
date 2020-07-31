import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def RandomNum = RandomStringUtils.randomNumeric(3)

GlobalVariable.RandomNumber = RandomNum

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/BCM_SMC_Create_IC_Component'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Member_Non_TI_Hidden_Program_Project').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ProjectName_Obj'), 
    ((findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber) + '-') + findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue(
        'ComponentVariant', 1))

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ShowProject_My', 
        1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ProjectName_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Project Name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ProjectName_Obj'), 
    ((findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber) + '-') + findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue(
        'ComponentVariant', 1))

'Wait for ProjectName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Show_Projects_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for ProjectName element to be visible'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Show_Projects_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ShowProject', 
        1), false)

'Wait for Find btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default Content'
WebUI.switchToDefaultContent()

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Menu Collapsed element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), GlobalVariable.Element_Timeout)

'Click on  Menu Collapsed'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Few Seconds'
WebUI.delay(GlobalVariable.Short_Wait)

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC Component'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('BusinessUnit', 
        1), false)

'Wait for IPCalssification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/IPClass_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/IPClass_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('IPClassificatioin', 
        1), false)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Check My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Pagination Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Search_Page_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for BusinessUnit element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the BusinessUnit'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/BusinessUnit_Search_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('BusinessUnit', 
        1), false)

'Wait for IPCalssification element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/IPClass_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/IPClass_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('IPClassificatioin', 
        1), false)

'Wait for ProgramName element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    GlobalVariable.Element_Timeout)

'Set the Program name'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/ComponentNameSearch_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProgramName', 
        1) + GlobalVariable.RandomNumber)

'Wait for MyProgram element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    GlobalVariable.Element_Timeout)

'Uncheck My Program'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/MyComponent_CheckBox_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Wait for FInd element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/Find_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Table Verify Frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Project Not Found'
WebUI.verifyElementText(findTestObject('CDDS/BCM_Module_Objects/BCM_SMC_Objects/BCM_SMC_Non_Member_Non_TI_Hidden_Project_Objects/NoDataFoundProject_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_SMC_TestData/BCM_SMC_Non_Member_Non_TI_Hidden_Project').getValue('ProjectNotFound', 
        1), FailureHandling.CONTINUE_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_SMC/BCM_SMC_Delete_IC_Component'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the Browser'
WebUI.closeBrowser()

