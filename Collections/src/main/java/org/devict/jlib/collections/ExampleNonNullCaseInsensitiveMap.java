package org.devict.jlib.collections;

import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.apache.commons.collections4.map.PredicatedMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Gary.Myers on 10/5/2016.
 *
 * Example showing how to compose different functionality into a map
 */
public class ExampleNonNullCaseInsensitiveMap
{
   public static void main(String[] args)
   {
      Map<String, String> map = PredicatedMap.predicatedMap(new CaseInsensitiveMap<String, String>(), NotNullPredicate.notNullPredicate(), NotNullPredicate.notNullPredicate());

      map.put("one", "A");

      System.out.println(map);
      System.out.printf("using oNe as the key to get the value from the map: %s\n", map.get("oNe"));
      System.out.println("Going to put a null key on the map");

      try
      {
         map.put(null, "B");
      }
      catch(Exception e) //I don't like that this process throws an exception.  I'd much rather it just not put a null key in.
      {
         System.out.println(e.getMessage());
      }

      //so to fix this I implemented my own using the abstractions provided by Commons Collections 4
      Map<String, String> map2 = new FilteringPredicatedMap<>();

      map2.put("one", "A");
      map2.put(null, "B");
      map2.put("three", null);
      map2.put("four", "D");

      System.out.println(map2);

      Map<String, String> map3 = new FilteringPredicatedMap<>(new TreeMap<>(), (i -> i != null && i.equals("one")), FilteringPredicatedMap.nullPredicateInstance());

      map3.put("one", "A");
      map3.put(null, "B");
      map3.put("three", null);
      map3.put("four", "D");

      System.out.println(map3);
   }
}
