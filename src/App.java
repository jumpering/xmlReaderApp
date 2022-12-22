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
        Header header = new Header();
        Section section = new Section();

        NamedNodeMap documentNodeMap = this.xmlService.getAttributeNodeByTagName("Document");
        this.mapper.mapAttributes(documentNodeMap, document);
        NodeList headerList = this.xmlService.getNodeListByTagName("Headers");
        this.mapper.mapValues(headerList, header);
        document.setHeader(header);
        NodeList detailList = this.xmlService.getNodeListByTagName("Detail");
        List<Node> nodeList = Mapper.getChildNodes(detailList);
        boolean sectionPresent = false;
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).getNodeName().equals("Section")) {
                sectionPresent = true;
            }
        }

        if (sectionPresent) {
            NodeList sectionList = this.xmlService.getNodeListByTagName("Section");
            this.mapper.mapSectionLineValues(sectionList, section);
            document.setSection(section);
        }
        System.out.println(document.printConsole());
        System.out.println(document.getPrinter());
    }
}
