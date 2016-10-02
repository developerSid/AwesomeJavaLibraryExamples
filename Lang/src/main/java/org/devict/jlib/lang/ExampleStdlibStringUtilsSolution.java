package org.devict.jlib.lang;

/**
 * Created by Gary on 10/1/16.
 *
 * Shows what happens when you use the standard library
 */
public final class ExampleStdlibStringUtilsSolution
{
   public static void main(String[] args)
   {
      String op1 = "IgnoreCase";
      String op2 = "IGNORECASE";
      String op3 = null;
      System.out.printf("Strings %s, %s are equal when you ignore case: [%b]\n", op1, op2, op1.equalsIgnoreCase(op2));
      System.out.printf("Strings %s, %s are equal when you ignore case: [%b]\n", op2, op3, op3.equalsIgnoreCase(op2));
   }
}
