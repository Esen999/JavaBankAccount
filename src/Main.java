import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BankAccount acc = new BankAccount("Esen", 500.0, "1234");

        System.out.print("Enter PIN: ");
        String pin = input.nextLine();

        if (!acc.checkPin(pin)) {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        System.out.println("Login successful.");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Numbers only.");
                input.nextLine();
                continue;
            }

            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + acc.getBalance());
                    break;

                case 2:
                    System.out.print("Deposit amount: ");
                    double dep;
                    try {
                        dep = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid amount.");
                        input.nextLine();
                        break;
                    }
                    input.nextLine();
                    acc.deposit(dep);
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    System.out.print("Withdraw amount: ");
                    double wd;
                    try {
                        wd = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid amount.");
                        input.nextLine();
                        break;
                    }
                    input.nextLine();
                    if (acc.withdraw(wd)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 4:
                    System.out.println("Transaction history:");
                    for (String record : acc.getHistory()) {
                        System.out.println(record);
                    }
                    break;

                case 5:
                    System.out.println("Goodbye.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
