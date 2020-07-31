import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Launch the browser'
WebUI.openBrowser("")

'Maximize the window'
WebUI.maximizeWindow()

'Navigate to Application URL'
WebUI.navigateToUrl(GlobalVariable.Application_Url)

'Wait for Login Page Header element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_header_Obj'), GlobalVariable.Element_Timeout)

'Wait for Username element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Element_Timeout)

'Enter the Username'
WebUI.setText(findTestObject('CDDS/Generic_Objects/Login_Objects/Username_Obj'), GlobalVariable.Support_Role_Username)

'Wait for  login button element to be visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'), GlobalVariable.Element_Timeout)

'Click on login button'
WebUI.click(findTestObject('CDDS/Generic_Objects/Login_Objects/Login_Btn_Obj'))

'Switch to default'
WebUI.switchToDefaultContent()

'Switch to frame'
WebUI.switchToFrame(findTestObject('CDDS/Generic_Objects/Frames_Objects/Content_Iframe_Obj'), GlobalVariable.Element_Timeout)

'Wait for  welcome element  is visible'
WebUI.waitForElementVisible(findTestObject('CDDS/Generic_Objects/Login_Objects/Welcome_Obj'), GlobalVariable.Element_Timeout)

'Switch to default'
WebUI.switchToDefaultContent()

