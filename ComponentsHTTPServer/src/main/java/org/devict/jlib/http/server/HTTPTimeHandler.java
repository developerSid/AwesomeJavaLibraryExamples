package org.devict.jlib.http.server;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.nio.protocol.*;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Gary on 10/9/16.
 */
public class HTTPTimeHandler implements HttpAsyncRequestHandler<HttpRequest>
{
   @Override public HttpAsyncRequestConsumer<HttpRequest> processRequest(HttpRequest request, HttpContext context) throws HttpException, IOException
   {
      return new BasicAsyncRequestConsumer(); //simple in memory buffer
   }

   @Override public void handle(HttpRequest request, HttpAsyncExchange httpExchange, HttpContext context) throws HttpException, IOException
   {
      HttpResponse response = httpExchange.getResponse();

      if(request.getRequestLine().getMethod().equalsIgnoreCase("GET"))
      {
         response.setStatusCode(HttpStatus.SC_OK);
         response.setHeader("Content-Type", "text/plain");
         response.setEntity(new StringEntity(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
      }
      else
      {
         response.setStatusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
      }

      httpExchange.submitResponse(new BasicAsyncResponseProducer(response));
   }
}
