package repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	<optional> User findByemail(String email);

}


