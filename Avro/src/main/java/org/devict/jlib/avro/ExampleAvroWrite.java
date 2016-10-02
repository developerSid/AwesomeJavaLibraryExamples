package org.devict.jlib.avro;

import org.devict.jlib.avro.data.Employee;
import org.devict.jlib.avro.serializer.AvroWriteSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Gary on 10/2/16.
 */
public class ExampleAvroWrite
{
   public static void main(String[] args) throws IOException
   {
      Employee employee = new Employee("Joe", 31, new String[] { "joe@abc.com", "joe@gmail.com" });
      AvroWriteSerializer serilizer = new AvroWriteSerializer();

      try(FileOutputStream out = new FileOutputStream(new File("/tmp/employee.avro")))
      {
         serilizer.serialize(employee, out);
      }

      System.out.println(employee);
   }
}
