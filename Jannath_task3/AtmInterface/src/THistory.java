import java.util.ArrayList;

public class THistory {

    private ArrayList<Transaction> transactions;

    public THistory() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void displayHistory() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n----- Transaction History -----");

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
