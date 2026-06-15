import java.util.Scanner;

public class ATM {

    private User user;
    private Account account;
    private THistory history;

    public ATM(User user, Account account) {
        this.user = user;
        this.account = account;
        this.history = new THistory();
    }

    public void start() {
        System.out.println("Welcome " + user.getUserId());

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("=================================");
            System.out.println("      JH ATM SYSTEM");
            System.out.println("=================================");
            System.out.println("===== ATM LOGIN =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Transaction History");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Quit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

             switch(choice) {

    case 1:
        System.out.println("Current Balance: ₹" +
                           account.getBalance());
        break;

    case 2:
        history.displayHistory();
        break;

    case 3:
        withdraw(sc);
        break;

    case 4:
        deposit(sc);
        break;

    case 5:
        transfer(sc);
        break;

    case 6:
        System.out.println("Thank you for using JH ATM.");
        return;

    default:
        System.out.println("Invalid Choice!");
}
        }
    }

    private void withdraw(Scanner sc) {

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            history.addTransaction(
                    new Transaction("Withdraw", amount));
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    private void deposit(Scanner sc) {

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        account.deposit(amount);

        history.addTransaction(
                new Transaction("Deposit", amount));

        System.out.println("Deposit Successful");
    }

    private void transfer(Scanner sc) {

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {

            history.addTransaction(
                    new Transaction("Transfer", amount));

            System.out.println("Transfer Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}
