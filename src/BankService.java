import java.util.ArrayList;

public class BankService {
    InputUtils inputUtils = new InputUtils();

    public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public void createSavingAccount() {

        String accountNumber = inputUtils.GetAccountNumber(accounts);
        double balance = inputUtils.GetAmount();

        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, balance);
        accounts.add(savingsAccount);

        System.out.println("you have created a new savings account.");
        System.out.println("account number: " + accountNumber);
        System.out.println("starting balance: " + balance);
    }

    public void createCurrentAccount() {

        String accountNumber = inputUtils.GetAccountNumber(accounts);
        double balance = inputUtils.GetAmount();

        CurrentAccount currentAccount = new CurrentAccount(accountNumber, balance);
        accounts.add(currentAccount);

        System.out.println("you have created a new current account.");
        System.out.println("account number: " + accountNumber);
        System.out.println("starting balance: £" + balance);
        System.out.println("overdraft is: £" + 100);
    }

    public BankAccount getBankAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public void depositAmount() {
        String accountNumber = inputUtils.RecallAccountNumber(accounts);

        double amount = inputUtils.GetAmount();

        BankAccount account = getBankAccount(accountNumber);

        account.deposit(amount);

        System.out.println("you have deposited £" + amount + ".");
        System.out.println("your new balance is £" + account.getBalance());
    }

    public void withdrawAmount() {
        String accountNumber = inputUtils.RecallAccountNumber(accounts);

        double amount = inputUtils.GetAmount();

        BankAccount account = getBankAccount(accountNumber);

        boolean withdrawn = account.withdraw(amount);

        if (!withdrawn) {
            System.out.println("you do not have that much in your account.");
        } else {
            System.out.println("you have withdrawn £" + amount + ".");
            System.out.println("your new balance is £" + account.getBalance());
        }
    }

    public void checkBalance() {
        String accountNumber = inputUtils.RecallAccountNumber(accounts);

        BankAccount account = getBankAccount(accountNumber);

        System.out.println("your account balance is £" + account.getBalance());

        if (account instanceof CurrentAccount) {
            System.out.println("your overdraft balance is £" + ((CurrentAccount) account).getOverdraft());
        }
    }


}
