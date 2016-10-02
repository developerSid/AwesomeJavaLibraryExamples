package org.devict.jlib.cluster.agent;

import org.jgroups.JChannel;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Gary on 10/1/16.
 *
 * JGroups cluster receiver that listens for messages from the main server
 */
public final class JClusterAgent
{
   public static void main(String[] args) throws Exception
   {
      JChannel channel = new JChannel();
      CountDownLatch latch = new CountDownLatch(1); //using this to put the main thread to sleep while we receive messages

      try
      {
         channel.connect("devict.test.channel");
         channel.receiver(new AgentMessageReceiver());
         Runtime.getRuntime().addShutdownHook(new Thread(latch::countDown)); //this is the cheap Java way to listen for sigkill
         latch.await();
      }
      finally
      {
         channel.close();
      }
   }
}
