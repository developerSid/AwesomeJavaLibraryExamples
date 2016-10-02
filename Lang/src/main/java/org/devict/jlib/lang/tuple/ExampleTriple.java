package org.devict.jlib.lang.tuple;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Created by Gary on 10/2/16.
 *
 * Shows some uses for a generic triple container
 */
public class ExampleTriple
{
   public static void main(String[] args)
   {
      MutableTriple<String, String, String> mutableTriple = new MutableTriple<>("Left", "Middle", "Right");

      System.out.println("Our first Triple: " + buildATriple());

      System.out.println("Before changing: " + mutableTriple);

      buildATriple(mutableTriple);

      System.out.println("After changing: " + mutableTriple);
   }

   private static Triple<String, String, String> buildATriple()
   {
      Triple<String, String, String> toReturn = new ImmutableTriple<>(
         "Left",
         "Middle",
         "Right"
      );

      return toReturn;
   }

   private static void buildATriple(MutableTriple<String, String, String> triple)
   {
      triple.setMiddle("New Middle");
   }
}
