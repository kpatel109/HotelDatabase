package rc.springbootmongodbdemo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import rc.springbootmongodbdemo.Entities.Customer;
import rc.springbootmongodbdemo.Entities.hotelReservations;

import java.util.Collection;
import java.util.Optional;


@Component
public class CustomerDAO {
    @Autowired
    private CustomerRepository repository;
    //List of customer reservations
    public Collection<hotelReservations> getReservations(@PathVariable("id") int id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            return customer.get().getCustomerReservations();
        }
        else{
            System.out.println("Customer is not registered");
            return null;
        }

    }

    public Customer createCustomer(Customer newCustomer) {
        return repository.insert(newCustomer);
    }

    public Collection<hotelReservations> customerUpdateReservation(int id, hotelReservations newReservation){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            customer.get().updateNewReservation(newReservation);
            repository.save(customer.get());
            return customer.get().getCustomerReservations();
        }
        else{
            System.out.println("Customer is not registered");
            return null;
        }
    }

    public Collection<hotelReservations> createNewCustomerReservation(int customerId, hotelReservations newReservation) {
        Optional<Customer> customer = repository.findById(customerId);
        if(customer.isPresent()){
            customer.get().makeReservation(newReservation);
            repository.save(customer.get());
            return customer.get().getCustomerReservations();
        }
        else{
            System.out.println("Customer is not registered");
            return null;
        }
    }
    public Collection<hotelReservations> customerDeleteReservation(int id, hotelReservations newReservation){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            customer.get().removeReservation(newReservation);
            repository.save(customer.get());
            return customer.get().getCustomerReservations();
        }
        else{
            System.out.println("Customer is not registered");
            return null;
        }
    }
}
