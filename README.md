# The Java Library System
Have you ever been sitting there writing your own PDF generation code and find yourself hoping that someone doesn't move that image you need to embed in every file you generate from its required location on the network share?  Well never fear the Java library ecosystem is here to save you from that worry and thousands of others just like it.  The greatest thing about the Java Platform is the plethora of open source code at your fingertips maintained by armies of great people who only want to make your life easier.  If you are lazy like me you'll love the Java Library Ecosystem.


## Getting started
1. Clone this project
   1. git clone https://github.com/developerSid/DevICTJavaLibraries.git
1. Change directory to the one creaated by the clone
   1. cd DevICTJavaLibraries
1. Build projects
   1. ./gradlew clean build
      *  This builds an uberjar for all the projects to make it easy to run the examples. Normally this is something that would be handled by other Gradle plugins or you'd build a classpath containing all the libraries you need. 
 

## [Apache Commons](https://commons.apache.org/components.html, "Apache Commons Proper")
Root of Apache Commons Proper.  There are many sub projects here that are currently maintained and are usually meant to solve a single problem that is reusable within your projects.
### [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/, "Apache Commons Lang")
* Apache Commons Lang - The Stuff nobody on the JCP thought should be in the standard library (because they don't actually have to write business logic in Java)
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
      1. java -cp Lang/build/libs/Lang.jar org.devict.jlib.lang.ExampleStringUtils

## [JGroups clustering](http://www.jgroups.org "JGroups clustering")
  JGroups is a toolkit for reliable messaging. It can be used to create clusters whose nodes can send messages to each other.
### JGroups Example
    Terminalogy 
    - Handler: The server that will broadcast messages to listening nodes throughout the cluster
    - Agent: The node within the cluster that is listening for messages
* JGroupsHandler
  * Broadcasts a messge received from the command line and passes it to the cluster
* JGroupsAgent
  * Receives messages from the main cluster server
  
To run the examples run these commands in 3 separate console windows
1. java -Djava.net.preferIPv4Stack=true -cp JGroupsHandler/build/libs/JGroupsHandler.jar org.devict.jlib.cluster.handler.JClusterHandler
1. java -Djava.net.preferIPv4Stack=true -cp JGroupsAgent/build/libs/JGroupsAgent.jar org.devict.jlib.cluster.agent.JClusterAgent 
1. java -Djava.net.preferIPv4Stack=true -cp JGroupsAgent/build/libs/JGroupsAgent.jar org.devict.jlib.cluster.agent.JClusterAgent

Notes:  
This JGroups structure is not the only option, but is just an illustration of how easy it is to build simple broadcast/receiving messages.
The example uses the default cluster configuration which is UDP.  This may not scale as far as you may need, and may not cross collision domains, depends on how your network is configured.
 
 