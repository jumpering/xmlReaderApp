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
        System.out.println("screen print on " + document.getPrinter() + "\n" + document.printConsole());
    }

    public void print(){//todo with documentFlavor
        Integer maxLinesPerPageToPrint = 42; //todo set in printer config? ¿is data on formated lineSize element?
        
        do{
            this.document.getHeader().getPageTitle();
            this.document.getHeader().getListTitle();
            this.document.getHeader().getsectionListTitle();
            this.document.getHeader().getH4();//define name. Group Type?¿
            this.document.getHeader().getRowTitles();

            for(int i = 0; i < maxLinesPerPageToPrint - 9; i++){//how to calculate max lines
                //this.document.getNextDetailLine(); //create method
             }
             this.document.getTotalAllDetailsLine();
            maxLinesPerPageToPrint = maxLinesPerPageToPrint - 9;
        }while(maxLinesPerPageToPrint != 0);//todo
        this.document.getTotalSections();
    }

}
