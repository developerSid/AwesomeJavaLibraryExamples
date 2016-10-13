package org.devict.jlib.guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * Created by Gary on 10/12/16.
 *
 * Simple example showing how to use the Guava event bus
 */
public class ExampleEventBus
{
   public static void main(String[] args) throws InterruptedException
   {
      CountDownLatch latch = new CountDownLatch(10); //modify this to change how many messages the examples will process
      ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("Bus Thread").build());
      EventBus eventBus = new AsyncEventBus(executor);

      eventBus.register(new Consumer<String>()
      {
         @Subscribe @Override public void accept(String msg)
         {
            System.out.printf("Listener 1 received %s\n", msg);
            latch.countDown();
         }
      });

      eventBus.register(new Consumer<Integer>()
      {
         @Subscribe @Override public void accept(Integer msg)
         {
            System.out.printf("Listener 2 received %d\n", msg);
            latch.countDown();
         }
         @Subscribe public void accept(String msg)
         {
            System.out.printf("Listener 2 subscriber 2 %s\n", msg);
            latch.countDown();
         }
      });

      executor.execute(() -> {
         for(int count = 0; ; count++)
         {
            if(count > 0)
            {
               try
               {
                  if(latch.await(1, TimeUnit.SECONDS))
                  {
                     break;
                  }
               }
               catch(InterruptedException e)
               {
               }
            }

            if(count%2 == 0)
            {
               eventBus.post(String.format("%d", count));
            }
            else
            {
               eventBus.post(count);
            }

         }
      });

      latch.await();
      executor.shutdown();
   }
}
