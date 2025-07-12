package Logger.appenders;

import Logger.formatter.LogFormatter;
import Logger.models.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private final LogFormatter formatter;
    private final BufferedWriter writer;

    public FileAppender(LogFormatter formatter, String fileName) {
        this.formatter = formatter;
        try{
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        }catch (IOException e){
            throw new RuntimeException("Could not initialize FileAppender");
        }

    }

    @Override
    public synchronized void append(LogMessage message) {
        try{
            writer.write(formatter.format(message));
            writer.newLine();
            writer.flush();
        }catch (IOException e){
            throw new RuntimeException("Could not append log message to file");
        }
    }

    public synchronized void close(){
        try{
            writer.close();
        }catch (IOException e){
            throw new RuntimeException("Could not close file");
        }
    }
}
