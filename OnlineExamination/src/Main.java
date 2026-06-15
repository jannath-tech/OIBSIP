import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("jannath", "1234", "Jannath Hussain");

        System.out.println("======================================");
System.out.println("Stanley College of Engineering");
System.out.println("ONLINE EXAMINATION SYSTEM");
System.out.println("======================================");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!user.login(username, password)) {
            System.out.println("Invalid Login!");
             sc.close();
            return;
        }

        System.out.println("\nLogin Successful!");
        System.out.println("Welcome " + user.getName());

        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Update Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    user.updateProfile(newName);
                    break;

                case 2:
                    System.out.print("Enter New Password: ");
                    String newPass = sc.nextLine();
                    user.changePassword(newPass);
                    break;

                case 3:
                    Exam exam = new Exam();
                    exam.startExam();
                    break;

                case 4:
                    System.out.println("Logged Out Successfully!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
