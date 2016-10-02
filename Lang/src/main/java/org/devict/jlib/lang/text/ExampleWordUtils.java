package org.devict.jlib.lang.text;

import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by Gary on 10/2/16.
 */
public final class ExampleWordUtils
{
   public static void main(String[] args)
   {
      String op1 = "The quick brown fox jumps over the lazy dog";

      System.out.printf("Capitalize whitespace delimited words\n%s\n%s\n\n\n", op1, WordUtils.capitalize(op1));
      System.out.printf("Extract the first letter of all words\n%s\n%s\n\n\n", op1, WordUtils.initials(op1));
      System.out.printf("Swap case of all words\n%s\n%s\n\n\n", WordUtils.capitalize(op1), WordUtils.swapCase(WordUtils.capitalize(op1)));
      System.out.printf("Wrap words with a specific total line width\n%s\n%s\n\n\n", op1, WordUtils.wrap(op1, 10));
   }
}
