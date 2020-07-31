import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue(
            'UserID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigating BCM Elements '
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : 'BCMMyDesk'
        , ('SubMenu') : 'Projects'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRProject').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRTeam').getValue('TeamName', 
            1), ('TeamDescription') : findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRTeam').getValue('TeamDescription', 
            1), ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRTeam').getValue('TeamBaseSiteSelect', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Team_Navigation_Page'), [:], FailureHandling.STOP_ON_FAILURE)

'Assign a value to state'
String TeamName = findTestData('CDDS/BCM_Module_TestData/BCM_CR/Create_CRTeam').getValue('TeamName', 1)

'creating a team dynamic xpath'
String TeamNameXpath = ('//a[contains(text(),"' + TeamName) + '")]'

'creating the team xpath object'
TestObject TeamNameObj = new TestObject('objectName')

'adding property in team dynamic xpath'
TeamNameObj.addProperty('xpath', ConditionType.EQUALS, TeamNameXpath)

'Wait for team  element to be visible'
WebUI.waitForElementVisible(TeamNameObj, GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Scroll to  team element '
WebUI.verifyElementVisible(TeamNameObj, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

