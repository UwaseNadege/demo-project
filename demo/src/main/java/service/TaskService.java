package service;

import org.hibernate.mapping.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // More business logic here
}
