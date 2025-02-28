public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (this.balance <= amount) {
            return false;
        }
        this.balance -= amount;
        return true;
    }
}
