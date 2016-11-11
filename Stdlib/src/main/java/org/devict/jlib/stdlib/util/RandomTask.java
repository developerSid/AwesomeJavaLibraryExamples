package org.devict.jlib.stdlib.util;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gary on 10/16/16.
 */
public class RandomTask implements Runnable
{
   private final int job;

   public RandomTask(int job)
   {
      this.job = job;
   }

   @Override public void run()
   {
      try
      {
         int sleepTime = RandomUtils.nextInt(1, 5);
         System.out.printf("%d Sleeping %d seconds\n", job, sleepTime);
         TimeUnit.SECONDS.sleep(sleepTime);
         System.out.printf("%d Slept %d seconds\n", job, sleepTime);
      }
      catch(InterruptedException e)
      {
         e.printStackTrace();
      }
   }
}
