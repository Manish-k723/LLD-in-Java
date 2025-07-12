package Logger;

import Logger.Enums.LogLevel;
import Logger.appenders.LogAppender;
import Logger.handlers.DebugHandler;
import Logger.handlers.ErrorHandler;
import Logger.handlers.InfoHandler;
import Logger.handlers.LogHandler;

public class LogHandlerConfiguration {

    private static final LogHandler debug = new DebugHandler();
    private static final LogHandler info = new InfoHandler();
    private static final LogHandler error = new ErrorHandler();

    public static LogHandler build(){
        debug.setNext(info);
        info.setNext(error);
        return debug;
    }

    public static void addAppenderForLevel(LogLevel level, LogAppender appender){
        switch (level){
            case DEBUG:
                debug.subscribers(appender);
                break;
            case INFO:
                info.subscribers(appender);
                break;
            case ERROR:
                error.subscribers(appender);
                break;
        }
    }
}
