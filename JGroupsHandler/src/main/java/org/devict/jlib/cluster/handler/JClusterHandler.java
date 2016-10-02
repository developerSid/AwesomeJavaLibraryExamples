package org.devict.jlib.cluster.handler;

import org.apache.commons.lang3.StringUtils;
import org.jgroups.JChannel;
import org.jgroups.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Gary on 10/1/16.
 */
public final class JClusterHandler
{
   public static void main(String[] args) throws Exception
   {
      JChannel channel = new JChannel();

      try
      {
         channel.connect("devict.test.channel");

         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         System.out.print("> ");

         for(String msg = in.readLine(); !StringUtils.equalsIgnoreCase("QUIT", msg); msg = in.readLine())
         {
            channel.send(new Message(null, null, msg));
            System.out.print("> ");
         }
      }
      finally
      {
         channel.close();
      }
   }
}
