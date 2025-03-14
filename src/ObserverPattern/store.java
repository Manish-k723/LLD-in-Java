package ObserverPattern;

import ObserverPattern.observable.PixelObservable;
import ObserverPattern.observable.StocksObservable;
import ObserverPattern.observers.EmailAlertObservers;
import ObserverPattern.observers.NotificationAlertObservers;

public class store {
    public static void main(String[] args) {
        StocksObservable pixelObservable = new PixelObservable();
        NotificationAlertObservers observer1 = new EmailAlertObservers("abc@gmail.com", pixelObservable);
        NotificationAlertObservers observer2 = new EmailAlertObservers("fgh@gmail.com", pixelObservable);

        pixelObservable.addObserver(observer1);
        pixelObservable.addObserver(observer2);

        pixelObservable.setData(0);
    }
}
