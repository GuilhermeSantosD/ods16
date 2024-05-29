package com.unijorge.ods16.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime submissionDate = LocalDateTime.now();

    private String status;

    private boolean anonymous;

    @ManyToOne
    private User user;



}
