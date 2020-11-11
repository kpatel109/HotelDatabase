package rc.springbootmongodbdemo.Entities;

import org.springframework.data.annotation.Id;

public class hotelReservations {
    @Id
    private int reservationId;
    private int hotelId;
    private int date;
    public hotelReservations(int reservationId, int hotelId, int date){
        this.reservationId = reservationId;
        this.date = date;
        this.hotelId = hotelId;
    }
    public int getReservationId(){
        return reservationId;
    }
    public int getHotelId(){
        return hotelId;
    }
    public int getDate(){
        return date;
    }
    public void set(hotelReservations newRes){
        this.reservationId = newRes.getReservationId();
        this.hotelId = newRes.getHotelId();
        this.date = newRes.getDate();
    }
}
