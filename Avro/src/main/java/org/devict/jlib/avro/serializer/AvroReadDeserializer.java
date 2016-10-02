package org.devict.jlib.avro.serializer;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.util.Utf8;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.devict.jlib.avro.data.AdvancedEmployee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Gary on 10/2/16.
 */
public class AvroReadDeserializer
{
   private final Schema schema;

   public AvroReadDeserializer() throws IOException
   {
      this.schema = new Schema.Parser().parse(AvroWriteSerializer.class.getClassLoader().getResourceAsStream("Employee2.avsc"));
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

            employee.setName(record.get("name").toString());
            employee.setAge(Integer.parseInt(record.get("yrs").toString()));
            employee.setGender(record.get("gender").toString());
            employee.setMails(readEmails(record));
         }

         return employee;
      }
      finally
      {
         reader.close();
      }
   }

   private String[] readEmails(GenericData.Record record)
   {
      GenericData.Array<Utf8> emails = (GenericData.Array)record.get("emails");

      return emails.stream().map(Utf8::toString).toArray(String[]::new);
   }
}
