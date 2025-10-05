package com.Salazar.Class;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users") // optional, but avoids conflict if "user" is reserved in DB
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment primary key
    private Long id;

    @NotBlank(message = "Username should not be blank")
    @Column(nullable = false, unique = true) // usernames must be unique
    private String username;

    @NotBlank(message = "Password is incorrect")
    @Column(nullable = false)
    private String password;

    // --- Getters & Setters ---

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
