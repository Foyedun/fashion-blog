package com.example.week8.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<TaskEntity> task;



}
