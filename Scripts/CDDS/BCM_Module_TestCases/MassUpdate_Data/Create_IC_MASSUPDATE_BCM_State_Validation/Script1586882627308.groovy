import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.org.glassfish.gmbal.Description as Description
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Get the Create User request from Data file'
InternalData data = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation')

//int index = 1
'run the for loop to get the all data'
for (def index : (1..data.getRowNumbers())) {
    'login'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData(
                'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('UserId', 
                index)], FailureHandling.STOP_ON_FAILURE)

    'Click on menu'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on menu'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
            , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for Action element to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

    'Click on Action Btn'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Wait for create to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Create_Obj'), GlobalVariable.Element_Timeout)

    'Click on create Btn'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'wait for  IC name'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Name_Obj'), GlobalVariable.Element_Timeout)

    'Set IC name'
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Name_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Name', index))

    'Wait for none checkbox to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/noe_varient_Obj'), 
        GlobalVariable.Element_Timeout)

    'scroll to none checkbox '
    WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/noe_varient_Obj'), 
        GlobalVariable.Wait_Time)

    'Click on none'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/noe_varient_Obj'), 
        FailureHandling.STOP_ON_FAILURE)

    'wait for Owing BU'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select Owing BU'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'OwingBU', index), false)

    'wait for  IC model\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Model_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select IC model\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Model_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Model', index), false)

    'wait for  workflowtemplete\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/WorkflowTemplate_Obj'), GlobalVariable.Element_Timeout)

    'Select workflowtemplete\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/WorkflowTemplate_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Workflow', index), false, FailureHandling.OPTIONAL)

    'wait for library\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Library_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select library\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Library_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Library', index), false)

    'wait for  Technology\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Technology_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select Technology\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Technology_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Technology', index), false)

    'Select classification\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IP_Classification_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select classification\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IP_Classification_Obj'), findTestData(
            'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('Classification', 
            index), false)

    //'Set Variant'
    //WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Variant_Obj'), ICname)
    'Set secondary owner'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Secondary_Owner_Obj'), GlobalVariable.Element_Timeout)

    'Set secondary owner'
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Secondary_Owner_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'SecondaryOwner', index))

    'Wait for name to be visble'
    WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Scroll to name \t\r\n'
    WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

    'Click on Name'
    WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Add memeber to BCM action/Name_dropdown_Obj'), 
        FailureHandling.OPTIONAL)

    'Click on create new project'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectType_New_Obj'), GlobalVariable.Element_Timeout)

    'Click on create new project'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectType_New_Obj'))

    'wait for  CMsystem\t\r\n\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CM_system_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select CMsystem\t\r\n\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CM_system_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'CMsystem', index), false)

    'Set random value'
    String random_number = RandomStringUtils.randomNumeric(3)

    'set the path'
    String path = 'WTBUP' + random_number

    'wait for path to be visible'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CMPath_Obj'), GlobalVariable.Element_Timeout)

    'Set CM path'
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CMPath_Obj'), path)

    'wait for  CM path type\t\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CMPathType_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select CM path type\t\r\n'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/CMPathType_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'CMpathtype', index), false)

    'wait for category'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Category_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select category'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/IC_Category_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Category', index), false)

    'wait for  No'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Release_Package_no_Obj'), GlobalVariable.Element_Timeout)

    'Click on No'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Release_Package_no_Obj'))

    'wait for  description'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Description_Obj'), GlobalVariable.Element_Timeout)

    'Set description'
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Description_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Description', index))

    'scroll to none checkbox '
    WebUI.scrollToElement(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/noe_varient_Obj'), 
        GlobalVariable.Wait_Time)

    'Delay for fe sec'
    WebUI.delay(GlobalVariable.Short_Wait)

   /* 'verify revision textrea is disabled'
    WebUI.verifyElementNotVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/Disabled_revision_Obj'), 
        FailureHandling.OPTIONAL)*/

    'verify revision textrea is disabled'
    WebUI.verifyElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/Disabled_revision_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'if the text area is not disable click on none'
    if (WebUI.verifyElementNotPresent(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/Disabled_revision_Obj'), 
        GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)) {
        'Click on none'
        WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation/noe_varient_Obj'), 
            FailureHandling.STOP_ON_FAILURE)
    }
    
    'Switch to default'
    WebUI.switchToDefaultContent()

    'Click on done\t\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Element_Timeout)

    'Click on done\t\r\n'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

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

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Wait for project abberivation\r\n\r\n\t'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), GlobalVariable.Wait_Time)

    'Double click\r\n\t'
    WebUI.doubleClick(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

    'clear text'
    WebUI.clearText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), FailureHandling.STOP_ON_FAILURE)

    /*'set the abberivation'
    String abberivation = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'ProjectAbbreviation', index) + random_number*/
    'Set abberivation\r\n\t'
    WebUI.setText(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/ProjectAbbreviation_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'ProjectAbbreviation', index))

    'wait for abberivation\r\n\t'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/AssociatedSchema_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Set abberivation\r\n\t'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/AssociatedSchema_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'AssociatedSchema', 1), false)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'wait for done\t\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Element_Timeout)

    'Click on done\t\r\n'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

    'Click on done\t\r\n'
    WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), FailureHandling.OPTIONAL)

    'Wait till loading img is visible\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Wait till loading img is not visible\r\n'
    WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.OPTIONAL)

    'Wait till done is visible\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Wait_Time, 
        FailureHandling.OPTIONAL)

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Switch to default'
    WebUI.switchToDefaultContent()

    'refresh'
    WebUI.refresh()

    'Wait for alert'
    WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Click on ok'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Delay for few sec'
    WebUI.delay(GlobalVariable.Short_Wait)

    'Wait for alert'
    WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

    'Click on ok'
    WebUI.acceptAlert(FailureHandling.OPTIONAL)

    'Click on menu'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

    'Click on menu'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
            , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'Switch to frame'
    WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

    'WAIT FOR  Owing BU'
    WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), GlobalVariable.Element_Timeout, 
        FailureHandling.STOP_ON_FAILURE)

    'Select Owing BU'
    WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'OwingBU', index), false)

    'Wait till IC component is visible\r\n'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), GlobalVariable.Element_Timeout)

    'Enter IC name'
    WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'Name', index))

    'Assign a value to string'
    String IC = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'Name', index)

    'Click on find'
    WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'), GlobalVariable.Element_Timeout)

    'Click on find'
    WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

    'Switch to default'
    WebUI.switchToDefaultContent()

    'Wait for Loading  Element not present'
    WebUI.waitForElementNotPresent(findTestObject('CDDS/Generic_Objects/Common_Objects/Loading_Obj'), GlobalVariable.Element_Timeout)

    'switch to frame'
    WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

    'creating a IC dynamic xpath'
    String ICXpath = ('//a[contains(.,"' + IC) + '")]/../..//input'

    'creating the SubMenu xpath object'
    TestObject ICObj = new TestObject('objectName')

    'adding property in SubMenu dynamic xpath'
    ICObj.addProperty('xpath', ConditionType.EQUALS, ICXpath)

    'Wait for IC  element to be visible'
    WebUI.waitForElementVisible(ICObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

    'Scroll to  IC  element '
    WebUI.scrollToElement(ICObj, GlobalVariable.Element_Timeout)

    'Click on IC'
    WebUI.verifyElementVisible(ICObj, FailureHandling.CONTINUE_ON_FAILURE)
}

'Switch to default'
WebUI.switchToDefaultContent()

'logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

