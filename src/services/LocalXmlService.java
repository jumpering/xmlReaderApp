package services;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LocalXmlService implements XmlService{

    private String path = "./src/input.xml";
    private DocumentBuilderFactory dbf;
    private File file;
    private Document document;

    public LocalXmlService(){
        dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            file = new File(path);
            document = db.parse(file);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NodeList getNodeListByTagName(String tagName){
        return this.document.getElementsByTagName(tagName);
    }

    public NamedNodeMap getAttributeNodeByTagName(String tagName){
        return this.document.getElementsByTagName(tagName).item(0).getAttributes();
    }
}
