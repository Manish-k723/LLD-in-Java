package ObserverPattern.observable;

import ObserverPattern.observers.NotificationAlertObservers;

import java.util.List;

public class IphoneObservable implements StocksObservable {

    List<IphoneObservable> objlist;
    int temp;
    @Override
    public void addObserver(NotificationAlertObservers observer) {

    }

    @Override
    public void deleteObserver(NotificationAlertObservers observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void setData(int data) {

    }

    @Override
    public int getData() {
        return 0;
    }
}
