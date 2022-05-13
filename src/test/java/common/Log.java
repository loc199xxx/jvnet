package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
    // Ham khoi tao Log
    private static final Logger Log =  LogManager.getLogger(Log.class);

    // Ham ghi log INFO
    public static void info (String message) {
        Log.info(message);
    }

    // Ham ghi log WARN
    public static void warn (String message) {
        Log.warn(message);
    }
    public static void warn (Object object) {
        Log.warn(object);
    }

    // Ham ghi log Error
    public static void error (String message) {
        Log.error(message);
    }
    public static void error (Object object) {
        Log.error(object);
    }

    // Ham ghi log DEBUG
    public static void debug (String message) {
        Log.debug(message);
    }
    public static void debug (Object object) {
        Log.debug(object);
    }
}
