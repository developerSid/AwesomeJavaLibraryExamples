package org.devict.jlib.stdlib;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Gary on 10/12/16.
 *
 * Demonstrate some of the Java 8 streams for handling collections
 */
public class ExampleStream
{
   public static void main(String[] args)
   {
      List<String> list = Arrays.asList(
         "One",
         "Two",
         "Three",
         "Four",
         "Five"
      );

      System.out.println(list);

      System.out.printf("First Element: %s\n", list.stream().findFirst().get());

      long numbChars = list.stream()
         .map(i -> i.split(""))
         .flatMap(Arrays::stream).count();

      System.out.printf("number of chars in the list %d\n", numbChars);
   }
}
