package Logger.handlers;

import Logger.Enums.LogLevel;
import Logger.appenders.LogAppender;
import Logger.models.LogMessage;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogHandler {

    private LogHandler next;
    protected final List<LogAppender> appenderList = new CopyOnWriteArrayList<>();

    public void setNext(LogHandler next){
        this.next = next;
    }

    public void subscribers(LogAppender observer){
        appenderList.add(observer);
    }

    public void notifySubscribers(LogMessage message){
        for(LogAppender logAppender: appenderList){
//            appenderList.remove(logAppender);
            logAppender.append(message);
        }
    }

    public void handle(LogMessage message){
        if(canHandle(message.getLevel())){
            notifySubscribers(message);
        }else if(next != null) {
            next.handle(message);
        }
    }


    protected abstract boolean canHandle(LogLevel level);
}
