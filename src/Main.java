import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;




public class Main {


	public static void main(String[] args) {
		
		String FILE_PATH = "sample.pdf";	
		
		File file = new File(FILE_PATH);
		
		System.out.println("1Valor: "+file);
		
//		PDFParser parser;
		
		PDDocument document=null;
		
		String text="no hay";
		try {
			
//			parser = new PDFParser(new FileInputStream(file));
//			parser.parse();
			
			
//			document = new PDDocument();
			
			document = PDDocument.load(file);
			
//			document = parser.getPDDocument();
			
			
			
			
			System.out.println("Pages: "+document.getNumberOfPages());
			System.out.println("Encrypted: "+document.isEncrypted());
			PDFTextStripper textStripper = new PDFTextStripper();
			System.out.println(textStripper.getText(document));
			text = textStripper.getText(document);
			System.out.println("Escribir texto: "+text);			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println(text);
			
			if(document != null){
				try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}

}
