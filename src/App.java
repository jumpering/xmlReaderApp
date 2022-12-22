import models.Header;
import models.Document;
import models.Section;

import org.w3c.dom.*;
import services.LocalXmlService;
import services.XmlService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class App {

    private final XmlService xmlService = new LocalXmlService();
    private final Mapper mapper = new Mapper();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        new App().run();
    }

    public void run() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Document document = new Document();
        this.setDocumentAttributesAndHeaders(document);
        this.setDetailToDocument(document);
        System.out.println("screen print \n" + document.printConsole());
        this.print(document);
    }

    private void setDocumentAttributesAndHeaders(Document document) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Header header = new Header();
        this.mapper.mapAttributes(this.xmlService.getAttributeNodeByTagName("Document"), document);
        NodeList headerList = this.xmlService.getNodeListByTagName("Headers");
        this.mapper.mapValues(headerList, header);
        document.setHeader(header);
    }

    private void setDetailToDocument(Document document) {
        List<Node> detailNodeList = Mapper.getChildNodes(this.xmlService.getNodeListByTagName("Detail"));
        boolean sectionPresent = false;
        for (int i = 0; i < detailNodeList.size(); i++) {
            if (detailNodeList.get(i).getNodeName().equals("Section")) {
                sectionPresent = true;
            }
        }

        if (sectionPresent) {
            Section section = new Section();
            this.mapper.mapSectionLineValues(this.xmlService.getNodeListByTagName("Section"), section);
            document.setSection(section);
        }
    }

    private void print(Document document) {
        //todo send to printer
    }
}
