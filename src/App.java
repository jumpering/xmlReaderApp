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
        this.mapper.mapAttributes(this.xmlService.getAttributeNodeByTagName("Document"), this.document);
        this.mapper.mapDetailsValuesToDocument(this.xmlService.getNodeListByTagName("Detail"), this.document);
        this.mapper.mapValues(this.xmlService.getNodeListByTagName("Headers"), this.header);
        this.document.setHeader(this.header);
        this.print();
    }

    //todo
    //replace System.out.println() with directPrint() documentFlavor
    //only works with one section (refactor)
    //setPageNumber and date (in xml appears?)
    public void print(){
        DirectPrint directPrint = new DirectPrint();
        Integer lineLimitForSections = 5;
        Integer firstLine = 0;
        this.document.getHeader().setPageTitle("Header changed");
        do{
            System.out.println(this.document.getHeader().toString());
            System.out.println(this.document.sectionsToStringLimitedLines(firstLine, lineLimitForSections));
            firstLine += lineLimitForSections;
        }while(false);//todo max number of lines per page
        System.out.println(this.document.getTotalSections());
        directPrint.print("test: " + this.document.getTotalSections());//text not printed! why?
    }

}
