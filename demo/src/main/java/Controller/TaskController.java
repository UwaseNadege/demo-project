package Controller;

import java.util.List;

import org.apache.tomcat.util.descriptor.web.ContextService;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/tasks")
public class TaskController<Task> {
    private final ContextService taskService;

    public TaskController(ContextService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getUserTasks1(@AuthenticationPrincipal User user) {
		return null;
       		
    }
    
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TaskController.class);

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<Task> getUserTasks(@AuthenticationPrincipal User user) {
        logger.info("Accessing tasks for user: {}", user.getUsername());
		return null;
     
    }
}
    



