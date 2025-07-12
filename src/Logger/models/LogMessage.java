package Logger.models;

import Logger.Enums.LogLevel;


public class LogMessage {
    public LogMessage(LogLevel level, String message, long timestamp) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    private LogLevel level;
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    private long timestamp;

    public String getMessage() {
        return message;
    }
}
