package org.devict.jlib.avro;

import org.apache.commons.io.FileUtils;
import org.devict.jlib.avro.data.AdvancedEmployee;
import org.devict.jlib.avro.data.Employee;
import org.devict.jlib.avro.serializer.AvroWriteSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
      File outputFile = new File(FileUtils.getTempDirectory(), "employee.avro");
      AdvancedEmployee employee = new AdvancedEmployee("Joe", 31, Arrays.asList("joe@abc.com", "joe@gmail.com"), "Male");
      AvroWriteSerializer serializer = new AvroWriteSerializer();

      try(FileOutputStream out = new FileOutputStream(outputFile))
      {
         serializer.serialize(employee, out);
      }

      System.out.printf("%s \nsaved to %s\n", employee, outputFile.getAbsolutePath());
   }
}
