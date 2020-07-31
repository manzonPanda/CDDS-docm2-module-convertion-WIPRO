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
import java.io.File as File
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import java.io.IOException as IOException
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions as FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile as FirefoxProfile
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import javax.xml.parsers.DocumentBuilder as DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory as DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException as ParserConfigurationException
import javax.xml.transform.Transformer as Transformer
import javax.xml.transform.TransformerException as TransformerException
import javax.xml.transform.TransformerFactory as TransformerFactory
import javax.xml.transform.dom.DOMSource as DOMSource
import javax.xml.transform.stream.StreamResult as StreamResult
import org.w3c.dom.Document as Document
import org.w3c.dom.Element as Element
import org.w3c.dom.NamedNodeMap as NamedNodeMap
import org.w3c.dom.Node as Node
import org.w3c.dom.NodeList as NodeList
import org.xml.sax.SAXException as SAXException

String pathapp = RunConfiguration.getProjectDir()

println(pathapp)

//pathapp123 = ((pathapp + '/Data Files/CDDS') + '/DHFile_0711_1.xml')
pathapp123 = ((pathapp + '/Data Files/CDDS') + Filepath)

println(pathapp123)

String spath = pathapp123.replaceAll('/', '\\\\')

println(spath)

//String filepath = 'E:/Raji/CDDS/New_CDDS 11-03-2020/BCM FOLDER/Massupdate/Data Files/CDDS/DHFile_0711_1.xml'
try {
    File file1 = new File(spath) //file location should be specified correctly

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance()

    DocumentBuilder db = dbf.newDocumentBuilder()

    Document document = db.parse(file1)

    document.getDocumentElement().normalize()

    NodeList node = document.getElementsByTagName('CMSystem')

    NodeList node2 = document.getElementsByTagName('CMPath')

    NodeList node3 = document.getElementsByTagName('CMLabel')

    String cms1 = node.item(0).getTextContent()

    println(cms1)

    Node nodecms1 = node.item(0).setTextContent(CMSystem1)

    String cms2 = node.item(0).getTextContent()

    println(cms2)

    String cms3 = node.item(1).getTextContent()

    println(cms3)

    Node nodecms2 = node.item(1).setTextContent(CMSystem2)

    String cms4 = node.item(1).getTextContent()

    println(cms4)

    //------------------------------------------------------------------------------
    String cmp1 = node2.item(0).getTextContent()

    println(cmp1)

    Node nodecmp1 = node2.item(0).setTextContent(CMpath1)

    String cmp2 = node2.item(0).getTextContent()

    println(cmp2)

    String cmp3 = node2.item(1).getTextContent()

    println(cmp3)

    Node nodecmp2 = node2.item(1).setTextContent(CMpath2)

    String cmp4 = node2.item(1).getTextContent()

    println(cmp4)

    //-----------------------------
    String cml1 = node3.item(0).getTextContent()

    println(cml1)

    Node nodecml1 = node3.item(0).setTextContent(CMLabel1)

    String cml2 = node3.item(0).getTextContent()

    println(cml2)

    String cml3 = node3.item(1).getTextContent()

    println(cml3)

    Node nodecml2 = node3.item(1).setTextContent(CMLabel2)

    String cml4 = node3.item(1).getTextContent()

    println(cml4)

    TransformerFactory transformerFactory = TransformerFactory.newInstance()

    Transformer transformer = transformerFactory.newTransformer()

    DOMSource source = new DOMSource(document)

    StreamResult result = new StreamResult(new File(spath))

    transformer.transform(source, result)

    println('xml edited')
}
catch (Exception e) {
} 

