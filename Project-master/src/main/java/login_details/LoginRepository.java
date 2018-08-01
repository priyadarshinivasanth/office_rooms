package login_details;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LoginRepository extends CrudRepository<Login,Long>{
	@Query(value = "SELECT * FROM user t WHERE t.name = ?1",nativeQuery=true
    )
    public List<Login> findByTitle(String name);
}
