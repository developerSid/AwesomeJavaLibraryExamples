package org.devict.jlib.avro;

import org.devict.jlib.avro.serializer.AvroReadDeserializer;

import java.io.IOException;

/**
 * Created by Gary on 10/2/16.
 *
 * Program to deserialize an Employee object from a file that was produced by another program
 */
public class ExampleAvroRead
{
   public static void main(String[] args) throws IOException
   {
      AvroReadDeserializer deserializer = new AvroReadDeserializer();

      System.err.printf("Read: \n%s\n", deserializer.deserialize(System.in));
   }
}
