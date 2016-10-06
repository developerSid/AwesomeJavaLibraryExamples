package org.devict.jlib.collections;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

/**
 * Created by Gary on 10/5/16.
 *
 * Example using a map that uses case insensitive keys
 */
public class ExampleCaseInsensitiveMap
{
   public static void main(String[] args)
   {
      CaseInsensitiveMap<String, String> map = new CaseInsensitiveMap<>();

      map.put("one", "A");

      System.out.println(map);

      System.out.printf("using oNe as the key to get the value from the map: %s\n", map.get("oNe"));
   }
}
