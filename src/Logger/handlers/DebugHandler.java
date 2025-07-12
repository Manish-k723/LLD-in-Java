package Logger.handlers;

import Logger.Enums.LogLevel;
import Logger.Logger;
import Logger.models.LogMessage;

public class DebugHandler extends LogHandler{

    @Override
    protected boolean canHandle(LogLevel level){
        System.out.println("DebugHandler.canHandle");
        return LogLevel.DEBUG.equals(level);
    }
}
