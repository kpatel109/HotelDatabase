package rc.springbootmongodbdemo.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import rc.springbootmongodbdemo.Entities.Customer;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {

}
