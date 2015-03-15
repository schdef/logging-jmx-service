# logging-jmx-service
Automatically exported from code.google.com/p/logging-jmx-service

# Short description
JMX bean which provides the functionality to change the log level of a class/package and to reload the log4j.properties during runtime.

# Introduction
I was facing the problem to change {{{log4j.properties}}} settings of classes/categories during runtime of an application. Additionally I wanted to have also the possibility to reset/reload the settings again like they was before. After studying log4j documentation I couldn't find only a half solution materialized as an jmx bean (http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/jmx/package-summary.html). After deeper google search for this issue, I found several hints how to solve this issue, which I would like to combine here.

# Details
Current Version: 1.1.2 (03.12.2014)

Downloads are now available at: https://drive.google.com/folderview?id=0B7nl6Gg9GTWhQ1JPRTBuTTdHdTQ&usp=sharing

## Requirements
   * Java SUN JDK 1.5 - http://java.sun.com/javase/downloads/index_jdk5.jsp
   * Apache log4j >= 1.2.15 - http://logging.apache.org/log4j/
   * Maven2 2.0.x - http://maven.apache.org/
   * Spring >= 2.5 - http://www.springsource.org/

## Functionality
All functionalities are grouped in the interface http://code.google.com/p/logging-jmx-service/source/browse/trunk/logjmxservice/src/main/java/de/stefanheintz/log/jmxservice/LoggingConfig.java of the JMX MBean http://code.google.com/p/logging-jmx-service/source/browse/trunk/logjmxservice/src/main/java/de/stefanheintz/log/jmxservice/LoggingConfigImpl.java:
   * setting of _TRACE_, _DEBUG_, _INFO_, _WARN_, _ERROR_, _FATAL_ log levels for a class or category
   * disabling of logging of a class or category
   * show runtime *log4j* settings
   * reload the *log4j.properties* settings from classpath

Short demonstration: 
<iframe width="425" height="344" src="https://www.youtube.com/embed/03tIigdKSFM" frameborder="0" allowfullscreen></iframe>

More details are available at the [Tutorial] page.

# Version history
| Version | Date | Descritpion |
| --------|------|-------------|
|1.1.1|2009-05-10|Small NPE bug fixing for changing log level of a class having no log level yet|
|1.1.0|2009-02-10|Sending notifications whenever a log level change or reloading was triggered|
|1.0.0|2009-01-04|First implementation including setting of log levels and reloading of the log4j.properties|

# References
   * Monitoring and Management Using JMX:
      * See page http://java.sun.com/j2se/1.5.0/docs/guide/management/agent.html
      * Article about *jconsole* http://java.sun.com/developer/technicalArticles/J2SE/jconsole.html
   * JMX bean export
      * An easy way to expose jmx beans is with spring. See details at http://static.springframework.org/spring/docs/2.0.x/reference/jmx.html
   * Reload of log4j properties:
      * See very helpful hint at page http://www.bright-green.com/blog/2003_10_28/how_to_re_read_log4jproperties.html  
      
