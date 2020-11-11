package rc.springbootmongodbdemo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rc.springbootmongodbdemo.Entities.Hotel;
import rc.springbootmongodbdemo.Entities.hsideReservation;

import java.util.Collection;
import java.util.Optional;

@Component
public class HotelDAO {
    @Autowired
    private HotelRepository repository;

    public Hotel createHotel(Hotel newHotel) {
        return repository.insert(newHotel);
    }

    public Collection<hsideReservation> hotelDeleteReservation(int hotel_id, hsideReservation intendedReservation){
        Optional<Hotel> hotel = repository.findById(hotel_id);
        if(hotel.isPresent()){
            hotel.get().deleteReservation(intendedReservation);
            repository.save(hotel.get());
            return hotel.get().getHotelSideReservations();
        }
        else{
            System.out.println("Hotel is not registered");
            return null;
        }
    }

    public Collection<hsideReservation> newResforHotel(int hotelId, hsideReservation newReservation){
        Optional<Hotel> thisHotel = repository.findById(hotelId);
        if(thisHotel.isPresent()){
            System.out.println("Before:");
            System.out.println(thisHotel.get().getHotelSideReservations().size());
            thisHotel.get().addReservation(newReservation);
            System.out.println("After:");
            System.out.println(thisHotel.get().getHotelSideReservations().size());
            repository.save(thisHotel.get());
            return thisHotel.get().getHotelSideReservations();
        }
        else return null;
    }

}
