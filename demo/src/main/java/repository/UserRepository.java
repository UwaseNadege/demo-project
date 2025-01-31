package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This will give us access to basic CRUD operations, like save(), findAll(), findById(), etc.
    User findByEmail(String email); // Custom query to find a user by their email

	Object findByUsername(String username);
}
