package org.devict.jlib.cluster.agent;

import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;

/**
 * Created by Gary on 10/1/16.
 */
public class AgentMessageReceiver extends ReceiverAdapter
{
   @Override public void receive(Message msg)
   {
      System.out.println(msg.getObject());
   }
}
