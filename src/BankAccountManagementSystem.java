import java.util.Scanner;

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        InputUtils inputUtils = new InputUtils();
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("options: ");
            System.out.println("1. create account.");
            System.out.println("2. deposit money.");
            System.out.println("3. withdraw money.");
            System.out.println("4. check balance.");
            System.out.println("5. exit.");

            int option = inputUtils.GetOption(5);

            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("what kind of account?");
                    System.out.println("1. savings.");
                    System.out.println("2. current.");
                    int accountOption = inputUtils.GetOption(2);

                    switch (accountOption) {
                        case 0:
                            System.out.println("try again.");
                            break;
                        case 1:
                            bankService.createSavingAccount();
                            break;
                        case 2:
                            bankService.createCurrentAccount();
                            break;
                    }
                    scanner.nextLine();
                    break;
                case 2:
                    bankService.depositAmount();
                    scanner.nextLine();
                    break;
                case 3:
                    bankService.withdrawAmount();
                    scanner.nextLine();
                    break;
                case 4:
                    bankService.checkBalance();
                    scanner.nextLine();
                    break;
                case 5:
                    System.exit(0);
            }

        }
    }
}
