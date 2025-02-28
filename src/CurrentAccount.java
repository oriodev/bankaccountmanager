public class CurrentAccount extends BankAccount {
    private double overdraft;
    private double overdraftLimit = 100;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.overdraft = overdraftLimit;
    }

    public double getOverdraft() {
        return this.overdraft;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (overdraft < overdraftLimit) {
            double amountToAddToOverdraft = overdraftLimit - overdraft;
            if (amount >= amountToAddToOverdraft) {
                overdraft += amountToAddToOverdraft;
                amount -= amountToAddToOverdraft;
            } else {
                overdraft += amount;
                return true;
            }
        }

        this.balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }

        if ((this.balance + this.overdraft) >= amount) {
            double amountLeft = amount - this.balance;
            this.balance = 0;
            this.overdraft -= amountLeft;
            return true;
        }

        return false;
    }
}
