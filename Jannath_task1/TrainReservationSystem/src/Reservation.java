public class Reservation {
    String pnrNumber, passengerName, mobile, idProofType;
    String trainNumber, trainName, classType, dateOfJourney;
    String fromStation, toStation, status;
    int age;

    public Reservation(String pnr, String name, int age, String mobile,
                       String idType, String trainNo, String trainName,
                       String cls, String date, String from, String to) {
        this.pnrNumber = pnr; this.passengerName = name; this.age = age;
        this.mobile = mobile; this.idProofType = idType;
        this.trainNumber = trainNo; this.trainName = trainName;
        this.classType = cls; this.dateOfJourney = date;
        this.fromStation = from; this.toStation = to;
        this.status = "CONFIRMED";
    }

    public String toString() {
        return "\n  PNR Number     : " + pnrNumber +
               "\n  Passenger Name : " + passengerName +
               "\n  Age            : " + age +
               "\n  Mobile         : " + mobile +
               "\n  ID Proof       : " + idProofType +
               "\n  Train No.      : " + trainNumber +
               "\n  Train Name     : " + trainName +
               "\n  Class          : " + classType +
               "\n  Date of Journey: " + dateOfJourney +
               "\n  From           : " + fromStation +
               "\n  To             : " + toStation +
               "\n  Status         : " + status;
    }
}
