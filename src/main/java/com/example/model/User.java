package com.example.model;

/**
 * Represents a user in the system.
 */
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    /**
     * Default constructor.
     */
    public User() {}

    /**
     * Constructs a user with the given parameters.
     * @param id User ID
     * @param name User name
     * @param email User email
     * @param password User password
     */
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
} 