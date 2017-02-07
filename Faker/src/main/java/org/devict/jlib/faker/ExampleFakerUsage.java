package org.devict.jlib.faker;

import com.github.javafaker.Faker;

public class ExampleFakerUsage
{
   public static void main(String[] args)
   {
      Faker faker = new Faker();

      System.out.printf("name: %s\n", faker.name().name());
      System.out.printf("valid ID Number: %s\n", faker.idNumber().valid());
      System.out.printf("crypto sha1: %s\n", faker.crypto().sha1());
      System.out.printf("code IMEI: %s\n", faker.code().imei());
   }
}
