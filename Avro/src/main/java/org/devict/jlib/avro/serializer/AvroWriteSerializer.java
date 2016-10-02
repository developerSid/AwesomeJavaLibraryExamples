package org.devict.jlib.avro.serializer;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.util.Utf8;
import org.devict.jlib.avro.data.Employee;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Gary on 10/2/16.
 * <p>
 * Class to write with older schema to a stream
 */
public class AvroWriteSerializer
{
   private final Schema schema;

   public AvroWriteSerializer() throws IOException
   {
      this.schema = new Schema.Parser().parse(AvroWriteSerializer.class.getClassLoader().getResourceAsStream("Employee.avsc"));
   }

   public void serialize(Employee employee, OutputStream out) throws IOException
   {
      GenericDatumWriter datum = new GenericDatumWriter(schema);
      DataFileWriter writer = new DataFileWriter(datum);

      try
      {

         writer.create(schema, out);
         writer.append(serialize(employee));
         writer.close();
      }
      finally
      {
         writer.close();
      }
   }

   public GenericData.Record serialize(Employee employee)
   {
      GenericData.Record record = new GenericData.Record(schema);

      record.put("name", employee.getName());
      record.put("age", employee.getAge());

      int nemails = (employee.getMails() != null) ? employee.getMails().length : 0;
      GenericData.Array emails = new GenericData.Array(nemails, schema.getField("emails").schema());

      for(int i = 0; i < nemails; ++i)
      {
         emails.add(new Utf8(employee.getMails()[i]));
      }
      record.put("emails", emails);

      return record;
   }
}
