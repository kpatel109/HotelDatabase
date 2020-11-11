package rc.springbootmongodbdemo.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import rc.springbootmongodbdemo.Entities.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, Integer> {

}
