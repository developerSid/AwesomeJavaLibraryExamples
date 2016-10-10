package org.devict.jlib.pdf;

import org.apache.commons.io.input.AutoCloseInputStream;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gary.Myers on 10/10/2016.
 *
 * Example putting an image in a PDF with a watermark
 *
 * Modified from original at https://svn.apache.org/viewvc/pdfbox/trunk/examples/src/main/java/org/apache/pdfbox/examples/pdmodel/AddImageToPDF.java?revision=1750159&view=markup
 */
public class ExampleAddImage
{
   private static final float scale = 1f;

   public static void main(String[] args) throws IOException, URISyntaxException
   {
      File pdfFile = File.createTempFile("devict-exampleimage", ".pdf");
      File overlayPdf = File.createTempFile("devict-exampleoverlay", ".pdf");

      createOverlayDocument(overlayPdf);
      createFinalDocument(pdfFile, overlayPdf);

      Desktop.getDesktop().open(pdfFile);
   }

   private static void createOverlayDocument(File overlayPdf) throws IOException
   {
      PDDocument overlayDoc = new PDDocument();

      try
      {
         PDPage page=new PDPage();

         overlayDoc.addPage(page);
         PDFont font=PDType1Font.COURIER_OBLIQUE;

         PDPageContentStream contentStream=new PDPageContentStream(overlayDoc, page);
         contentStream.setFont(font, 50);
         contentStream.setNonStrokingColor(0);
         contentStream.beginText();
         contentStream.newLineAtOffset(100, 500);
         contentStream.setNonStrokingColor(255, 0, 0);
         contentStream.showText("CLASSIFIED");
         contentStream.endText();
         contentStream.close();
         overlayDoc.save(overlayPdf);
      }
      finally
      {
         overlayDoc.close();
      }
   }

   private static void createFinalDocument(File pdfFile, File overlayPdf) throws IOException
   {
      PDDocument doc = new PDDocument();

      try
      {
         PDPage page = new PDPage();

         doc.addPage(page);
         PDImageXObject pdImage =JPEGFactory.createFromStream(doc, new AutoCloseInputStream(ExampleAddImage.class.getClassLoader().getResourceAsStream("death-star-plans.jpg")));
         PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);
         Map<Integer, String> overlayGuide = new HashMap<>();

         contentStream.drawImage(pdImage, 100, 300, pdImage.getWidth()*scale, pdImage.getHeight()*scale);

         overlayGuide.put(1, overlayPdf.getAbsolutePath());
         Overlay overlay = new Overlay();
         overlay.setInputPDF(doc);
         overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
         overlay.overlay(overlayGuide);

         contentStream.close();
         doc.save(pdfFile);
      }
      finally
      {
         doc.close();
      }
   }
}
