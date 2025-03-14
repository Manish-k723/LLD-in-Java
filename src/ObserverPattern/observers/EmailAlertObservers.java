package ObserverPattern.observers;

import ObserverPattern.observable.StocksObservable;

public class EmailAlertObservers implements NotificationAlertObservers {
    String emailId;
    StocksObservable stocksObservable;

    public EmailAlertObservers(String emailId, StocksObservable stocksObservable) {
        this.emailId = emailId;
        this.stocksObservable = stocksObservable;
    }
    @Override
    public void update() {
        sendMailTo(this.emailId);
    }
    public void sendMailTo(String emailId) {
        System.out.println("Email sent to " + emailId);
    }
}
