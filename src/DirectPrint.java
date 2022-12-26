import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
 
//copied from https://www.lawebdelprogramador.com/foros/Java/1486154-imprimir-directo-a-la-impresora.html

public class DirectPrint {

	private PrintService printService;
	private DocFlavor flavor;
	private DocPrintJob docPrintJob;
 
	public DirectPrint() {
		this.printService = PrintServiceLookup.lookupDefaultPrintService();
		this.flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		this.docPrintJob = printService.createPrintJob();
	}

	public void print(String stringToPrint){
		Doc doc = new SimpleDoc(stringToPrint.getBytes(), this.flavor, null);
		try {
			this.docPrintJob.print(doc, null);
		} catch (PrintException e) {
			e.printStackTrace();
		}
	}
}
