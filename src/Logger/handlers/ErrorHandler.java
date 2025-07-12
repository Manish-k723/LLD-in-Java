package Logger.handlers;

import Logger.Enums.LogLevel;
import Logger.models.LogMessage;

public class ErrorHandler extends LogHandler{

    @Override
    protected boolean canHandle(LogLevel level) {
        System.out.println("ErrorHandler.canHandle");
        return LogLevel.ERROR.equals(level);
    }
}
