package model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Tells Spring to treat this class as an entity representing a table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the primary key for each user
    private Long id; // Primary key field for the user

    private String username; // User's username
    private String email;    // User's email
    private String password; // User's password

    // Default constructor (needed by JPA)
    public User() {}

    // Constructor with parameters for easy object creation
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters (for accessing and modifying the fields)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
