package com.example.managementsoftware.Modell;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "User ID should not be null")
private int userID;
@NotEmpty(message = "name should not be empty")
@Size(min = 5)
private String name;
@NotEmpty(message = "Username should not be empty")
@Size(min = 5)
//@Column(unique = true)
private String userName;
@NotEmpty(message = "Password should not be empty")
private String password;
    @NotEmpty(message = "email should not be empty")
    @Email
//    @Column(unique = true)
private String email;
    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "^(admin|user|)$")
    private String role;
    @NotNull(message = "age should not be null")
    private int age;

















}
