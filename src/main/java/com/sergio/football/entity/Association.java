package com.sergio.football.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "associations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private String ceo;

    //  Relación 1-N con Club
    @OneToMany(mappedBy = "association", fetch = FetchType.LAZY)
    private List<Club> clubs;
}
