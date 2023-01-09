import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
 
//copied from https://www.lawebdelprogramador.com/foros/Java/1486154-imprimir-directo-a-la-impresora.html

public class DirectPrint { //todo, that is a sample
 
	public void print(String stringToPrint) throws PrintException{
		byte[] bytes = new String("Estó ès una pruebà \r\n Hola qu€ tal").getBytes(Charset.forName("Cp858"));
		PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		DocPrintJob pj = service.createPrintJob();
		Doc doc = new SimpleDoc(bytes, flavor, null);
		pj.print(doc, null);
	}
}
