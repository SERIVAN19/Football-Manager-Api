package com.sergio.football.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clubs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación con Entrenador (1-1)
    @OneToOne
    @JoinColumn(name = "coach_id")
    private Entrenador entrenador;

    // Relación con Jugadores (1-N)
    @OneToMany(mappedBy = "club")
    private List<Jugador> jugadores;

    // Relación con Asociación (N-1)
    @ManyToOne
    @JoinColumn(name = "association_id")
    private Asociacion asociacion;

    // Relación con Competiciones (N-N)
    @ManyToMany
    @JoinTable(
            name = "club_competitions",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "competition_id")
    )
    private List<Competicion> competiciones;
}
