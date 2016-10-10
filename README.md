# The Java Library System
Have you ever been sitting there writing your own PDF generation code and find yourself 
hoping that someone doesn't move that image you need to embed in every file you generate 
from its required location on the network share?  Well never fear the Java library 
ecosystem is here to save you from that worry and thousands of others just like it.  The 
greatest thing about the Java Platform is the plethora of open source code at your 
fingertips maintained by armies of great people who only want to make your life easier.  
If you are lazy like me you'll love the Java Library Ecosystem.


## [Difference between a library and a framework](http://www.programcreek.com/2011/09/what-is-the-difference-between-a-java-library-and-a-framework/, "Difference between a library and a framework")
> The key difference between a library and a framework is "Inversion of Control". When you 
call a method from a library, you are in control. But with a framework, the control is 
inverted: the framework calls you.

The above quote sums up the idea of these examples quite well.  I was originally going 
to include Spring and JUnit in these examples, but upon further reflection that while they
are provided as library jars like everything else in the Java world they aren't strictly
what I would consider a library.  Logging is probably not exactly a library based on this
definition, but since all the calls to do work are via calls pragmatically to log some
message to an output it is less of a framework.

## Getting started
The project uses Gradle for it's builds to simplify dependency (library) management 
as well as quick and easy JAR creation for running the examples.  It does in my 
opinion abuse what you should use the Gradle multi-project support so please do not
do this with a production system.

1. Clone this project
   1. git clone https://github.com/developerSid/AwesomeJavaLibraryExamples.git
1. Change directory to the one created by the clone
   1. cd AwesomeJavaLibraryExamples
1. Build projects
   1. ./gradlew clean build
      *  This builds an uberjar for all the projects to make it easy to run the examples. 
      Normally this is something that would be handled by other Gradle plugins or you'd build a 
      classpath containing all the libraries you need. So please do not use this in production,
      instead use the Spring-boot Gradle plugin
 

## [Apache Commons](https://commons.apache.org/ "Apache Commons Proper")

Apache Commons is broken up into three parts
1. Apache Commons Proper
   1. "A repository of reusable Java components"
   1. Projects here are kept up to date and have continuing development and support.
1. Apache Commons Sandbox
   1. "A workspace for Java component development"
   1. Newer development happens here for projects that hope to one day make it into Proper
   1. May or may not be maintained anymore
1. Apache Commons Dormant
   1. "A repository of components that are currently inactive"
   1. Basically dead no longer maintained code that you can still use, but you will be on
   your own supporting it.  At least it is open source so if there is something you can
   use to bootstrap something you are working on you can always fork and maintain yourself

Root of Apache Commons Proper.  There are many sub projects here that are currently
maintained and are usually meant to solve a single problem that is reusable within your projects.
### [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/ "Apache Commons Lang")
* Apache Commons Lang - The Stuff nobody on the JCP thought should be in the standard 
library (because they don't actually have to write business logic in Java)
  * StringUtils - org.apache.commons.lang3.StringUtils
    * You should use this when
      * Avoid null checks in your code
      * Do simple String operations you do a lot of with less code
        * Strip
        * Chomp/Chop
        * Padding
        * [many others](https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html)
    * To run the examples (./gradlew clean build)
      1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.ExampleStdlibStringUtilsSolution
         1. will throw a NullPointerException
      1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.ExampleStringUtils
         1. Won't throw a NullPointerException
  * SystemUtils - shortcuts for getting information about the system or the JVM that is running your application
    1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.ExampleSystemUtils
  * WordUtils - Word based formatting of strings
    1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.text.ExampleWordUtils
  * StrBuilder - StringBuilder/StringBuffer replacement
    1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.text.ExampleStrBuilder
  * Tuples - Simple pair and triple generic containers
    1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.tuple.ExampleTriple
### [Apache Commons Collections](https://commons.apache.org/proper/commons-collections/ "Apache Commons Collections")
* Apache Commons Collections - Yet more things the Java Standard Library's collections should provide, but doesn't.
(However they have added a bunch of stuff inspired by this library over the years see java.util.Collections)
  * CollectionUtils - helpful utility methods for dealing with collections
    1. java -cp Collections/build/libs/Collections.jar org.devict.jlib.collections.ExampleCollectionUtils
    1. java -cp Collections/build/libs/Collections.jar org.devict.jlib.collections.ExampleCaseInsensitiveMap
    1. java -cp Collections/build/libs/Collections.jar org.devict.jlib.collections.ExampleCollectionUtils
    1. java -cp Collections/build/libs/Collections.jar org.devict.jlib.collections.ExampleMultiValueMap
    1. java -cp Collections/build/libs/Collections.jar org.devict.jlib.collections.ExampleNonNullCaseInsensitiveMap

### [Apache Commons IO](https://commons.apache.org/proper/io "Apache Commons IO")
* More useful stuff that is missing from the Java standard libary.  (However this too is less useful if you are using java 8 and NIO 2)

To Run
1. java -cp IO/build/libs/IO.jar org.devict.io.ExampleIO

## [Apache Avro](https://avro.apache.org/ "Schema based Data Serialization")
Apache Avro is very similar to Google's Protocol buffers, however it's main advantage is that it sends the schema
the data was encoded with along with the message making it easier to evolve the schema over time.  This is useful
when building distributed systems using messaging middleware like Apache Kafka. When used with a Schema server
you can build flexible processing systems that aren't as tightly coupled as they would be if you just shared a library
of data classes for each application.  Meaning you can upgrade applications slowly allowing for different teams to
build separate parts of the system without perfect knowledge of the other applications.

The example provided here isn't as clear cut as the others because I wanted to show changing the schema slightly.

To Run

1. java -cp Avro/build/libs/Avro.jar org.devict.jlib.avro.ExampleAvroWrite > out.avro #write with an older schema to out.avro
   1. This program uses the "newer" AdvancedEmployee schema to encode the message
1. java -cp Avro/build/libs/Avro.jar org.devict.jlib.avro.ExampleAvroRead < out.avro #read with a newer schema from out.avro
   1. This program uses the "older" Employee schema to decode the message
* Your Other option is to use the unix way of doing applications you can run
  * java -cp Avro/build/libs/Avro.jar org.devict.jlib.avro.ExampleAvroWrite | java -cp Avro/build/libs/Avro.jar org.devict.jlib.avro.ExampleAvroRead

## [Apache HTTP Components](http://hc.apache.org "Components for communicating via HTTP")

### An HTTP server that responds to any request with the time.
1. java -cp ComponentsHTTPServer/build/libs/ComponentsHTTPServer.jar org.devict.jlib.http.server.HTTPServer
1. curl -v -XGET http://localhost:8080/

### An HTTP client that requests from a the above server and displays the time.
1. java -cp ComponentsHTTPClient/build/libs/ComponentsHTTPClient.jar org.devict.jlib.http.client.HTTPClient
   1. make sure you are running the above server

## [Logback](http://logback.qos.ch, "Logback Logging Library")
This is the logging library I prefer right now primarily because it allows for configuration through
Groovy and implements the Slf4j (simple logging facade for java) natively.

* ExampleLogback
  * Logs to stdout and to /tmp/log/LogbackExample/LogbackExample.log
  * Logging is configured to roll once per day
    * can be configured to roll on size also (as well as other custom methods)

To run the example

1. java -Dlog.dir=/tmp/LogbackExample -cp Logback/build/libs/Logback.jar org.devict.jlib.logback.ExampleLogback
   1. Note: -D is setting a Java system property (kind of like an environment variable, but only one that the JVM cares about)
   1. The log.dir system property is optional as the logging configuration does have a default.  In this case /tmp/log, if you are on Windows this will blow up
   you should change it to something else if you are using Windows to run this example.

## [JGroups clustering](http://www.jgroups.org "JGroups clustering")
  JGroups is a toolkit for reliable messaging. It can be used to create clusters whose nodes can send messages to each other.
### JGroups Example
    Terminalogy 
    - Handler: The server that will broadcast messages to listening nodes throughout the cluster
    - Agent: The node within the cluster that is listening for messages
* JGroupsHandler
  * Broadcasts a message received from the command line and passes it to the cluster
* JGroupsAgent
  * Receives messages from the main cluster server
  
To run the examples run these commands in 3 separate console windows

1. java -Djava.net.preferIPv4Stack=true -cp JGroups/build/libs/JGroups.jar org.devict.jlib.cluster.JClusterHandler
1. java -Djava.net.preferIPv4Stack=true -cp JGroups/build/libs/JGroups.jar org.devict.jlib.cluster.JClusterAgent 
1. java -Djava.net.preferIPv4Stack=true -cp JGroups/build/libs/JGroups.jar org.devict.jlib.cluster.JClusterAgent

### JGroups Example Notes:  
This JGroups structure is not the only option, but is just an illustration of how easy it is 
to build simple broadcast/receiving messages.

The example uses the default cluster configuration which is UDP.  This may not scale as far 
as you may need, and may not cross collision domains, depends on how your network is configured.

## [Apache HTTP Components Server](https://hc.apache.org "Embeddable Asynchronous HTTP Server")
  HTTP Components is a collection of what you could call basic HTTP building blocks for building up larger HTTP based communications systems. AKA 
  embedded HTTP Servers and clients.
  
 
