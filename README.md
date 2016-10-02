# The Java Library System

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
 > JGroups is a toolkit for reliable messaging. It can be used to create clusters whose nodes can send messages to each other.
### JGroups Example
    Terminalogy 
    - Handler: The server that will broadcast messages to listening nodes throughout the cluster
    - Agent: The node within the cluster that is listening for messages
* JGroupsHandler
  * Broadcasts a messge received from the command line and passes it to the cluster
* JGroupsAgent
  * Receives messages from the main cluster server
 
 