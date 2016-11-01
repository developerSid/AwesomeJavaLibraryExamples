package org.devict.jlib.groovy;

import groovy.lang.GroovyShell;

import java.util.List;
import java.util.Map;

/**
 * Created by Gary on 10/31/16.
 *
 * Example showing how to embed a Groovy interpreter in a Java program to use allow for parsing scripts into Java Objects
 */
public class ExampleEmbeddedGroovyStringToMap
{
   @SuppressWarnings("unchecked")
   public static void main(String[] args)
   {
      GroovyShell shell = new GroovyShell();
      List<Map<String, String>> map = (List<Map<String, String>>)shell.evaluate("[['key1': 'value1', 'key2': 'value2', 'key3': 'value3'], ['key1': 'value4', 'key2': 'value5', 'key3': 'value6']]");

      map.stream().forEach(i -> {
         i.entrySet().stream().forEach(System.out::println);
      });
   }
}
