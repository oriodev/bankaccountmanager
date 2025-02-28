import java.util.ArrayList;
import java.util.Scanner;

public class InputUtils {

    private Scanner scanner = new Scanner(System.in);

    public int GetOption(int max) {
        int optionInput = 0;

        try {
            System.out.print("enter >> ");
            optionInput = scanner.nextInt();

            if (optionInput > max || optionInput < 0) {
                optionInput = 0;
            }
        } catch (Exception e) {
            System.out.println("invalid option.");
        } finally {
            scanner.nextLine();
        }

        return optionInput;
    }

    public String GetAccountNumber(ArrayList<BankAccount> accounts) {
        String accountNumber = "";

        while (accountNumber.isEmpty()) {
            try {
                System.out.print("enter 6 digit account number >> ");
                accountNumber = scanner.nextLine();

                if (accountNumber.length() != 6) {
                    System.out.println("invalid account number. press e to exit.");
                    accountNumber = "";
                }

                if (!isAccountNumberUnique(accountNumber, accounts)) {
                    System.out.println("account number must be unique");
                    accountNumber = "";
                }


            } catch (Exception e) {
                System.out.println("invalid account number. press e to exit.");
                accountNumber = "";
            }
        }
        return accountNumber;
    }

    public String RecallAccountNumber(ArrayList<BankAccount> accounts) {
        String accountNumber = "";

        while (accountNumber.isEmpty()) {
            try {
                System.out.print("enter 6 digit account number >> ");
                accountNumber = scanner.nextLine();

                if (accountNumber.length() != 6) {
                    System.out.println("invalid account number.");
                    accountNumber = "";
                }

                if (isAccountNumberUnique(accountNumber, accounts)) {
                    System.out.println("account number does not exist.");
                    accountNumber = "";
                }

            } catch (Exception e) {
                System.out.println("invalid account number");
                accountNumber = "";
            }
        }
        return accountNumber;
    }

    public double GetAmount() {
        double amount = 0;

        try {
            System.out.print("enter amount >> ");
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("invalid amount");
            amount = 0;
        } finally {
            scanner.nextLine();
        }

        return amount;
    }

    public boolean isAccountNumberUnique(String accountNumber, ArrayList<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return false;
            }
        }
        return true;
    }
}

