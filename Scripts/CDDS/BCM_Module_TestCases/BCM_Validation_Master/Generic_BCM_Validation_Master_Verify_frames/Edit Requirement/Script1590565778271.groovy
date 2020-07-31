import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.java.swing.plaf.motif.MotifInternalFrameTitlePane.Title as Title
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('1.Keyword-Requirement_Approved_State,Title-ON,Type-Requirement')

'Keyword as Requirement_Approved_State'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), Keyword1)

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/ID_Unselect'))

'Select Type as Requirement'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('Type', 
        1), false)

'Select State as New'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        8), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'ActualGetTextAlert'
not_run: ActualGetTextAlert = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
not_run: if (ActualGetTextAlert.contains('Refreshing the table data will reset all previous selections. Click OK to continue')) {
    WebUI.acceptAlert(WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1)))
} else {
}

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

String title_1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_Title'))

'Verify Title as Requirement_Approved_State'
WebUI.verifyEqual(title_1, Title1)

String team_1 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_Team'))

'Verify Team as Administration'
WebUI.verifyEqual(team_1, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
        'TeamName', 2))

'select on first Team to edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Team_Select'))

'Click on Team to Edit\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Team_Edit'))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Edit_Team_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Select state as Assign:Assigned'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/State_Bug'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        1), false)

'Select assigned to as Ashwini'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Assigned To'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('OnBehalfOf', 
        2))

'Delay'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for On behalf of person name to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
    GlobalVariable.Element_Timeout)

'Click on On behalf of person name'
WebUI.mouseOver(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
    FailureHandling.OPTIONAL)

'Click on On behalf of person name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
    FailureHandling.STOP_ON_FAILURE)

'Click on On behalf of person name'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Create_Requirement_Master_Objects/Common_Object_For_BCM_Module/Select_Person_Obj'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/SAVE_Team_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Save'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/SAVE'))

WebUI.delay(GlobalVariable.Short_Wait)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'ActualGetTextAlert'
not_run: ActualGetTextAlert_1 = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
not_run: if (ActualGetTextAlert_1.wait(0, 0)) {
    WebUI.acceptAlert(WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1)))
} else {
}

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select State as Assigned'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        6), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get text of the title field'
String title_2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_Title'))

'Verify Title as Requirement_Approved_State'
WebUI.verifyEqual(title_2, Title1)

'get text of state status from table'
state_status_2 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_State_status'))

'Verify State as Assigned:'
WebUI.verifyEqual(state_status_2, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
        'State', 2))

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select State as Assigned'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        6), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Short wait'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'ActualGetTextAlert'
not_run: ActualGetTextAlert_2 = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
not_run: if (ActualGetTextAlert_2.wait(0, 0)) {
    WebUI.acceptAlert(WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1)))
} else {
}

WebUI.comment('2.Edit the Team')

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'select on first Team to edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Team_Select'))

'Click on Team to Edit\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Team_Edit'))

'Navigation to edit team'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Edit_Team_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Select state as Assess:Assessed'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/State_Bug'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        3), false)

'Select classification as New feature'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCM_Classification'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMClassification', 
        1), false)

'Enter Sub classification as Sub Classification'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCM_SubClassification'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMSubClassification', 
        1))

'Select BCM Difficulty as 1-High'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCM_Difficulty'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMDifficulty', 
        1), false)

'Select BCMImpactOnsoftware as Major Break'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactOnSoftware'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactOnsoftware', 
        1), false)

'Enter BCMImpactAreaMinimum as 1'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactAreaMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactAreaMinimum', 
        1))

'Enter BCMImpactAreaMaximum as 2'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactAreaMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactAreaMaximum', 
        1))

'Enter BCMImpactAreaTypical as 3'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactAreaTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactAreaTypical', 
        1))

'Enter BCMImpactCostMinimum as 4'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactCostMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactCostMinimum', 
        1))

'Enter BCMImpactCostMaximum as 5'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactCostMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactCostMaximum', 
        1))

'Enter BCMImpactCostTypical as 6'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactCostTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactCostTypical', 
        1))

'Select BCMImpactEffort as Weeks'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactEffort'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactEffort', 
        1), false)

'Enter BCMImpactEffortMinimum as 7'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactEffortMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactEffortMinimum', 
        1))

'Enter BCMImpactEffortMaximum as 8'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactEffortMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactEffortMaximum', 
        1))

'Enter BCMImpactEffortTypical as 9'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactEffortTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactEffortTypical', 
        1))

'Select BCMImpactPerformance as Mbits'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPerformance'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPerformance', 
        1), false)

'Enter BCMImpactPerformanceMinimum as 20'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPerformanceMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPerformanceMinimum', 
        1))

'Enter BCMImpactPerformanceMaximum as 30'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPerformanceMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPerformanceMaximum', 
        1))

'Enter BCMImpactPerformanceTypical as 40'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPerformanceTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPerformanceTypical', 
        1))

'Select BCMImpactPower as W'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPower'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPower', 
        1), false)

'Enter BCMImpactPowerMinimum as 3'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPowerMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPowerMinimum', 
        1))

'Enter BCMImpactPowerMaximum as 11'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPowerMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPowerMaximum', 
        1))

'Enter BCMImpactPowerTypical as 12'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactPowerTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactPowerTypical', 
        1))

'Select BCMImpactOnSafety as None-No Impact to safety'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactOnSafety'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactOnSafety', 
        1), false)

'Select BCMImpactOnTest as None-No Impact to test'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactOnTest'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactOnTest', 
        1), false)

'Enter BCMAssessmentEffortMinimum as 13'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMAssessmentEffortMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMAssessmentEffortMinimum', 
        1))

'Enter BCMAssessmentEffortMaximum as 14'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMAssessmentEffortMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMAssessmentEffortMaximum', 
        1))

'Enter BCMAssessmentEffortTypical as 15'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMAssessmentEffortTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMAssessmentEffortTypical', 
        1))

'Enter BCMImplementationEffortMinimum as 16'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImplementationEffortMinimum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImplementationEffortMinimum', 
        1))

'Enter BCMImplementationEffortMaximum as 17'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImplementationEffortMaximum'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImplementationEffortMaximum', 
        1))

'Enter BCMImplementationEffortTypical as 18'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImplementationEffortTypical'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImplementationEffortTypical', 
        1))

'Enter BCMTechnicalProposal as technical_req'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMTechnicalProposal'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMTechnicalProposal', 
        1))

'Select BCMRecommendationas Approve'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMRecommendation'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMRecommendation', 
        1), false)

'Enter BCMOtherImpacts as impacts_req'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMOtherImpacts'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMOtherImpacts', 
        1))

WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/SAVE_Team_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Save'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/SAVE'))

'Short wait'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'ActualGetTextAlert'
not_run: ActualGetTextAlert_4 = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window\r\nYes is not getting clicked'
not_run: if (ActualGetTextAlert_4.wait(0, 0)) {
    WebUI.acceptAlert(WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1)))
} else {
}

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('3.Keyword-Requirement_Approved_State,Title-ON,Type-Requirement')

'Keyword as Requirement_Approved_State'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), Keyword1)

'Unselect ID'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/ID_Unselect'))

'Select Type as Requirement'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('Type', 
        1), false)

'Select State as Assessed'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        7), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Short wait'
WebUI.delay(GlobalVariable.Short_Wait)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'ActualGetTextAlert'
not_run: ActualGetTextAlert_5 = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
not_run: if (ActualGetTextAlert_5.wait(0, 0)) {
    WebUI.acceptAlert(WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1)))
} else {
}

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get text of the title field'
String title_3 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_Title'))

'Verify Title as Requirement_Approved_State'
WebUI.verifyEqual(title_3, Title1)

'get text of state status from table'
state_status_3 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_State_status'))

'Verify State as Assessed:'
WebUI.verifyEqual(state_status_3, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
        'State', 4))

WebUI.comment('To get the assessed state Team this filter is applied')

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Select State as Assessed'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        7), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'select on first Team to edit'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Team_Select'))

'Click on Team to Edit\r\n'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/Team_Edit'))

'Navigation to edit team'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/Edit_Team_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Select state as Approve:Approved'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/State_Bug'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        5), false)

'Select BCMPriority as 5-None'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMPriority'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMPriority', 
        1), false)

'Select BCMImpactOnsoftware as Minor Break'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/BCMImpactOnSoftware'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('BCMImpactOnsoftware', 
        2), false)

'Navigation to SAVE button'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Generic_BCM_Validation_Master_Verify_frames/SAVE_Team_Navigation_Frame'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click on Save'
WebUI.click(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Bug_Auto_Generation_DSPS_HW/SAVE'))

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'ActualGetTextAlert'
not_run: ActualGetTextAlert_6 = WebUI.getAlertText(FailureHandling.OPTIONAL)

'if already exist contains then close window'
not_run: if (ActualGetTextAlert_6.wait(0, 0)) {
    'Short wait'
    WebUI.delay(GlobalVariable.Short_Wait)

    WebUI.acceptAlert(WebUI.closeWindowTitle(findTestData('CDDS/Generic_TestData/WindowTitle').getValue('WindowName', 1)))
} else {
}

'Navigate to apply filters frame in Inbox'
WebUI.callTestCase(findTestCase('CDDS/BCM_Module_TestCases/BCM_Validation_Master/Filetrs_Navifgation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('5.Keyword-Requirement_Approved_State,Title-ON,Type-Requirement')

'Keyword as Requirement_Approved_State'
WebUI.setText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Keyword'), Keyword1)

'Select Type as Requirement'
WebUI.selectOptionByLabel(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Type'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('Type', 
        1), false)

'Select State as Approved'
WebUI.selectOptionByValue(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/State'), 
    findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue('State', 
        10), false)

'Click on find'
WebUI.click(findTestObject('CDDS/Generic_Objects/Create_IC/Find_Obj'))

'Short wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Navigate to Verification of applied filters in Project Inbox'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verif_InboxTable_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Get text of the title field'
String title_5 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_Title'))

'Verify Title as Requirement_Approved_State'
WebUI.verifyEqual(title_5, Title1)

'get text of state status from table'
state_status_5 = WebUI.getText(findTestObject('CDDS/BCM_Module_Objects/BCM_Validation_Master_Objects/Verify_My_Inbox/Verify_State_status'))

'Verify State as Approved:'
WebUI.verifyEqual(state_status_5, findTestData('CDDS/BCM_Module_TestData/BCM_Validation_Master_TestData/Bug_Auto_Generation_DSPS_HW').getValue(
        'State', 9))

