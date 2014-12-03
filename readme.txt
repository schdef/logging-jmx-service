Requirements
============
* Java JDK 1.5 - http://java.sun.com/javase/downloads/index_jdk5.jsp
* log4j >= 1.2.15 - http://logging.apache.org/log4j/
* Maven2 2.0.x - http://maven.apache.org/
* Spring 2.5 - http://www.springsource.org/

References
==========
* JMX bean export:
  An easy way to expose jmx beans is with spring. See details at http://static.springframework.org/spring/docs/2.0.x/reference/jmx.html
* Reload of log4j properties:
  See very helpful hint at page http://www.bright-green.com/blog/2003_10_28/how_to_re_read_log4jproperties.html  
* Monitoring and Management Using JMX:
  See page http://java.sun.com/j2se/1.5.0/docs/guide/management/agent.html

Start parameter
===============

To monitor an application, run it with the VM argument: 
-Dcom.sun.management.jmxremote

Default is to be able to access the application with jconsole only locally. If you
would like to monitor it remotely, add following parameters:
-Dcom.sun.management.jmxremote.port=12345
-Dcom.sun.management.jmxremote.authenticate=false
See also details at 

Troubleshooting
===============
If you get the exception 
"The server sockets created using the LocalRMIServerSocketFactory 
only accept connections from clients running on the host where the ...",
try to run the application with the following parameter:
-Dcom.sun.management.jmxremote.local.only=false 