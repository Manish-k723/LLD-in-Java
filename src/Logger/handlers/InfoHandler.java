package Logger.handlers;

import Logger.Enums.LogLevel;
import Logger.models.LogMessage;

public class InfoHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel level) {
        System.out.println("InfoHandler.canHandle");
        return LogLevel.INFO.equals(level);
    }
}
