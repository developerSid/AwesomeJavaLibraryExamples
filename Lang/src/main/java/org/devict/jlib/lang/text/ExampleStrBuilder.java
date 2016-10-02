package org.devict.jlib.lang.text;

import org.apache.commons.lang3.text.StrBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Gary on 10/2/16.
 */
public class ExampleStrBuilder
{
   public static void main(String[] args) throws IOException
   {
      StrBuilder builder = new StrBuilder("The quick brown fox jumps over the lazy dog");

      builder.append(", because it was hungry");

      System.out.println(builder);
      System.out.println();

      legacyMethodThatOnlyTakesAWriter(builder.asWriter());

      System.out.println(builder);
      System.out.println();
      System.out.println(legacyMethodThatOnlyTakesAReader(builder.asReader()));
   }

   private static void legacyMethodThatOnlyTakesAWriter(Writer writer) throws IOException
   {
      writer.append("\nand saw a steak on the other side of the road");
   }

   private static String legacyMethodThatOnlyTakesAReader(Reader reader) throws IOException
   {
      BufferedReader bufferedReader = new BufferedReader(reader);

      return bufferedReader.readLine();
   }
}
