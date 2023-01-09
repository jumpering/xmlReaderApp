import models.Header;
import models.Document;
import services.LocalXmlService;
import services.XmlService;
import java.lang.reflect.InvocationTargetException;

import javax.print.PrintException;

public class App {

    private final XmlService xmlService = new LocalXmlService();
    private final Mapper mapper = new Mapper();
    private Document document;
    private Header header;

    public App() {
        this.document = new Document();
        this.header = new Header();
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, PrintException {
        new App().run();
    }

    public void run() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, PrintException {
        this.mapper.mapAttributes(this.xmlService.getAttributeNodeByTagName("Document"), this.document);
        this.mapper.mapDetailsValuesToDocument(this.xmlService.getNodeListByTagName("Detail"), this.document);
        this.mapper.mapValues(this.xmlService.getNodeListByTagName("Headers"), this.header);
        this.document.setHeader(this.header);
        this.print(10);
    }

    public void print(Integer maxLinesPerPage) {
        do{
            System.out.println(this.document.toString(maxLinesPerPage));
        }while(this.document.end());

    }

}
