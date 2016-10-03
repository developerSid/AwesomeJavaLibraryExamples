package org.devict.jlib.avro.data;

import java.util.List;

/**
 * Created by Gary on 10/2/16.
 *
 * Employee that contains gender
 */
public class AdvancedEmployee extends Employee
{
   private String gender;

   public AdvancedEmployee()
   {

   }

   public AdvancedEmployee(String name, int age, List<String> emails, Employee b, String gender)
   {
      super(name, age, emails);
      this.gender = gender;
   }

   public String getGender()
   {
      return gender;
   }

   public void setGender(String gender)
   {
      this.gender = gender;
   }

   @Override public String toString()
   {
      return "AdvancedEmployee{" + super.toString() + " gender='" + gender + '\'' + '}';
   }
}
