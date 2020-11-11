package rc.springbootmongodbdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.springbootmongodbdemo.DAO.CustomerDAO;
import rc.springbootmongodbdemo.DAO.HotelDAO;
import rc.springbootmongodbdemo.Entities.Customer;
import rc.springbootmongodbdemo.Entities.Hotel;
import rc.springbootmongodbdemo.Entities.hotelReservations;
import rc.springbootmongodbdemo.Entities.hsideReservation;

import java.util.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private CustomerDAO customer;
    @Autowired
    private HotelDAO thisHotel;
    @GetMapping
    public String printHome(){
        return "This is a homescreen B!";
    }
    @GetMapping(value="/{id}")
    //List of customer reservations
    public Collection<hotelReservations> getCustomerReservation(@PathVariable("id") int id){
        return customer.getReservations(id);
    }
    @PostMapping(value="/create")
    public Customer postCustomer(@RequestBody Customer newCustomer){
        return customer.createCustomer(newCustomer);
    }
    @PostMapping(value="/reserve/{id}")
    //Edits reservation to customer[id]
    public Collection<hotelReservations> makeReservation(@PathVariable("id") int id, @RequestBody hotelReservations newReservation){
        System.out.println("Input: " + newReservation.getDate() + ", Id:  " + newReservation.getReservationId() + "    " + newReservation.getHotelId());
        return customer.customerUpdateReservation(id,newReservation);
    }
    @PostMapping(value="/newReserve/{id}")
    public Collection<hotelReservations> makeNewReservation(@PathVariable("id") int customerId, @RequestBody hotelReservations newReservation){
        hsideReservation newRes = new hsideReservation(newReservation.getReservationId(), newReservation.getDate(), customerId);
        thisHotel.newResforHotel(newReservation.getHotelId(), newRes);
        return customer.createNewCustomerReservation(customerId, newReservation);
    }
    @PostMapping(value="/delReserve/{id}")
    public Collection<hotelReservations> delReservation(@PathVariable("id") int customerId, @RequestBody hotelReservations deletingReservation){
        return customer.customerDeleteReservation(customerId, deletingReservation);
    }
    @PostMapping(value="/makeHotel")
    public Hotel makeHotel(@RequestBody Hotel newHotel){
        return thisHotel.createHotel(newHotel);
    }
    @PostMapping(value="/delReserveByHotel/{hotelid}")
    public Collection<hsideReservation> deleteReservationByHotel(@PathVariable("hotelid") int hotelId, @RequestBody hsideReservation intendedReservation){
        hotelReservations deletingReservation = new hotelReservations(intendedReservation.getReservationId(), hotelId, intendedReservation.getDate());
        customer.customerDeleteReservation(intendedReservation.getCustomerId(), deletingReservation);
        return thisHotel.hotelDeleteReservation(hotelId, intendedReservation);
    }
    @PostMapping(value="/test/{hotelId}")
    public Collection<hsideReservation> testAddhotelRes(@PathVariable("hotelId") int hotelId, @RequestBody hsideReservation newRes){
        return thisHotel.newResforHotel(hotelId, newRes);
    }
}