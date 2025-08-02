package ParkingSystem.user;

public abstract class Account {
    private String username;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.status = AccountStatus.ACTIVE;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public abstract boolean resetPassword();
}

enum AccountStatus {
    ACTIVE, BLOCKED, CLOSED
}