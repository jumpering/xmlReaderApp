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

    public void print(){//todo
        //printer.setPrintConfig();//todo docFlavor
        final Integer totalLinesToPrint = 132; //todo set in config? ¿is in formated lineSize?
        final Integer maxLinesPerPageToPrint = 42; //todo set in config? ¿is in formated lineSize?
        
        do{
            this.document.getHeader().getPageHeader();
            this.document.getHeader().getListTitle();
            this.document.getHeader().getsectionListTitle();
            //this.document.getH4();//define name. Group Type?¿
            //this.document.getH5();//define name. Title columns

            //todo set maximum lines to print
            // for(int i = 0; i < maxLinesPerPageToPrint - 9; i++){//calculate max lines
            //     this.document.getNextDetailLine();
            // }
            // this.document.getTotalDetailLine();

        }while(totalLinesToPrint != 0 && maxLinesPerPageToPrint != 0);//todo
        this.document.getTotalSections();
    }

}
