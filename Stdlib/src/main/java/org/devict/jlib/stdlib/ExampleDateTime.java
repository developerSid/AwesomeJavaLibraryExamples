package org.devict.jlib.stdlib;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * Created by Gary on 10/28/16.
 *
 * show using the Java 8 Time API
 */
public class ExampleDateTime
{
   public static void main(String[] args) throws IOException
   {
      LocalDateTime past = LocalDateTime.of(1955, Month.NOVEMBER, 5, 0, 0);    //when Doc brown invented time travel
      LocalDateTime present = LocalDateTime.of(1985, Month.OCTOBER, 26, 0, 0); //when Marty travels to the past
      LocalDateTime future = LocalDateTime.of(2015, Month.OCTOBER, 21, 0, 0);  //future point when Marty and Jennifer travel to with Doc

      System.out.printf("Is %s before %s %b\n", past, present, past.isBefore(present));
      System.out.printf("Adding 30 years and subtracting 5 days to %s makes it equal to %s %b\n", present, future, present.plusYears(30).minusDays(5).isEqual(future));

      File tempFile = File.createTempFile("test", "txt");

      LocalDateTime tempFileTime = LocalDateTime.ofInstant(Files.getLastModifiedTime(tempFile.toPath()).toInstant(), ZoneId.systemDefault());

      System.out.printf("Temp file with time of %s was created after %s %b\n", tempFileTime, past, tempFileTime.isAfter(past));

      tempFile.delete();
   }
}
