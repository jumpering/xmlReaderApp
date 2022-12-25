import models.Header;
import models.Document;

import services.LocalXmlService;
import services.XmlService;

import java.lang.reflect.InvocationTargetException;

public class App {

    private final XmlService xmlService = new LocalXmlService();
    private final Mapper mapper = new Mapper();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        new App().run();
    }

    public void run() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Document document = new Document();
        Header header = new Header();
        this.mapper.mapAttributes(this.xmlService.getAttributeNodeByTagName("Document"), document);
        this.mapper.mapValues(this.xmlService.getNodeListByTagName("Headers"), header);
        document.setHeader(header);
        this.mapper.mapDetailsToDocumentValues(this.xmlService.getNodeListByTagName("Detail"), document);
        System.out.println("screen print demo \n" + document.printConsole());
    }

}
