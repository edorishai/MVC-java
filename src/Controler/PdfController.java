package Controler;

import model.DocumentData;
import vue.PdfGenerator;

import com.google.zxing.WriterException;
import java.io.IOException;

public class PdfController {

    /**
     * Génère un PDF avec QR code à partir des données du DocumentData.
     */
    public void genererPdf(DocumentData docData) throws IOException, WriterException {
    	String home = System.getProperty("user.home");
    	String chemin = home + "\\Downloads\\document.pdf";
    	
        PdfGenerator.createPdfWithQr(
            chemin,
            docData.getTitre(),
            docData.getTexte(),
            docData.getTitre()  // QR code encode ici le titre ou lien
        );
    }
}
