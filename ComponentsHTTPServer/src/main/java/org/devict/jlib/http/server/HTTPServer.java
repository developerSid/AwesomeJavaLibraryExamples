package org.devict.jlib.http.server;

import org.apache.http.ExceptionLogger;
import org.apache.http.impl.nio.bootstrap.HttpServer;
import org.apache.http.impl.nio.bootstrap.ServerBootstrap;
import org.apache.http.impl.nio.reactor.IOReactorConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gary on 10/8/16.
 *
 * Asynchronis HTTP Server
 */
public class HTTPServer
{
   private static final int PORT = 8080;

   public static void main(String[] args) throws InterruptedException, IOException
   {
      try
      {
         IOReactorConfig config = IOReactorConfig.custom().setSoTimeout(15000).setTcpNoDelay(true).build();
         final HttpServer server = ServerBootstrap.bootstrap().setListenerPort(PORT).setServerInfo("Test/1.1").setIOReactorConfig(config).setExceptionLogger(ExceptionLogger.STD_ERR).registerHandler("*", new HttpTimeHandler()).create();

         server.start();

         System.out.println("Server started");

         Runtime.getRuntime().addShutdownHook(new Thread()
         {
            @Override public void run()
            {
               System.out.println("Server shutdown requested");
               server.shutdown(5, TimeUnit.SECONDS);
            }
         });

         server.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
      }
      finally
      {
         System.out.println("Server shutdown");
      }
   }
}
