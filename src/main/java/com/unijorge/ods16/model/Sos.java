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
public class Sos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;



    @Column(nullable = false, updatable = false)
    private LocalDateTime submissionDate = LocalDateTime.now();

    @ManyToOne
    private User user;

}
