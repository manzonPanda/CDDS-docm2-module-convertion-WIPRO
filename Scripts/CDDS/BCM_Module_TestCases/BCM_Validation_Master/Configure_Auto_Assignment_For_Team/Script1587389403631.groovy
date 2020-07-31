import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'login to CDDS with Support Role'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'LoginID', 1)], FailureHandling.STOP_ON_FAILURE)

'Navigate to MyDesk tab'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate  Bug and Change Management (BCM) tab to Projects'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'MainMenu', 1), ('SubMenu') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'SubMenu', 1)], FailureHandling.STOP_ON_FAILURE)

'Create project\r\n'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Project'), [('TC_Name_Path') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'TC_Name_Path', 1), ('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'ProjectName', 1), ('ProjectAbbreviation') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'ProjectAbbreviation', 1), ('BusinessUnit') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'BusinessUnit', 1), ('ProjectOwner') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'ProjectOwner', 1), ('AssociateSchema') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'AssociateSchema', 1), ('TC_Name_Path1') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'TC_Name_Path1', 1)], FailureHandling.STOP_ON_FAILURE)

'Create team'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Team'), [('ProjectName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'ProjectName', 1), ('TeamName') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'TeamName', 1), ('TeamDescription') : 'CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile'
        , ('TeamBaseSite') : findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
            'TeamSite', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for configurations tab  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Project_Level_Routes_Objects/Configurations_Tab_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the configurations tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Project_Level_Routes_Objects/Configurations_Tab_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to bcm project config  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectConfigurationsDisplay_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to list display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for bug config link  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Project_Level_Routes_Objects/Bug_configurationlink_Obj'), 
    GlobalVariable.Element_Timeout)

'click on bug config link'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Project_Level_Routes_Objects/Bug_configurationlink_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Wait for team auto assign  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/Team_AutoAssign_Obj'), 
    GlobalVariable.Element_Timeout)

'click on the team auto assign tab'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/Team_AutoAssign_Obj'))

'Switch to BCM project config frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectConfigDetailsTeamAutoAssign_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Wait for Actions button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'click on Actions button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Common_Objects/Actions_Btn_Obj'))

'Wait for edit user to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Edit_User_obj'), 
    GlobalVariable.Element_Timeout)

'click on edit user'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Edit_User_obj'))

'Navigate to page frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Page_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Attribute name  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_User_Objects/Attribute_Obj'), 
    GlobalVariable.Element_Timeout)

'select Attribute name as required'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_User_Objects/Attribute_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
        'Attribute', 1), false)

'Wait for team element  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/Team_Select_Obj'), 
    GlobalVariable.Element_Timeout)

'select team as required'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/Team_Select_Obj'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
        'TeamName', 1), false)

'Switch to default'
WebUI.switchToDefaultContent()

'Wait for Done button  to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'), 
    GlobalVariable.Element_Timeout)

'click on done button'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Done_Btn_Obj'))


'Wait till loading element is not visible'
WebUI.waitForElementNotVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Common_Objects/Loading_obj'), 
    GlobalVariable.Wait_Time)

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to Content   frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch toDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to TIDetail Display  frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/TIDetails_Frame_Object'), GlobalVariable.Element_Timeout)

'Switch to portal frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Portal_Frame_Obj'), GlobalVariable.Element_Timeout)

'Switch to BCM project config frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/BCMProjectConfigDetailsTeamAutoAssign_Frame_Obj'), 
    GlobalVariable.Element_Timeout)

'Switch to list display frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Search result type element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableType_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search type'
ActualType = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableType_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search type'
println(ActualType.trim())

'Verify Equal Actual type with expected type'
WebUI.verifyEqual(ActualType.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
        'type', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result team element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableTeam_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search team'
ActualTeam = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableTeam_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search team'
println(ActualTeam.trim())

'Verify Equal Actual team with expected team'
WebUI.verifyEqual(ActualTeam.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
        'TeamName', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result attribute name element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableAttributeName_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search attribute name'
ActualAttribute = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableAttributeName_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search attribute name'
println(ActualAttribute.trim())

'Verify Equal Actual attribute name with expected attribute name'
WebUI.verifyEqual(ActualAttribute.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
        'Attribute', 1), FailureHandling.CONTINUE_ON_FAILURE)

'Wait for Search result Attribute range element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableAttributeRange_Obj'), 
    GlobalVariable.Element_Timeout)

'Get the Actual Search Attribute range'
ActualAttributeRange = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Configure_Auto_Assignment_For_Team_Objects/TableAttributeRange_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Print Actual Search Attribute range'
println(ActualAttributeRange.trim())

'Verify Equal Actual Attribute range with expected Attribute range'
WebUI.verifyEqual(ActualAttributeRange.trim(), findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Configure_Auto_Assignment_For_Team_Datafile').getValue(
        'AttributeRange', 1), FailureHandling.CONTINUE_ON_FAILURE)

'close browser'
WebUI.closeBrowser()

