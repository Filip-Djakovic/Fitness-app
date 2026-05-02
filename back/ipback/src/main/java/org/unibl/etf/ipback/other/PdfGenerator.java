package org.unibl.etf.ipback.other;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.unibl.etf.ipback.entities.DiaryEntity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PdfGenerator {
    public void generatePdf(List<DiaryEntity> entits) {
        File file = new File("output.pdf");

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.OVERWRITE, true)) {
                //contentStream.setFont(PDType1Font., 12);
                //contentStream.setFont();
                File fileFont = new File("C://Windows//Fonts//timesbd.ttf");
                System.out.println(fileFont.getAbsolutePath());
                PDType0Font font = PDType0Font.load(document, fileFont);
                contentStream.setFont(font, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                for(DiaryEntity entity : entits){

                    contentStream.showText(entity.getText());
                    contentStream.newLineAtOffset(0, -15);
                    contentStream.showText("Stara tezina : " + entity.getOldWeight());
                    contentStream.newLineAtOffset(0, -15);
                    contentStream.showText("Nova tezina : " + entity.getNewWeight());
                    contentStream.newLineAtOffset(0, -30);
                }

                contentStream.endText();
            }

            document.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
