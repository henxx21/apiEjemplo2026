package com.jaroso.apiejemplo2026.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto es un autoincrement, es decir cada objeto nuevo va a tener un idd diferente
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    @Column(nullable = false, name = "finish_date")
    private LocalDate finishDate;

}
