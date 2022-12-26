import models.Header;
import models.Document;

import services.LocalXmlService;
import services.XmlService;

import java.lang.reflect.InvocationTargetException;

public class App {

    private final XmlService xmlService = new LocalXmlService();
    private final Mapper mapper = new Mapper();
    private Document document;
    private Header header;

    public App(){
        this.document = new Document();
        this.header = new Header();
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        new App().run();
    }

    public void run() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        this.mapper.mapAttributes(this.xmlService.getAttributeNodeByTagName("Document"), document);
        this.mapper.mapValues(this.xmlService.getNodeListByTagName("Headers"), header);
        document.setHeader(header);
        this.mapper.mapDetailsValuesToDocument(this.xmlService.getNodeListByTagName("Detail"), document);
        this.print();
    }

    //todo
    //with documentFlavor
    //replace System.out.println() with directPrint()
    //only works with one section (requisitos)
    public void print(){
        DirectPrint directPrint = new DirectPrint();
        Integer lineLimitForSections = 5;
        Integer firstLine = 0;
        do{
            System.out.println(this.document.getHeader().toString());
            System.out.println(this.document.sectionsToStringLimitedLines(firstLine, lineLimitForSections));
            firstLine += lineLimitForSections;
        }while(false);//todo
        System.out.println(this.document.getTotalSections());
    }

}
