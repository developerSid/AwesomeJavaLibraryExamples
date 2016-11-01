package org.devict.jlib.avro.serializer;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.util.Utf8;
import org.devict.jlib.avro.AvroUtils;
import org.devict.jlib.avro.data.AdvancedEmployee;

import java.io.IOException;
import java.io.OutputStream;

import static org.apache.avro.generic.GenericData.*;

/**
 * Created by Gary on 10/2/16.
 * <p>
 * Class to write with older schema to a stream
 */
public final class AvroWriteSerializer
{
   private final Schema schema;

   public AvroWriteSerializer() throws IOException
   {
      this.schema = new Schema.Parser().parse(AvroWriteSerializer.class.getClassLoader().getResourceAsStream("AdvancedEmployee.avsc"));
   }

   public void serialize(AdvancedEmployee employee, OutputStream out) throws IOException
   {
      GenericDatumWriter<Record> datum = new GenericDatumWriter<>(schema);
      DataFileWriter<Record> writer = new DataFileWriter<>(datum);

      try
      {
         writer.create(schema, out);
         writer.append(serialize(employee));
      }
      finally
      {
         writer.close();
      }
   }

   public Record serialize(AdvancedEmployee employee)
   {
      Record record = new Record(schema);

      AvroUtils.put("name", employee.getName(), record);
      AvroUtils.put("age", employee.getAge(), record);
      AvroUtils.put("gender", employee.getGender(), record);

      int numberOfEmails = (employee.getMails() != null) ? employee.getMails().size() : 0;
      GenericData.Array<Utf8> emails = new GenericData.Array<>(numberOfEmails, schema.getField("emails").schema());

      for(int i = 0; i < numberOfEmails; ++i)
      {
         emails.add(new Utf8(employee.getMails().get(i)));
      }

      record.put("emails", emails);

      return record;
   }
}
