package Logger.formatter;

import Logger.models.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
