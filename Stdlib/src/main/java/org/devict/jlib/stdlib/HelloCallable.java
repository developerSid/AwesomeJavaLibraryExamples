package org.devict.jlib.stdlib;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gary on 10/16/16.
 */
public class HelloCallable implements Callable<String>
{
   @Override public String call() throws Exception
   {
      try
      {
         TimeUnit.SECONDS.sleep(2);
      }
      catch(InterruptedException e)
      {

      }

      return "Hello after sleeping";
   }
}
