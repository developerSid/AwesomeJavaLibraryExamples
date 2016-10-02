package org.devict.jlib.avro.data;

import java.util.Arrays;

/**
 * Created by Gary on 10/2/16.
 *
 * Simple container to illustrate serializing and deserializing data with Apache Avro
 */
public class Employee
{
   private String name;
   private int age;
   private String[] mails;

   public Employee()
   {

   }

   public Employee(String name, int age, String[] emails)
   {
      this.name = name;
      this.age = age;
      this.mails = emails;
   }

   @Override public String toString()
   {
      return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", mails="
         + Arrays.toString(mails) + '}';
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public void setMails(String[] mails)
   {
      this.mails = mails;
   }

   public String getName()
   {
      return name;
   }

   public int getAge()
   {
      return age;
   }

   public String[] getMails()
   {
      return mails;
   }
}
