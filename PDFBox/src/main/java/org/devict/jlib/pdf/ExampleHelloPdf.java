package org.devict.jlib.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Gary.Myers on 10/10/2016.
 */
public class ExampleHelloPdf
{
   public static void main(String[] args) throws IOException
   {
      PDDocument doc = new PDDocument();
      File pdfFile = File.createTempFile("devict-example", ".pdf");

      try
      {
         PDPage page = new PDPage();
         doc.addPage(page);

         PDFont font = PDType1Font.HELVETICA_BOLD;

         PDPageContentStream contents = new PDPageContentStream(doc, page);
         contents.beginText();
         contents.setFont(font, 12);
         contents.newLineAtOffset(100, 700);
         contents.showText("Hello DevICT PDFBox the time is " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
         contents.endText();
         contents.close();

         doc.save(pdfFile);
      }
      finally
      {
         System.out.printf("PDF created and saved at %s\n", pdfFile.getAbsolutePath());
         doc.close();
      }

      Desktop.getDesktop().open(pdfFile);
   }
}
