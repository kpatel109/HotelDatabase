package rc.springbootmongodbdemo.Entities;

import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.List;

public class Customer {
    @Id
    private int customerId;
    private List<hotelReservations> customerReservations;

    public Integer getCustomerId(){
        return customerId;
    }
    public Collection<hotelReservations> getCustomerReservations(){
        return customerReservations;
    }

    public Collection<hotelReservations> makeReservation(hotelReservations reservation){
        customerReservations.add(reservation);
        return customerReservations;
    }

    public Collection<hotelReservations> updateNewReservation(hotelReservations editedRes){
        for(int i = 0; i < customerReservations.size(); i++){
            if(customerReservations.get(i).getReservationId() == editedRes.getReservationId()){
                customerReservations.get(i).set(editedRes);
                return customerReservations;
            }
        }
        return customerReservations;
        }

    public Collection<hotelReservations> removeReservation(hotelReservations intendedRes){
        for(int i = 0; i < customerReservations.size(); i++){
            if(customerReservations.get(i).getReservationId() == intendedRes.getReservationId()){
                customerReservations.remove(i);
                return customerReservations;
            }
        }
        return customerReservations;
    }

   public String toString(){
        StringBuilder s = new StringBuilder();
        for(hotelReservations h : customerReservations) {
            s.append(h.getDate());
            s.append(" , ");
        }
        return s.toString();
   }
}
