package ObserverPattern.observable;

import ObserverPattern.observers.NotificationAlertObservers;

public interface StocksObservable {
    public void addObserver(NotificationAlertObservers observer);
    public void deleteObserver(NotificationAlertObservers observer);
    public void notifyObservers();
    public void setData(int data);
    public int getData();
}
