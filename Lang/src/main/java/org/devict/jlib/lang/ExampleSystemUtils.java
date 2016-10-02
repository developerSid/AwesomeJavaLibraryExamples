package org.devict.jlib.lang;

import org.apache.commons.lang3.SystemUtils;

/**
 * Created by Gary on 10/2/16.
 */
public class ExampleSystemUtils
{
   public static void main(String[] args)
   {
      System.out.printf("Java Home: %s\n", SystemUtils.getJavaHome());
      System.out.printf("User Home: %s\n", SystemUtils.getUserHome());
      System.out.printf("User Name: %s\n", SystemUtils.USER_NAME);
      System.out.printf("IS Windows? %b\n", SystemUtils.IS_OS_WINDOWS);
      System.out.printf("IS MacOS? %b\n", SystemUtils.IS_OS_MAC_OSX);
      System.out.printf("What version of Java? %s\n", SystemUtils.JAVA_VERSION);
   }
}
