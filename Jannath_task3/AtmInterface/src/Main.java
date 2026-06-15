import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("12345", "1111");
        Account account = new Account(10000);

        System.out.println("===== ATM LOGIN =====");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (user.getUserId().equals(userId)
                && user.validatePin(pin)) {

            System.out.println("Login Successful!");
            System.out.println("JH ATM Welcomes" + user.getUserId());

            ATM atm = new ATM(user, account);
            atm.start();

        } else {
            System.out.println("Invalid User ID or PIN");
        }
        sc.close();
    }
}
