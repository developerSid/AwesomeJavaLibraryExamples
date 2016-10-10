package org.devict.jlib.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by Gary.Myers on 10/10/2016.
 *
 * Shows the table type from Guava
 */
public class ExampleTable
{
   public static void main(String[] args)
   {
      Table<String, String, String> table = HashBasedTable.create();


   }
}
