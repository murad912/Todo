package com.example.todoapi.entities;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private Boolean completed;


}