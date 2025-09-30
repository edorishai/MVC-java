package vue;



import com.google.zxing.WriterException;
import Controler.PdfController;
import model.DocumentData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class principal extends JFrame {

    private JPanel contentPane;
    private JTextField textField;   // texte
    private JTextField textField_1; // lien

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                principal frame = new principal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField_1 = new JTextField();
        textField_1.setBounds(82, 38, 200, 19);
        contentPane.add(textField_1);

        textField = new JTextField();
        textField.setBounds(82, 110, 200, 19);
        contentPane.add(textField);

        JLabel lblLien = new JLabel("Lien");
        lblLien.setBounds(28, 38, 44, 19);
        contentPane.add(lblLien);

        JLabel lblTexte = new JLabel("Texte");
        lblTexte.setBounds(28, 110, 44, 19);
        contentPane.add(lblTexte);

        JButton validerButton = new JButton("Valider");
        validerButton.setBounds(150, 180, 100, 25);
        contentPane.add(validerButton);

        validerButton.addActionListener(e -> {
            String texte = textField.getText();
            String lien = textField_1.getText();

            DocumentData docData = new DocumentData(lien, texte);
            PdfController pdfCtrl = new PdfController();
            try {
                pdfCtrl.genererPdf(docData);
                JOptionPane.showMessageDialog(this, "PDF généré dans telechargement !");
            } catch (IOException | WriterException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erreur lors de la génération du PDF : " + ex.getMessage());
            }
        });
    }
}


