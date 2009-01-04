/*
 * Copyright 2009 Stefan Heintz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.stefanheintz.log.jmxservice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.config.PropertyPrinter;
import org.apache.log4j.spi.LoggerRepository;

public class LoggingConfigImpl implements LoggingConfig {

	public String[] getLoggers(String filter) {
		LoggerRepository r = LogManager.getLoggerRepository();

		Enumeration<Logger> enumList = r.getCurrentLoggers();

		Logger logger = null;
		List<String> resultList = new ArrayList<String>();
		while (enumList.hasMoreElements()) {
			logger = (Logger) enumList.nextElement();
			if (filter == null
					|| (filter != null && logger.getName().contains(filter))) {
				resultList.add(logger.getName());
			}
		}

		return (String[]) resultList.toArray(new String[] {});
	}

	public void assignInfoLevel(String target) {
		assignLogLevel(target, Level.INFO);
	}

	public void assignWarnLevel(String target) {
		assignLogLevel(target, Level.WARN);
	}

	public void assignErrorLevel(String target) {
		assignLogLevel(target, Level.ERROR);
	}

	public void assignDebug(String target) {
		assignLogLevel(target, Level.DEBUG);
	}

	public void assignFatalLevel(String target) {
		assignLogLevel(target, Level.FATAL);
	}

	public void deactivateLogging(String target) {
		assignLogLevel(target, Level.OFF);
	}

	public void assignTraceLevel(String target) {
		assignLogLevel(target, Level.TRACE);
	}
	
	private void assignLogLevel(String target, Level level) {
//		Logger logger = LogManager.exists(target);
//		if(logger != null) {
//			logger.setLevel(level);
//		}
		LogManager.getLogger(target).setLevel(level);
	}
	
	public void resetConfiguration() {
	    LogManager.resetConfiguration();
	    ClassLoader cl = getClass().getClassLoader();
	    URL log4jprops = cl.getResource(
	            "log4j.properties");
	    if (log4jprops != null) {
	        (new PropertyConfigurator())
	                .configure(log4jprops);
	    }
	}
	
	public String printLog4jConfig() {
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    PropertyPrinter pp = new PropertyPrinter(pw);
	    pp.print(pw);
//	    System.out.println(sw.toString());
	    return sw.toString();
	}



}
