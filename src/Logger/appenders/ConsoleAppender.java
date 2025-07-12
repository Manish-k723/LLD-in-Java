package Logger.appenders;

import Logger.formatter.LogFormatter;
import Logger.models.LogMessage;

public class ConsoleAppender implements LogAppender{
    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message){
        System.out.println(formatter.format(message));
    }
}
