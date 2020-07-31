import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'If Verify Menu Expanded is not visible'
if (!(WebUI.verifyElementVisible(findTestObject('CDDS/Generic_Objects/Common_Objects/Menu_Expanded_Obj'), FailureHandling.OPTIONAL))) {
    'creating a MainMenu dynamic xpath'
    String MainMenuXpath = ('//a[contains(@id,"' + MainMenu) + '")]'

    'creating the MainMenu xpath object'
    TestObject MainMenuObj = new TestObject('objectName')

    'adding property in MainMenu dynamic xpath'
    MainMenuObj.addProperty('xpath', ConditionType.EQUALS, MainMenuXpath)

    'Wait for Mainmenu  element to be visible'
    WebUI.waitForElementVisible(MainMenuObj, GlobalVariable.Element_Timeout)

    'Click on MainMenu'
    WebUI.click(MainMenuObj)
} else {

}

//String SubMenuXpath = ('//label[contains(text(),"' + SubMenu) + '")]'
'creating a SubMenu dynamic xpath'
//String SubMenuXpath = ('//label[text()="' + SubMenu) + '"]'
String SubMenuXpath = ('(//label[text()="' + SubMenu) + '"])[1]'
'creating the SubMenu xpath object'
TestObject SubMenuObj = new TestObject('objectName')

'adding property in SubMenu dynamic xpath'
SubMenuObj.addProperty('xpath', ConditionType.EQUALS, SubMenuXpath)

'Wait for SubMenu  element to be visible'
WebUI.waitForElementVisible(SubMenuObj, GlobalVariable.Element_Timeout)

'Scroll to  SubMenu  element '
WebUI.scrollToElement(SubMenuObj, GlobalVariable.Element_Timeout)

'Click on SubMenu'
WebUI.click(SubMenuObj)

