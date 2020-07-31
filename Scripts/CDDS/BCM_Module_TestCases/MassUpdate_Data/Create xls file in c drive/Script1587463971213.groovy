import java.io.PrintWriter as PrintWriter

//WebUI.callTestCase(findTestCase('CDDS/Generic_TestCases/Login_With_Parameterized_ID'), [('Login_Id') : findTestData('CDDS/BCM_Module_TestData/Generate_BCM_Element/GenBCMElem_CreateProject').getValue(
//'UserID', 1)], FailureHandling.STOP_ON_FAILURE)
'Create folder'
File dir = new File('C:/Katalon CDDS Automation')

'Create folder'
dir.mkdir()

'create a file in folder'
File file = new File('C:/Katalon CDDS Automation/Automation.xls')

'create a file in folder'
file.createNewFile()

'Write the text in file'
PrintWriter out = new PrintWriter(file)

'enter test automation in file'
out.println('Test automation')

'close the file'
out.close()

