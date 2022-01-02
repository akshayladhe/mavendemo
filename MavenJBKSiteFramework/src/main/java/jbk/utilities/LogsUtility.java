package jbk.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogsUtility {
	public Logger pageLog() {
		
		String path = System.getProperty("user.dir") + "/src/main/resources/log4jPage.properties";
		PropertyConfigurator.configure(path);
		Logger logger = Logger.getLogger(this.getClass());
		return logger;
	}
	public Logger testLog() {
		
		String path = System.getProperty("user.dir") + "/src/main/resources/Testlog4j.properties";
		PropertyConfigurator.configure(path);
		Logger logger = Logger.getLogger(this.getClass());
		return logger;
	}
}
