import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'creating a member dynamic xpath'
String MemberXpath = ('//td[text()="' + member) + '"]'

'creating the member xpath object'
TestObject memberObj = new TestObject('objectName')

'adding property in member dynamic xpath'
memberObj.addProperty('xpath', ConditionType.EQUALS, MemberXpath)

'Wait for member  element to be visible'
WebUI.waitForElementVisible(memberObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'Scroll to  member element '
WebUI.scrollToElement(memberObj, GlobalVariable.Element_Timeout, FailureHandling.OPTIONAL)

'verify  on member'
WebUI.verifyElementVisible(memberObj, FailureHandling.CONTINUE_ON_FAILURE)

