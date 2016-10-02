package org.devict.jlib.avro;

import org.devict.jlib.avro.serializer.AvroReadDeserializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Gary on 10/2/16.
 */
public class ExampleAvroRead
{
   public static void main(String[] args) throws IOException
   {
      AvroReadDeserializer deserializer = new AvroReadDeserializer();

      try(FileInputStream in = new FileInputStream(new File("/tmp/employee.avro")))
      {
         System.out.println(deserializer.deserialize(in));
      }
   }
}
