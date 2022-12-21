import models.Header;
import models.Page;
import org.w3c.dom.*;
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
        Page page = new Page();
        Header header = new Header();

        NamedNodeMap documentNodeMap = this.xmlService.getAttributeNodeByTagName("Document");
        this.mapper.mapAttributes(documentNodeMap, page);
        NodeList headerList = this.xmlService.getNodeListByTagName("Headers");
        this.mapper.mapValues(headerList, header);
        System.out.println(page.getPrinter());
        System.out.println(header.getH2());
    }
}
