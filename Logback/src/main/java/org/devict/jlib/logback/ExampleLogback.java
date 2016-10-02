package org.devict.jlib.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gary on 10/2/16.
 *
 * Loads a logging configuration and logs some messages at different levels in a loop
 */
public class ExampleLogback
{
   //Access logback via Slf4j because as Java programmers we can always use another layer of abstraction
   private static Logger logger = LoggerFactory.getLogger(ExampleLogback.class); //on the first call to LoggerFactory the Logback system is initialized as well as returning an instance of a logger

   public static void main(String[] args) throws InterruptedException
   {
      logger.info("Starting Example Logback application");
      Runtime.getRuntime().addShutdownHook(new Thread(() -> logger.info("Shutting down")));
      logger.trace("Hello World from Trace logging");
      logger.debug("Hello World from Debug logging");
      logger.info("Hello World from Info logging");
      logger.warn("Hello World from Warn logging");
      logger.error("Hello World from Error logging");

      for(int count = 0; ; count++)
      {
         if(count%1 == 0)
         {
            logger.trace("counter was {}", count);
         }
         if(count%2 == 0)
         {
            logger.debug("counter was {}", count);
         }
         if(count%3 == 0)
         {
            logger.info("counter was {}", count);
         }
         if(count%4 == 0)
         {
            logger.warn("counter was {}", count);
         }
         if(count%5 == 0)
         {
            logger.error("counter was {}", count);
         }

         TimeUnit.SECONDS.sleep(1);
      }
   }
}
