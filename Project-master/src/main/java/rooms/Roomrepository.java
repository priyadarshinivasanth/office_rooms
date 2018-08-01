package rooms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Roomrepository extends CrudRepository<Room,Long>{

}
