package org.devict.jlib.avro.serializer;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.devict.jlib.avro.AvroUtils;
import org.devict.jlib.avro.data.Employee;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gary on 10/2/16.
 *
 * Parses the information from the serialized file into and Employee
 */
public final class AvroReadDeserializer
{
   private final Schema schema;

   public AvroReadDeserializer() throws IOException
   {
      this.schema = new Schema.Parser().parse(AvroWriteSerializer.class.getClassLoader().getResourceAsStream("Employee.avsc"));
   }

   public Employee deserialize(InputStream in) throws IOException
   {
      GenericDatumReader datum = new GenericDatumReader(schema);
      DataFileStream reader = new DataFileStream(in, datum);
      Employee employee = null;

      try
      {
         GenericData.Record record = new GenericData.Record(schema);

         if(reader.hasNext())
         {
            employee = new Employee();

            reader.next(record);

            employee.setName(AvroUtils.get("name", record, "").toString());
            employee.setAge(Integer.parseInt(AvroUtils.get("yrs", record, "0").toString()));
            //employee.setMails(readEmails(record, reader));
         }

         return employee;
      }
      finally
      {
         reader.close();
      }
   }
}
