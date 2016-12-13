package org.devict.jlib.stdlib;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by developerSid on 12/12/16.
 *
 * Demnonstrates some useful things that can be parsed out of a URI using the java.net.URI class
 */
public class ExampleURI
{
   public static void main(String[] args) throws URISyntaxException
   {
      URI google = new URI("http://www.google.com/find?search=BMW");

      System.out.printf("Protocol: %s Host: %s Authority: %s Path: %s Query: %s\n", google.getScheme(), google.getHost(), google.getAuthority(), google.getPath(), google.getQuery());

      URI zookeeper = new URI("zk://192.168.1.1:2181,192.168.1.2:2181/root");

      System.out.printf("Protocol: %s  Authority: %s Path: %s\n", zookeeper.getScheme(), zookeeper.getAuthority(), zookeeper.getPath());

   }
}
