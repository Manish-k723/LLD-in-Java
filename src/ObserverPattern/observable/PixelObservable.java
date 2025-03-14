package ObserverPattern.observable;

import ObserverPattern.observers.NotificationAlertObservers;

import java.util.ArrayList;
import java.util.List;

public class PixelObservable implements StocksObservable {

    List<NotificationAlertObservers> observers = new ArrayList<>();
    private int itemCount = 0;
    @Override
    public void addObserver(NotificationAlertObservers observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(NotificationAlertObservers observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObservers observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setData(int newStockCount) {
        itemCount = newStockCount + itemCount;
        if(newStockCount > 0) {
            notifyObservers();
        }
    }

    @Override
    public int getData() {
        return itemCount;
    }
}
