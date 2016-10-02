package org.devict.jlib.collections;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gary on 10/2/16.
 *
 * Example of using the CollectionUtils utility class
 */
public class ExampleCollectionUtils
{
   public static void main(String[] args)
   {
      List<String> collection = new LinkedList<>(Arrays.asList("Hello", "World"));

      System.out.println(collection);

      CollectionUtils.addIgnoreNull(collection, "Common");
      System.out.println(collection);

      CollectionUtils.addIgnoreNull(collection, null);
      System.out.println(collection);

      System.out.println(CollectionUtils.union(Arrays.asList("One", "Two", "Three"), Arrays.asList("Two", "Three", "Four")));

      System.out.println(CollectionUtils.subtract(Arrays.asList("One", "Two", "Three"), Arrays.asList("Two", "Three", "Four")));
   }
}
