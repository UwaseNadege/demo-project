package repository;

import org.hibernate.mapping.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List findByUser(User user);
}
