package org.devict.jlib.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

/**
 * Created by Gary.Myers on 10/10/2016.
 *
 * Shows the table type from Guava
 */
public class ExampleTable
{
   public static void main(String[] args)
   {
      Table<String, String, String> table = TreeBasedTable.create();

      table.put("Row1", "Column1", "Data1");
      table.put("Row1", "Column2", "Data2");

      table.put("Row2", "Column1", "Data3");
      table.put("Row2", "Column2", "Data4");

      table.put("Row3", "Column1", "Data5");
      table.put("Row3", "Column2", "Data6");
      table.put("Row3", "Column3", "Data7");

      Joiner.MapJoiner mapJoiner = Joiner.on(',').withKeyValueSeparator("="); //Let's a Guava Joiner to illustrate that

      table.rowKeySet().forEach(r -> {
         System.out.println(r + "->" + mapJoiner.join(table.row(r)));
      });
   }
}
