package vue;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PdfGenerator {

    /**
     * Crée un PDF avec texte et QR code.
     */
    public static void createPdfWithQr(String filePath, String titre, String texte, String qrData)
            throws IOException, WriterException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Génération du QR code
        QRCodeWriter qrWriter = new QRCodeWriter();
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(
                qrWriter.encode(qrData, BarcodeFormat.QR_CODE, 100, 100)
        );

        // Écriture dans le PDF
        try (PDPageContentStream content = new PDPageContentStream(document, page)) {

            // Titre
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 18);
            content.newLineAtOffset(50, 700);
            content.showText(titre);
            content.endText();

            // Texte
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 14);
            content.newLineAtOffset(50, 650);
            content.showText(texte);
            content.endText();

            // QR code
            content.drawImage(JPEGFactory.createFromImage(document, qrImage), 50, 500, 100, 100);
        }

        document.save(new File(filePath));
        document.close();
    }
}
