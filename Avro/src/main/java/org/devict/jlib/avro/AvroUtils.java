package org.devict.jlib.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Gary on 10/2/16.
 *
 * Simple Utility methods for dealing with Avro
 */
public final class AvroUtils
{
   private AvroUtils(){}

   public static void put(String fieldName, Object value, GenericData.Record record)
   {
      Schema schema = record.getSchema();
      Schema.Field field = schema.getFields().stream()
         .filter(i -> i.name().equals(fieldName) || i.aliases().contains(fieldName))
         .findFirst()
         .get();

      record.put(field.pos(), value);
   }

   public static Object get(String fieldName, DataFileStream stream, GenericData.Record record)
   {
      Schema schema = stream.getSchema();

      Schema.Field field = schema.getFields().stream()
         .filter(i -> i.name().equals(fieldName) || i.aliases().contains(fieldName))
         .findFirst()
         .get();

      return record.get(field.pos());
   }

   public static <T, R> List<R> readEmails(GenericData.Record record, String fieldName, Function<T, R> transformer)
   {
      GenericData.Array<T> emails = (GenericData.Array<T>)record.get(fieldName);

      return emails.stream()
         .map(transformer)
         .collect(Collectors.toList());
   }
}
