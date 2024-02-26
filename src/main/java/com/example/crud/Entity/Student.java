package com.example.crud.Entity;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "address" , nullable = false)
    private String address;
    @Column(name = "mobile" , nullable = false )
    private int mobile;


}
