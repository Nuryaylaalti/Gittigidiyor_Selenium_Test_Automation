package com.gittigidiyor.test.automation.model;

import org.apache.log4j.Logger;

public class Log {

    private static Logger logger = Logger.getLogger(Log.class.getName());

    //Info
    public static void info (String message) {
        logger.info(message);
    }

    //Warn
    public static void warn (String message) {
        logger.warn(message);
    }

    //Error
    public static void error (String message) {
        logger.error(message);
    }

    //Fatal
    public static void fatal (String message) {
        logger.fatal(message);
    }

    //Debug
    public static void debug (String message) {
        logger.debug(message);
    }

}
