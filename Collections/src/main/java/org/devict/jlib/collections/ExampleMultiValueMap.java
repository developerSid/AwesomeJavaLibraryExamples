package org.devict.jlib.collections;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.Arrays;

/**
 * Created by Gary on 10/5/16.
 *
 * Illustrate using a Map that can hold more than one value per key
 */
public class ExampleMultiValueMap
{
   public static void main(String[] args)
   {
      MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();

      map.put("one", "A");
      System.out.println(map);

      map.putAll("one", Arrays.asList("B", "C"));
      System.out.println(map);

      map.put("one", "D");
      System.out.println(map);

      map.putAll("two", Arrays.asList("1", "2", "3"));
      System.out.println(map);

      System.out.printf("The value of the one key: %s\n", map.get("one"));
   }
}
