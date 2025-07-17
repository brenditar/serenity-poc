package com.example.model;

/**
 * Represents a user in the system.
 *
 * Patrón Builder: Permite construir instancias de User de forma flexible y legible.
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
     * Constructor completo.
     */
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // --- Patrón Builder ---
    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String password;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public User build() {
            return new User(id, name, email, password);
        }
    }
    // --- Fin Builder ---

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