package Logger;

import Logger.Enums.LogLevel;
import Logger.appenders.ConsoleAppender;
import Logger.appenders.FileAppender;
import Logger.formatter.JsonFormatter;
import Logger.formatter.PlainTextFormatter;

public class main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.INFO,
                new ConsoleAppender(new PlainTextFormatter())
        );
//
        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.DEBUG,
                new FileAppender(new JsonFormatter(), "log.json")
        );
//
        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.ERROR,
                new FileAppender(new JsonFormatter(), "log.json")
        );

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.ERROR,
                new ConsoleAppender(new PlainTextFormatter())
        );


//        logger.info("Hello World!");
//        logger.debug("Debug Message");
        logger.error("Error Message");
    }
}
