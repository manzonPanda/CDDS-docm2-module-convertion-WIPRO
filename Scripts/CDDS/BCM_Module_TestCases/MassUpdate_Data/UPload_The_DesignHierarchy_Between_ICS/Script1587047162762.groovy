import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

'login'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'UserId', 1)], FailureHandling.STOP_ON_FAILURE)

'Get the CMPath'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/Upload_getpath'), [('Index') : 2], FailureHandling.STOP_ON_FAILURE)

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
String CMlabel = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'ProjectAbbreviation', 2)

'Assign a value to a variable'
String CMpath = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'CMpathtype', 2)

'creating a IC dynamic xpath'
String CMlabelXpath1 = ((('//a[contains(.,"' + CMlabel) + '")]/..//..//..//td[contains(.,"') + CMpath) + '")]'

'creating the Ic xpath object'
TestObject CMlabelObj1 = new TestObject('objectName')

'adding property in Ic dynamic xpath'
CMlabelObj1.addProperty('xpath', ConditionType.EQUALS, CMlabelXpath1)

'Wait for IC  element to be visible'
WebUI.waitForElementVisible(CMlabelObj1, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Click on IC'
CMpath = WebUI.getText(CMlabelObj1, FailureHandling.STOP_ON_FAILURE)

println(CMpath)

String[] path1 = CMpath.split(':', 2)

String T2 = path1[1]

System.out.println(T2)

String[] path2 = T2.split(' ', 2)

String T3 = path2[0]

System.out.println(T3)

WebUI.refresh()

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.waitForAlert(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

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
String CMlabel2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'ProjectAbbreviation', 1)

'Assign a value to a variable'
String CMpath2 = findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
    'CMpathtype', 1)

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

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/MassUpdate_Data/Update xml file'), [('Filepath') : findTestData(
            'CDDS/BCM_Module_TestData/MassUpdate_Data/UPload_The_DesignHierarchy_Between_ICS').getValue('File_Path', 1), ('CMSystem1') : findTestData(
            'CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue('CMsystem', 1)
        , ('CMSystem2') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'CMsystem', 2), ('CMpath1') : p3, ('CMpath2') : T3, ('CMLabel1') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'ProjectAbbreviation', 1), ('CMLabel2') : findTestData('CDDS/BCM_Module_TestData/MassUpdate_Data/Create_IC_MASSUPDATE_BCM_State_Validation').getValue(
            'ProjectAbbreviation', 2)], FailureHandling.STOP_ON_FAILURE)

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

