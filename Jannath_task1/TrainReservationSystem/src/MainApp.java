import java.util.*;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();
    static long pnrCounter = 1000000000L;
    static User loggedInUser = null;
    static Map<String, String> trains = new HashMap<>();

    public static void main(String[] args) {
        // Setup users
        users.add(new User("admin", "1234", "ADMIN"));
        users.add(new User("user1", "pass1", "USER"));

        // Setup trains
        trains.put("12301", "Goa Express");
        trains.put("12302", "Lonavla Express");
        trains.put("12951", "Vizag Express");
        trains.put("12002", "Mysore Express");
        trains.put("22691", "Coorg Express");
        trains.put("12259", "Srisailam Express");
        trains.put("12649", "Karnataka Sampark Kranti");
        trains.put("11301", "Bidar Express");
        trains.put("12627", "Vijaywada Express");
        trains.put("12839", "Warangal Express");

        System.out.println("==========================================");
System.out.println("   Heavenese's Train Reservation System  ");
System.out.println("   Developed by: JANNATH HUSSAIN          ");
System.out.println("   Roll No: 160623740303 |  Stanley College og Engineering and technology for women    ");
System.out.println("==========================================");

        loginModule();
    }

    // ── MODULE 1: LOGIN ──────────────────────────────
    static void loginModule() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.println("\n--- LOGIN (Attempt " + attempt + " of 3) ---");
            System.out.print("Login ID : "); String id = sc.nextLine().trim();
            System.out.print("Password : "); String pw = sc.nextLine().trim();

            for (User u : users) {
                if (u.loginId.equals(id) && u.password.equals(pw)) {
                    loggedInUser = u;
                    System.out.println("Login successful! Welcome aboard, " + id);
                    mainMenu();
                    return;
                }
            }
            System.out.println("Oops Wrong Credentials. Try again.");
        }
        System.out.println("Too many failed attempts. Exiting.");
    }

    // ── MAIN MENU ────────────────────────────────────
    static void mainMenu() {
        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. New Reservation");
            System.out.println("2. Cancellation of Ticket");
            System.out.println("3. View All Reservations");
            System.out.println("4. View Available Trains");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");
            String c = sc.nextLine().trim();

            if (c.equals("1"))      reservationModule();
            else if (c.equals("2")) cancellationModule();
            else if (c.equals("3")) viewAll();
            else if (c.equals("4")) viewTrains();
            else if (c.equals("5")) { loggedInUser = null; System.out.println("Logged out."); loginModule(); return; }
            else if (c.equals("6")) { System.out.println("Thank you. Goodbye!"); System.exit(0); }
            else System.out.println("Invalid choice. Enter 1 to 6.");
        }
    }

    // ── MODULE 2: RESERVATION ────────────────────────
    static void reservationModule() {
        System.out.println("\n--- NEW RESERVATION FORM ---");

        System.out.print("Passenger Name       : "); String name = sc.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Name cannot be empty."); return; }

        System.out.print("Age                  : ");
        int age;
        try { age = Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { System.out.println("Invalid age."); return; }

        System.out.print("Mobile Number        : "); String mobile = sc.nextLine().trim();
        if (!mobile.matches("\\d{10}")) { System.out.println("Mobile must be 10 digits."); return; }

        System.out.println("ID Proof Type:");
        System.out.println("  1. Aadhar Card  2. Passport  3. Voter ID  4. Driving Licence");
        System.out.print("Choose (1-4)         : ");
        String[] idTypes = {"Aadhar Card", "Passport", "Voter ID", "Driving Licence"};
        String idType;
        try { idType = idTypes[Integer.parseInt(sc.nextLine().trim()) - 1]; }
        catch (Exception e) { System.out.println("Invalid choice."); return; }

        System.out.print("Train Number         : "); String trainNo = sc.nextLine().trim();
        String trainName = trains.getOrDefault(trainNo, "Unknown Train");
        System.out.println("Train Name           : " + trainName + "  (auto-filled)");

        System.out.println("Class Type:");
        System.out.println("  1. Sleeper (SL)  2. AC 3 Tier (3A)  3. AC 2 Tier (2A)  4. AC First (1A)  5. General (GN)");
        System.out.print("Choose (1-5)         : ");
        String[] classes = {"Sleeper (SL)", "AC 3 Tier (3A)", "AC 2 Tier (2A)", "AC First Class (1A)", "General (GN)"};
        String classType;
        try { classType = classes[Integer.parseInt(sc.nextLine().trim()) - 1]; }
        catch (Exception e) { System.out.println("Invalid choice."); return; }

        System.out.print("Date of Journey      : ");
        System.out.println("(Format DD/MM/YYYY)");
        System.out.print("Date                 : "); String date = sc.nextLine().trim();
        if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) { System.out.println("Wrong date format. Use DD/MM/YYYY."); return; }

        System.out.print("From Station         : "); String from = sc.nextLine().trim();
        System.out.print("To Station           : "); String to = sc.nextLine().trim();
        if (from.equalsIgnoreCase(to)) { System.out.println("From and To cannot be same."); return; }

        System.out.print("\nPress ENTER to confirm, or type cancel to abort: ");
        if (sc.nextLine().trim().equalsIgnoreCase("cancel")) { System.out.println("Reservation aborted."); return; }

        String pnr = String.valueOf(++pnrCounter);
        reservations.add(new Reservation(pnr, name, age, mobile, idType, trainNo, trainName, classType, date, from, to));
        System.out.println("Reservation confirmed! Your PNR is: " + pnr);
        System.out.println("Please save your PNR number for future use.");
    }

    // ── MODULE 3: CANCELLATION ───────────────────────
    static void cancellationModule() {
        System.out.println("\n--- TICKET CANCELLATION ---");
        System.out.print("Enter PNR Number: "); String pnr = sc.nextLine().trim();

        Reservation found = null;
        for (Reservation r : reservations)
            if (r.pnrNumber.equals(pnr)) { found = r; break; }

        if (found == null) { System.out.println("No reservation found for PNR: " + pnr); return; }

        System.out.println(found);

        if (found.status.equals("CANCELLED")) { System.out.println("This ticket is already cancelled."); return; }

        System.out.print("\nType OK to confirm cancellation: ");
        if (sc.nextLine().trim().equalsIgnoreCase("OK")) {
            found.status = "CANCELLED";
            System.out.println("Ticket cancelled successfully for PNR: " + pnr);
        } else {
            System.out.println("Cancellation aborted. Your ticket is still active.");
        }
    }

    // ── VIEW ALL RESERVATIONS ────────────────────────
    static void viewAll() {
        System.out.println("\n--- ALL RESERVATIONS ---");
        if (reservations.isEmpty()) { System.out.println("No reservations yet."); return; }
        System.out.printf("%-14s %-20s %-8s %-15s %-12s %-10s%n", "PNR", "Name", "Train", "Class", "Date", "Status");
        System.out.println("-".repeat(80));
        for (Reservation r : reservations)
            System.out.printf("%-14s %-20s %-8s %-15s %-12s %-10s%n",
                r.pnrNumber, r.passengerName, r.trainNumber,
                r.classType.split(" ")[0], r.dateOfJourney, r.status);
    }

    // ── VIEW TRAINS ──────────────────────────────────
    static void viewTrains() {
        System.out.println("\n--- AVAILABLE TRAINS ---");
        System.out.printf("%-12s %-35s%n", "Train No.", "Train Name");
        System.out.println("-".repeat(47));
        trains.forEach((no, name) -> System.out.printf("%-12s %-35s%n", no, name));
    }
}
