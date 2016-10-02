package org.devict.jlib.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Gary on 10/1/16.
 *
 * Shows useful methods on the Apache Commons Lang StringUtils utility class
 */
public final class ExampleStringUtils
{
   public static void main(String[] args)
   {
      String op1 = "IgnoreCase";
      String op2 = "IGNORECASE";
      String op3 = null;
      System.out.printf("Strings %s, %s are equal when you ignore case: [%b]\n", op1, op2, StringUtils.equalsIgnoreCase(op1, op2));
      System.out.printf("Strings %s, %s are equal when you ignore case: [%b]\n", op2, op3, StringUtils.equalsIgnoreCase(op2, op3));
   }
}
