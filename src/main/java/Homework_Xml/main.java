package Homework_Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/main/resources/employee.xml"));
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("employee");
        Node first = nodeList.item(0);

        NodeList childNodesList = first.getChildNodes();
        int n = childNodesList.getLength();
        Node current;
        for (int i=0; i<n; i++) {
            current = childNodesList.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(
                        current.getNodeName() + ": " + current.getTextContent());
            }
        }
    }
}
