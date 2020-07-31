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

'Login or Navigate to CDDS Application'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_SupportRole'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('MENU1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
            'MENU2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Create element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Create_Obj'), GlobalVariable.Element_Timeout)

'Click on Create... option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Create_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to Add Member window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('WINDOW_TITLE', 1))

'Maximize the Add Member Window'
WebUI.maximizeWindow()

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'wait for IC Name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/ICName_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/ICName_Field_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 1))

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for Owning business unit visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Owning_Business_Unit_Obj'), GlobalVariable.Element_Timeout)

'Select owing business unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Owning_Business_Unit_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 2), false)

'wait for Revision Variant field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Revision_Variant_Obj'), GlobalVariable.Element_Timeout)

'Enter Revision Variant'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Revision_Variant_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 3), FailureHandling.STOP_ON_FAILURE)

'wait for IC Engagement Model visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IC_Engagement_Model_Obj'), 
    GlobalVariable.Element_Timeout)

'Select IC Engagement Model'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IC_Engagement_Model_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 4), false)

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'wait for Workflow template visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Workflow_Temp_Obj'), GlobalVariable.Element_Timeout)

'Select Work flow template '
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Workflow_Temp_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 5), false)

'wait for Library visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Liberary_Obj'), GlobalVariable.Element_Timeout)

'Select Library'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Liberary_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 6), false)

'wait for Technology visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Technology_Obj'), GlobalVariable.Element_Timeout)

'Select Technology'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Technology_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 7), false)

'wait for IPClassification visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IPClassification_Obj'), GlobalVariable.Element_Timeout)

'Select IPClassification '
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IPClassification_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 8), false)

'Wait for BCM project radio option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_BCM_Project_Obj'), GlobalVariable.Element_Timeout)

'Check BCM project radio option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_BCM_Project_Obj'))

'wait for IC Secondary Owner visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Secondary_Owner_Obj'), GlobalVariable.Element_Timeout)

'Enter IC Secondary Owner'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Secondary_Owner_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 9), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for IC Secondary Owner name visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IC_Secondary_Owner_Obj'), GlobalVariable.Element_Timeout)

'Select IC Secondary Owner'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IC_Secondary_Owner_Obj'))

'wait for CM System visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_CM_System_Obj'), GlobalVariable.Element_Timeout)

'Select CM System'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_CM_System_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 10), false)

'wait for CM path field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/CM_Path_Field_Obj'), GlobalVariable.Element_Timeout)

Date GetDate = new Date()

String Basedate = GetDate.format('MMddyyyy')

String Basedate1 = GetDate.format('HHmmss')

String CMPath = ('Request_ICPath' + Basedate) + Basedate1

'Enter CM path field'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/CM_Path_Field_Obj'), CMPath, FailureHandling.STOP_ON_FAILURE)

'wait for CM Path Type visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_CM_Path_Type_Obj'), GlobalVariable.Element_Timeout)

'Select CM Path Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_CM_Path_Type_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 12), false)

'wait for IC Category visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IC_Category_Obj'), GlobalVariable.Element_Timeout)

'Select IC Category'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IC_Category_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 13), false)

'Wait for Release Package required radio btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Release_Package_Req_Obj'), GlobalVariable.Element_Timeout)

'Select Release Package required radio btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Release_Package_Req_Obj'))

'Wait for Action Search Image visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Action_Search_Img_Obj'), GlobalVariable.Element_Timeout)

'Click on Action Search Image'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Action_Search_Img_Obj'))

'wait'
WebUI.delay(GlobalVariable.Short_Wait)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to Company Search window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('WINDOW_TITLE', 2))

'Maximize the Company Search Window'
WebUI.maximizeWindow()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Company name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Company_Name_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter Company name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Company_Name_Field_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 14), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for company visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Company_Obj'), GlobalVariable.Element_Timeout)

'Select company'
WebUI.check(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Company_Obj'))

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Submit Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Submit_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Submit Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Submit_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to Add Member window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('WINDOW_TITLE', 1))

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Wait_Time, 
    FailureHandling.OPTIONAL)

'wait for Description field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Description_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter Description '
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Description_Field_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 11), FailureHandling.STOP_ON_FAILURE)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Pagecontent_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Project Abbreviation field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Project_Abbreviation_Obj'), GlobalVariable.Element_Timeout)

'Enter Project Abbreviation'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Project_Abbreviation_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 15), FailureHandling.STOP_ON_FAILURE)

'wait for Associated Schema visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Associated_Schema_Obj'), GlobalVariable.Element_Timeout)

'Select Associated Schema '
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Associated_Schema_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 16), false)

'Switch to default content'
WebUI.switchToDefaultContent()

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'wait'
WebUI.delay(30)

'Switch to iframe window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('WINDOW_TITLE', 3))

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Business Unit option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Business_Unit_Obj'), GlobalVariable.Element_Timeout)

'Select Business Unit'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Business_Unit_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 2), false)

'wait for IP Classification option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IP_Classification_Obj'), GlobalVariable.Element_Timeout)

'Select IP Classification'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_IP_Classification_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 8), false)

'wait for IC Name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Name_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter IC Name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Name_Field_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for IC Name  visible in the table'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Link_Obj'), GlobalVariable.Element_Timeout)

'Click on the link of IC Name'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Link_Obj'))

'Switch to default content'
WebUI.switchToDefaultContent()

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Wait for Members/Auth Option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Members_Auth_Obj'), GlobalVariable.Element_Timeout, 
    FailureHandling.OPTIONAL)

'Click on Members/Auth Option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Members_Auth_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/PortalDisplay_iframe'), GlobalVariable.Element_Timeout)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/ITMembers_Iframe'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add Members element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Add_Members_Obj'), GlobalVariable.Element_Timeout)

'Click on Add Members option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Add_Members_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to new window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('WINDOW_TITLE', 4))

'Maximize New Window'
WebUI.maximizeWindow()

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Business Type option visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Type_Obj'), GlobalVariable.Element_Timeout)

'Select Business Type'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Type_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 17), false)

'wait for User name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/UserID_Obj'), GlobalVariable.Element_Timeout)

'Enter User id'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/UserID_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 18), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'))

'Wait for page to be loaded'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Switch to default content'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait for Multiple select in Fuction column visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Function_Obj'), GlobalVariable.Element_Timeout)

'Select Function value'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_Function_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 19), false)

'Switch to be default content'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'))

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'), FailureHandling.OPTIONAL)

'wait'
WebUI.delay(10)

'Switch to be default content'
WebUI.switchToDefaultContent()

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Expanded menu visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Expanded_Menu_Obj'), GlobalVariable.Element_Timeout)

'Collaps Expanded menu'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Expanded_Menu_Obj'))

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('MENU1', 2), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
            'MENU2', 2)], FailureHandling.STOP_ON_FAILURE)

'Wait for page to be loaded'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Create Group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Create_Groups'), [('GroupName') : findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
            'TEXT', 20), ('Company') : findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 21), ('Description') : findTestData(
            'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 22)], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(3)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Verify_Table_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Group Name Link  visible in the table'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/GroupName_Link_Obj'), GlobalVariable.Element_Timeout)

'Click on the link of Group Name'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/GroupName_Link_Obj'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time, FailureHandling.OPTIONAL)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to ITMembers frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/DetailsDisplay_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Action Btn element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Actions_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Action btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Actions_Btn_Obj'), FailureHandling.STOP_ON_FAILURE)

'Wait for Add Members element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Add_Members_Obj'), GlobalVariable.Element_Timeout)

'Click on Add Members option'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Add_Members_Obj'), FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.Wait_Time)

'Switch to new window'
WebUI.switchToWindowTitle(findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('WINDOW_TITLE', 4))

'Maximize New Window'
WebUI.maximizeWindow()

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for User name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/UserID_Obj'), GlobalVariable.Element_Timeout)

'Enter User id'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/UserID_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 18), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Wait for page to be loaded'
WebUI.waitForPageLoad(GlobalVariable.Element_Timeout)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Display_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for company visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_User_Obj'), GlobalVariable.Element_Timeout)

'Select company'
WebUI.check(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_User_Obj'))

'wait for select option in Fuction column visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_User_Function_Obj'), GlobalVariable.Element_Timeout)

'Select Function value'
WebUI.selectOptionByLabel(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Select_User_Function_Obj'), findTestData(
        'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('TEXT', 23), false)

'Switch to be default content'
WebUI.switchToDefaultContent()

'Switch to content frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for Done Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Done Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Done_Btn_Obj'))

'wait'
WebUI.delay(20)

'Switch to be default content'
WebUI.switchToDefaultContent()

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Expanded menu visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Expanded_Menu_Obj'), GlobalVariable.Element_Timeout)

'Collaps Expanded menu'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Expanded_Menu_Obj'))

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('MENU1', 2), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
            'MENU2', 2)], FailureHandling.STOP_ON_FAILURE)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for Group name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Group_Name_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter Group name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Group_Name_Field_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 20), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Delete created group'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Group'), [:], FailureHandling.STOP_ON_FAILURE)

'Switch to be default content'
WebUI.switchToDefaultContent()

'Call generic TC navigate to My desk menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate_to_MyDesk_Tab'), [:], FailureHandling.STOP_ON_FAILURE)

'Wait for Expanded menu visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Expanded_Menu_Obj'), GlobalVariable.Element_Timeout)

'Collaps Expanded menu'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Expanded_Menu_Obj'))

'Call generic TC navigate to sub menu'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Navigate _MainModule_By_Id_to_Sub_Module_By_Text'), [('MainMenu') : findTestData(
            'CDDS/UM_Module_TestData/CreateIC_AddMember').getValue('MENU1', 1), ('SubMenu') : findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
            'MENU2', 1)], FailureHandling.STOP_ON_FAILURE)

'Switch to Action Navigation frame'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Action_Navigation_Frame'), [:], FailureHandling.STOP_ON_FAILURE)

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/List_Filtr_Iframe_Obj'), GlobalVariable.Element_Timeout)

'wait for IC name field visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Name_Field_Obj'), GlobalVariable.Element_Timeout)

'Enter IC name'
WebUI.setText(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/IC_Name_Field_Obj'), findTestData('CDDS/UM_Module_TestData/CreateIC_AddMember').getValue(
        'TEXT', 1), FailureHandling.STOP_ON_FAILURE)

'Wait for Find Btn visible'
WebUI.waitForElementVisible(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on Find Btn'
WebUI.click(findTestObject('CDDS/UM_Module_Objects/CreateIC_AddMember/Find_Btn_Obj'))

'wait'
WebUI.delay(GlobalVariable.Wait_Time)

'Delete created IC'
WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Delete_Group'), [:], FailureHandling.STOP_ON_FAILURE)

'Close browser'
WebUI.closeBrowser()

