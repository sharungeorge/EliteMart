package com.shopkart.entity;

import java.time.LocalDateTime;

import javax.management.relation.Role;

import org.apache.catalina.UserDatabase;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class user implements UserDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    @Column(unique = true, nullable= false)
    private  String email;
  

    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Password should be valid")
    @Column(nullable= false)
    private String password ;

    @NotBlank(message = "first name is required")
    @Column(name = "first name", nullable= false)
    private String firstName;

    @NotBlank(message = "last name is required")
    @Column(name = "last name", nullable= false)
    private String LastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;

    private Role role =Role.USER;

    public enum role{
        user,
        admin;
    }


}