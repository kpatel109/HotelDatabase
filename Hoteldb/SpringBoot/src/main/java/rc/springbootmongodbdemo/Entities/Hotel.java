package rc.springbootmongodbdemo.Entities;

import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.List;
public class Hotel {
    @Id
    private int hotelId;
    private String city;
    private List<hsideReservation> hotelSideReservations;

    public String getCity(){
        return city;
    }
    public int getHotelId(){
        return hotelId;
    }
    public Collection<hsideReservation> getHotelSideReservations(){
        return hotelSideReservations;
    }
    public Collection<hsideReservation> addReservation(hsideReservation newReservation){
        hotelSideReservations.add(newReservation);
        return hotelSideReservations;
    }


    public Collection<hsideReservation> deleteReservation(hsideReservation intendedRes) {
        for(int i = 0; i < hotelSideReservations.size(); i++){
            if(hotelSideReservations.get(i).getReservationId() == intendedRes.getReservationId()){
                hotelSideReservations.remove(i);
                return hotelSideReservations;
            }
        }
        return hotelSideReservations;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(hsideReservation h : hotelSideReservations) {
            s.append(h.getDate());
            s.append(" , ");
        }
        return s.toString();
    }

}
