package org.devict.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Gary on 10/9/16.
 *
 * Some examples from Commons IO
 */
public class ExampleIO
{
   public static void main(String[] args) throws IOException
   {
      File tempDir = FileUtils.getTempDirectory();

      System.out.printf("System temp Dir is at %s", tempDir.getAbsolutePath());

      FileUtils.listFiles(tempDir, FileFileFilter.FILE, null).forEach(i -> System.out.printf("file path %s\n", i.getAbsolutePath()));

      File tempTestDir = new File(tempDir, "test");

      tempTestDir.mkdirs();

      try
      {
         FileUtils.write(new File(tempTestDir, "01"), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), Charset.defaultCharset());
         FileUtils.write(new File(tempTestDir, "02"), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), Charset.defaultCharset());
         FileUtils.write(new File(tempTestDir, "03"), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), Charset.defaultCharset());
         FileUtils.write(new File(tempTestDir, "04"), "one\ntwo\nthree\nfour\n", Charset.defaultCharset());
         FileUtils.copyFile(new File(tempTestDir, "04"), new File(tempTestDir, "05"));

         FileUtils.listFiles(tempTestDir, FileFileFilter.FILE, null).forEach(i ->
            {
               try
               {
                  System.out.printf("file path %s\n%s\n", i.getAbsolutePath(), FileUtils.readFileToString(i, Charset.defaultCharset()));
               }
               catch(IOException e)
               {
                  e.printStackTrace();
               }
            }
         );

         StringWriter sw = new StringWriter();
         IOUtils.copy(new StringReader("Hello World"), sw);

         System.out.printf("message copied: %s\n", sw);

         //in memory buffer useful for interfacing with API's that only take OutputStreams and creating a file might not make sense.  Good for testing
         org.apache.commons.io.output.ByteArrayOutputStream out = new ByteArrayOutputStream(); //this one is better than the stdlib one in that it can be much larger as it doesn't rely on a single array, and can be faster

         out.write("Hello World".getBytes(Charset.defaultCharset()));

         System.out.printf("Message stored in ByteArrayOutputStream: %s", new String(out.toByteArray(), Charset.defaultCharset()));

         String filename = "test.txt";
         System.out.printf("extension of %s - %s\n", filename, FilenameUtils.getExtension(filename));
      }
      finally
      {
         FileUtils.cleanDirectory(tempTestDir);
         FileUtils.forceDelete(tempTestDir);
      }
   }
}
