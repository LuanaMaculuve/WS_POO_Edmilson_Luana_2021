/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recibo;

/**
 *
 * @author Luana M
 */
import GUI.TelaConfirmInquilino;
import GUI.TelaPrincipal;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReciboPDF {

    public void recibo() {
        File f = new File("C:/Recibos");
        if (!f.exists()) {
            f.mkdir();
        }
        Date dia = new Date();
        DateFormat hora = DateFormat.getDateTimeInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        // aqui inicia a criacao do documento

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:/Recibos/Recibo do Sr. " + TelaConfirmInquilino.NomeInq.getText() + ".pdf"));
            document.setPageSize(PageSize.A4);
            document.open();

            // adicionando  parágrafos ao documento
            document.add(new Paragraph("                                                SIAR-IMOB   "
                    + "                                   RECIBO "));
            document.add(new Paragraph("                                              Av. de Mocambique"));
            document.add(new Paragraph("                                              Telefone: +2134567"));
            document.add(new Paragraph("                                                  NUIT: 345678"));
            document.add(new Paragraph("                         "));
            document.add(new Paragraph("Recebemos do(a) Exmo(a) Senhor(a):        " + TelaConfirmInquilino.NomeInq.getText()));

            document.add(new Paragraph("A quantia de: " + TelaConfirmInquilino.Valor_a_Pagar.getText()));

            document.add(new Paragraph("Referente ao pagamento de Taxa de Arrendamento de Imovel que passamos o presente recibo"));

            document.add(new Paragraph("Pago em Numerario"));

            document.add(new Paragraph("Data e Hora: " + hora.format(dia)));
            document.add(new Paragraph("Processado por: " + TelaPrincipal.email));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        } finally {
            document.close();
        }
    }
}
