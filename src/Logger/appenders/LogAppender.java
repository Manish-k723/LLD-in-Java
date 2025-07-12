package Logger.appenders;

import Logger.models.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
