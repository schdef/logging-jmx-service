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

import org.apache.log4j.Level;

public interface LoggingConfig {

	/**
	 * 
	 * @param filter returns only loggers, which contain the filter string
	 * @return all available loggers
	 */
	public String[] getLoggers(String filter);
	
	/**
	 * assigns the {@link Level#INFO} to the given class
	 * @param target the FQCN of the class
	 */
	public void assignInfoLevel(String target);

	/**
	 * assigns the {@link Level#WARN} to the given class
	 * @param target the FQCN of the class
	 */
	public void assignWarnLevel(String target);

	/**
	 * assigns the {@link Level#ERROR} to the given class
	 * @param target the FQCN of the class
	 */
	public void assignErrorLevel(String target);

	/**
	 * assigns the {@link Level#DEBUG} to the given class
	 * @param target the FQCN of the class
	 */
	public void assignDebug(String target);
	
	/**
	 * assigns the {@link Level#FATAL} to the given class
	 * @param target the FQCN of the class
	 */
	public void assignFatalLevel(String target);
	
	/**
	 * assigns the {@link Level#TRACE} to the given class
	 * @param target the FQCN of the class
	 */
	public void assignTraceLevel(String target);
	
	/**
	 * deactivates the logging of the given class
	 * @param target the FQCN of the class
	 */
	public void deactivateLogging(String target);
	
	/**
	 * reloads the log4j configuration from the <code>log4j.properties</code> file in the classpath 
	 */
	public void resetConfiguration();

	/**
	 * 
	 * @return the log4j configuration from the <code>log4j.properties</code> file in the classpath 
	 */
	public String printLog4jConfig();
}
