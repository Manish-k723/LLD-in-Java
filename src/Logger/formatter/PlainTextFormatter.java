package Logger.formatter;

import Logger.models.LogMessage;

import java.time.format.DateTimeFormatter;

public class PlainTextFormatter implements LogFormatter {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String format(LogMessage message) {
        return String.format("%s [%s] %s", DATE_TIME_FORMATTER.format(java.time.LocalDateTime.now()), message.getLevel(), message.getMessage());
    }
}
