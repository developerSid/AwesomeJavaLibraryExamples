package org.devict.jlib.stdlib;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.devict.jlib.stdlib.util.HelloCallable;
import org.devict.jlib.stdlib.util.RandomTask;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Gary on 10/16/16.
 *
 * Using a thread pool for doing a bunch of stuff
 */
public class ExampleThreading
{
   public static void main(String[] args) throws ExecutionException, InterruptedException
   {
      List<Future<?>> randomTasks = new LinkedList<>();
      ExecutorService executorService = Executors.newCachedThreadPool(
         new BasicThreadFactory.Builder()
            .daemon(true)
            .namingPattern("ExampleThread")
            .build()
      );

      try
      {
         Future<String> result = executorService.submit(new HelloCallable());

         System.out.printf("Result %s\n", result.get()); //will wait until the submitted job is done

         for(int count = 0; count < 10; count++)
         {
            randomTasks.add(executorService.submit(new RandomTask(count)));
         }

         waitForTheFuture(randomTasks);
      }
      finally
      {
         executorService.shutdown(); //make sure you shut it down
      }
   }

   private static void waitForTheFuture(List<Future<?>> randomTasks) throws ExecutionException, InterruptedException
   {
      for(Future<?> future: randomTasks)
      {
         if(!future.isDone())
         {
            future.get();
         }
      }
   }
}
