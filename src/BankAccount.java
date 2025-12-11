import java.util.ArrayList;

public class BankAccount {
    private String owner;
    private double balance;
    private String pin;
    private ArrayList<String> history = new ArrayList<>();

    public BankAccount(String owner, double balance, String pin) {
        this.owner = owner;
        this.balance = balance;
        this.pin = pin;
        history.add("Account created with balance: $" + balance);
    }

    public boolean checkPin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        history.add("Deposited: $" + amount + " | New balance: $" + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        history.add("Withdrew: $" + amount + " | New balance: $" + balance);
        return true;
    }

    public ArrayList<String> getHistory() {
        return history;
    }
}
