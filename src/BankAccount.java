public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    protected String getAccountNumber() {
        return accountNumber;
    }

    protected double getBalance() {
        return balance;
    }

    abstract boolean deposit(double amount);
    abstract boolean withdraw(double amount);
}
