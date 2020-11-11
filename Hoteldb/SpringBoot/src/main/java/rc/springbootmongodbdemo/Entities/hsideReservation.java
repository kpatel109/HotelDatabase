package rc.springbootmongodbdemo.Entities;

public class hsideReservation {
    private int reservationId;
    private int date;
    private int customerId;
    public hsideReservation(int reservationId, int date, int customerId){
        this.reservationId = reservationId;
        this.date = date;
        this.customerId = customerId;
    }
    public int getReservationId(){
        return reservationId;
    }
    public int getDate(){
        return date;
    }
    public int getCustomerId(){
        return customerId;
    }
}
