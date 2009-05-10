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

import org.apache.log4j.Logger;

public class TestImpl implements Test {

	private static final Logger logger = Logger.getLogger(TestImpl.class);
	
	public void logAllLogĹevels() {
		while (true) {
			try {
				Thread.currentThread().sleep(500L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			logger.trace("This is the TRACE logging");
			logger.debug("This is the DEBUG logging");
			logger.warn("This is the WARN logging");
			logger.info("This is the INFO logging");
			logger.error("This is the ERROR logging");		
			logger.fatal("This is the FATAL logging");
		}
	}

}
