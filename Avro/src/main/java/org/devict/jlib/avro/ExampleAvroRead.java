package org.devict.jlib.avro;

import org.apache.commons.io.FileUtils;
import org.devict.jlib.avro.serializer.AvroReadDeserializer;

import java.io.File;
import java.io.FileInputStream;
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
      File output = new File(FileUtils.getTempDirectory(), "employee.avro");
      AvroReadDeserializer deserializer = new AvroReadDeserializer();

      try(FileInputStream in = new FileInputStream(output))
      {
         System.out.printf("%s\ndeserialized from %s\n", deserializer.deserialize(in), output.getAbsolutePath());
      }
   }
}
