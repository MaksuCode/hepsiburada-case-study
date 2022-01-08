package testlogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple log4j logger class
 */
public class Log {

    static Logger logger = LogManager.getLogger();

    public void info(String message){
        logger.info(message);
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void error(String message){
        logger.error(message);
    }

}