package org.devict.jlib.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Gary.Myers on 10/17/2016.
 *
 * Simple example showing parsing of CSV file
 */
public class ExampleStudentCSV
{
   public static void main(String[] args) throws IOException
   {
      try(Reader reader = new InputStreamReader(ExampleStudentCSV.class.getClassLoader().getResourceAsStream("students.csv")))
      {
         try(CSVParser parser=new CSVParser(reader, CSVFormat.EXCEL.withHeader("Name","Class","Dorm","Room","GPA").withFirstRecordAsHeader()))
         {
            System.out.printf("%20s | %20s\n", "Name", "Class");
            System.out.printf("%20s-+-%20s\n", StringUtils.leftPad("", 20, '-'), StringUtils.leftPad("", 20, '-'));

            for(CSVRecord record: parser)
            {
               System.out.printf("%20s | %20s\n", record.get("Name"), record.get("Class"));
            }
         }
      }
   }
}
