package Logger;

import Logger.Enums.LogLevel;
import Logger.handlers.LogHandler;
import Logger.models.LogMessage;

public class Logger {
    private static final Logger INSTANCE = new Logger();
    private final LogHandler handlerChain;

    private Logger(){
        handlerChain = LogHandlerConfiguration.build();
    }

    public static Logger getInstance(){
        return INSTANCE;
    }

    public void log(LogLevel level, String message){
        LogMessage logMessage = new LogMessage(level, message, System.currentTimeMillis());
        handlerChain.handle(logMessage);
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void info(String message){
        log(LogLevel.INFO, message);
    }
    public void error(String message){
        log(LogLevel.ERROR, message);
    }
}
