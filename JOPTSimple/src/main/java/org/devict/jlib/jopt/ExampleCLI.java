package org.devict.jlib.jopt;

/**
 * Created by Gary.Myers on 10/17/2016.
 *
 * Simple example showing just the basics of Command Line Parsing
 */
public class ExampleCLI
{
   public static void main(String[] args)
   {
      CommandLine cmd = new CommandLine(args);

      if(cmd.successfullyParsed() && !cmd.helpRequested())
      {
         System.out.printf("Endpoint:    %s\n", cmd.getEndpoint());
         System.out.printf("Username:    %s\n", cmd.getUserName());
         System.out.printf("Password:    %s\n", cmd.getPassword());
         System.out.printf("Config file: %s\n", cmd.getConfigurtionFile().getAbsolutePath());
      }
      else
      {
         System.out.println(cmd.toString());
      }
   }
}
