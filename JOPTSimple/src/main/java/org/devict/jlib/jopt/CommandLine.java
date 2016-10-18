package org.devict.jlib.jopt;

import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Created by Gary.Myers on 10/17/2016.
 *
 * Just a command line example
 */
public class CommandLine
{
   private OptionSet options;
   private String errorMessage = null;
   private final OptionParser optionParser;
   private final ArgumentAcceptingOptionSpec<String> username;
   private final ArgumentAcceptingOptionSpec<String> password;
   private final ArgumentAcceptingOptionSpec<String> endpoint;
   private final ArgumentAcceptingOptionSpec<File> configurationFile;
   private final ArgumentAcceptingOptionSpec<File> uploadFile;
   private final OptionSpec<Void> help;

   public CommandLine(String... args)
   {

      this.optionParser = new OptionParser();
      this.optionParser.allowsUnrecognizedOptions();

      this.help = optionParser.acceptsAll(Arrays.asList("?", "help"), "shows this message").forHelp();
      this.endpoint = optionParser.acceptsAll(Arrays.asList("e", "endpoint"), "Endpoint that the file will be uploaded to.  Should include protocol://endpoint/path").withRequiredArg().required();
      this.username = optionParser.acceptsAll(Arrays.asList("u", "username"), "Username used for logging in to the remote server").withRequiredArg();
      this.password = optionParser.acceptsAll(Arrays.asList("p", "password"), "Password to go with the username for the remote server. (Required if username provided)").requiredIf(username).withRequiredArg();
      this.uploadFile = optionParser.acceptsAll(Arrays.asList("f", "file"), "File to be uploaded to the remote host").withRequiredArg().required().ofType(File.class);
      this.configurationFile = optionParser.acceptsAll(Arrays.asList("c", "config"), "Configuration file that holds the username and password (required if username/password not provided)").requiredUnless(username).requiredUnless(password).withRequiredArg().ofType(File.class);

      try
      {
         this.options = optionParser.parse(args);
      }
      catch(Exception e)
      {
         this.errorMessage = e.getMessage();
      }
   }

   public final File getConfigurtionFile()
   {
      return options.valueOf(configurationFile);
   }

   public final String getUserName()
   {
      return options.valueOf(username);
   }

   public final String getPassword()
   {
      return options.valueOf(password);
   }

   public final File getFileToUpload()
   {
      return options.valueOf(uploadFile);
   }

   public final String getEndpoint()
   {
      return options.valueOf(endpoint);
   }

   public boolean successfullyParsed()
   {
      return errorMessage == null;
   }

   public boolean helpRequested()
   {
      return options.has(help);
   }

   public final String toString() throws RuntimeException
   {
      try
      {
         StringWriter help = new StringWriter();

         if(StringUtils.isNotBlank(errorMessage))
         {
            help.append(errorMessage);
         }

         optionParser.printHelpOn(help);

         return help.toString();
      }
      catch(IOException e)
      {
         throw new RuntimeException("Unable to generate help");
      }
   }
}
