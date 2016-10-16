package org.devict.jlib.http.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Gary on 10/9/16.
 * <p>
 * Simple HTTP client that does a GET request to http://localhost:8080/
 */
public class HTTPClient
{
   public static void main(String[] args) throws IOException
   {
      CloseableHttpClient httpclient = HttpClients.createDefault();

      try
      {
         HttpGet httpget = new HttpGet("http://localhost:8080/");

         System.out.printf("Executing request %s\n", httpget.getRequestLine());

         CloseableHttpResponse responseBody = httpclient.execute(httpget);
         System.out.println("----------------------------------------");
         Arrays.asList(responseBody.getAllHeaders()).forEach(i -> System.out.printf("Header: %s -> %s\n", i.getName(), i.getValue()));
         System.out.printf("\nThe Time is: %s\n", EntityUtils.toString(responseBody.getEntity()));
      }
      finally
      {
         httpclient.close();
      }
   }
}
