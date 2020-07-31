import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Wait_Time)

'Wait for ProjectName  element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), GlobalVariable.Element_Timeout)

'Set a ProjectName'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Create_Project_Objects/ProjectName_Obj'), Project_name)

'Wait for project'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Project_Obj'), 
    GlobalVariable.Wait_Time, FailureHandling.STOP_ON_FAILURE)

'Select the project'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Project_Obj'), 
    Select_Project, false, FailureHandling.OPTIONAL)

'Wait for find'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Find_Btn_Obj'), 
    GlobalVariable.Wait_Time)

'Click on find'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/GemBCMElem_Createproject/GenBCMElem_CreateCR/Find_Btn_Obj'))

'Wait for loading img'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Wait for loading img not present'
WebUI.waitForElementNotPresent(findTestObject('CDDS/UM_Module_Objects/CreateCompany_FromGlobalMenu/loading_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'creating a projectxpath dynamic xpath'
String Projectxpath = ('//a[contains(text(),"' + Project_name) + '")]'

'creating the Select Project xpath object'
TestObject ProjectObj = new TestObject('objectName')

'adding property in Project dynamic xpath'
ProjectObj.addProperty('xpath', ConditionType.EQUALS, Projectxpath)

'Wait for Project  element to be visible'
WebUI.waitForElementVisible(ProjectObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Click on Select Project'
WebUI.click(ProjectObj, FailureHandling.OPTIONAL)

