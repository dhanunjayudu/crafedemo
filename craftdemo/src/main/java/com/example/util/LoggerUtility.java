package com.example.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtility {

   /*
    * Logger factory method. We are setting LOG4J properties in log4j.properties
    */
   public static Logger getLogger(@SuppressWarnings("rawtypes") Class c) {
      Logger logger = Logger.getLogger(c);
      PropertyConfigurator.configure("properties/log4j.properties");
      return logger;
   }
}
