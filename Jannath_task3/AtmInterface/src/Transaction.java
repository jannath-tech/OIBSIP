import java.time.LocalDateTime;
public class Transaction {
    private LocalDateTime dateTime;
    private String type;
    private double amount;

   public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.dateTime = LocalDateTime.now();
}

    @Override
    public String toString() {
        return dateTime +
       " | " +
       type +
       " : ₹" +
       amount;
    }
}
