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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'-----------------------------------------------'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_IC'), [('IC') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue(
            'Name', 1)], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'DRCMyDesk'
        , ('SubMenu') : 'IC'], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Select Owing BU'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Select Owing BU'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/OwningBU_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
        'OwingBU', 1), false)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_IC/IC_Component_Obj'), findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue(
        'Search_Name', 1))

'Assign a value to string'
String ICNew = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue('Name', 
    1)

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
String ICXpathNew = ('//a[contains(.,"' + ICNew) + '")]'

'creating the SubMenu xpath object'
TestObject ICObjNew = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
ICObjNew.addProperty('xpath', ConditionType.EQUALS, ICXpathNew)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(ICObjNew, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  IC  element '
WebUI.scrollToElement(ICObjNew, GlobalVariable.Element_Timeout)

'Click on IC'
WebUI.click(ICObjNew, FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for CM label to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CM_Label_Btn_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on CM label'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CM_Label_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add CM Label... to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/Add CM Label_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on Add CM Label... Btn'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/Add CM Label_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait till IC component is visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CMLabel_Obj'), 
    GlobalVariable.Element_Timeout)

'Enter CM Label'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE/CMLabel_Obj'), findTestData(
        'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue('Label', 1))

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Wait till loading img is  visible\r\n'
not_run: WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Wait till loading img is not visible\r\n'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Delay for fe sec'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait till loading img is  visible\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on unique\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Unique_Obj'))

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

String CMlabelNew = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue(
    'Label', 1)

'creating a IC dynamic xpath'
String CMlabelXpath1New = ('//a[contains(.,"' + CMlabelNew) + '")]'

'creating the Ic xpath object'
TestObject CMlabelObj1New = new TestObject('objectName')

'adding property in Ic dynamic xpath'
CMlabelObj1New.addProperty('xpath', ConditionType.EQUALS, CMlabelXpath1New)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(CMlabelObj1New, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  IC  element '
WebUI.scrollToElement(CMlabelObj1New, GlobalVariable.Element_Timeout)

'Click on IC'
WebUI.verifyElementVisible(CMlabelObj1New, FailureHandling.CONTINUE_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'-----------------------------------------------'

'Get the CMPath'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/Upload_getpath'), [('Index') : 1], FailureHandling.STOP_ON_FAILURE)

'Navigate to Action frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on unique\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Unique_Obj'))

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/BCM_Module_Objects/BCM_Action_Edit_Fun_Master/Validate edit functionality Action New State/Detail_display_Obj'), 
    GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Wait_Time)

'Assign a value to a variable'
String CMlabel2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue('Label', 
    1)

'Assign a value to a variable'
String CMpath2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Upload_The_DesignHierarchy_Between_ICS_2').getValue(
    'CMPathType', 1)

'creating a IC dynamic xpath'
String CMlabelXpath2 = ((('//a[contains(.,"' + CMlabel2) + '")]/..//..//..//td[contains(.,"') + CMpath2) + '")]'

'creating the Ic xpath object'
TestObject CMlabelObj2 = new TestObject('objectName')

'adding property in Ic dynamic xpath'
CMlabelObj2.addProperty('xpath', ConditionType.EQUALS, CMlabelXpath2)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(CMlabelObj2, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on IC'
CMpath2 = WebUI.getText(CMlabelObj2, FailureHandling.STOP_ON_FAILURE)

println(CMpath2)

String[] path3 = CMpath2.split(':', 2)

String p1 = path3[1]

System.out.println(p1)

String[] path4 = p1.split(' ', 2)

String p3 = path4[0]

System.out.println(p3)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/update_xml_file_1'), [('Filepath') : findTestData(
            'CDDS/BCM_Module_TestData/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS').getValue('File_Path', 1), ('CMSystem1') : findTestData(
            'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('CMsystem', 1)
        , ('CMpath1') : p3, ('CMLabel1') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_CM-Label-IN-IC_MASSUPDATE_2').getValue(
            'Label', 1)], FailureHandling.STOP_ON_FAILURE)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS/Checkbox_Obj'), 
    GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on IC'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS/Checkbox_Obj'))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Btn'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

String pathapp = RunConfiguration.getProjectDir()

println(pathapp)

String Filepath = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS').getValue(
    'File_Path', 1)

//pathapp123 = ((pathapp + '/Data Files/CDDS') + '/DHFile_0711_1.xml')
pathapp123 = ((pathapp + '/Data Files/CDDS') + Filepath)

println(pathapp123)

String spath = pathapp123.replaceAll('/', '\\\\')

println(spath)

'Wait for Action element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS/Upload XML_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

WebUI.click(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS/Upload XML_Btn_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.uploadFile(findTestObject('CDDS/BCM_Module_Objects/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS/Chosefile_Obj'), 
    spath)

'Switch to default'
WebUI.switchToDefaultContent()

'Click on done\t\r\n'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'), GlobalVariable.Element_Timeout)

'Click on done\t\r\n'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/UM_Create_IC/Done_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

WebUI.delay(GlobalVariable.Short_Wait)

'logout'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

