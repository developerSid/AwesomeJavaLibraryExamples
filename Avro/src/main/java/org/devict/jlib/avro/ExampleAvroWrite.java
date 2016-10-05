package org.devict.jlib.avro;

import org.devict.jlib.avro.data.AdvancedEmployee;
import org.devict.jlib.avro.serializer.AvroWriteSerializer;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Gary on 10/2/16.
 *
 * Program to serialize an Employee object to a file for consumption by another program
 */
public class ExampleAvroWrite
{
   public static void main(String[] args) throws IOException
   {
      AdvancedEmployee employee = new AdvancedEmployee("Joe", 31, Arrays.asList("joe@abc.com", "joe@gmail.com"), "Male");
      AvroWriteSerializer serializer = new AvroWriteSerializer();

      System.err.printf("Writing: \n%s\n", employee);
      serializer.serialize(employee, System.out);
   }
}
