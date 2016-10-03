package org.devict.jlib.avro.serializer;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.devict.jlib.avro.AvroUtils;
import org.devict.jlib.avro.data.AdvancedEmployee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

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

   public AdvancedEmployee deserialize(InputStream in) throws IOException
   {
      GenericDatumReader datum = new GenericDatumReader(schema);
      DataFileStream reader = new DataFileStream(in, datum);
      AdvancedEmployee employee = null;

      try
      {
         GenericData.Record record = new GenericData.Record(schema);

         if(reader.hasNext())
         {
            employee = new AdvancedEmployee();

            reader.next(record);

            employee.setName(AvroUtils.get("name", reader, record).toString());
            employee.setAge(Integer.parseInt(AvroUtils.get("yrs", reader, record).toString()));
            employee.setGender(AvroUtils.get("gender", reader, record).toString());
            //employee.setMails(readEmails(record, reader));
         }

         return employee;
      }
      finally
      {
         reader.close();
      }
   }

   private List<String> readEmails(GenericData.Record record, DataFileStream reader)
   {
      GenericData.Array<?> emails = (GenericData.Array)AvroUtils.get("emails", reader, record);

      return emails.stream().map(Object::toString).collect(Collectors.toList());
   }
}
